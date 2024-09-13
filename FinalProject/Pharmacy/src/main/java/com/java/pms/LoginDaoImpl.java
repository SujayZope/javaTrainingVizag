package com.java.pms;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "lDao")
@SessionScoped
public class LoginDaoImpl implements LoginDao {

	@Override
	public String validateMe(Login login) {
		Map<String, Object> sessionMap1 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		SessionFactory sf1 = SessionHelper.getConnection();
		Session session1 = sf1.openSession();
		Criteria cr1 = session1.createCriteria(Login.class);

		cr1.add(Restrictions.eq("userName", login.getUserName()));

		Login log = (Login) cr1.uniqueResult();////

		if (log == null) {
			sessionMap1.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}

		if (log.getPassCode() == null) {
			// String encr = EntryptPassword.getCode(login.getPassCode());
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			long enteredotp = Long.parseLong(login.getPassCode());
			System.out.println("Entered otp=" + enteredotp);
			System.out.println("asdfasj");
			Criteria cr = session.createCriteria(Login.class);

			cr.add(Restrictions.eq("userName", login.getUserName()));

			// cr.add(Restrictions.eq("otpNo",
			// Long.parseLong(login.getPassCode())));

			Login userFound = searchByLoginUser(login.getUserName());
			Login l = (Login) cr.uniqueResult();
			if (l == null || log.getOtpNo() != enteredotp) {
				sessionMap.put("error", "Invalid Credentials...");
				return "Login.xhtml?faces-redirect=true";
			}

			if (l.getStatus().toString().equals("PENDING")) {
				sessionMap.put("error", "Your Status is PENDING......");
				return "Login.xhtml?faces-redirect=true";
			}

			if (l.getStatus().toString().equals("REJECT")) {
				sessionMap.put("error", "Your Status is Rejected......");
				return "Login.xhtml?faces-redirect=true";
			}

			cr.setProjection(Projections.rowCount());

			long count = (Long) cr.uniqueResult();

			System.out.println("count=" + count);
			if (count == 1 && log.getOtpNo() == enteredotp) {
				sessionMap.put("err", "First reset password.....");
				return "reset.xhtml?faces-redirect=true";
			} else {
				sessionMap.put("error", "Invalid Credentials...");
				return "Login.xhtml?faces-redirect=true";
			}
		} else {
			String encr = EntryptPassword.getCode(login.getPassCode());
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(Login.class);

			cr.add(Restrictions.eq("userName", login.getUserName()));
			cr.add(Restrictions.eq("passCode", encr.trim()));

			Login userFound = searchByLoginUser(login.getUserName());
			Login l = (Login) cr.uniqueResult();
			if (l == null) {
				sessionMap.put("error", "Invalid Credentials...");
				return "Login.xhtml?faces-redirect=true";
			}

			if (l.getStatus().toString().equals("PENDING")) {
				sessionMap.put("error", "Your Status is PENDING......");
				return "Login.xhtml?faces-redirect=true";
			}

			if (l.getStatus().toString().equals("REJECT")) {
				sessionMap.put("error", "Your Status is Rejected......");
				return "Login.xhtml?faces-redirect=true";
			}

			cr.setProjection(Projections.rowCount());

			long count = (Long) cr.uniqueResult();

			if ((new Date()).before(userFound.getPassExpiryTime())) {
				if (count == 1) {
					return "menu.xhtml?faces-redirect=true";
				} else {
					sessionMap.put("error", "Invalid Credentials...");
					return "Login.xhtml?faces-redirect=true";
				}
			} else {
				sessionMap.put("err", "your password has expired.....");
				return "checkUName.xhtml?faces-redirect=true";
			}
		}
	}

	@Override
	public String validateOtp(Login login) {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("otpNo", login.getOtpNo()));

		Login l = (Login) cr.uniqueResult();

		if (l == null) {
			sessionMap.put("err1", "You Entered Wrong OTP....");
			return "You Entered Wrong OTP....";
		}
		System.out.println(l.getStatus());

		System.out.println(l.getOtpNo());
		System.out.println(l.getUserName());

		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();

		Login userFound = searchByLoginUser(login.getUserName());

		System.out.println("count  " + count);

		if (l.getStatus().toString().equals("PENDING")) {
			sessionMap.put("err1", "Your Status is PENDING......");
			return "otpLogin.xhtml?faces-redirect=true";
		} else if (l.getStatus().toString().equals("REJECT")) {
			sessionMap.put("err1", "Your Status is Rejected......");
			return "otpLogin.xhtml?faces-redirect=true";
		} else {
			if ((new Date()).before(userFound.getOtpExpiryTime())) {
				if (count == 1) {
					return "reset.xhtml?faces-redirect=true";
				}

				else {
					sessionMap.put("err1", "You Entered Wrong OTP....");
					return "You Entered Wrong OTP....";
				}
			} else {
				sessionMap.put("err1", "Time Out your otp expired.....");
				return "Time Out.....";
			}
		}
	}

	@Override
	public String otp(Login login) {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);

		Login userFound = searchByLoginUser(login.getUserName());
		String email = userFound.geteMail();

		long otpNew = generateOtp();
		System.out.println(generateOtp());
		System.out.println("Email is " + email);
		SendMail.sendInfo(email, "Your OTP Generated", "Generated Otp is " + otpNew);
		Transaction tr = session.beginTransaction();

		userFound.setOtpNo(otpNew);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 2);
		Date exdate = c.getTime();
		userFound.setOtpExpiryTime(exdate);
		session.update(userFound);
		tr.commit();
		return "otpLogin.xhtml?faces-redirect=true";

	}

	@Override
	public String addUser(Login login) {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		String encPwd = EntryptPassword.getCode(login.getPassCode());
		login.setPassCode(encPwd);
		login.setStatus(Status.valueOf(("APPROVED")));
		Transaction t = session.beginTransaction();
		session.save(login);
		t.commit();
		System.out.println("Record Inserted...");
		return "Login.xhtml?faces-redirect=true";
	}

	public static int generateOtp() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	@Override
	public Login searchByLoginUser(String userName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", userName));
		Login user = (Login) cr.uniqueResult();
		System.out.println("Searched......");

		return user;
	}

	@Override
	public String checkUsername(String username) {

		System.out.println(username);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		Login login = searchByLoginUser(username);

		if (login == null) {
			sessionMap.put("error2", "Invalid Username..Please Enter valid Username..!");
			return "checkUName.xhtml?faces-redirect=true";
		} else {
			sessionMap.put("loginsession", login);
			System.out.println("login data " + login);

			String maskId = maskMailId(login.geteMail());
			sessionMap.put("maskIdSession", maskId);
			sessionMap.put("pharmacysession", login);

			return "sendOtp.xhtml?faces-redirect=true";

		}

	}

	public String maskMailId(String email) {

		int index = email.indexOf("@");
		String end_id = email.substring(index);
		String mask = "";
		int size = email.substring(2, index).length();
		for (int i = 0; i < size; i++) {
			mask += "*";
		}
		mask = email.substring(0, 2) + mask + end_id;
		return mask;
	}
}