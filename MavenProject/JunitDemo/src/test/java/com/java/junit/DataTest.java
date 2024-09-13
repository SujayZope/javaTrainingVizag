package com.java.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataTest {
	static Data obj;
	
	@Before
	public void show(){
		System.out.println("Test Case Execution Started...");
	}
	
	@After
	public void clear(){
		System.out.println("Test Case Execution Completed...");
	}
	
	@BeforeClass
	public static void setUp(){
		obj = new Data();
		System.out.println("Test Cases are getting executed...");
	}
	
	@AfterClass
	public static void cleanUp(){
		obj = null;
		System.out.println("Test Cases Completed... Objects Restored");
	}

	@Test
	public void testSayHello() {
		assertEquals("Welcome to Junit Teasting...", obj.sayHello());
	}
	
	@Test
	public void testSum(){
		assertEquals(5, obj.sum(4, 1));
	}

	@Test
	public void testMax3(){
		assertEquals(5, obj.max3(5, 3, 1));
		assertEquals(10, obj.max3(5, 10, 1));
		assertEquals(16, obj.max3(5, 6, 16));
	}
	
	@Test
	public void testCheck(){
		assertTrue(obj.check(2));
		assertFalse(obj.check(3));
		
	}
	
	@Test
	public void testArray(){
		int[] a = new int[] {1,2,3,4,5};
		int[] b = new int[] {1,2,3,4,5};
		assertArrayEquals(a, b);
	}
	
	@Test
	public void testShow(){
		assertNotNull(obj.show("Venkat"));
		assertNull(obj.show("Yogesh"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
