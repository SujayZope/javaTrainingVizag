package com.hib.jsf;

import java.sql.SQLException;
import java.util.List;

public interface AgentDAO {

	List<Agent> showAgentDao();
	String searchAgentDao(int agentid);
	String authenticate(Login login);
	String validateMe(Login login);
	String addAgentDao(Agent agent);
	String updateAgentDao(Agent agentNew);
	String deleteAgentDao(int agentid);
	String addUser(Login login);
	
}