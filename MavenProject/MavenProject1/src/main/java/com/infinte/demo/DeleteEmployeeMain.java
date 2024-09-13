package com.infinte.demo;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployeeMain {

	public static void main(String[] args) {
		int empno;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Number to Delete Details  ");
		empno = sc.nextInt();
		EmployeeDAO dao = new EmployeeDaoImpl();
		
		try {
			System.out.println(dao.deleteEmployeeDao(empno));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}