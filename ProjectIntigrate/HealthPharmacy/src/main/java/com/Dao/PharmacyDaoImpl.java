package com.Dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;


import infinite.HealthPharmacy.Pharmacy;
import infinite.HealthPharmacy.SessionHelper;


@ManagedBean(name="pharmacyImpl")
@SessionScoped
public class PharmacyDaoImpl implements PharmacyDao {

	@Override
	public List<Pharmacy> getMedicalNameList() {
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria = session.createCriteria(Pharmacy.class);
		Projection projection = Projections.distinct(Property.forName("pharmaName"));
		
		criteria.setProjection(projection);
		
		List<Pharmacy> pharmacyNameList = criteria.list();
		
		return pharmacyNameList;
	}

}
