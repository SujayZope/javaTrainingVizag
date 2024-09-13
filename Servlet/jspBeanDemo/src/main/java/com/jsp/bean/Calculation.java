package com.jsp.bean;

public class Calculation {
	
	private int firstno;
	private int secondno;
	
	
	public int getFirstno() {
		return firstno;
	}
	public void setFirstno(int firstno) {
		this.firstno = firstno;
	}
	public int getSecondno() {
		return secondno;
	}
	public void setSecondno(int secondno) {
		this.secondno = secondno;
	}
	
	
	public int sum(){
		return getFirstno() + getSecondno();
	}
	
	public int sub(){
		return getFirstno() - getSecondno();
	}
	
	public int multi(){
		return getFirstno() * getSecondno();
	}
	
	

}
