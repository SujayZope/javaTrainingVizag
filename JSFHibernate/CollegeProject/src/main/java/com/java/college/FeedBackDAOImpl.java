package com.java.college;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "fDao")
@SessionScoped
public class FeedBackDAOImpl implements FeedBackDAO {

	public String generateFID() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Feedback.class).setProjection(Projections.max("fid"));
		String str = (String) criteria.uniqueResult();

		String sub = str.substring(1);
		int tempId = Integer.parseInt(sub);
		tempId++;
		return String.format("F%03d", tempId);

	}

	@Override
	public String giveFeedback(Feedback feedback) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		feedback.setFid(generateFID());
		Transaction trans = session.beginTransaction();
		session.save(feedback);
		trans.commit();
		return "Thanks.xhtml?faces-redirect=true";

	}

	public List<String> searchInstructor() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Subjects.class);
		Projection projection = Projections.distinct(Projections.property("instructor"));
		cr.setProjection(projection);
		List<String> list = cr.list();
		System.out.println(list);
		return list;
	}

	public List<String> showSubjectNames(String instructor) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Subjects.class);
		cr.add(Restrictions.eq("instructor", instructor));
		Projection projection = Projections.property("subject");
		cr.setProjection(projection);
		List<String> subjectList = cr.list();
		return subjectList;
	}

	private String localCode;

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public void instLocaleCodeChanged(ValueChangeEvent e) {
		System.out.println(e.getNewValue().toString());
		this.localCode = e.getNewValue().toString();

	}

	public String showFeedback(Feedback feed) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.alias(Projections.groupProperty("fbValue"), "fbValue"))
				.add(Projections.alias(Projections.rowCount(), "fbCount"));
		Criteria cr = session.createCriteria(Feedback.class, "fb");
		cr.add(Restrictions.eq("instructor", feed.getInstructor()));
		cr.add(Restrictions.eq("subject", feed.getSubject()));
		cr.setProjection(plist);
		List<Object[]> flist = cr.list();
		List<Result> resultList = new ArrayList<Result>();
		Result result = null;
		for (Object[] objects : flist) {
			result = new Result();
			System.out.println("Result  ");
			result.setFbValue((String) objects[0]);
			result.setFbCount((Long) objects[1]);
			resultList.add(result);
		}
		sessionMap.put("resultList", resultList);
		return "ShowFeedback.xhtml?faces-redirect=true";

	}
}
