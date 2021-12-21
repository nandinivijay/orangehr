package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class NationalitiesPage extends AdminPage{

	WebDriver driver;

	public NationalitiesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("nationality");
		
	}
}
