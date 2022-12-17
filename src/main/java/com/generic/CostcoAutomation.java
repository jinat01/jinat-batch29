package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.seleniumpagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class CostcoAutomation {
		public static void productHandle() throws InterruptedException {
		WebDriver driver = DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to(Constants.COSTCO_URL);
		SeleniumWait.getImplicitWait(driver, 5);
		
		//Get the page name => title>> getTitle()
		System.out.println("Home page title/ name = " + driver.getTitle());
		ScreenShot.getScreenShot(driver, "Costco home welcome page");
		//Check = validate current URL is matched or not ==> getCurrentUrl()
		System.out.println("Current page URL = " + driver.getCurrentUrl());
		
		//Expectation = Constants.COSTCO_URL , actual = driver.getCurrentUrl()
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(driver.getCurrentUrl(), Constants.COSTCO_URL);
		//Go to signIn page
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getCostCoSignIn().get(0), 30);
		HighLighter.getHighlighter(driver, pf.getCostCoSignIn().get(0), "red");
		pf.getCostCoSignIn().get(0).click();
		//Get the page name
		System.out.println("Login page title/name = " + driver.getTitle());
		ScreenShot.getScreenShot(driver, "Costco home signin page");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		driver.navigate().back();//costco problem
//		driver.navigate().back();
		
//		for(int i=0; i<10; i++) {
//			if(pf.getCostCoSignIn().size()>0) {
//				break;
//			}else {
//				driver.navigate().back();
//				Thread.sleep(3000);
//			}
//		}
		
		while(true) {
			if(pf.getCostCoSignIn().size()>0) {
				break;
			}else {
				driver.navigate().back();
				Thread.sleep(3000);
			}
		}
		
		//Read all options and count options below the login button
		System.out.println("Menu count = " + pf.getCostCoMenuBtn().size());
		for(int i=0; i<pf.getCostCoMenuBtn().size(); i++) {
			HighLighter.getHighlighter(driver, pf.getCostCoMenuBtn().get(i), "red");
			System.out.println(pf.getCostCoMenuBtn().get(i).getText());
		}
		
		
		//If deal is there mousehover on it and read all options
		//mousehover = Actions class = moveToElement
		for(int i=0; i<pf.getCostCoMenuBtn().size(); i++) {
			
			if(pf.getCostCoMenuBtn().get(i).getText().contains("Deals")) {
				HighLighter.getHighlighter(driver, pf.getCostCoMenuBtn().get(i), "white");
				Actions ac = new Actions(driver);
				ac.moveToElement(pf.getCostCoMenuBtn().get(i)).perform();
				Thread.sleep(2000);
				
				System.out.println("Deal options count = "+ pf.getDealSubItem().size());
				//Read name of all deal options==> loop
				
				for(int j=0; j<pf.getDealSubItem().size(); j++) {
					HighLighter.getHighlighter(driver, pf.getDealSubItem().get(j), "green");
					System.out.println( pf.getDealSubItem().get(j).getText());
					
				}
			}
		}
		
		

		
		
		sf.assertAll();
		}
		
		public static void main(String[] args) throws InterruptedException {
			CostcoAutomation.productHandle();
		}
}
