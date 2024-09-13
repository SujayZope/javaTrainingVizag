package com.jsf.jdbc;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



public interface EmployeeDAO {

	String createUser(Login login) throws ClassNotFoundException, SQLException;
	int authenticate(String user, String pwd) throws ClassNotFoundException, SQLException;
	List<Employee> showEmployeeDao() throws ClassNotFoundException, SQLException;
	String searchEmployeeDao(int empno) throws ClassNotFoundException, SQLException;
	String addEmployeeDao(Employee employee) throws ClassNotFoundException, SQLException;
	String updateEmployeeDao(Employee employee) throws ClassNotFoundException, SQLException;
	String deleteEmployeeDao(int empno) throws ClassNotFoundException, SQLException;
}
