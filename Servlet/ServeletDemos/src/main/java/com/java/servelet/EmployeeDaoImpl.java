package com.java.servelet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {

	Connection connection;
	PreparedStatement pst;
	
	
	@Override
	public List<Employee> showEmployeeDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from Employ";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employee> employeeList= new ArrayList<Employee>();
		Employee employee = null;
		while(rs.next()){
			employee=new Employee();
			employee.setEmpno(rs.getInt("empno"));
			employee.setName(rs.getString("name"));
			employee.setDept(rs.getString("dept"));
			employee.setDesig(rs.getString("Desig"));
			employee.setBasic(rs.getInt("basic"));
			employeeList.add(employee);
		}
		return employeeList;
	}


	@Override
	public Employee searchEmployeeDao(int empno) throws ClassNotFoundException, SQLException {
		
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from Employ WHERE Empno=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		if(rs.next()){
			employee=new Employee();
			employee.setEmpno(rs.getInt("empno"));
			employee.setName(rs.getString("name"));
			employee.setDept(rs.getString("dept"));
			employee.setDesig(rs.getString("Desig"));
			employee.setBasic(rs.getInt("basic"));
		}
		return employee;
	}


	@Override
	public String addEmployeeDao(Employee employee) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Employ(Name,Dept,Desig,Basic) values(?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, employee.getName());
		pst.setString(2, employee.getDept());
		pst.setString(3, employee.getDesig());
		pst.setInt(4, employee.getBasic());
		pst.executeUpdate();
		
		return "Employee Record Inserted...";
	}


	@Override
	public String updateEmployeeDao(Employee employeeNew) throws ClassNotFoundException, SQLException {
		Employee employee = searchEmployeeDao(employeeNew.getEmpno());
		if(employee!=null){
		connection = ConnectionHelper.getConnection();
		String cmd = "update Employ set  Name=?, Dept=?, Desig=?, Basic=? where empno=?";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, employeeNew.getName());
		pst.setString(2, employeeNew.getDept());
		pst.setString(3, employeeNew.getDesig());
		pst.setInt(4, employeeNew.getBasic());
		pst.setInt(5, employeeNew.getEmpno());
		pst.executeUpdate();
		
		return "Employee Record Updated...";
		}
		return "Employee Record Not Found...";
	}


	@Override
	public String deleteEmployeeDao(int empno) throws ClassNotFoundException, SQLException {
		Employee employee= searchEmployeeDao(empno);
		if(employee!=null){
			connection = ConnectionHelper.getConnection();
			String cmd = "Delete from Employ where empno=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.executeUpdate();
			return "Employee Record Deleted...";
				
		}
		return "Employee Record Not Found...";
	}
	
	

}
