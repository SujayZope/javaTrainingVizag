package infinite.EnrollPharmacy;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import infinite.HealthPharmacy.Login;
import infinite.HealthPharmacy.OwnerDetail;
import infinite.HealthPharmacy.Pharmacy;
import infinite.HealthPharmacy.SessionHelper;
import infinite.HealthPharmacy.Status;





@ManagedBean(name="rDao")
@SessionScoped
public class PharmacyEnrollDaoImpl implements PharmacyEnrollDAO{
	
	
	private String errMeg;
	private String errorMsg;
	private String e1;
	private String e2;
	
	
	
	
	
	
	
	public String getE2() {
		return e2;
	}

	public void setE2(String e2) {
		this.e2 = e2;
	}

	public String getE1() {
		return e1;
	}

	public void setE1(String e1) {
		this.e1 = e1;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrMeg() {
		return errMeg;
	}

	public void setErrMeg(String errMeg) {
		this.errMeg = errMeg;
	}



	
	
	@Override
	public String AddPharmacyDetail(Login login,Pharmacy pharmacy ,OwnerDetail ownerDetail) {
		
		
		errMeg="";
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		
		Criteria cr=session.createCriteria(OwnerDetail.class);
		cr.add(Restrictions.eq("email", ownerDetail.getEmail()));
		OwnerDetail od=(OwnerDetail)cr.uniqueResult();
		if(od!=null){	
			errMeg="Email iS already Registered please Register with Diffrenet email";
			
			return "AddPharmacyDetail.xhtml? faces-redirect=true";
		}
		
		Transaction trans = session.beginTransaction();
		session.save(ownerDetail);
		pharmacy.setOwnerDetail(ownerDetail);
		pharmacy.setStatus(Status.PENDING);
		ownerDetail.setLogin(login);
		session.save(pharmacy);
		
		System.out.println(pharmacy);
		trans.commit();
		return "Thanks1.xhtml? faces-redirect=true";
	}
	
	
	
	
	
	
	@Override
	public String updatePharmacyDetails(Pharmacy pharmacy ,OwnerDetail ownerDetail){
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Transaction t=session.beginTransaction();
		session.update(pharmacy);
		pharmacy.setStatus(Status.PENDING);
		session.update(ownerDetail);
		t.commit();
		
		return "Thanks2.xhtml? faces-redirect=true";
	}
	
	
	
	
	
	
	
	@Override
	public String searchOwner(String email){
		
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		
		Criteria cr=session.createCriteria(OwnerDetail.class);
		cr.add(Restrictions.eq("email", email));
		OwnerDetail od=(OwnerDetail)cr.uniqueResult();
		Criteria cr1=session.createCriteria(Pharmacy.class);
		cr1.add(Restrictions.eq("ownerId",od.getOwnerId() ));
		
		Pharmacy p=(Pharmacy)cr1.uniqueResult();
		
		sessionMap.put("od", od);
		sessionMap.put("pharm", p);
		return "UpdatePharmacyDetail.xhtml? faces-redirect=true";
	}
	public Pharmacy searchPharm(int oid){
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		
		Criteria cr=session.createCriteria(Pharmacy.class);
		cr.add(Restrictions.eq("ownerId", oid));
		Pharmacy pharm=(Pharmacy)cr.uniqueResult();
		return pharm;
	}
	
	
	
	
	
	@Override
	public String authenticate(String email) {
		 //  String email=admin1.getEmail();
			Map<String, Object> map=
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			// TODO Auto-generated method stub
	//String encr=EntryptPassword.getCode(admin.getPwd());
			SessionFactory sf=SessionHelper.getConnection();
			Session s=sf.openSession();
			String email1=email.trim();
		
			OwnerDetail owner=searchOwnerByEmail(email1);
			e2="";
			errorMsg="";
		//	cr.add(Restrictions.eq("pwd",encr.trim() ));
			if(owner==null){
				errorMsg="Email is Wrong Please Check Once......";
				
		
				return "SendOtp.xhtml? faces-redirect=true";
			}
			
			if(owner!=null){
				
				
				Criteria cr2=s.createCriteria(Pharmacy.class);
				cr2.add(Restrictions.eq("ownerId",owner.getOwnerId()));
				
				Pharmacy p=(Pharmacy)cr2.uniqueResult();
				
				
				
				if(!(p.getStatus().equals(Status.REWORK))){
					e2="* Your Application is in under Process *";
					
					return "SendOtp.xhtml? faces-redirect=true";
					
				}
				
				
				
				
				
				
			}
			
			
			
			
			
	         if(owner.getEmail()!=null){
	        	 
	        	 Criteria cr=s.createCriteria(LoginOtp.class);	 
	        	 LoginOtp login=new LoginOtp();
	        	login.setUserName(owner.getOwnerName());
	        	Calendar c=Calendar.getInstance();
	        	Date date=c.getTime();
	        	login.setsDate(date);
	        	c.add(Calendar.MINUTE, 2);
	        	Date date1=c.getTime();
	        	login.seteDate(date1);
	             int otp=otpGenerate();
	        	login.setOtpPass(otp);
	        	login.setStatus("Active");	 
	        	 Transaction t=s.beginTransaction();
	        	 
	        	 s.save(login);
	        	 t.commit();
	        long otpnew=otp;
        	 SendMail.sendInfo(owner.getEmail(),"Your generated Otp For Update Your Pharmacy Details ","Otp is "+otpnew);	 
	         }
			map.put("email",owner.getEmail());
			return "LoginOtp.xhtml? faces-redirect=true";
		}
		
		
		public Date maxDate(){
			
			Date date =new Date();
			return date;
			
			
		}
	
	
	    @Override
		public long otpGenerate(String userName) {
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(LoginOtp.class);
			cr.add(Restrictions.eq("userName", userName));
			cr.setProjection(Projections.rowCount());
			long  count =(Long)cr.uniqueResult();
			System.out.println(count);
			return count;
		}
		
		
		
		
		
	    @Override
		 public	OwnerDetail  searchOwnerByEmail(String email) {
		    	
		    	SessionFactory sf=SessionHelper.getConnection();
		    	Session s=sf.openSession();
		    	Criteria cr=s.createCriteria(OwnerDetail.class);
		    	cr.add(Restrictions.eq("email", email.trim()));
		    OwnerDetail a=(OwnerDetail)cr.uniqueResult();
		    	
		    	System.out.println(a);	
		    	
		    	return a;
		    }
		    public int otpGenerate(){
		    	
		    		Random r = new Random( System.currentTimeMillis() );
		    	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
		    	}
		  
		
		    
		    
		    
		    
		    
		    @Override
		    public String checkUser(LoginOtp l,String email){
		    	
		    	Map<String, Object> map=
		    			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		    	SessionFactory sf=SessionHelper.getConnection();
		    	Session s=sf.openSession();
	    	Criteria cr=s.createCriteria(LoginOtp.class);
		    	//cr.add(Restrictions.eq("userName", l.getUserName()));
		    	cr.add(Restrictions.eq("otpPass", l.getOtpPass()));
		    e1="";
		    LoginOtp loginOtp=(LoginOtp)cr.uniqueResult();
		    
		    if(loginOtp==null){
		    	e1="You have Entered Wrong Otp..";
		        	
		        	return "LoginOtp.xhtml? faces-redirect=true";
		        }
		    Transaction t=s.beginTransaction();
		    
		    if((new Date()).after(loginOtp.geteDate())){	
		    s.delete(loginOtp);
		    t.commit();
		    
		    	
		    	map.put("err", "Time Out for Otp Please try Again.....");
		    	return "SendOtp.xhtml?faces-redirect=true";
		    }
		    if(loginOtp!=null && loginOtp.getStatus()!="Active"){
		    	loginOtp.setStatus("Deactive");
		    	
		    	
		    	Criteria cr1=s.createCriteria(OwnerDetail.class);
				cr1.add(Restrictions.eq("email",email));
				OwnerDetail od=(OwnerDetail)cr1.uniqueResult();
				
				Criteria cr2=s.createCriteria(Pharmacy.class);
				cr2.add(Restrictions.eq("ownerId",od.getOwnerId() ));
				
				Pharmacy p=(Pharmacy)cr2.uniqueResult();
				
				map.put("od", od);
				map.put("pharm", p);
		    	
		    	return "UpdatePharmacyDetail.xhtml? faces-redirect=true";
		    	
		    }
		   
		    	map.put("err", "Something went Wrong....");
		    	
		    	return "Thanks.xhtml? faces-redirect=true";
		    }
		   

		
	
	
	

	

}
