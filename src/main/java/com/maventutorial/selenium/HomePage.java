package com.maventutorial.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, css = "#user_header>nav>a")
	private WebElement contulMeu;	
	
	public void enterLoginPage(){
		contulMeu.click();
	}
	
	/*		

	
	public void openPage(String pageLink){
		driver.get(pageLink);
	}
	*/
	public void accessMyAccount(){
		contulMeu.click();
	}
	
	
	
	
	/*
	public void accessDaSistemCategory(){
		LoggedInPage pressTheSistemeButton = PageFactory.initElements(driver, LoggedInPage.class);
		pressTheSistemeButton.accessSisteme();
		pressTheSistemeButton.pressAButton();
		
	}
	*/

}
