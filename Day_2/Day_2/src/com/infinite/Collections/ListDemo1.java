package com.infinite.Collections;


import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
	
	public static void main(String[] args) {
		List names=new ArrayList();
		names.add("Pavan");
		names.add("Chandu");
		names.add("Lata");
		names.add("Azhar");
		names.add("Chetan");
		System.out.println("Names are  ");
		
		for(Object object : names){
			System.out.println(object);
		}
		System.out.println();
		
		names.add(1,"Nikhil");
		for(Object object : names){
			System.out.println(object);
		}
		System.out.println();
		
		
	}

}
