package com.java.meven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int agentid;
		System.out.println("Enter Agent ID  ");
		agentid = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/exam", "root", "india@123");
			String cmd = "select * from agent where agentid=?";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setInt(1,  agentid);
			ResultSet rs = pst.executeQuery(); 
			if(rs.next()){
				System.out.println("Agent Id "+rs.getInt("agentid"));
				System.out.println("Agent Name "+rs.getString("name"));
				System.out.println("City "+rs.getString("city"));
				System.out.println("Gender "+rs.getString("gender"));
				System.out.println("Marital Status "+rs.getInt("maritalstatus"));
				System.out.println("Premium "+rs.getDouble("premium"));
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
		

	}
}
