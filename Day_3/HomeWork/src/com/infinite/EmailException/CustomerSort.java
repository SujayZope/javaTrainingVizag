package com.infinite.EmailException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerSort {
	
	
	public static void main(String[] args) {
		
		List<Customer> c=new ArrayList<>();
		
		CustomerComarator comp=new CustomerComarator();
		
		c.add(new Customer(1,"akash","pune", 18000,1500));
		c.add(new Customer(2,"aditya","nashik", 18000,1500));
		c.add(new Customer(3,"gorukh","jalgaon", 18000,1500));
		c.add(new Customer(4,"riddhi","dhule", 18000,1500));
		c.add(new Customer(5,"badhe","amaravati", 18000,1500));
		c.add(new Customer(6,"bade","nagar", 18000,1500));
		c.add(new Customer(7,"rushi","beed", 18000,1500));
		c.add(new Customer(8,"nikhil","jalgaon", 18000,1500));
		c.add(new Customer(9,"suraj","latur", 18000,1500));
		c.add(new Customer(10,"sarkthak","nagpur", 18000,1500));
		c.add(new Customer(11,"akhil","latur", 18000,1500));
		c.add(new Customer(12,"nikhil","latur", 18000,1500));
		c.add(new Customer(13,"vikas","pune", 18000,1500));
		
		Collections.sort(c,comp);
		
		for (Customer cust : c) {
			System.out.println(cust);
		}
		
		
		
	}
	

}

