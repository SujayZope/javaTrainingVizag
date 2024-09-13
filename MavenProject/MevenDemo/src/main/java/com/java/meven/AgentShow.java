package com.java.meven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentShow {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/exam", "root", "india@123");
			
			String cmd= "select * from agent";
			PreparedStatement pst = conn.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery(); 
			while(rs.next()){
				System.out.println("Agent Id "+rs.getInt("agentid"));
				System.out.println("Agent Name "+rs.getString("name"));
				System.out.println("City "+rs.getString("city"));
				System.out.println("Gender "+rs.getString("gender"));
				System.out.println("Marital Status "+rs.getInt("maritalstatus"));
				System.out.println("Premium "+rs.getDouble("premium"));
				System.out.println("-------------------------------------- ");
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
