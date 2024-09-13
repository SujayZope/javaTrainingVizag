package com.java.hib;

import java.util.List;

public interface EmployeeDAO {
	
	 List<Employee> showEmployeeDao();
	 String searchEmployeeDao(int empno);
	 String validateMe(Login login);
	 String updateEmployeeDao(Employee empNew);

}
