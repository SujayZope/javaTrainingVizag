package com.infinite.Collections;

import java.util.Comparator;

public class CgpaComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		if(s2.cgpa >= s2.cgpa){
			return 0;
		}
		
		return -1;
	}

}
