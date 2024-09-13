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

import com.Medical_Entry.Procedure;

import infinite.HealthPharmacy.SessionHelper;


@ManagedBean(name="procedureImpl")
@SessionScoped
public class ProcedureDaoImpl implements ProcedureDao {

	@Override
	public List<Procedure> getRecipientId() {
		
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		
		Criteria criteria  = session.createCriteria(Procedure.class);
		Projection projection = Projections.distinct(Property.forName("recipientid"));
		
		criteria.setProjection(projection);
		List<Procedure> patientId = criteria.list();
		
		return patientId;
	}

}
