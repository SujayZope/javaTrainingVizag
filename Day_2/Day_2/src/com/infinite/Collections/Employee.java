package com.infinite.Collections;

public class Employee {
	int empno;
	String name;
	double basic;
	
	
	public Employee() {
	
	}


	public Employee(int empno, String name, double basic) {
		super();
		this.empno = empno;
		this.name = name;
		this.basic = basic;
	}


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", basic=" + basic + "]";
	}
	
	
	

}
