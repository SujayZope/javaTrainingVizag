package com.java.day3.GetSet;

public class Customer {
	
	int custId;
	String name;
	double premium;
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", premium=" + premium + "]";
	}
	
	

}
