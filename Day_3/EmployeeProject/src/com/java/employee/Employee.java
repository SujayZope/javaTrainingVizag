package com.java.employee;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private int empno;
	private String name;
	private String gender;
	private String dept;
	private String desig;
	private double basic;
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", gende=" + gender + ", dept=" + dept + ", desig="
				+ desig + ", basic=" + basic + "]";
	}
	public Employee(int empno, String name, Gender gende, String dept, String desig, double basic) {
		super();
		this.empno = empno;
		this.name = name;
		this.gender = gender;
		this.dept = dept;
		this.desig = desig;
		this.basic = basic;
	}
	public Employee() {
		
	}
	
	

}
