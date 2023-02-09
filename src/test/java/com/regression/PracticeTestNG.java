package com.regression;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTestNG {
	
	@BeforeTest
	public void getSetup1() {
		System.out.println("This is Before Test setup");
	}
	
	@Test (priority = 0)
	public void getTest0() {
		System.out.println("This is Test0");
		
	}
	
	

	
	@Test (priority = 1, enabled = false)
	public void getTest1() {
		System.out.println("This is Test One");
		
	}
	
	
	@Test (priority = 2, enabled = false)
	public void getTest2() {
		System.out.println("This is Test two");
		
	}
	
	
	@AfterTest
	public void teardown2() {
		System.out.println("This is after test close connection two");
	}

}
