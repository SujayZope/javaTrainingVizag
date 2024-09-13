package com.java.thrs;

public class Tab2 implements Runnable {
	
	MTable mtable;
	Tab2(MTable mtable){
		this.mtable=mtable;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		mtable.dispTable(15);
	}

}
