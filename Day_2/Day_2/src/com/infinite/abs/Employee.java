package com.infinite.abs;

public abstract class Employee {
	int empno;
	String name;
	double basic;
	
	
	public Employee(int empno, String name, double basic) {
		super();
		this.empno = empno;
		this.name = name;
		this.basic = basic;
	}
	
	public abstract Employee showEmployee(Employee emp);


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", basic=" + basic + "]";
	}
	
	
	
	
	

}
