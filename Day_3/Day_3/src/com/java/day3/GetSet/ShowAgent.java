package com.java.day3.GetSet;

public class ShowAgent {
	
	public static void main(String[] args) {
		 Agent agent = new Agent();
		 agent.setAgentId(1031062);
		 agent.setAgentName("Yogesh");
		 agent.setCity("Nagar");
		 
		 System.out.println(agent.getAgentId());
		 System.out.println(agent.getAgentName());
		 System.out.println(agent.getCity());
	}

}
