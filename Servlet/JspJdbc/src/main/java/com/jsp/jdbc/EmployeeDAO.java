package com.jsp.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	List<Employee> showEmployeeDao() throws ClassNotFoundException, SQLException;
	Employee searchEmployeeDao(int empno) throws ClassNotFoundException,SQLException;
	String addEmployeeDao(Employee employee) throws ClassNotFoundException, SQLException;
	String updateEmployeeDao(Employee employee) throws ClassNotFoundException, SQLException;
	String deleteEmployeeDao(int empno) throws ClassNotFoundException, SQLException;
	int authenticate(String user, String pwd) throws ClassNotFoundException, SQLException;
	
}
