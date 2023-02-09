package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.drivermanager.DriverManager;
import com.util.SeleniumWait;

public class LumaWithTestNG {
	@BeforeTest
	public void getSetup() {
			WebDriver driver = DriverManager.getBrowser("chrome");
			driver.manage().window().maximize();
			driver.navigate().to("https://magento.softwaretestingboard.com/");
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
