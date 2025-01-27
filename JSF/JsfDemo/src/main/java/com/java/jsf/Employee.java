package com.java.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Employee {
	
	private int empno;
	private String name;
	private String dept;
	private String desig;
	private double basic;
	
	
	public Employee() {
	
	}


	public Employee(int empno, String name, String dept, String desig, double basic) {
		super();
		this.empno = empno;
		this.name = name;
		this.dept = dept;
		this.desig = desig;
		this.basic = basic;
	}


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
		return "Employee [empno=" + empno + ", name=" + name + ", dept=" + dept + ", desig=" + desig + ", basic="
				+ basic + "]";
	}
	
	

}
