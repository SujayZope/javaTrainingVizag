package com.java.hbn;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class DeleteEmployee {

	public static void main(String[] args) {
			int empno;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee Number = ");
			empno=sc.nextInt();
			SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Query query = session.createQuery("from Employee where empno="+empno);
			List<Employee> empList = query.list();
			if(empList.size()==0){
				System.out.println("Record Not Found...");
			}else{
				Employee emp=empList.get(0);
				Transaction t = session.beginTransaction();
				session.delete(emp);
				t.commit();
				System.out.println("Record Deleted...");
			}
		}

	}

