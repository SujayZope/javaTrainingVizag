package com.emp.crud;

import java.util.List;

public interface EmployeeDAO {
	
	List<Employee>ShowAllEmployee();
	String addEmployee(Employee emp);
	String searchEmployeeDao(int empId);

}
