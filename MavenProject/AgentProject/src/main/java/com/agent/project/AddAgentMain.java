package com.agent.project;

import java.sql.SQLException;
import java.util.Scanner;

public class AddAgentMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Agent agent= new Agent();
		System.out.println("Enter Agent Name  ");
		agent.setName(sc.next());
		System.out.println("Enter City  ");
		agent.setCity(sc.next());
		System.out.println("Enter Gender  ");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Marital Status  ");
		agent.setMaritalstatus(sc.nextInt());
		System.out.println("Enter Premium  ");
		agent.setPremium(sc.nextDouble());
		AgentDao dao=new AgentDaoImp();
		
		try {
			System.out.println(dao.addAgentDao(agent));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
