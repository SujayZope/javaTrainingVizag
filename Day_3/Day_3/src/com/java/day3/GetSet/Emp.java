package com.java.day3.GetSet;

public class Emp {
	private int eno;
	private String name;
	private double basic;
	
	
	public Emp() {
	
	}


	public Emp(int eno, String name, double basic) {
		super();
		this.eno = eno;
		this.name = name;
		this.basic = basic;
	}


	@Override
	public String toString() {
		return "Emp [eno=" + eno + ", name=" + name + ", basic=" + basic + "]";
	}


	public int getEno() {
		return eno;
	}


	public String getName() {
		return name;
	}


	public double getBasic() {
		return basic;
	}
	
	
	
	

}
