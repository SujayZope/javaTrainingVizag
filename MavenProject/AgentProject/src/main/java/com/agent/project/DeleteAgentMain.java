package com.agent.project;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAgentMain {

	public static void main(String[] args) {
		int agentid;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Agent ID to Delete Details  ");
		agentid = sc.nextInt();
		AgentDao dao = new AgentDaoImp();
		
		try {
			System.out.println(dao.deleteAgentDao(agentid));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
