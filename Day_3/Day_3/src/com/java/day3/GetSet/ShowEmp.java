package com.java.day3.GetSet;

public class ShowEmp {
	
	
	public static void main(String[] args) {
		
		Emp emp1 = new Emp(1,"Nikhil",99999);
		
		System.out.println(emp1.getEno()+"   "+emp1.getName()+"   "+emp1.getBasic());
	}

}
