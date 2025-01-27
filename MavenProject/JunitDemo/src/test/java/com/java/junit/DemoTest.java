package com.java.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.After;  
import org.junit.AfterClass;  
import org.junit.Before;  
import org.junit.BeforeClass;

import org.junit.Test;


public class DemoTest {

    static Demo obj;

    @BeforeClass 
    public static void setUp() {
        obj = new Demo();
        System.out.println("Global Object Created...");
    }

    @AfterClass 
    public static void cleanUp() {
        obj = null;
        System.out.println("Object Deallocated...");
    }

    @Before 
    public void showInfo() {
        System.out.println("Test Case Started...");
    }

    @After 
    public void clearInfo() {
        System.out.println("Test Case Ended...");
    }
    
    @Test 
    public void testSayHello() {
        // Demo obj = new Demo();
        assertEquals("Welcome to Junit...", obj.sayHello());
    }

    @Test 
    public void testSum() {
        // Demo obj = new Demo();
        assertEquals(5, obj.sum(2,3));
    }

    @Test 
    public void testMax3() {
        // Demo obj = new Demo();
        assertEquals(5, obj.max3(2,3,5));
    }
}
