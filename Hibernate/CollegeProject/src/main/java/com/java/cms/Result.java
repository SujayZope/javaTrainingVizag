package com.java.cms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="result")
@SessionScoped
public class Result {

	private String fbValue;
	private Long fbCount;
	
	public String getFbValue() {
		return fbValue;
	}
	public void setFbValue(String fbValue) {
		this.fbValue = fbValue;
	}
	public Long getFbCount() {
		return fbCount;
	}
	public void setFbCount(Long fbCount) {
		this.fbCount = fbCount;
	}
	@Override
	public String toString() {
		return "Result [fbValue=" + fbValue + ", fbCount=" + fbCount + "]";
	}
	
	
}
