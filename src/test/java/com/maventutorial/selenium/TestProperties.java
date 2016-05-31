package com.maventutorial.selenium;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class TestProperties {
	String result = "";
	InputStream inputStream;
	public WebDriver driver;
	public String homePageLink;
	
 
	public void getPropValues() throws IOException {
 
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
			homePageLink = prop.getProperty("homePageLink");
			Map<String, Boolean> capabilitiesMap = new HashMap<String, Boolean>();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			int i =0;
			while((prop.getProperty("capability"+Integer.toString(i)) != null) && (prop.getProperty("capabilityValue"+Integer.toString(i)) != null))
			{
				capabilitiesMap.put(prop.getProperty("capability"+Integer.toString(i)), Boolean.valueOf(prop.getProperty("capabilityValue"+Integer.toString(i))));
				i++;
			}
			if(!capabilitiesMap.isEmpty())
			{
				capabilities = new DesiredCapabilities(capabilitiesMap);
			}
			
			usedWebDriver = usedWebDriver.toLowerCase();
			
			switch (usedWebDriver){
			case "firefox":
				driver = new FirefoxDriver(capabilities);
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
				driver = new ChromeDriver(capabilities);
				break;
			case "iexplore":
				System.setProperty("webdriver.ie.driver",prop.getProperty("iexplorePath"));
				driver = new InternetExplorerDriver(capabilities);
				break;
			}
			
			driver.manage().window().maximize();
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
}
	
