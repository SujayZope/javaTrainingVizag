package com.java.jdk8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class SortEmployee {
	
public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>(); 
		employeeList.add(new Employee(1, "Yogesh", 12345));
		employeeList.add(new Employee(2, "Nikhil", 88888));
		employeeList.add(new Employee(3, "Aniket", 37468));
		employeeList.add(new Employee(4, "Akshay", 83234));
		employeeList.add(new Employee(5, "Deepak", 63822));
		employeeList.add(new Employee(6, "Lokesh", 36487));
	    
		Collections.sort(employeeList, (e1 ,e2) -> {
			return e1.getName().compareTo(e2.getName());
		});
		System.out.println("Sorted Data   ");
		employeeList.forEach(x -> {
			System.out.println(x);
		});
		
		Collections.sort(employeeList, (e1 ,e2) -> {
			return (int) (e2.getBasic() - e1.getBasic());
		});
		System.out.println("\nSorted Basic   ");
		employeeList.forEach(x -> {
			System.out.println(x);
		});
		
		
		
		}

}
