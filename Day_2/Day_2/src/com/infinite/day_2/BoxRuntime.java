package com.infinite.day_2;

public class BoxRuntime {
	public void show(Object ob){
		String type =ob.getClass().getSimpleName();
		if(type.equals("Integer")){
			System.out.println("Integer Casting...");
			int x=(Integer)ob;
		}
		if(type.equals("String")){
			System.out.println("String Casting...");
			String x=(String)ob;
		}
		if(type.equals("Double")){
			System.out.println("Double Casting...");
			double x=(double)ob;
		}
		
	}
	public static void main(String[] args) {
		int x=12;
		double b=12.5;
		String str="Welcome";
		BoxRuntime bxt=new BoxRuntime();
		bxt.show(str);
		bxt.show(x);
		bxt.show(b);
		
	}

}
