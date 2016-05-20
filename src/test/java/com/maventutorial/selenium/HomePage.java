package com.maventutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		driver.get("http://pcgarage.ro");
	}
	
	@FindBy(how = How.CSS, css = "#user_header>nav>a")
	private WebElement contulMeu;
	
	@FindBy(how = How.XPATH, xpath = "//*[@id='email']")
	private WebElement eMail;
	
	@FindBy(how = How.XPATH, xpath = "//*[@id='password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, xpath = "//form[@id='login']//button")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, xpath = "*//p[@class='error-text']")
	private WebElement loginError;
	
	public void enterLoginPage(){
		contulMeu.click();
	}
	
	public void enterCredentials(String emailaddress,String passwd){
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(eMail));
		eMail.sendKeys(emailaddress);
		password.sendKeys(passwd);
	}
	
	public void pressLoginButton(){
		Assert.assertTrue(isUserLoggedInSuccessfully(),"User failed to login");
	}
	
	public void openPage(String pageLink){
		driver.get(pageLink);
	}
	
	public boolean isUserLoggedInSuccessfully(){
		loginButton.click();
		try{
		if(new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(loginError)) != null)
			return false;
		}
		catch(TimeoutException e){
		return true;
		}
		
		return false;
	}
	
	public void accessMyAccount(){
		contulMeu.click();
	}
	
	
	
	
	
	public void accessDaSistemCategory(){
		LoggedInPage pressTheSistemeButton = PageFactory.initElements(driver, LoggedInPage.class);
		pressTheSistemeButton.accessSisteme();
	}

}
