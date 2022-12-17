package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.seleniumpagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
	public void getLogin() {
		//Open browser
		WebDriver driver = DriverManager.getBrowser("chrome");
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//Implicit wait
		SeleniumWait.getImplicitWait(driver, 3);
		
		//Go to url
		driver.navigate().to(Constants.URL);
		
		//ScreenShot 
		ScreenShot.getScreenShot(driver,"Home Page");
		
		
		
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		//Explicit wait
		SeleniumWait.getExplicitWait(driver, pf.getSignInBtn().get(0), 3);
		
		//Click signin button
		HighLighter.getHighlighter(driver, pf.getSignInBtn().get(0), "red");
		pf.getSignInBtn().get(0).click();
		
		//ScreenShot 
		ScreenShot.getScreenShot(driver,"Login Page");
		
		//Email
		HighLighter.getHighlighter(driver, pf.getEmail(), "red");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.email);
		
		//Password
		HighLighter.getHighlighter(driver, pf.getPassword(), "red");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.pass);
		
		
		//Click second signin button
		HighLighter.getHighlighter(driver, pf.getSecondSignInBtn(), "red");
		pf.getSecondSignInBtn().click();
		
		
		//validation
		HighLighter.getHighlighter(driver, pf.getWelcomeMessage().get(0), "red");
		boolean status = pf.getWelcomeMessage().get(0).isDisplayed();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);
		sa.assertAll();
		
		//ScreenShot 
		ScreenShot.getScreenShot(driver,"After Validation");
		
	}
	
	

}
