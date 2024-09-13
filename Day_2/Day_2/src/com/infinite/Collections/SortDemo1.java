package com.infinite.Collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortDemo1 {
	public static void main(String[] args) {
		SortedSet names = new TreeSet();
		
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
		
		for(Object object : names){
			System.out.println(object);
		}
		
	}

}
