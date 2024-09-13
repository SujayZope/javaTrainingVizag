package com.java.day3.ExceptionHandling;

import java.util.Scanner;

public class ThrEx {
	
	public void show(int n){
		if(n<0){
			throw new ArithmeticException("Negative Number not Allowed...");
		}
		else if(n==0){
			throw new NumberFormatException("Zero is Invalid....");
		}
		else{
			System.out.println("N Value is  "+n);
		}
	}
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N Value  ");
		n=sc.nextInt();
		ThrEx obj = new ThrEx();
		try {
			obj.show(n);
		}
		catch(ArithmeticException e){
			System.out.println(e);
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
