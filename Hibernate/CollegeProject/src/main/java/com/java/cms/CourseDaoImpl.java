package com.java.cms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@ManagedBean(name="cDao")
@SessionScoped
public class CourseDaoImpl implements CourseDAO {
	
	@Override
	public String addCourseDao(Course course)  {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction t=session.beginTransaction();
	    session.save(course);
	    t.commit();
	    System.out.println("Record Inserted...");
		return "ShowCourse.xhtml?faces-redirect=true";

	}

}
