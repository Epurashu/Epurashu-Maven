package com.maventutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstTest {

	@Test
	public void openAnLink(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://filelist.ro");
		WebElement element = driver.findElement(By.id("username"));
		element.sendKeys("Epurashu");
		element = driver.findElement(By.id("password"));
		element.sendKeys("bignope");
		WebElement loginButton = driver.findElement(By.className("btn"));
		loginButton.click();
		
	}
}
