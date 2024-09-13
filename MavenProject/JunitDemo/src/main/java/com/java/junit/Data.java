package com.java.junit;

import java.util.HashMap;
import java.util.Map;

public class Data {
	
	public Object show(String key){
		Map m = new HashMap();
		m.put("Venkat", "Sai");
		m.put("Divya", "Moukthika");
		m.put("Krishna", "Mahendra");
		m.put("Raj", "Kishore");
		return m.get(key);
		
	}
	
	public boolean check(int a){
		if(a%2==0){
			return true;
		}
		return false;
	}
	
	public int max3(int a, int b, int c){
		int m=a;
		if(m<b){
			m=b;
		}if(m<c){
			m=c;
		}
		return m;
	}
	
	public int sum(int a,int b){
		return a+b;
	}
	
	public String sayHello(){
		return "Welcome to Junit Teasting...";
	}

}
