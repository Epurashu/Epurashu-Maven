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
	
	@FindBy(how = How.XPATH, xpath = "*//p[@id='ff_01']/span")
	private WebElement producatorButton;
	
	@FindBy(how = How.XPATH, xpath= ".//*[@id='fv_01']/li[3]/a[@href='http://www.pcgarage.ro/servere/hp/']")
	private WebElement producerList;
	
	@FindBy(how = How.XPATH, xpath = "*//div[@class='product-box']/div/div[@class='pb-name']/a[@title='HP ProLiant ML10 v2, Procesor Intel® Xeon® E3-1220 v3 3.1GHz Haswell, 1x 8GB UDIMM DDR3 1600MHz, 1x 1TB SATA HDD, LFF 3.5 inch, B120i']")
	private WebElement hpServer;
	
	public AccountPage(WebDriver driver){
		super(driver);
	}
	
	public void accessSisteme(){
		sistemeButton.click();
	}
	
	public String returnAProductTitleFromSisteme(){
		if(waitForElement(serversCategory))
		serversCategory.click();
		
		if(waitForElement(producatorButton))
		producatorButton.click();
		
		if(waitForElement(producerList))
		producerList.click();
		
		if(waitForElement(hpServer))
		hpServer.click();
		
		return driver.getTitle();
		
	}
	
	
	
}
