package com.rmi.crud;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDaoImp extends UnicastRemoteObject implements AgentDao {

	protected AgentDaoImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Agent> showAgentDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from agent";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Agent> agentList = new ArrayList<Agent>();
		Agent agent = null;
		while (rs.next()) {
			agent = new Agent();
			agent.setAgentid(rs.getInt("AgentID"));
			agent.setName(rs.getString("Name"));
			agent.setCity(rs.getString("City"));
			agent.setGender(Gender.valueOf(rs.getString("GENDER")));
			agent.setMaritalstatus(rs.getInt("MaritalStatus"));
			agent.setPremium(rs.getDouble("Premium"));
			agentList.add(agent);
		}
		return agentList;
	}

}
