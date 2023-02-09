package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.drivermanager.DriverManager;
import com.util.Constants;
import com.util.SeleniumWait;

public class GoogleWithTestNg {
	@BeforeTest
	public void getSetup() {
			WebDriver driver = DriverManager.getBrowser("chrome");
			driver.manage().window().maximize();
			driver.navigate().to("https://www.google.com/");
			SeleniumWait.getImplicitWait(driver, 5);
			
	}
	
	
	
	@Test 
	public void getTest() {
		//Test execution
		
	}
	
	@AfterTest
	public void teardown() {
		//close any connection
	}


}
