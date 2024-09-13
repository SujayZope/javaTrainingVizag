package com.infinite.EmailException;

public class Customer {
	
	int custId;
	String custName;
	String city;
	double premium;
	double installment;
	
	
	
	public Customer() {
		
	}



	public Customer(int custId, String custName, String city, double premium, double installment) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.city = city;
		this.premium = premium;
		this.installment = installment;
	}



	public int getCustId() {
		return custId;
	}



	public void setCustId(int custId) {
		this.custId = custId;
	}



	public String getCustName() {
		return custName;
	}



	public void setCustName(String custName) {
		this.custName = custName;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public double getPremium() {
		return premium;
	}



	public void setPremium(double premium) {
		this.premium = premium;
	}



	public double getInstallment() {
		return installment;
	}



	public void setInstallment(double installment) {
		this.installment = installment;
	}



	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", city=" + city + ", premium=" + premium
				+ ", installment=" + installment + "]";
	}
	
	
	
	
	
	

}
