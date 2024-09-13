package com.infinite.Collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {
	public static void main(String[] args) {
		List numbers = new ArrayList();
		numbers.add(new Integer(32));
		numbers.add(new Integer(56));
		numbers.add(new Integer(87));
		numbers.add(new Integer(98));
		numbers.add(new Integer(516));
		numbers.add(new Integer(345));
		numbers.add(new Integer(76));
		
		int sum=0;
		for(Object object : numbers){
			sum+=(Integer)object;
		}
		System.out.println("Sum is  "+sum);
		
		
	}

}
