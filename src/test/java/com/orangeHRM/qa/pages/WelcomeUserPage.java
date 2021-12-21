package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomeUserPage {
	
WebDriver driver;
	
	public WelcomeUserPage(WebDriver driver) {
			
		this.driver = driver;
	}
	
	By About_ID = By.id("aboutDisplayLink");
	 
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().equalsIgnoreCase("Welcome");
		
	}	
	
	public WebElement getAbout_id()
	{
	 return driver.findElement(About_ID);
	}
	
	

}
