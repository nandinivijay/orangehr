package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class DirectoryPage {

	WebDriver driver;
	public DirectoryPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("directory");
		
	}

}
