package com.java.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EmployeeDAO {
	
	public List<Employee> showEmployee(){
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Subodh", "Java", "Developer", 98000.00));
        empList.add(new Employee(2, "Suraj", "J2EE", "Expert", 67890.00));
        empList.add(new Employee(3, "Akash", "MySQL", "Programmer", 89076.00));
        empList.add(new Employee(4, "Anant", "Angular", "Tester", 78960.00));
        empList.add(new Employee(5, "Sarthak", "React", "Manager", 89678.00));
		empList.add(new Employee(6, "Nikhil", "Java", "Expert", 65748.99));
		return empList;
	}

}
