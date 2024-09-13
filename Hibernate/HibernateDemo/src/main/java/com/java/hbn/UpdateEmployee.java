package com.java.hbn;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class UpdateEmployee {

	public static void main(String[] args) {
		
		Employee emp=new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee No");
		emp.setEmpno(sc.nextInt());
		System.out.println("Enter Name");
		emp.setName(sc.next());
		System.out.println("Enter Department");
		emp.setDept(sc.next());
		System.out.println("Enter Designation");
		emp.setDesig(sc.next());
		System.out.println("Enter Basic");
		emp.setBasic(sc.nextInt());
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.update(emp);
		t.commit();
		System.out.println("Record Updated...");
	}
}
