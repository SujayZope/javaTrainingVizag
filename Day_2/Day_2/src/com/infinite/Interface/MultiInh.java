package com.infinite.Interface;

public class MultiInh implements IOne,ITwo{

	@Override
	public void email() {
		System.out.println("Email is infinte@gmail.com");
		
	}

	@Override
	public void name() {
		System.out.println("Name is Infinite....");
		
	}
	
	public static void main(String[] args) {
		MultiInh obj = new MultiInh();
		obj.email();
		obj.name();
	}

}
