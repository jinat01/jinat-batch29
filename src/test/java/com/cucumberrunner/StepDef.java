package com.cucumberrunner;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.seleniumpagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	SeleniumPageFactory pf;
	@Given("open any browser")
	public void open_any_browser() {
		// Open browser
		 driver = DriverManager.getBrowser("chrome");

		// Maximize browser
		driver.manage().window().maximize();

		// Implicit wait
		SeleniumWait.getImplicitWait(driver, 3);
	}

	@When("go to the browser with URL")
	public void go_to_the_browser_with_URL() {
		// Go to url
		driver.navigate().to(Constants.URL);

		// ScreenShot
		ScreenShot.getScreenShot(driver, "Home Page");

		pf = new SeleniumPageFactory(driver);
		// Explicit wait
		SeleniumWait.getExplicitWait(driver, pf.getSignInBtn().get(0), 3);
	}

	@When("click signin button")
	public void click_signin_button() {
		// Click signin button
		HighLighter.getHighlighter(driver, pf.getSignInBtn().get(0), "red");
		pf.getSignInBtn().get(0).click();

		// ScreenShot
		ScreenShot.getScreenShot(driver, "Login Page");
	}

	@When("put email")
	public void put_email() {
		// Email
		HighLighter.getHighlighter(driver, pf.getEmail(), "red");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.email);
	}

	@When("put password")
	public void put_password() {
		// Password
		HighLighter.getHighlighter(driver, pf.getPassword(), "red");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.pass);
	}

	@When("click second signin button")
	public void click_second_signin_button() {
		// Click second signin button
		HighLighter.getHighlighter(driver, pf.getSecondSignInBtn(), "red");
		pf.getSecondSignInBtn().click();
	}

	@Then("validate the login successful")
	public void validate_the_login_successful() {
		// validation
		HighLighter.getHighlighter(driver, pf.getWelcomeMessage().get(0), "red");
		boolean status = pf.getWelcomeMessage().get(0).isDisplayed();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);
		sa.assertAll();

		// ScreenShot
		ScreenShot.getScreenShot(driver, "After Validation");

	}

}
