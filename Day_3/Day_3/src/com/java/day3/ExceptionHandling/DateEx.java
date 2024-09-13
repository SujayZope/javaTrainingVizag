package com.java.day3.ExceptionHandling;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateEx {
	
	public static void main(String[] args) {
		Date obj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		System.out.println(sdf.format(obj));
	}

}
