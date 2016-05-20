package com.maventutorial.selenium;

import java.util.List;

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
	
	@FindBy(how = How.XPATH, xpath = "*//ul[@class='filters']/li/a[.='Servere']")
	private WebElement serversCategory;
	
	@FindBy(how = How.XPATH, xpath = "*//span[@class='visuallyhidden']")
	private List<WebElement> hiddenButtons;
	
	@FindBy(how = How.XPATH, xpath= "*//div/ul[@id='fv_01']/li/a")
	private List<WebElement> producerList;
	
	@FindBy(how = How.XPATH, xpath = ".//div[@class='pb-name']/a")
	private List<WebElement> productList;
	
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
	
	public void pressAButton(){
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(serversCategory));
		serversCategory.click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(hiddenButtons.get(2)));
		hiddenButtons.get(2).click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(producerList.get(2)));
		producerList.get(2).click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(productList.get(4)));
		productList.get(4).click();
		Assert.assertEquals("Server HP ProLiant ML310e Gen8 Tower 4U, Procesor Intel® Xeon® E3-1220 v3 3.1GHz Haswell, 4GB UDIMM DDR3, 2x 1TB LFF 3.5 inch, B120i/ZM - PC Garage", driver.getTitle());
		
	}
	
	
	
}
