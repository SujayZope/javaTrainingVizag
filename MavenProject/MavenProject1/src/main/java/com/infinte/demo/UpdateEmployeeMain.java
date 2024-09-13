package com.infinte.demo;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployeeMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Employee employee= new Employee();
		System.out.println("Enter Employee Number to update Details  ");
		employee.setEmpno(sc.nextInt());
		System.out.println("Enter Employee Name  ");
		employee.setName(sc.next());
		System.out.println("Enter Department  ");
		employee.setDept(sc.next());
		System.out.println("Enter Designation  ");
		employee.setDesig(sc.next());
		System.out.println("Enter Basic  ");
		employee.setBasic(sc.nextInt());
		EmployeeDAO dao=new EmployeeDaoImpl();
		
		try {
			System.out.println(dao.updateEmployeeDao(employee));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
