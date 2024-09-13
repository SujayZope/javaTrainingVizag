package com.java.day3.ExceptionHandling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ChkEx {
	
	public void show(String date) throws ParseException {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-mm-dd");
		Date dt = sdf.parse(date);
		System.out.println(dt);
		
	}
	public static void main(String[] args) {
		String date ="2022-12-16";
		ChkEx obj = new ChkEx();
		try{
			obj.show(date);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		
	} 

}
