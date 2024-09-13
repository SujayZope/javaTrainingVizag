package com.java.jdk8;

public class CalcTest {
	
	public int sum(int a,int b){
		return a+b;
	}
	
	public int sub(int a,int b){
		return a-b;
	}
	
	public int multi(int a,int b){
		return a*b;
	}
	
	public static void main(String[] args) {
		ICalc obj1 = new CalcTest()::sum;
		System.out.println(obj1.calc(12,5));
		
		ICalc obj2 = new CalcTest()::sub;
		System.out.println(obj2.calc(12,5));
		
		ICalc obj3 = new CalcTest()::multi;
		System.out.println(obj3.calc(12,5));
		
		
	}

}
