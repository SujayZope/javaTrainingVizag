package com.java.cms;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

@ManagedBean(name = "sDao")
@SessionScoped
public class SubjectsDaoImpl implements SubjectsDAO {

	private String localCode;
	private int theory;
	private int practical;

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public int getTheory() {
		return theory;
	}

	public void setTheory(int theory) {
		this.theory = theory;
	}

	public int getPractical() {
		return practical;
	}

	public void setPractical(int practical) {
		this.practical = practical;
	}

	@Override
	public String addSubjectDao(Subjects subjects, int tMarks, int pMarks, String subName) {
		Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		subjects.setPract(pMarks);
		subjects.setTheory(tMarks);
		subjects.setSub(subName);
		
		SessionFactory sf = SessionHelper.getConnection();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(subjects);
		t.commit();
		map.put("msg", "Subject Added Successfully...");
		return "thanks.xhtml?faces-redirect=true";
	}

	public List<String> showSubjectsByName() {
		SessionFactory sf = SessionHelper.getConnection();
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Subjects.class);
		Projection projection = Projections.property("subject");
		List<String> list = cr.list();
		return list;
	}

	public void eventLocalCodeChanged(ValueChangeEvent e) {
		this.localCode = e.getNewValue().toString();

		if (localCode.equals("PC Architecture")) {
			this.setTheory(42);
			this.setPractical(14);
		}
		if (localCode.equals("PC Hardware 1")) {
			this.setTheory(90);
			this.setPractical(50);

		}
		if (localCode.equals("PC Hardware 2")) {
			this.setTheory(69);
			this.setPractical(41);
		}
		if (localCode.equals("Microprocessor Interfacing devices and Embedded System")) {
			this.setTheory(160);
			this.setPractical(93);
		}
		if (localCode.equals("C#")) {
			this.setTheory(84);
			this.setPractical(56);
		}
		if (localCode.equals("Data Structures")) {
			this.setTheory(60);
			this.setPractical(0);

		}
		if (localCode.equals("Operating System")) {
			this.setTheory(80);
			this.setPractical(70);
		}
		if (localCode.equals("SQL Serve")) {
			this.setTheory(66);
			this.setPractical(34);
		}
		if (localCode.equals("Networking")) {
			this.setTheory(94);
			this.setPractical(156);
		}
		if (localCode.equals("Advance Computer Concept and Data Securit")) {
			this.setTheory(0);
			this.setPractical(0);
		}
		if (localCode.equals("Value Added Services")) {
			this.setTheory(27);
			this.setPractical(11);
		}

		System.out.println(this.practical);
		System.out.println(this.theory);

	}

}
