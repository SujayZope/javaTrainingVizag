package com.infinite.day_2;

public class EnumEx1 {

	public static void main(String[] args) {
	WeekDays wd = WeekDays.THURSDAY;
	System.out.println(wd);
	
	String dayNames="SUNDAY";
	
	WeekDays wd2 = WeekDays.valueOf(dayNames);
	System.out.println(wd2);
	

	}

}
