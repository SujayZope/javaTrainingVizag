package com.java.employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class EmployeeDaoImp1 implements EmployeeDAO{
	
	static List<Employee> employeeList;
	
	
	static{
		employeeList= new ArrayList<Employee>();
	}

	@Override
	public List<Employee> showEmployeeDAO() {
		// TODO Auto-generated method stub
		return employeeList;
	}

	@Override
	public String addEmployeeDao(Employee employee) {
		employeeList.add(employee);
		return "Employee Record Added Successfully....";
	}

	@Override
	public Employee searchEmployeeDao(int empno) {
		Employee employeeFound = null;
		for(Employee employee : employeeList){
			if(employee.getEmpno()==empno){
				employeeFound = employee;
				break;
			}	
		}
		return employeeFound;
	}

	@Override
	public String deleteEmployeeDao(int empno) {
		Employee employeeFound = searchEmployeeDao(empno);
		if(employeeFound != null){
			employeeList.remove(employeeFound);
			return "Employee Record Deleted...";
		}
		return "Employee Record Not Found....";
	}

	@Override
	public String updateEmloyeeDao(Employee employeeNew) {
		Employee employeeFound = searchEmployeeDao(employeeNew.getEmpno());
		if(employeeFound != null){
			for(Employee employee : employeeList){
				if(employee.getEmpno()==employeeNew.getEmpno()){
				employee.setName(employeeNew.getName());
				employee.setDept(employeeNew.getDept());
				employee.setDesig(employeeNew.getDesig());
				employee.setGender(employeeNew.getGender());
				employee.setBasic(employeeNew.getBasic());
				}
				break;
			}
			return "Employee Record Updated...";
		}
		return "Employee Record Not Found....";
	}

	@Override
	public String writeEmployeeFileDao() throws IOException {
		FileOutputStream fout = new FileOutputStream("D:/Files/project.txt");
		ObjectOutputStream objout=new ObjectOutputStream(fout);
		objout.writeObject(employeeList);
		objout.close();
		fout.close();
		
		return "File Created Successfully...";
	}

	@Override
	public String readEmployeeFileDao() throws ClassNotFoundException, IOException {
		FileInputStream fin = new FileInputStream("D:/Files/project.txt");
		ObjectInputStream objin=new ObjectInputStream(fin);
		employeeList=(List<Employee>)objin.readObject();
		objin.close();
		fin.close();
		
		return "File Data read Successfully...";
	}
	

}
