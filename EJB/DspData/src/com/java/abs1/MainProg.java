package com.java.abs1;

public class MainProg {

	public static void main(String[] args) {
		String topic ="IPhone";
		AbstractFactory obj = new MobileFactory();
		Mobile result = obj.getDetails(topic);
		System.out.println(result.getClass().getSimpleName());
		System.out.println(result.getMobileDetails());
	}
}
