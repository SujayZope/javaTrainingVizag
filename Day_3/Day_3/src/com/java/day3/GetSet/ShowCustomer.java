package com.java.day3.GetSet;

public class ShowCustomer {
	
	public static void main(String[] args) {
		Customer customer = new Customer();
		
		customer.setCustId(1);
		customer.setName("Nikhil");
		customer.setPremium(138989);
		
		System.out.println(customer);
	}

}
