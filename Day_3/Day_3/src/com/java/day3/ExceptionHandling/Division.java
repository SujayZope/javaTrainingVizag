package com.java.day3.ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class Division {
	
	public static void main(String[] args) {
		int a,b,c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter two number  ");
		
		try {
			a = sc.nextInt();
			b = sc.nextInt();
			c = a / b;
			System.out.println("Division  " + c);
		} catch (ArithmeticException e) {
			System.err.println("Division by zero not possible ");
		}
		catch (InputMismatchException e){
			System.err.println("String cannot be converted as Integer");
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		finally{
			sc.close();
			System.out.println("Infinite December Batch....");
		}
	}

}
