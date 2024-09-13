package com.java.jdk8;

import java.util.Calendar;
import java.util.Date;

public class CalEx4 {
	
	public long count(Date start, Date end) {
		 Calendar c1 = Calendar.getInstance();
		    c1.setTime(start);
		    int w1 = c1.get(Calendar.DAY_OF_WEEK);
		    c1.add(Calendar.DAY_OF_WEEK, -w1);

		    Calendar c2 = Calendar.getInstance();
		    c2.setTime(end);
		    int w2 = c2.get(Calendar.DAY_OF_WEEK);
		    c2.add(Calendar.DAY_OF_WEEK, -w2);

		    //end Saturday to start Saturday 
		    long days = (c2.getTimeInMillis()-c1.getTimeInMillis())/(1000*60*60*24);
		    long daysWithoutWeekendDays = days-(days*2/7);

		    // Adjust days to add on (w2) and days to subtract (w1) so that Saturday
		    // and Sunday are not included
		    if (w1 == Calendar.SUNDAY && w2 != Calendar.SATURDAY) {
		        w1 = Calendar.MONDAY;
		    } else if (w1 == Calendar.SATURDAY && w2 != Calendar.SUNDAY) {
		        w1 = Calendar.FRIDAY;
		    } 

		    if (w2 == Calendar.SUNDAY) {
		        w2 = Calendar.MONDAY;
		    } else if (w2 == Calendar.SATURDAY) {
		        w2 = Calendar.FRIDAY;
		    }

		    return daysWithoutWeekendDays-w1+w2;

	}
	
	public static void main(String[] args) {
		Date start = new Date();
		Date today = new Date();
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, -15);
		start = cal1.getTime();
		System.out.println(start);
		System.out.println(today);
		System.out.println(new CalEx4().count(start, today));
	}
}