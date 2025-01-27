package infinite.LoginPharmacy;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import infinite.HealthPharmacy.EntryptPassword;
import infinite.HealthPharmacy.Login;
import infinite.HealthPharmacy.OwnerDetail;
import infinite.HealthPharmacy.SessionHelper;
import infinite.forgetPharmacy.SendMail;

@ManagedBean(name = "lDao")
@SessionScoped
public class LoginDaoImpl implements LoginDao {

	private String errmsg;
	private String otperrmsg;
	private String passerrmsg;

	public String getPasserrmsg() {
		return passerrmsg;
	}

	public void setPasserrmsg(String passerrmsg) {
		this.passerrmsg = passerrmsg;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getOtperrmsg() {
		return otperrmsg;
	}

	public void setOtperrmsg(String otperrmsg) {
		this.otperrmsg = otperrmsg;
	}

	@Override
	public String validateMe(Login login) {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		System.out.println("Login Data " + login);

		cr.add(Restrictions.eq("userName", login.getUserName()));
		Login loginFound = (Login) cr.uniqueResult();
		if (loginFound == null) {
			sessionMap.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}

		System.out.println("inside  login" + loginFound);

		if (loginFound.getFlag().equals("No")) {
			System.out.println("for old user login");
			String encr = EntryptPassword.getCode(login.getPassword());
			cr.add(Restrictions.eq("userName", loginFound.getUserName()));
			cr.add(Restrictions.eq("password", encr.trim()));
			cr.setProjection(Projections.rowCount());
			long count = (Long) cr.uniqueResult();
			try {
				if (count == 1) {
					if ((new Date()).before(loginFound.getPassExpiryTime())) {
						sessionMap.put("userName", loginFound.getUserName());
						sessionMap.put("home", "Welcome to dashboard page ...");
						return "HomePage.xhtml?faces-redirect=true";
					} else {
						sessionMap.put("err", "your password has expired.....");
						return "checkUName.xhtml?faces-redirect=true";
					}
				} else {
					sessionMap.put("error", "Invalid Credentials...");
				}

			} catch (HibernateException | ClassCastException e) {
				e.printStackTrace();

			}
		}

		System.out.println(loginFound.getFlag());
		if (loginFound.getFlag().equals("Yes")) {
			System.out.println("inside reset 2");
			String checkOtp = String.valueOf(loginFound.getOtp());
			if (checkOtp.equals(login.getPassword())) {
				System.out.println("otp match");
				sessionMap.put("userName", loginFound.getUserName());
				Login login2 = searchByUserName(loginFound.getUserName());
				System.out.println("*****************************");
				sessionMap.put("err", "First reset password.....");
				return "reset.xhtml?faces-redirect=true";
			} else {
				sessionMap.put("error", "Invalid Credentials...");
			}

		}

		return "Login.xhtml?faces-redirect=true";
	}

	@Override
	public Login searchByUserName(String username) {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", username));
		Login user = (Login) cr.uniqueResult();
		System.out.println("Searched......");

		return user;
		
		
		
	}

	@Override
	public OwnerDetail searchPharmacyByloginId(int userId) {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(OwnerDetail.class);
		cr.add(Restrictions.eq("userId", userId));
		OwnerDetail ownerdetail = (OwnerDetail) cr.uniqueResult();
		System.out.println("ownerdetail data========== " + ownerdetail);
		return ownerdetail;
	}

	@Override
	public String checkUsername(String username) {

		System.out.println(username);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		Login login = searchByUserName(username);

		if (login == null) {
			errmsg = "The email address that you have entered doesn't match an account.Please try again..!";

			return "checkUName.xhtml?faces-redirect=true";
		} else {
			sessionMap.put("loginsession", login);
			System.out.println("login data " + login);
			int id = login.getUserId();

			// search data in OwnerDetail by userId
			OwnerDetail ownerDetail = searchPharmacyByloginId(id);
			String maskId = maskMailId(ownerDetail.getEmail());
			sessionMap.put("maskIdSession", maskId);
			sessionMap.put("ownwerdetailsession", ownerDetail);
			errmsg = "";
			return "emailVerify.xhtml?faces-redirect=true";
		}
	}

	@Override
	public String sendOtp(String email, String userName) {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		long otpNew = generateOtp();
		System.out.println(generateOtp());
		System.out.println("Email is " + email);
		SendMail.sendInfo(email, "Your OTP Generated", "Generated Otp is " + otpNew);
		Login login = searchByUserName(userName);
		login.setOtp(otpNew);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 2);
		Date exdate = c.getTime();
		login.setOtpexptime(exdate);
		session.update(login);
		tr.commit();
		otperrmsg = "";
		return "submitOtp.xhtml?faces-redirect=true";

	}

	// change
	@Override
	public String ResendOtp(String email, String userName) {
		System.out.println("resend " + email);

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		long otpNew = generateOtp();
		System.out.println(generateOtp());
		System.out.println("Email is " + email);
		SendMail.sendInfo(email, "Your OTP Generated", "Generated Otp is " + otpNew);
		Login login = searchByUserName(userName);
		login.setOtp(otpNew);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 2);
		Date exdate = c.getTime();
		login.setOtpexptime(exdate);
		session.update(login);
		tr.commit();
		otperrmsg = "";
		return "submitOtp.xhtml?faces-redirect=true";

	}

	@Override
	public String validateOtp(Login login, String sessionUsername) {
		passerrmsg = "";

		// Map<String, Object> sessionMap =
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", sessionUsername));
		cr.add(Restrictions.eq("otp", login.getOtp()));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();

		Login loginFound = searchByUserName(sessionUsername);

		if ((new Date()).before(loginFound.getOtpexptime())) {
			if (count == 1) {
				System.out.println(count);
				return "reset.xhtml?faces-redirect=true";
			} else {

				otperrmsg = "You Entered Wrong OTP....";
				return otperrmsg;
			}
		} else {
			otperrmsg = "Time Out.....OTP Expired...!";

			return otperrmsg;
		}

	}

	public static int generateOtp() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	
	public String maskMailId(String email) {

		int index = email.indexOf("@");
		String end_id = email.substring(index);// @gmail.com
		String mask = "";
		int size = email.substring(2, index).length();// kitpatil3012@
		for (int i = 0; i < size; i++) {
			mask += "*";
		}
		mask = email.substring(0, 2) + mask + end_id;
		return mask;
	}
}
