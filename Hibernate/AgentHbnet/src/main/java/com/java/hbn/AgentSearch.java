package com.java.hbn;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class AgentSearch {
	public static void main(String[] args) {
		int agentId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent Id = ");
		agentId=sc.nextInt();
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Agent where AgentID="+agentId);
		List<Agent> agentList = query.list();
		if(agentList.size()==0){
			System.out.println("Record Not Found...");
		}else{
			Agent agent=agentList.get(0);
			System.out.println(agent);
		}
	}

}
