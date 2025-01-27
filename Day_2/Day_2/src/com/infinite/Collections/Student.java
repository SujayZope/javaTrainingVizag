package com.infinite.Collections;

public class Student implements Comparable {
	int rno;
	String name;
	String city;
	double cgpa;
	
	
	public Student() {
		
		
	}


	public Student(int rno, String name, String city, double cgpa) {
		super();
		this.rno = rno;
		this.name = name;
		this.city = city;
		this.cgpa = cgpa;
	}


	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", city=" + city + ", cgpa=" + cgpa + "]";
	}


	@Override
	public int compareTo(Object o) {
		Student student = (Student)o;
		
		return name.compareTo(student.name);
	}
	
	
	
	

}
