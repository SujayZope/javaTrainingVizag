package com.infinite.day_2;

public class StExample {
	
	static {
		System.out.println("Static Constructor...");
	}
	
	StExample(){
		System.out.println("Default Constructor...");
	}
	
	
	public static void main(String[] args) {
		StExample obj = new StExample();
		
	}

}
