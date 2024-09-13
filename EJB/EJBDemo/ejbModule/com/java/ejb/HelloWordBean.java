package com.java.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWordBean
 */
@Stateless
@Remote(HelloWordBeanRemote.class)
public class HelloWordBean implements HelloWordBeanRemote {

    /**
     * Default constructor. 
     */
    public HelloWordBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Welcome to EJB Programming...";
	}

}