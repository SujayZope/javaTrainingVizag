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

import com.Medical_Entry.Provider;

import infinite.HealthPharmacy.SessionHelper;

@ManagedBean(name="providerImpl")
@SessionScoped
public class ProviderDaoImpl implements ProviderDao {

	@Override
	public List<Provider> getHospitalName() {
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria = session.createCriteria(Provider.class);
		Projection projection = Projections.distinct(Property.forName("hospital"));
		criteria.setProjection(projection);
		
		List<Provider> hospitalList = criteria.list();
		
		return hospitalList;
	}

}
