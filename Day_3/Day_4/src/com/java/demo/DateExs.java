package com.java.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateExs {
	
	public static void main(String[] args) {
		String startDate="2022-12-19";
		String endDate="2022-12-20";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			long ms = end.getTime() - start.getTime();
			int days = (int) ms/ (1000 * 60 * 60 * 24);
			days++;
			System.out.println(days);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
