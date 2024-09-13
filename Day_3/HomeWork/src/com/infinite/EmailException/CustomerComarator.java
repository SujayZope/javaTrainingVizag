package com.infinite.EmailException;

import java.util.Comparator;

public class CustomerComarator implements Comparator<Customer>{

	@Override
	public int compare(Customer c1, Customer c2) {
		
		if(c1.city==c2.city){
			return c1.custName.compareTo(c2.custName);
		}
		return c1.city.compareTo(c2.city);
	}

}
