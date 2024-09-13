package com.java.ejb;

import java.util.Properties;

import javax.naming.InitialContext;




public class MainProg {

	public static void main(String[] args) {
			Properties p = new Properties();
			p.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
			p.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
			p.put("java.naming.provider.url", "localhost:1099");
			
				try {
					CalcBeanRemote service = 
							(CalcBeanRemote) new InitialContext(p).lookup("CalcBean/remote");
					System.out.println(service.sum(78,56));
					System.out.println(service.sum(85,26));
					System.out.println(service.sum(7,5));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
}
