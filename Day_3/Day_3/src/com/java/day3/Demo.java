package com.java.day3;

public class Demo <T,V> {
	
	public void show(T t,V v){
		System.out.println(t.getClass().getSimpleName());
		System.out.println(v.getClass().getSimpleName());
	}

}
