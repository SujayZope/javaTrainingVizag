package com.infinite.hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Dummy {

	public static void main(String[] args) {
		SessionFactory sessionFactory = 
				new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Question where id=1");
		
		Question question1 = (Question) query.uniqueResult();
		Answer ans1 = new Answer();
		ans1.setAnswerName("Java is OOP Programming language");
		ans1.setPostedBy("Jadhav");
		
		System.out.println(question1.getId());
		Answer ans2 = new Answer();
		ans2.setAnswerName("Java used to create enterprise apps");
		ans2.setPostedBy("Suraj");
		ans2.setQid(question1.getId());
		System.out.println(ans2.getQid());

		Transaction t = session.beginTransaction();
		session.save(ans2);
		t.commit();
	}
}
