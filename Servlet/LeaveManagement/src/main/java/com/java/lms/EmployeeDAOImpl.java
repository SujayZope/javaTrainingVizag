package com.java.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Employee> showEmployeeDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from employee";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = null;

		while (rs.next()) {
			employee = new Employee();
			employee.setEmpid(rs.getInt("EMP_ID"));
			employee.setEname(rs.getString("EMP_NAME"));
			employee.setEmail(rs.getString("EMP_MAIL"));
			employee.setMobNo(rs.getString("EMP_MOB_NO"));
			employee.setDateJoin(rs.getDate("EMP_DT_JOIN"));
			employee.setDept(rs.getString("EMP_DEPT"));
			employee.setManagerId(rs.getInt("EMP_MANAGER_ID"));
			employee.setLeaveAvail(rs.getInt("EMP_AVAIL_LEAVE_BAL"));
			employeeList.add(employee);
		}
		connection.close();
		pst.close();
		return employeeList;
	}

	@Override
	public Employee searchEmployeeDao(int empid) throws ClassNotFoundException, SQLException {

		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employee where EMP_ID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empid);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		if (rs.next()) {
			employee = new Employee();
			employee.setEmpid(rs.getInt("EMP_ID"));
			employee.setEname(rs.getString("EMP_NAME"));
			employee.setEmail(rs.getString("EMP_MAIL"));
			employee.setMobNo(rs.getString("EMP_MOB_NO"));
			employee.setDateJoin(rs.getDate("EMP_DT_JOIN"));
			employee.setDept(rs.getString("EMP_DEPT"));
			employee.setManagerId(rs.getInt("EMP_MANAGER_ID"));
			employee.setLeaveAvail(rs.getInt("EMP_AVAIL_LEAVE_BAL"));

		}
		connection.close();
		pst.close();
		return employee;
	}
}
