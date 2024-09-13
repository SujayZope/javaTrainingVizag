package com.hbn.jsf;

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


@ManagedBean(name="eDao")
@SessionScoped
public class EmployeeDaoImpl implements EmployeeDAO {

	
	@Override
	public List<Employee> showEmployeeDao() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr= session.createCriteria(Employee.class);
		List<Employee> empList = cr.list();
		return empList;
	}
	
	@Override
    public String searchEmployeeDao(int empno) {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr= session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("empno", empno));
		List<Employee> empList = cr.list();
		Employee employee = empList.get(0);
		sessionMap.put("editEmploy", employee);
		return "UpdateEmployee.xhtml?faces-redirect=true";
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
			return "ShowEmployee.xhtml?faces-redirect=true";			
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
			return "ShowEmployee.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}
	}
	
	@Override
	public String addEmployeeDao(Employee emp)  {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
	    session.save(emp);
	    t.commit();
	    System.out.println("Record Inserted...");
		return "ShowEmployee.xhtml?faces-redirect=true";

	}

	
	@Override
	public String updateEmployeeDao(Employee empNew) {
			
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
		session.update(empNew);
	    t.commit();
	    System.out.println("Record Updated...");
		return "ShowEmployee.xhtml?faces-redirect=true";
	}

	@Override
	public String deleteEmployeeDao(int empno) {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee where empno="+empno);
		List<Employee> empList = query.list();
		if(empList.size()==0){
			System.out.println("Record not found..");
		}else{
			Employee emp=empList.get(0);
			Transaction t=session.beginTransaction();
	        session.delete(emp);
	        t.commit();
			System.out.println("record deleted");
		}
			return "ShowEmployee.xhtml?faces-redirect=true";
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
	
	public List<Employee> getEmployListByDept(String dept) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("dept", dept));
		List<Employee> empList = cr.list();
		return empList;
	}
	public List<String> getDepartments() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		Projection projection = Projections.distinct(Projections.property("dept")); 
		cr.setProjection(projection); 
		List<String> list = cr.list();
		return list;
	}
	private String localCode;
	
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	public void employLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		this.localCode = e.getNewValue().toString();
	}
	
	
	
}