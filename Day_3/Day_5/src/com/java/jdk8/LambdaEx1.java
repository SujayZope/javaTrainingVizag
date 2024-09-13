package com.java.jdk8;

public class LambdaEx1 {

	public static void main(String[] args) {
		IHello obj1= () ->{
			System.out.println("Welcome to Lambda Expression...");
		};
		obj1.dispMsg();
		
		IHello obj2= () ->{
			System.out.println("Lambda Expression Session going on...");
		};
		obj2.dispMsg();
	}
}
