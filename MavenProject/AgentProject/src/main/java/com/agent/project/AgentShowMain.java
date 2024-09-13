package com.agent.project;

import java.sql.SQLException;
import java.util.List;

public class AgentShowMain {

	public static void main(String[] args) {
		AgentDao dao= new AgentDaoImp();
		List<Agent> agentList;
		try {
			agentList = dao.showAgentDao();
			for(Agent agent : agentList){
				System.out.println(agent);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}}
