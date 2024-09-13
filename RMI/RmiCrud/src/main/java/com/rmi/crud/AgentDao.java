package com.rmi.crud;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.List;

public interface AgentDao extends Remote {
	
	List<Agent> showAgentDao() throws ClassNotFoundException, SQLException;
	

}
