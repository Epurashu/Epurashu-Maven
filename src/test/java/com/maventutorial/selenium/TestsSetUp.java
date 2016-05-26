package com.maventutorial.selenium;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


public abstract class TestsSetUp {
	
	public WebDriver driver;
	public String HomePage;
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		TestProperties setUp = new TestProperties();
		setUp.getPropValues();
		driver = setUp.driver;
		HomePage =setUp.homePageLink;
	}
	
	@AfterSuite
	public void closeTest()
	{
		driver.close();
	}


}
