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

	private String errmsg;
	
	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String validateMe(Login login) {
		String encr = EntryptPassword.getCode(login.getPassCode());
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("passCode", encr.trim()));
		//cr.add(Restrictions.eq("status", Status.APPROVED));
		
		Login userFound = searchByLoginUser(login.getUserName());
		Login l=(Login)cr.uniqueResult();
		if(l==null){
			errmsg="Invalid Credentials...";
			return "Login.xhtml?faces-redirect=true";
		}
		/*System.out.println(l.getStatus());
		boolean result=(l.getStatus().toString().equals("APPROVED"));
		System.out.println(result);*/
		
		long attempt=userFound.getOtpNo();
		if(attempt==0){
			sessionMap.put("err", "First reset password.....");
			return "sendOtp.xhtml?faces-redirect=true";
		}
		
		if(l.getStatus().toString().equals("PENDING")){
			sessionMap.put("error", "Your Status is PENDING......");
			return "Login.xhtml?faces-redirect=true";	
		}
		
		if(l.getStatus().toString().equals("REJECT")){
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
		}}else {
			sessionMap.put("err", "your password has expired.....");
			return "sendOtp.xhtml?faces-redirect=true";
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
		//cr.add(Restrictions.eq("status", Status.APPROVED));
		
		Login l=(Login)cr.uniqueResult();
		System.out.println(l.getStatus());
		
		System.out.println(l.getOtpNo());
		System.out.println(l.getUserName());
		
		/*if(l.getStatus().toString().equals("PENDING")){
			sessionMap.put("err", "Your Status is PENDING......");
			return "otpLogin.xhtml?faces-redirect=true";	
		}else if(l.getStatus().toString().equals("REJECT")){
			sessionMap.put("err", "Your Status is Rejected......");
			return "otpLogin.xhtml?faces-redirect=true";	
		}else*/
		
		
		
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();

		
		Login userFound = searchByLoginUser(login.getUserName());
		
		if(l.getStatus().toString().equals("PENDING")){
			sessionMap.put("err", "Your Status is PENDING......");
			return "otpLogin.xhtml?faces-redirect=true";	
		}else if(l.getStatus().toString().equals("REJECT")){
			sessionMap.put("err", "Your Status is Rejected......");
			return "otpLogin.xhtml?faces-redirect=true";	
		}else{
		if ((new Date()).before(userFound.getOtpExpiryTime())) {
			if (count == 1) {
				return "reset.xhtml?faces-redirect=true";
			} else {
				sessionMap.put("err", "You Entered Wrong OTP....");
				return "You Entered Wrong OTP....";
			}
		}else {
			sessionMap.put("err", "Time Out.....");
			return "Time Out.....";
		}}
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
		Calendar c=Calendar.getInstance();
		c.add(Calendar.MINUTE, 2);
		Date exdate=c.getTime();
		userFound.setOtpExpiryTime(exdate);;
				
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

	public long otpGenerate(String userName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", userName));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();
		System.out.println(count);
		return count;
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

}