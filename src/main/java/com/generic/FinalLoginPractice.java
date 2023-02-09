package com.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.seleniumpagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FinalLoginPractice {
	public static void getFinalLogin() {
		
		WebDriver driver = DriverManager.getBrowser("chrome");
		
		driver.manage().window().maximize();
		
		SeleniumWait.getImplicitWait(driver,5);
		
		driver.navigate().to(Constants.URL);
		
		ScreenShot.getScreenShot(driver, "Home Page");
		
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		
		HighLighter.getHighlighter(driver, pf.getSignInBtn().get(0), "red");
		
		pf.getSignInBtn().get(0).click();
		
		ScreenShot.getScreenShot(driver, "Login Page");
		
		HighLighter.getHighlighter(driver, pf.getEmail(), "green");
		
		pf.getEmail().sendKeys(Constants.email);
		
		HighLighter.getHighlighter(driver, pf.getPassword(), "blue");
		
		pf.getPassword().sendKeys(Constants.pass);
		
		HighLighter.getHighlighter(driver, pf.getSecondSignInBtn(), "yellow");
		
		pf.getSecondSignInBtn().click();
		
		ScreenShot.getScreenShot(driver, "Login Validation");
		
//		if(pf.getWelcomeMessage().get(0).isDisplayed()) {
//			System.out.println("Test passed");
//		}else {
//			System.out.println("Test failed");
//		}
		

		
		//Assert.assertTrue(pf.getWelcomeMessage().get(0).isDisplayed());
		
		SoftAssert sf = new SoftAssert();
		HighLighter.getHighlighter(driver, pf.getWelcomeMessage().get(0), "pink");
		sf.assertTrue(pf.getWelcomeMessage().get(0).isDisplayed());
		sf.assertAll();
		
		driver.quit();
		
		
		
	}

	public static void main(String[] args) {
		FinalLoginPractice.getFinalLogin();
	}
}
