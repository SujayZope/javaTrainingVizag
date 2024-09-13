package com.java.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LambdaEx2 {

	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>(); 
		employeeList.add(new Employee(1, "Yogesh", 12345));
		employeeList.add(new Employee(2, "Nikhil", 99999));
		employeeList.add(new Employee(3, "Aniket", 37468));
		employeeList.add(new Employee(4, "Akshay", 83234));
		employeeList.add(new Employee(5, "Deepak", 63822));
		employeeList.add(new Employee(6, "Lokesh", 36487));
	    
		Stream<Employee> filtered_data = employeeList.stream().filter(p -> p.getBasic() > 50000);
			System.out.println("Filtered Data  ");
		
			filtered_data.forEach(x ->{
				System.out.println(x);
			});
		}
}
