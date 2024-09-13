package com.java.singleton;

public class SingleTonExample2 {

	private static ConnectionString cs;
	
	static {
		cs = ConnectionString.getInstance();
	}
	
	public static void main(String[] args) {
		String db="MySql";
		System.out.println(cs.getCredentials(db));
	}
}
