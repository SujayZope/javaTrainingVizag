package com.java.thrs;

import java.util.*;

public class C2 implements Runnable {
	
	@Override
	public void run() {
		LinkedList<String> names =new LinkedList<String>();
		names.add("Chandu");
		names.add("Nikhil");
		names.add("Yogesh");
		names.add("Deepak");
		names.add("Aniket");
		names.add("Lata");
		names.addFirst("Subodh");
		names.addLast("Abhijit");
		for(String s : names){
			System.out.println("Linked List  "+s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
