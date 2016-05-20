package com.maventutorial.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoggedInPage {

	WebDriver driver;
	
	@FindBy(how = How.XPATH, xpath = "*//nav[@id='bottommenu']/ul/li[@data-link='sisteme']")
	private WebElement sistemeButton;
	
	public LoggedInPage(WebDriver driver){
		this.driver = driver;
		driver.get("https://www.pcgarage.ro/cont/");
	}
	
	public void accessSisteme(){
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(sistemeButton));
		sistemeButton.click();
		//Assert.assertEquals("Let`s fail on purpose :>",driver.getTitle());
		Assert.assertEquals("Sisteme & Servere - PC Garage",driver.getTitle());
	}
	
}
