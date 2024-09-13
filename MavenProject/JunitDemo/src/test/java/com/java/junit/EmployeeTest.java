package com.java.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testConstructors(){
		Employee employee1=new Employee();
		assertNotNull(employee1);
		Employee employee2 = new Employee(1,"Nikhil",Gender.MALE,"JAVA","Programmer",88888.12);
		assertEquals(1,employee2.getEmpno());
		assertEquals("Nikhil",employee2.getName());
		assertEquals(Gender.MALE,employee2.getGender());
		assertEquals("JAVA",employee2.getDept());
		assertEquals("Programmer",employee2.getDesign());
		assertEquals(88888.12,employee2.getBasic(),2);
		
		
	}
	
	@Test
	public void testGettersAndSetters(){
		Employee employee1=new Employee();
		employee1.setEmpno(1);
		employee1.setName("Nikhil");
		employee1.setGender(Gender.MALE);
		employee1.setDept("JAVA");
		employee1.setDesign("Programmer");
		employee1.setBasic(88888.88);
		
		
		assertEquals(1, employee1.getEmpno());
		assertEquals("Nikhil", employee1.getName());
		assertEquals(Gender.MALE, employee1.getGender());
		assertEquals("JAVA", employee1.getDept());
		assertEquals("Programmer", employee1.getDesign());
		assertEquals(88888.88, employee1.getBasic(),2);
	}
	
//	@Test
//	public void testtoString() {
//		Employee emp = new Employee(1,"Nikhil", Gender.MALE, "JAVA", "Programmer",88888.88);
//		String result= "Employee [empno=" + empno + ", name=" + name + ", gender=" + gender + ", dept=" + dept + ", design="
//				+ design + ", basic=" + basic + "]";
//	}
	
	
	
}
