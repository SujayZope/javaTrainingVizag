package com.rmi.crud;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class ServerProg {

	public static void main(String[] args) {
		System.setSecurityManager(new RMISecurityManager());

		try {
			AgentDao obj = new AgentDaoImp();
			Naming.rebind("localhost", obj);
			System.out.println("Server is Ready....");
			System.out.println("Waiting for Clients Request...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
