package com.infinte.demo;

import java.sql.SQLException;
import java.util.List;

public class EmployeeShowAllMain {
	
	public static void main(String[] args) {
		EmployeeDAO dao= new EmployeeDaoImpl();
		List<Employee> employeeList;
		try {
			employeeList = dao.showEmployeeDao();
			for(Employee employee : employeeList){
				System.out.println(employee);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
