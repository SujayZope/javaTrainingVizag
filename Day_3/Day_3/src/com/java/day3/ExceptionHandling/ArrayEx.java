package com.java.day3.ExceptionHandling;

public class ArrayEx {
	public static void main(String[] args) {
		int[] a = new int[]{12,5};
		try {
			a[10]=43;
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Array Size is small...");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
