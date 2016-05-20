package com.maventutorial.selenium;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class FirstTest {

	WebDriver driver = new FirefoxDriver();

	
	@Test
	public void FailedLogIn(){
		HomePage pcGarage = PageFactory.initElements(driver, HomePage.class);
		pcGarage.accessMyAccount();
		pcGarage.enterCredentials("ggg@yahoo.com", "NotMyPAss");
		pcGarage.pressLoginButton();
		
	}
	
	@Test
	public void SuccessfulLogin(){
		HomePage pcGarage = PageFactory.initElements(driver, HomePage.class);
		pcGarage.accessMyAccount();
		pcGarage.enterCredentials("alexeusebiu@yahoo.co.uk","felicia");
		pcGarage.pressLoginButton();
	}
	
	@Test
	public void doSomethingIrrelevant()
	{
		HomePage pcGarage = PageFactory.initElements(driver, HomePage.class);
		pcGarage.accessMyAccount();
		pcGarage.enterCredentials("alexeusebiu@yahoo.co.uk", "felicia");
		pcGarage.pressLoginButton();
		pcGarage.accessDaSistemCategory();
	}

	/*
	
	@Test
	public void LoginSuccessufulTest() throws InterruptedException{
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
	
	@Test
	public void facebookCreate() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		
		WebElement field = driver.findElement(By.id("u_0_1"));
		field.sendKeys("Popaye");
		
		field = driver.findElement(By.id("u_0_3"));
		field.sendKeys("Sailor");
		
		field = driver.findElement(By.id("u_0_6"));
		field.sendKeys("testing@yahoo.com");
		
		field = driver.findElement(By.id("u_0_9"));
		field.sendKeys("testing@yahoo.com");
		
		field = driver.findElement(By.id("u_0_b"));
		field.sendKeys("testPassword");
		
		field = driver.findElement(By.id("u_0_e"));
		field.click();
		
		//Adding values to the dropdown lists
		Select dropDownList = new Select(driver.findElement(By.id("month")));
		dropDownList.selectByValue(Integer.toString(randInt(1,12)));
		
		dropDownList = new Select(driver.findElement(By.id("day")));
		dropDownList.selectByValue(Integer.toString(randInt(1,31)));
		
		dropDownList = new Select(driver.findElement(By.id("year")));
		dropDownList.selectByValue(Integer.toString(randInt(1915,2016)));
		
		
	}
	
	
	public static int randInt(int min, int max) {

	    // NOTE: This will (intentionally) not run as written so that folks
	    // copy-pasting have to think about how to initialize their
	    // Random instance.  Initialization of the Random instance is outside
	    // the main scope of the question, but some decent options are to have
	    // a field that is initialized once and then re-used as needed or to
	    // use ThreadLocalRandom (if using at least Java 1.7).
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	*/
}
