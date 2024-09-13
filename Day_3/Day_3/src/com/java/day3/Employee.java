package com.java.day3;

public class Employee {
	int empno;
	String name;
	double basic;
	

	public Employee(int empno, String name, double basic) {
		super();
		this.empno = empno;
		this.name = name;
		this.basic = basic;
	}
	
	
	public Employee() {
	
	}


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", basic=" + basic + "]";
	}
	
	
	

}

