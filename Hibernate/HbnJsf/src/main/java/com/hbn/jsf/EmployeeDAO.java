package com.hbn.jsf;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	List<Employee> showEmployeeDao();
	String searchEmployeeDao(int empno);
	String authenticate(Login login);
	String validateMe(Login login);
	String addEmployeeDao(Employee emp);
	String updateEmployeeDao(Employee empNew);
	String deleteEmployeeDao(int empno);
	String addUser(Login login);
	
}