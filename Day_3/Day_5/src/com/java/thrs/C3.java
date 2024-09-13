package com.java.thrs;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class C3 implements Runnable{
	
	@Override
	public void run() {
		Vector<String> names =new Vector<String>();
		names.add("Chandu");
		names.add("Nikhil");
		names.add("Yogesh");
		names.add("Deepak");
		names.add("Aniket");
		names.add("Lata");
		for(String s : names){
			System.out.println("Vector is  "+s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	

}
