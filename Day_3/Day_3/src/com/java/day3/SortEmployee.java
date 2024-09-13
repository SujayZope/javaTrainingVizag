package com.java.day3;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortEmployee {
	
	public static void main(String[] args) {
		
		NameComparator nm= new NameComparator();
		
		
		SortedSet<Employee> employeeList=new TreeSet<Employee>(nm);
		employeeList.add(new Employee(1,"Nikhil", 98765));
		employeeList.add(new Employee(1,"Yogesh", 98765));
		employeeList.add(new Employee(1,"Aniket", 98765));
		employeeList.add(new Employee(1,"Ritesh", 98765));
		employeeList.add(new Employee(1,"Niraj", 98765));
		employeeList.add(new Employee(1,"Sanket", 98765));
		
		for (Employee employee : employeeList){
			System.out.println(employee);
		}
	}

}
