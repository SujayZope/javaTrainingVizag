package com.agent.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class AgentDaoImp implements AgentDao {
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Agent> showAgentDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from agent";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Agent> agentList= new ArrayList<Agent>();
		Agent agent = null;
		while(rs.next()){
			agent=new Agent();
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

	@Override
	public Agent searchAgentDao(int agentid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from agent WHERE AgentID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentid);
		ResultSet rs = pst.executeQuery();
		Agent agent = null;
		if(rs.next()){
			agent=new Agent();
			agent.setAgentid(rs.getInt("AgentID"));
			agent.setName(rs.getString("Name"));
			agent.setCity(rs.getString("City"));
			agent.setGender(Gender.valueOf(rs.getString("GENDER")));
			agent.setMaritalstatus(rs.getInt("MaritalStatus"));
			agent.setPremium(rs.getDouble("Premium"));
		}
		return agent;
		
	}

	@Override
	public String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into agent(Name,City,GENDER,MaritalStatus,Premium) values(?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, agent.getName());
		pst.setString(2, agent.getCity());
		pst.setString(3, agent.getGender().toString());
		pst.setInt(4, agent.getMaritalstatus());
		pst.setDouble(5, agent.getPremium());
		pst.executeUpdate();
		
		return "Agent Record Inserted...";
		
	}

	@Override
	public String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException {
		Agent agentFound = searchAgentDao(agentNew.getAgentid());
		if(agentFound!=null){
		connection = ConnectionHelper.getConnection();
		String cmd = "update agent set  Name= ?, City=?, GENDER=? ,MaritalStatus=? ,Premium= ? where AgentID=?";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, agentNew.getName());
		pst.setString(2, agentNew.getCity());
		pst.setString(3, agentNew.getGender().toString());
		pst.setInt(4, agentNew.getMaritalstatus());
		pst.setDouble(5, agentNew.getPremium());
		pst.setInt(6, agentNew.getAgentid());
		pst.executeUpdate();
		
		return "Agent Record Updated...";
		}
		return "Agent Record Not Found...";
	}

	@Override
	public String deleteAgentDao(int agentid) throws ClassNotFoundException, SQLException {
		Agent agent= searchAgentDao(agentid);
		if(agent!=null){
			connection = ConnectionHelper.getConnection();
			String cmd = "Delete from Agent where AgentID=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, agentid);
			pst.executeUpdate();
			return "Agent Record Deleted...";
				
		}
		return "Agent Record Not Found...";
	}

}
