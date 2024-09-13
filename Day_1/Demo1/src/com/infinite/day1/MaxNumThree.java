package com.infinite.day1;

public class MaxNumThree {
	public void show(int num1, int num2, int num3){
		int m=num1;
		if(m<num2){
			m=num2;
		}
		if(m<num3){
			m=num3;
		}
		System.out.println("Max " +m);
	}
	public static void main(String[] args) {
		int num1=78,num2=89,num3=99;
		new MaxNumThree().show(num1, num2, num3);
		
	}

}
