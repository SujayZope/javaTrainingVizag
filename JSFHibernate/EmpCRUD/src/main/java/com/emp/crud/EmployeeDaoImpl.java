package com.emp.crud;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@ManagedBean(name = "eDao")
@SessionScoped
public class EmployeeDaoImpl implements EmployeeDAO {

	@Override
	public List<Employee> ShowAllEmployee() {
		SessionFactory sf=SessionHelper.getConnection();
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Employee.class);
		List<Employee> empList=cr.list();
		return empList;
	}

	@Override
	public String addEmployee(Employee emp) {
		SessionFactory sf=SessionHelper.getConnection();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		session.save(emp);
		t.commit();
		System.out.println("Record Inserted...");
		return "ShowEmp.xhtml?faces-redirect=true";
	}
	
	@Override
    public String searchEmployeeDao(int empId) {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr= session.createCriteria(Employee.class);
		
		
		return null;
	}
}
