package com.java.meven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int empno;
		System.out.println("Enter Employee Number  ");
		empno = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/infinite", "root", "india@123");
			String cmd = "select * from Employ where empno=?";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setInt(1,  empno);
			ResultSet rs = pst.executeQuery(); 
			if(rs.next()){
				System.out.println("Employee Number "+rs.getInt("empno"));
				System.out.println("Employee Name "+rs.getString("name"));
				System.out.println("Department "+rs.getString("dept"));
				System.out.println("Designation "+rs.getString("desig"));
				System.out.println("Basic "+rs.getInt("basic"));
				System.out.println("-------------------------------------- ");
			
			
			}else{
				System.out.println("*** Record Not Found ***");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}}


