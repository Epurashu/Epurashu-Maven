package com.maventutorial.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageConstructor {

	public WebDriver driver;
	
	@FindBy(how = How.XPATH, xpath = "*//body")
	private WebElement title;
	
	
	public AbstractPageConstructor (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		waitForElement(title);
	}
	
	public void waitForElement(WebElement element){
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElement(WebElement element, int waitTime){
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.elementToBeClickable(element));
	}
}
