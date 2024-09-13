package com.jsf.hib;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "cDao")
@SessionScoped
public class CustomerDaoImpl implements CustomerDAO {

	@Override
	public String addCustomerDao(Customer customer) {
		String pwd = EntryptPassword.getCode(customer.getCustPassword());
		customer.setCustPassword(pwd);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(customer);
		trans.commit();
		return "Thanks.xhtml?faces-redirect=true";
	}

	


	@Override
	public String validateMe(Customer customer) {
		String encr = EntryptPassword.getCode(customer.getCustPassword());
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("custUserName", customer.getCustUserName()));
		cr.add(Restrictions.eq("custPassword", encr.trim()));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();
		if (count == 1) {
			Customer c = searchByCustomerUser(customer.getCustUserName());
			sessionMap.put("customerInfo", c);
			return "CustDashBoard.xhtml?faces-redirect=true";
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "CustLogin.xhtml?faces-redirect=true";
		}
	}

	@Override
	public Customer searchByCustomerUser(String userName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("custUserName", userName));
		Customer customer = (Customer) cr.uniqueResult();
		return customer;
	}

}
