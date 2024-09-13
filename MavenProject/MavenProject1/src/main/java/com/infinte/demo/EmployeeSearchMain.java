package com.infinte.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeSearchMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeDAO dao= new EmployeeDaoImpl();
		
		System.out.println("Enter Employee Number  ");
		int empno=sc.nextInt();
		
		try {
			Employee emp = dao.searchEmployeeDao(empno);
			
			if(emp!=null){
				System.out.println(emp);
			}else{
				System.out.println("Employee Not Found  ");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
