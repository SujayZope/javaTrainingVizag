package com.infinite.Collections;

import java.util.ArrayList;
import java.util.List;

public class ListEmployee {
	
	public static void main(String[] args) {
		
		List empList = new ArrayList();
		empList.add(new Employee(1,"Chetan",83456));
		empList.add(new Employee(2,"Ankit",28358));
		empList.add(new Employee(3,"Riddhi",23456));
		empList.add(new Employee(4,"Rushikesh",54742));
		empList.add(new Employee(5,"Makarand",36573));
		empList.add(new Employee(6,"Kumar",43734));
		System.out.println("Employee List  ");
		for(Object object : empList){
			Employee employee =(Employee)object;
			System.out.println(employee);
		}
		
		
	}

}
