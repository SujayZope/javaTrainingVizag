package com.infinite.Collections;

import java.util.HashSet;
import java.util.Set;

public class SetDemo1 {
	
	public static void main(String[] args) {
		
		Set names = new HashSet();
		names.add("Chetan");
		names.add("Ritesh");
		names.add("Kiran");
		names.add("Yogesh");
		names.add("Suraj");
		names.add("Nikhil");
		names.add("Deepak");
		names.add("Mahesh");
		names.add("Aniket");
		names.add("Akshay");
		
		System.out.println("Names are  ");
		for(Object object : names){
			System.out.println(object);
		}
	}

}
