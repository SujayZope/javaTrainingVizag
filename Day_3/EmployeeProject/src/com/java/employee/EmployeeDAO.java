package com.java.employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public interface EmployeeDAO {
	
	List<Employee> showEmployeeDAO();
	String addEmployeeDao(Employee employee);
	Employee searchEmployeeDao(int empno);
	String deleteEmployeeDao(int empno);
	String updateEmloyeeDao(Employee employeeNew);
	String writeEmployeeFileDao() throws FileNotFoundException,IOException;;
	String readEmployeeFileDao() throws ClassNotFoundException,IOException;;

}
