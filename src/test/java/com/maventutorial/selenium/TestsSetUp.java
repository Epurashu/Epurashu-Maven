package com.maventutorial.selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public abstract class TestsSetUp {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		String HomePage = "http://pcgarage.ro";
		driver.get(HomePage);
	}
	
	@AfterTest
	public void reset() throws Exception {
		driver.close();
		/*
		String Homepage = "http://pcgarage.ro";
		driver = new FirefoxDriver();
		driver.get(Homepage);
		*/
	}


}
