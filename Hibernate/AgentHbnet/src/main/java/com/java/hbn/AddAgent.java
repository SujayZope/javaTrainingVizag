package com.java.hbn;

import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AddAgent {
	
	public static void main(String[] args) {
		Agent agent=new Agent();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		agent.setName(sc.next());
		System.out.println("Enter City");
		agent.setCity(sc.next());
		System.out.println("Enter Gender");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Marital Status");
		agent.setMaritalstatus(sc.nextInt());
		System.out.println("Premium");
		agent.setPremium(sc.nextDouble());
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.save(agent);
		t.commit();
		System.out.println("Record Inserted...");
	}

}
