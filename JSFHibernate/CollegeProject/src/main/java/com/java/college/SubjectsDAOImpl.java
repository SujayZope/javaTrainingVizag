package com.java.college;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@ManagedBean(name = "sDao")
@SessionScoped
public class SubjectsDAOImpl implements SubjectsDAO {

	Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	private List<String> subjectsList;

	public SubjectsDAOImpl() {
		subjectsList = Arrays.asList("PC Architecture", "PC Hardware 1", "PC Hardware 2",
				"Microprocessor Interfacing devices & Embedded System", "C#", "Data Structures", "Operating System",
				"SQL Server", "Networking", "Advance Computer Concept & Data Security", "Value Added Services");
	}

	public List<String> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(List<String> subjectsList) {
		this.subjectsList = subjectsList;
	}

	@Override
	public String AddSubject(String localcode, int theory, int practical, Subjects subjects) {
		subjects.setSubject(localcode);
		subjects.setTheory(theory);
		subjects.setPractical(practical);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(subjects);
		trans.commit();
		return "Thanks.xhtml?faces-redirect=true";
	}

	public String localeCode;
	public int theory;
	public int practical;

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public void marksLocaleCodeChanged(ValueChangeEvent e) {
		// assign new value to localeCode

		System.out.println(e.getNewValue().toString());
		localeCode = e.getNewValue().toString();

		if (localeCode.equals("PC Architecture")) {
			this.setTheory(42);
			this.setPractical(14);
		}
		if (localeCode.equals("PC Hardware 1")) {
			this.setTheory(90);
			this.setPractical(50);
		}
		if (localeCode.equals("PC Hardware 2")) {
			this.setTheory(69);
			this.setPractical(41);
		}
		if (localeCode.equals("Microprocessor Interfacing devices & Embedded System")) {
			this.setTheory(107);
			this.setPractical(93);
		}
		if (localeCode.equals("C#")) {
			this.setTheory(84);
			this.setPractical(56);
		}
		if (localeCode.equals("Data Structures")) {
			this.setTheory(60);
			this.setPractical(0);
		}

		if (localeCode.equals("Operating System")) {
			this.setTheory(80);
			this.setPractical(70);
		}

		if (localeCode.equals("SQL Server")) {
			this.setTheory(66);
			this.setPractical(34);

		}

		if (localeCode.equals("Networking")) {
			this.setTheory(94);
			this.setPractical(156);

		}

		if (localeCode.equals("Advance Computer Concept & Data Security")) {
			this.setTheory(0);
			this.setPractical(0);

		}

		if (localeCode.equals("Value Added Services")) {
			this.setTheory(27);
			this.setPractical(11);

		}
		System.out.println(this.theory + " Prac  " + this.practical);

		sessionMap.put("theory", this.getTheory());
		sessionMap.put("practical", this.getPractical());

		System.out.println(sessionMap.get("theory"));
		System.out.println(sessionMap.get("practical"));
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

}
