package com.java.thrs;

public class TabDemo {
	public static void main(String[] args) {
		MTable table = new MTable();
		Tab1 obj1=new Tab1(table);
		Tab2 obj2=new Tab2(table);
	
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
		
		t1.start();
		t2.start();
		
	}

}
