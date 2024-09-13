package com.java.demo;

import java.time.LocalDate;

public class date {
	
	public static void main(String[] args) {
		
		
	   // LocalDate date = LocalDate.parse("2020-05-03");
	    LocalDate date = LocalDate.now();
		
		System.out.println("Date : "+date);
		
		LocalDate newDate1 = date.plusMonths(6); 
		
		System.out.println("start Date : "+newDate1);
		
		LocalDate newDate2 = date.plusMonths(18);
		
		
		System.out.println("End Date : "+newDate2);
	}

}
