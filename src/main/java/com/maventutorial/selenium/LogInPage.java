package com.maventutorial.selenium;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends AbstractPageConstructor {
	
	
	@FindBy(how = How.XPATH, xpath = "//*[@id='email']")
	private WebElement eMail;
	
	@FindBy(how = How.XPATH, xpath = "//*[@id='password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, xpath = "//form[@id='login']//button")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, xpath = "*//p[@class='error-text']")
	private WebElement loginError;
	
	@FindBy(how = How.XPATH, xpath = "*//h1")
	private WebElement title;
	
	@FindBy(how = How.XPATH, xpath = "*//a[.='Log out']")
	private WebElement logOutButton;
	
	@FindBy(how = How.XPATH, xpath = ".//h1/span")
	private WebElement logOutMessage;
	
	public LogInPage (WebDriver driver){
		super(driver);
	}
	
	public void enterCredentials(String emailaddress,String passwd){
		eMail.sendKeys(emailaddress);
		password.sendKeys(passwd);
	}
	
	public void pressLoginButton(){
		loginButton.click();
	}
	
	public boolean isUserLoggedInSuccessfully(){
		try{
		if(new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(loginError)) != null)
			return false;
		}
		catch(TimeoutException e){
		return true;
		}
		
		return false;
	}
	
	
	public void logOut(){
		logOutButton.click();
		
		waitForElement(logOutMessage);
	}
	
}
