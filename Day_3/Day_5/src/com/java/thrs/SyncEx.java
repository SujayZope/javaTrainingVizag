package com.java.thrs;

public class SyncEx {

	public static void main(String[] args) {
		Data data = new Data();
		Chetan obj1 = new Chetan(data);
		Subodh obj2 = new Subodh(data);
		Nikhil obj3 = new Nikhil(data);
		
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
		Thread t3=new Thread(obj3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
