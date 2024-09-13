package com.java.employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class EmployeeBAL {

	static EmployeeDAO dao;
	static StringBuilder sb;
	
	static{
		dao = new EmployeeDaoImp1();
		sb = new StringBuilder();
	}
	
	public String addEmployeeBal(Employee employee) throws EmployeeException{
		if(doValid(employee)==false){
			throw new EmployeeException(sb.toString());
		}
		return dao.addEmployeeDao(employee);
	}
	
	public Employee searchEmployeeBal(int empno){
		return dao.searchEmployeeDao(empno);
	}
	
	public String readEmployeeFileBal() throws ClassNotFoundException,IOException{
		return dao.readEmployeeFileDao();
	}
	
	public String writeEmployeeFileBal()throws FileNotFoundException,IOException{
		return dao.writeEmployeeFileDao();
	}
	
	public String deleteEmployeeBal(int empno){
		return dao.deleteEmployeeDao(empno);
	}
	
	public String updateEmployeeBal(Employee employee) throws EmployeeException{
		if(doValid(employee)==false){
			throw new EmployeeException(sb.toString());
		}
		return dao.updateEmloyeeDao(employee);
	}
	
	
	public List<Employee> showEmployeeBal(){
		return dao.showEmployeeDAO();
	}
	
	
	public boolean doValid(Employee employee){
		boolean isValid = true;
		if (employee.getEmpno() <= 0){
			sb.append("Employee No cannot be Zero or negative...\n");
			isValid = false;
		}
		if (employee.getName().length() < 5){
			sb.append("Employee Name Contains Min. 5 chars...\n");
			isValid = false;
		}
		if(employee.getDept().length() < 3){
			sb.append("Department Contains Min. 3 chars...\n");
			isValid = false;	
		}
		if(employee.getDesig().length() < 4){
			sb.append("Designation Contains Min. 4 chars...\n");
			isValid = false;
		}
		if(employee.getBasic() < 10000 || employee.getBasic() > 90000){
			sb.append("Basic must be  between 10000 to 90000...\n");
			isValid = false;	
		}
		return isValid;
		
	}
}
