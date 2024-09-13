package com.agent.project;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearchMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AgentDao dao= new AgentDaoImp();
		
		System.out.println("Enter Agent ID  ");
		int agentid=sc.nextInt();
		
		try {
			Agent agent = dao.searchAgentDao(agentid);
			
			if(agent!=null){
				System.out.println(agent);
			}else{
				System.out.println("Agent Not Found  ");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}}
