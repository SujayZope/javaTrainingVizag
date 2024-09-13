package com.java.jsf;

import javax.faces.bean.*;

@ManagedBean
@SessionScoped
public class HelloBean {
	
	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	
}
