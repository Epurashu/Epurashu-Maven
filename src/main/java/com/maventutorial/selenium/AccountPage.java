package com.maventutorial.selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountPage {

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
	
	@FindBy(how = How.XPATH, xpath = "*//h1")
	private WebElement title;
	
	public AccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
		//Let`s wait for the page to load 
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(title));
	}
	
	public void accessSisteme(){
		sistemeButton.click();
	}
	
	public String pressAButton(){
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(serversCategory));
		serversCategory.click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(hiddenButtons.get(2)));
		hiddenButtons.get(2).click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(producerList.get(2)));
		producerList.get(2).click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(productList.get(4)));
		productList.get(4).click();
		
		return driver.getTitle();
		
	}
	
	
	
}
