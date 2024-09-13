package com.hib.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


@ManagedBean(name="aDao")
@SessionScoped
public class AgentDaoImpl implements AgentDAO {

	
	@Override
	public List<Agent> showAgentDao() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr= session.createCriteria(Agent.class);
		List<Agent> agentList = cr.list();
		return agentList;
	}
	
	@Override
    public String searchAgentDao(int agentid) {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr= session.createCriteria(Agent.class);
		cr.add(Restrictions.eq("agentid", agentid));
		List<Agent> agentList = cr.list();
		Agent agent = agentList.get(0);
		sessionMap.put("editAgent", agent);
		return "UpdateAgent.xhtml?faces-redirect=true";
	}
	

	@Override
	public String authenticate(Login login) {
		String encr = EntryptPassword.getCode(login.getPassCode());
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("passCode", encr.trim()));
		List<Login> loginList = cr.list();
		System.out.println("Records are " +loginList.size());
		if (loginList.size()==1) {
			return "ShowAgent.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}
	}

	@Override
	public String validateMe(Login login) {
		String encr = EntryptPassword.getCode(login.getPassCode());
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("passCode", encr.trim()));
		cr.setProjection(Projections.rowCount());
		long count =(Long)cr.uniqueResult();
		if (count==1) {
			return "ShowAgent.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}
	}
	
	@Override
	public String addAgentDao(Agent agent)  {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
	    session.save(agent);
	    t.commit();
	    System.out.println("Record Inserted...");
		return "ShowAgent.xhtml?faces-redirect=true";

	}

	
	@Override
	public String updateAgentDao(Agent agentNew) {
			
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
		session.update(agentNew);
	    t.commit();
	    System.out.println("Record Updated...");
		return "ShowEmployee.xhtml?faces-redirect=true";
	}

	@Override
	public String deleteAgentDao(int agentid) {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Query query = session.createQuery("from Agent where agentid="+agentid);
		List<Agent> agentList = query.list();
		if(agentList.size()==0){
			System.out.println("Record not found..");
		}else{
			Agent agent=agentList.get(0);
			Transaction t=session.beginTransaction();
	        session.delete(agent);
	        t.commit();
			System.out.println("Record Deleted...");
		}
			return "ShowAgent.xhtml?faces-redirect=true";
	}
	
	@Override
	public String addUser(Login login) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		String encPwd = EntryptPassword.getCode(login.getPassCode());
		login.setPassCode(encPwd);
		Transaction t=session.beginTransaction();
        session.save(login);
        t.commit();
        System.out.println("Record Inserted...");
		return "Login.xhtml?faces-redirect=true";
	}
	
	public List<Agent> getAgentListByGender(Gender gender) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Agent.class);
		cr.add(Restrictions.eq("gender", gender));
		List<Agent> agentList = cr.list();
		return agentList;
	}
	public List<Gender> getGenders() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Agent.class);
		Projection projection = Projections.distinct(Projections.property("gender")); 
		cr.setProjection(projection); 
		List<Gender> list = cr.list();
		return list;
	}
	private String localCode;
	
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	public void agentLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		this.localCode = e.getNewValue().toString();
	}
	
	
	
}