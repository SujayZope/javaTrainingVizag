package com.java.hbn;

import javax.persistence.*;
import org.hibernate.*;


@Entity
@Table(name="Employ")
public class Employee {

	@Id
	@Column(name="empno")
	private int empno;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dept")
	private String dept;
	
	@Column(name="desig")
	private String desig;
	
	@Column(name="basic")
	private int basic;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	

	@Override
	public String toString() {
		return "Employee Records\n"+"------------------------------------------"
				+"\nEmployee No\t=\t" + empno + "\nEmployee Name\t=\t" 
				+ name + "\nDepartment\t=\t" + dept + "\nDesignation\t=\t" + desig + "\nBasic\t\t=\t"
				+ basic + "\n------------------------------------------\n";
	}
	
	
//	@Override
//	public String toString() {
//		return "empno\t" + "name\t" +"dept\t" +"desig\t" +"basic\n"
//				+empno+ "\t" +name+ "\t" +dept+"\t" +desig+"\t" +basic+"";
//	}

	
	
}