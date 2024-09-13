package com.java.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxMinEx {
	
public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>(); 
		employeeList.add(new Employee(1, "Yogesh", 12345));
		employeeList.add(new Employee(2, "Nikhil", 88888));
		employeeList.add(new Employee(3, "Aniket", 37468));
		employeeList.add(new Employee(4, "Akshay", 83234));
		employeeList.add(new Employee(5, "Deepak", 63822));
		employeeList.add(new Employee(6, "Lokesh", 36487));
	    
		Employee employee1 = employeeList.stream().max((m1,m2)->
		m1.getBasic() > m2.getBasic() ? 1 : -1).get();
		System.out.println(employee1);
		
		Employee employee2 = employeeList.stream().min((m1,m2)->
		m1.getBasic() > m2.getBasic() ? 1 : -1).get();
		System.out.println(employee2);
		
		
		
		
		}
}
