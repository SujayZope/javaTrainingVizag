package com.java.day3;

public class GetDemo2 {

	public static void main(String[] args) {
		int x=12;
		String str = "Infinite";
		Demo obj =new Demo();
		obj.show(x, str);
		Employee e1=new Employee(1,"Nikhil",99999);
		obj.show(str, e1);
		Demo<String, Employee> obj1=new Demo<String,Employee>();
		obj1.show("Yogesh", e1);
	}
}
