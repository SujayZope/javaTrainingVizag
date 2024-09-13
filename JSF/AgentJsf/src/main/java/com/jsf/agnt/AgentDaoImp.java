package com.jsf.agnt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;






@ManagedBean(name="aDao")
@SessionScoped
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
	public String searchAgentDao(int agentid) throws ClassNotFoundException, SQLException {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
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
			sessionMap.put("editAgent", agent);
		}
		return "UpdateAgent.xhtml?faces-redirect=true";
		
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
		
		return "AgentShow.xhtml?faces-redirect=true";
		
	}
	
	@Override
	public String authenticate(Login login) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		connection = ConnectionHelper.getConnection();
		String encr=EntryptPassword.getCode(login.getPassCode());
		String cmd = "select count(*) cnt from Login where userName=? AND PassCode=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, login.getUserName());
		pst.setString(2, encr.trim());
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
	if(count==1){
		return "AgentShow.xhtml?faces-redirect=true";
	}
	return "Login.xhtml?faces-redirect=true";
	}

	@Override
	public String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException {
		
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
		
		
		return "AgentShow.xhtml?faces-redirect=true";
	}

	@Override
	public String deleteAgentDao(int agentid) throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "Delete from Agent where AgentID=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, agentid);
			pst.executeUpdate();
			
				
		
		return "AgentShow.xhtml?faces-redirect=true";
	}


@Override
public String createUser(Login login) throws ClassNotFoundException, SQLException {
	connection = ConnectionHelper.getConnection();
	String encPwd = EntryptPassword.getCode(login.getPassCode());
	String cmd = "Insert into login(userName,passCode) "
			+ " values(?,?)";
	pst = connection.prepareStatement(cmd);
	pst.setString(1, login.getUserName());
	pst.setString(2, encPwd);
	pst.executeUpdate();
	return "Login.xhtml?faces-redirect=true";
}

}