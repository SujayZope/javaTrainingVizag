package com.jsf.agnt;

import java.sql.SQLException;
import java.util.List;

public interface AgentDao {
	
	
	List<Agent> showAgentDao() throws ClassNotFoundException, SQLException;
	String authenticate(Login login) throws ClassNotFoundException, SQLException;
	String searchAgentDao(int agentid) throws ClassNotFoundException,SQLException;
	String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException;
	String updateAgentDao(Agent agent) throws ClassNotFoundException, SQLException;
	String deleteAgentDao(int agentid) throws ClassNotFoundException, SQLException;
	String createUser(Login login) throws ClassNotFoundException, SQLException;

}
