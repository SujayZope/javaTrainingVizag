package com.jsf.hib;

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


@ManagedBean(name="vDao")
@SessionScoped

public class VendorDAOImpl implements VendorDAO {

	@Override
	public String addVendorDao(Vendor vendor) {
		String pwd = EntryptPassword.getCode(vendor.getVenPassword());
		vendor.setVenPassword(pwd);
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(vendor);
		trans.commit();
		return "Thanks.xhtml?faces-redirect=true";		
	}
	

	@Override
	public String validateMe(Vendor vendor) {
		String encr = EntryptPassword.getCode(vendor.getVenPassword());
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		cr.add(Restrictions.eq("venUserName", vendor.getVenUserName()));
		cr.add(Restrictions.eq("venPassword", encr.trim()));
		cr.setProjection(Projections.rowCount());
		long  count =(Long)cr.uniqueResult();
		if (count==1) {
			Vendor c = searchByVendorUser(vendor.getVenUserName());
			//sessionMap.put("cname", c.getCustName());
			sessionMap.put("vendorInfo", c);
			return "VendDashBoard.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "VendLogin.xhtml?faces-redirect=true";
		}
	}

	@Override
	public Vendor searchByVendorUser(String userName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		cr.add(Restrictions.eq("venUserName", userName));
		Vendor vendor = (Vendor)cr.uniqueResult();
		return vendor;
	}
	

}
