package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ConfigurationTimePage extends AttendancePage{

	WebDriver driver;

	public ConfigurationTimePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("configure");
	}

}
