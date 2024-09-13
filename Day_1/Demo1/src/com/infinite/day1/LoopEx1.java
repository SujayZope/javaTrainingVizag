package com.infinite.day1;

public class LoopEx1 {

	public void show(int n){
		int i=0;
		while(i <= n){
			System.out.println("Welcome to Infinite...");
			i++;
		}
	}
	public static void main(String[] args) {
		int n=10;
		LoopEx1 obj = new LoopEx1();
		obj.show(n);
	}

}
