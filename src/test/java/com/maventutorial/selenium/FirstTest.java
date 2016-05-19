package com.maventutorial.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstTest {

	@Test
	public void openAnLink() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		//Open Yahoo Mail Page
		driver.get("http:/login.yahoo.com");
		
		//Trying to uncheck the Stayed logged in
		WebElement element = driver.findElement(By.id("persistent"));
		Actions unclickPersistency = new Actions(driver);
		unclickPersistency.moveByOffset(element.getLocation().getX(), element.getLocation().getY()).click();
		
		//Writing email Adress
		WebElement loginForm = driver.findElement(By.id("login-username"));
		loginForm.sendKeys("n.skype@yahoo.com");

		//Clicking on Next
		element = driver.findElement(By.id("login-signin"));
		element.click();

		//Writing password
		loginForm =(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("login-passwd")));
		loginForm.sendKeys("felicia");
		
		//Clicking on Log-In
		element = driver.findElement(By.id("login-signin"));
		element.click();
		
		//Wait for the Search Bar to load
		element =(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.id("UHSearchBox")));
		element.sendKeys("Page Has Loaded");
		System.out.println("You have logged in !");
		
	}
	
	@Test
	public void failedTest() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://webmail-studs.info.uaic.ro/?_action=login&_url=");
		WebElement loginForm = driver.findElement(By.id("rcmloginuser"));
		loginForm.sendKeys("Spanac");
		
		loginForm = driver.findElement(By.id("rcmloginpwd"));
		loginForm.sendKeys("supa");
		
		WebElement FindingNemo = driver.findElement(By.xpath("//*[@id='login-form']/div[2]/form/p/input"));
		FindingNemo.click();
	}
	
	
}
