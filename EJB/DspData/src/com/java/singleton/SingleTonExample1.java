package com.java.singleton;

public class SingleTonExample1 {

	public static void main(String[] args) {
		Calculation obj1 = Calculation.getInstance();
		System.out.println(obj1.sum(12, 6));
		Calculation obj2 = Calculation.getInstance();
		System.out.println(obj2.sub(12, 5));
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}
}
