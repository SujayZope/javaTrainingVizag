package com.java.cms;

import java.util.Date;
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

@ManagedBean(name = "comDao")
@SessionScoped
public class ComplaintDaoImp implements ComplaintDao {

	public String complaintIdGen() {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Complaint.class).setProjection(Projections.max("complaintID"));
		String str = (String) criteria.uniqueResult();

		String order = str.substring(1);
		int CoId = Integer.parseInt(order);
		CoId++;
		return String.format("C%03d", CoId);

	}

	@Override
	public String AddcomplaintDao(Complaint complaint) {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		String id = complaintIdGen();
		complaint.setComplaintID(id);
		Transaction t = session.beginTransaction();
		session.save(complaint);
		t.commit();
		System.out.println("Record Inserted...");

		return "showAllComplaint.xhtml?faces-redirect=true";
	}

	@Override
	public List<Complaint> showAllComplaint() {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Complaint.class);
		List<Complaint> complaintList = cr.list();
		return complaintList;
	}

	@Override
	public String searchcomplaintDao(String complaintID) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Complaint.class);
		cr.add(Restrictions.eq("complaintID", complaintID));
		List<Complaint> cList = cr.list();
		if (cList.size() == 0) {
			System.out.println("Record not found..");
		} else {
			Complaint complaint = cList.get(0);
			sessionMap.put("editcomplaint", complaint);
		}
		return "RsolveComplaint.xhtml?faces-redirect=true";
	}

	@Override
	public String addResolve(Complaint complaint, Resolve resolve) {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		resolve.setComplaintDate(complaint.getComplaintDate());
		resolve.setComplaintId(complaint.getComplaintID());

		Transaction t = session.beginTransaction();
		session.save(resolve);
		t.commit();
		System.out.println("Record Inserted...");

		complaint.setComplaintStatus("Approved");
		Transaction t1 = session.beginTransaction();
		session.update(complaint);
		t1.commit();

		return "showAllComplaint.xhtml?faces-redirect=true";

	}

	@Override
	public List<Resolve> showAllResolveComplaint() {

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Resolve.class);
		List<Resolve> resolveList = cr.list();
		return resolveList;
	}

	@Override
	public int calculatedays(Date ComplaintDate, Date ResolveDate) {

		int noOfDays;
		long ms = ResolveDate.getTime() - ComplaintDate.getTime();
		System.out.println(ms);
		noOfDays = (int) ((ms) / (1000 * 60 * 60 * 24));
		return ++noOfDays;
	}

}
