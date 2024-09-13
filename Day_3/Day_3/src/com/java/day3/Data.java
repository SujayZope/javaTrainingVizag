package com.java.day3;

public class Data<T> {
	
	public void swap(T a,T b){
		T t;
		t=a;
		a=b;
		b=t;
		
		System.out.println("A Value "+ a +" B Value "+b);
	}

}
