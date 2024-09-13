package com.java.jsf;
 
import java.io.Serializable;

import javax.faces.bean.*;


@ManagedBean(name="test")
@SessionScoped
public class Test implements Serializable {
	
	public String sayHello(){
		return "Welcome to JSF Programming...";
	}

}
