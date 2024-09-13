package com.jsf.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



@ManagedBean(name="empDao")
@SessionScoped
public class EmployeeDaoImpl implements EmployeeDAO {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<Employee> showEmployeeDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employ";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = null;
		while(rs.next()) {
			emp = new Employee();
			emp.setEmpno(rs.getInt("empno"));
			emp.setName(rs.getString("name"));
			emp.setDept(rs.getString("dept"));
			emp.setDesig(rs.getString("desig"));
			emp.setBasic(rs.getInt("basic"));
			empList.add(emp);
		}
		connection.close();
		pst.close();
		return empList;
	}

	@Override
	public String searchEmployeeDao(int empno) throws ClassNotFoundException, SQLException {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employ where empno=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs = pst.executeQuery();
		Employee emp = null;
		if(rs.next()) {
			emp = new Employee();
			emp.setEmpno(rs.getInt("empno"));
			emp.setName(rs.getString("name"));
			emp.setDept(rs.getString("dept"));
			emp.setDesig(rs.getString("desig"));
			emp.setBasic(rs.getInt("basic"));
            sessionMap.put("editEmploy", emp);
		}
		return "UpdateEmployee.xhtml?faces-redirect=true";
	}

	@Override
	public String addEmployeeDao(Employee emp) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into Employ(name,dept,desig,basic) "
				+ " values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, emp.getName());
		pst.setString(2, emp.getDept());
		pst.setString(3, emp.getDesig());
		pst.setInt(4, emp.getBasic());
		pst.executeUpdate();
		return "EmployeeShow.xhtml?faces-redirect=true";

	}

	@Override
	public int authenticate(String user, String pwd) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encr=EntryptPassword.getCode(pwd);
		System.out.println("User Name " +user);
		System.out.println(encr);
		String cmd = "select count(*) cnt from login where userName=? AND passcode=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, user);
		pst.setString(2, encr.trim());
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}

	@Override
	public String updateEmployeeDao(Employee empNew) throws ClassNotFoundException, SQLException {
			String cmd = "update employ set name=?, Dept=?, desig=?, "
					+ " Basic =? where empno=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, empNew.getName());
			pst.setString(2, empNew.getDept());
			pst.setString(3, empNew.getDesig());
			pst.setInt(4, empNew.getBasic());
			pst.setInt(5, empNew.getEmpno());
			pst.executeUpdate();
//			return "Employ Record Updated...";
		return "EmployeeShow.xhtml?faces-redirect=true";
	}

	@Override
	public String deleteEmployeeDao(int empno) throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "delete from Employ where empno=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.executeUpdate();
			return "EmployeeShow.xhtml?faces-redirect=true";
	}

	
	@Override
	public String createUser(Login login) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encPwd = EntryptPassword.getCode(login.getPassCode());
		String cmd = "Insert into login(userName,passCode) "
				+ " values(?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, login.getUserName());
		pst.setString(2, encPwd);
		pst.executeUpdate();
		return "Login.xhtml?faces-redirect=true";
	}

}