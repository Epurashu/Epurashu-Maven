package com.maventutorial.selenium;

import org.openqa.selenium.TimeoutException;
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
	
	public boolean waitForElement(WebElement element){
		return waitForElement(element, 10);

	}
	
	public boolean waitForElement(WebElement element, int waitTime){
		try{
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.elementToBeClickable(element));
		return true;
		}
		catch (TimeoutException e){
			String errorMessage = e.getMessage();
			String errorParser[] = errorMessage.split("\n");
			System.out.println("Elementul: "+errorParser[0].substring(errorParser[0].lastIndexOf("By."))+" nu a fost gasit pe pagia: "+driver.getCurrentUrl() );
			return false;
		}
	}
}
