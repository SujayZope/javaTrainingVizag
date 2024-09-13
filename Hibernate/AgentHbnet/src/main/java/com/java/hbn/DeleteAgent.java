package com.java.hbn;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class DeleteAgent {

	public static void main(String[] args) {
			int agentId;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Agent Id = ");
			agentId=sc.nextInt();
			SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Query query = session.createQuery("from Agent where agentid="+agentId);
			List<Agent> agentList = query.list();
			if(agentList.size()==0){
				System.out.println("Record Not Found...");
			}else{
				Agent agent=agentList.get(0);
				Transaction t = session.beginTransaction();
				session.delete(agent);
				t.commit();
				System.out.println("Record Deleted...");
			}
		}

	}

