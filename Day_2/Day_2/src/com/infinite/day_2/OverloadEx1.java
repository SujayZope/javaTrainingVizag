package com.infinite.day_2;

public class OverloadEx1 {
	public void show(int x){
		System.out.println("Show Method w.r.t. Integer "+x);
	}
	public void show(double x){
		System.out.println("Show Method w.r.t. Double "+x);
	}
	public void show(String x){
		System.out.println("Show Method w.r.t. String "+x);
	}

	public static void main(String[] args) {
		OverloadEx1 obj1= new OverloadEx1();
		obj1.show(12);
		obj1.show(12.5);
		obj1.show("Yogesh");
	}
}
