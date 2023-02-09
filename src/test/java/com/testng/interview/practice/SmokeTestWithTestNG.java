package com.testng.interview.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeTestWithTestNG {
	@BeforeSuite
	public void suitesetup() {
		System.out.println("This is Before suite setup");
	}
	
	@BeforeTest
	public void getSetup() {
		System.out.println("This is Before Test setup");
	}
	
	@BeforeClass
	public void getClassSetup() {
		System.out.println("This is Before class setup");
	}
	
	
	@BeforeMethod
	public void getMethodSetup() {
		System.out.println("This is Before method setup");
	}
	
	
	@Test
	public void getTest1() {
		System.out.println("This is Test1");
		
	}
	
	
	
	@AfterMethod
	public void getAftermethod() {
		System.out.println("This is after method setup");
	}
	
	
	@AfterClass
	public void getAfterClass() {
		System.out.println("This is after class setup");
	}
	
	
	@AfterTest
	public void teardown() {
		System.out.println("This is after test close connection");
	}
	
	
	@AfterSuite
	public void getAfterSuite() {
		System.out.println("This is after suite setup");
	}
}
