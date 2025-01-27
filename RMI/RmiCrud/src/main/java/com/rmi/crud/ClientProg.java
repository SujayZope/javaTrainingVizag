package com.rmi.crud;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClientProg {

	public static void main(String[] args) {
		

		try {
			
			List<Agent> agentList;
			AgentDao dao = (AgentDao) Naming.lookup("localhost");
			System.out.println("Client Programming...");
			agentList = dao.showAgentDao();
			for(Agent agent : agentList){
				System.out.println(agent);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
