package com.java.hbn;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class AgentShow {

	public static void main(String[] args) {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Agent");
		List<Agent> agentList = query.list();
		for (Agent agent : agentList) {
			System.out.println(agent);
		}
	}
}