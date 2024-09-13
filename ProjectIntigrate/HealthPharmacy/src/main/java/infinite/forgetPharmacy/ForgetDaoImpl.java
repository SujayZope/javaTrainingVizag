package infinite.forgetPharmacy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import infinite.HealthPharmacy.EntryptPassword;
import infinite.HealthPharmacy.Login;
import infinite.HealthPharmacy.LoginHistory;
import infinite.HealthPharmacy.OwnerDetail;
import infinite.HealthPharmacy.SessionHelper;

@ManagedBean(name ="Dao")
@SessionScoped
public  class ForgetDaoImpl implements ForgetDao {

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
	public Login searchByUserName(String username) {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", username));
		Login login=(Login)cr.uniqueResult();
		return login;
	}
	
	@Override
   public OwnerDetail searchPharmacyByloginId(int userId){
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(OwnerDetail.class);
		cr.add(Restrictions.eq("userId", userId));
		OwnerDetail ownerdetail=(OwnerDetail)cr.uniqueResult();
		System.out.println("ownerdetail data========== "+ownerdetail);
		return ownerdetail;
	}
	
	
	
	
	@Override
	public String checkUsername(String username)
	{
		
		System.out.println(username);
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
					
				
		 Login login=searchByUserName(username);
		
		 
		if(login==null)
		{
			errmsg="The Username that you have entered doesn't match an account.Please try again..!";
			
			return "ForgetPass.xhtml?faces-redirect=true";
		}
		else{ 
		 sessionMap.put("loginsession", login);
		 System.out.println("login data "+login);
		 int id=login.getUserId();
		 
		 //search data in OwnerDetail by userId
		 OwnerDetail ownerDetail=searchPharmacyByloginId(id);
		 String maskId=maskMailId(ownerDetail.getEmail());
		 sessionMap.put("maskIdSession", maskId);
		 sessionMap.put("ownwerdetailsession", ownerDetail);
		 errmsg="";
		 return "ForgetPass2.xhtml?faces-redirect=true";
	    }
	}

	@Override
	public String sendOtp(String email,String userName)
	{
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		    long otpNew = generateOtp();
			System.out.println(generateOtp());
			System.out.println("Email is " + email);
			SendMail.sendInfo(email, "One Time Password(OTP) for Account recovery process", "Your One Time Password(OTP) for Forgot Password recovery is " + otpNew);
			Login login=searchByUserName(userName);
			login.setOtp(otpNew);
			Calendar c=Calendar.getInstance();
			c.add(Calendar.MINUTE, 2);
			Date exdate=c.getTime();
			login.setOtpexptime(exdate);
			session.update(login);
			tr.commit();
			otperrmsg="";
			return "OtpLogin.xhtml?faces-redirect=true";
	
		}
	
	//change
	@Override
	public String ResendOtp(String email,String userName)
	{
		System.out.println("resend "+email);
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		    long otpNew = generateOtp();
			System.out.println(generateOtp());
			System.out.println("Email is " + email);
			SendMail.sendInfo(email, "One Time Password(OTP) for Account recovery process", "Your One Time Password(OTP) for Forgot Password recovery is " + otpNew);
			Login login=searchByUserName(userName);
			login.setOtp(otpNew);
			Calendar c=Calendar.getInstance();
			c.add(Calendar.MINUTE, 2);
			Date exdate=c.getTime();
			login.setOtpexptime(exdate);
			session.update(login);
			tr.commit();
			otperrmsg="";
			return "OtpLogin.xhtml?faces-redirect=true";
			
		
		
		}
	
	
	
	@Override
	public String validateOtp(Login login,String sessionUsername) {
		passerrmsg="";
		
		//Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
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
				return "ForgetPass3.xhtml?faces-redirect=true";
			} else { 
				
				otperrmsg="You Entered Wrong OTP....";
				return otperrmsg;
			}
		}else {
			otperrmsg="Time Out.....OTP Expired...!";
			
			return otperrmsg;
		}
		
	}
	
	
	
	@Override
	public String ForgetPassword(String username,String password) {
		
		System.out.println( "======================================================="+username +"        "+password);
		
		
		String encr = EntryptPassword.getCode(password); //New Pass
//		Map<String,Object> sessionMap = 
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", username)); //
		cr.setProjection(Projections.rowCount());
		long  count =(Long)cr.uniqueResult();
		boolean isFound = false;
		if(count==1) {
			Criteria cr1 = session.createCriteria(LoginHistory.class);
			cr1.add(Restrictions.eq("userName", username));
			cr1.addOrder(Order.desc("createdOn"));
			List<LoginHistory> history = cr1.list();
			System.out.println(history.size());
			System.out.println(history);
			
			List<LoginHistory> firstFive = new ArrayList<LoginHistory>();
			
		                      	if (history.size()>= 5){
				
				                                   for (LoginHistory loginHistory : history) {
				                                   System.out.println("Hi");
					                               firstFive.add(loginHistory);
					                               System.out.println(firstFive.size());
					                               if (firstFive.size()==5) {
						                             break;
					                                                        }
			                                                               	                 }
			                                            } 
		                                         	//updated else part
			   else{
				if (history.size()<= 5){
					
					for (LoginHistory loginHistory : history) {
						System.out.println("Hi");
						firstFive.add(loginHistory);
						System.out.println(firstFive.size());
						
					}
				} 
				
			}
			
			
			System.out.println(firstFive);
			history = firstFive;
			System.out.println("============="+history);
			for (LoginHistory loginHistory : firstFive) {
				if (loginHistory.getPassCode().equals(encr.trim())) {
					System.out.println(loginHistory.getPassCode() + "   " +encr.trim());
					isFound = true;
					break;
				}
			}
			
			if (isFound==true) {
				passerrmsg="Your password cannot be same as old password...";
				return "ForgetPass3.xhtml?faces-redirect=true";
			}

			else {
				
				Transaction tran = session.beginTransaction();
				LoginHistory history1 = new LoginHistory();
				history1.setUserName(username);
				history1.setPassCode(encr);
				history1.setCreatedOn(new java.sql.Timestamp(new java.util.Date().getTime()));
				System.out.println(history1);
				session.save(history1);
				
			    Login log=searchByUserName(username); 
			    Calendar c = Calendar.getInstance();
				c.add(Calendar.HOUR, 1080);
				Date exdate = c.getTime();
				log.setPassExpiryTime(exdate);
				log.setPassword(encr);
				
				session.update(log);
				tran.commit();
				passerrmsg="Password Changed Successfully...!";
				return "Login.xhtml?faces-redirect=true";
			}
		}
		return "Login.xhtml?faces-redirect=true";
	}

		
	
	//Generate otp
	public static int generateOtp() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	
	// EmailIdmasking ankitpatil3012@gmail.com
		public String maskMailId(String email)
		{
		
			int index=email.indexOf("@");
			String end_id=email.substring(index);//@gmail.com
			String mask="";
			int size=email.substring(2,index).length();//kitpatil3012@
			for(int i=0;i<size;i++)
			{
				mask+="*";
			}
			mask=email.substring(0,2)+mask+end_id;
			return mask;
		}
		
			
}
