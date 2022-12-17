package com.seleniumpagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	WebDriver driver;
	public SeleniumPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//*[@class='authorization-link']")
	private List<WebElement> signInBtn;
	
	@FindBy(xpath="//*[@title='Email']")
	private WebElement email;
	
	@FindBy(xpath="//*[@title='Password']")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='action login primary']")
	private WebElement secondSignInBtn;
	
	@FindBy(xpath="//*[@class='greet welcome']")
	private List<WebElement> welcomeMessage;
	
	//Costco web page
	@FindBy(xpath="//*[text() ='Sign In / Register']")
	private List<WebElement> costCoSignIn;
	
	@FindBy(xpath="//*[@id='navigation-widget']//a")
	private List<WebElement> costCoMenuBtn;
	
	@FindBy(xpath="//*[@class='sub-item']")
	private List<WebElement> dealSubItem;
	
	
	
	public List<WebElement> getDealSubItem() {
		return dealSubItem;
	}



	public List<WebElement> getCostCoMenuBtn() {
		return costCoMenuBtn;
	}

	

	public List<WebElement> getCostCoSignIn() {
		return costCoSignIn;
	}



	public List<WebElement> getSignInBtn() {
		return signInBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSecondSignInBtn() {
		return secondSignInBtn;
	}

	public List<WebElement> getWelcomeMessage() {
		return welcomeMessage;
	}
	
	
}
