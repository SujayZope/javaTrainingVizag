package com.infinite.day1;

public class EvenShow {
	
	public void show(int n){
		for(int i=0;i<n;i+=2){
			System.out.println("Even  "+i);
		}
	}
	public static void main(String[] args) {
		int n=20;
		new EvenShow().show(n);
	}

}