package com.java.hib;


import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



@ManagedBean(name="eDao")
@SessionScoped

public class EmployeeDaoImpl implements EmployeeDAO {

	@Override
	public List<Employee> showEmployeeDao() {
		SessionFactory sf = SessionHelper.getConnection();
  	    Session session=sf.openSession();  
		Query query = session.getNamedQuery("showEmploy");
		List<Employee> empList = query.list();
		return empList;
	}

	@Override
	public String searchEmployeeDao(int empno) {
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		

		SessionFactory sf = SessionHelper.getConnection();
  	    Session session=sf.openSession();  
  	    Query query = session.getNamedQuery("searchEmploy");
		query.setParameter("empno",empno);   
		Employee emp = (Employee)query.uniqueResult();
        sessionMap.put("editEmploy", emp);
		return "UpdateEmployee.xhtml?faces-redirect=true";
	}

	@Override
	public String validateMe(Login login) {
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
  	    Session session=sf.openSession();  
  	    Query query = session.getNamedQuery("validate");
		query.setParameter("passCode",EntryptPassword.getCode(login.getPassCode().trim()));  
		query.setParameter("userName", login.getUserName());
		List<Login> loginList = query.list();
		System.out.println("Records are " +loginList.size());
		if (loginList.size()==1) {
			return "EmployeeShow.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}

	}
	@Override
	public String updateEmployeeDao(Employee empNew) {
			
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
		session.update(empNew);
	    t.commit();
	    System.out.println("Record Updated...");
		return "EmployeeShow.xhtml?faces-redirect=true";
	}


}