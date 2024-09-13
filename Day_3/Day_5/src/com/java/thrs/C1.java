package com.java.thrs;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class C1 implements Runnable{
	
	@Override
	public void run() {
		List<String> names =new ArrayList<String>();
		names.add("Chandu");
		names.add("Nikhil");
		names.add("Yogesh");
		names.add("Deepak");
		names.add("Aniket");
		names.add("Lata");
		for(String s : names){
			System.out.println("ArrayList is  "+s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
}
