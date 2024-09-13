package com.java.jdk8;

public class Greeting {
	
	public void greet(){
		System.out.println("Good Morning to all..");
	}
	
	public static void main(String[] args) {
		IGreeting obj1 = new Greeting()::greet;
		obj1.Solution();
	}

}
