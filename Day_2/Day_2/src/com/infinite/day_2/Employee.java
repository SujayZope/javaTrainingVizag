package com.infinite.day_2;

public class Employee {
	
	int empno;
	String name;
	double basic;
	
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", basic=" + basic + "]";
	}


	public Employee() {
		
		
	}
	


	public Employee(int empno, String name, double basic) {
		super();
		this.empno = empno;
		this.name = name;
		this.basic = basic;
	}


	public static void main(String[] args) {
		
	}

}
