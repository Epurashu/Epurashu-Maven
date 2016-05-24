package com.maventutorial.selenium;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstTest extends TestsSetUp {
	
	//public String HomePage = "http://pcgarage.ro";
	
	@BeforeMethod
	public void setUp() {
		driver.get(HomePage);
	}
	
	
	@Test
	public void FailedLogIn(){
		
		HomePage homePage = new HomePage(this.driver);
		homePage.accessMyAccount();
		LogInPage loginPage = new LogInPage(this.driver);
		loginPage.enterCredentials("ggg@yahoo.com", "NotMyPAss");
		loginPage.pressLoginButton();
		Assert.assertFalse(loginPage.isUserLoggedInSuccessfully(),"User failed to login");
	}
	
	@Test
	public void SuccessfulLogin(){
		HomePage homePage = new HomePage(this.driver);
		homePage.accessMyAccount();
		LogInPage loginPage = new LogInPage(this.driver);
		loginPage.enterCredentials("alexeusebiu@yahoo.co.uk", "felicia");
		loginPage.pressLoginButton();
		Assert.assertTrue(loginPage.isUserLoggedInSuccessfully(),"User logged successfully");
		loginPage.logOut();
	}
	
	@Test
	public void doSomethingIrrelevant()
	{
		HomePage homePage = new HomePage(this.driver);
		homePage.accessMyAccount();
		LogInPage loginPage = new LogInPage(this.driver);
		loginPage.enterCredentials("alexeusebiu@yahoo.co.uk", "felicia");
		loginPage.pressLoginButton();
		AccountPage accPage = new AccountPage(this.driver);
		accPage.accessSisteme();
		Assert.assertEquals("Server HP ProLiant ML10 v2, Procesor Intel® Xeon® E3-1220 v3 3.1GHz Haswell, 1x 8GB UDIMM DDR3 1600MHz, 1x 1TB SATA HDD, LFF 3.5 inch, B120i - PC Garage", accPage.pressAButton());
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
