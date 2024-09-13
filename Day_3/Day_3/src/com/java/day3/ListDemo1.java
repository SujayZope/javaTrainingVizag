package com.java.day3;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
	
	public static void main(String[] args) {
		List<Integer> number =new ArrayList<Integer>();
		number.add(new Integer(32));
		number.add(new Integer(87));
		number.add(new Integer(56));
		number.add(new Integer(45));
		number.add(new Integer(27));
		number.add(new Integer(83));
		
		int sum=0;
		for(Integer i : number){
			sum+=i;
		}
		System.out.println("Sum is  "+sum);
		
	}

}
