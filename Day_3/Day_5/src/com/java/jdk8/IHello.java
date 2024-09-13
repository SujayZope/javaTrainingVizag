package com.java.jdk8;

@FunctionalInterface
public interface IHello {

	void dispMsg();
	default void company(){
		System.out.println("Infinite Computers.....");
	}
}
