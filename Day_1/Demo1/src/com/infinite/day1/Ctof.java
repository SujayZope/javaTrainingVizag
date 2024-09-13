package com.infinite.day1;

public class Ctof {

	public void calc(double c){
		double f;
		f=((9*c)/5)+32;
		System.out.println("Fahrenheit Value  "+f);
		
		}
	public void kelvin(double c){
		double d;
		
	}
	public void Radian(double c){
		double a;
		a=c*(3.14/180);
		System.out.println(a);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double c=37;
		new Ctof().calc(c);
		new Ctof().Radian(c);

	}

}
