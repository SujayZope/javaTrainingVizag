package com.infinite.Collections;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortStudent {

	public static void main(String[] args) {
		Comparator o = new CgpaComparator();
		SortedSet names = new TreeSet();
		names.add(new Student(1,"Chetan","Mumbai",9.1));
		names.add(new Student(2,"Riddhi","Pune",8.7));
		names.add(new Student(3,"Abhishek","Delhi",7.7));
		names.add(new Student(4,"Lata","Hydrabad",8.1));
		names.add(new Student(5,"Suraj","Vizag",9.4));
		names.add(new Student(6,"Mitesh","Nanded",7.8));
		names.add(new Student(7,"Parth","Nagpur",8.1));
		
		System.out.println("Names are ");
		for(Object object : names){
			Student student =(Student)object;
			System.out.println(object);
		}
		
	}
}
