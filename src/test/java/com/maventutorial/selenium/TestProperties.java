package com.maventutorial.selenium;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class TestProperties {
	String result = "";
	InputStream inputStream;
	public WebDriver driver;
	public String homepage;
	
 
	public String getPropValues() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			String usedWebDriver = prop.getProperty("WebDriver");
			homepage = prop.getProperty("HomePage");
			
			if(usedWebDriver.equals("firefox"))
				driver = new FirefoxDriver();
			else	if(usedWebDriver.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "D:\\Alexandru.Epure\\chromedriver.exe");
					driver = new ChromeDriver();
			}
					else if(usedWebDriver.equals("iexplore")){
						System.setProperty("webdriver.ie.driver","D:\\Alexandru.Epure\\IEDriverServer.exe");
						driver = new InternetExplorerDriver();
					}
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}
	
