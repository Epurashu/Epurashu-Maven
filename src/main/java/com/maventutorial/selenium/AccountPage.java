package com.maventutorial.selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage extends AbstractPageConstructor {

	//WebDriver driver;
	
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
	
	public AccountPage(WebDriver driver){
		super(driver);
	}
	
	public void accessSisteme(){
		sistemeButton.click();
	}
	
	public String returnAProductTitleFromSisteme(){
		waitForElement(serversCategory);
		serversCategory.click();
		
		waitForElement(hiddenButtons.get(2));
		hiddenButtons.get(2).click();
		
		waitForElement(producerList.get(2));
		producerList.get(2).click();
		
		waitForElement(productList.get(4));
		productList.get(4).click();
		
		return driver.getTitle();
		
	}
	
	
	
}
