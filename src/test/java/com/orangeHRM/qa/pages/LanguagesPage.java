package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class LanguagesPage extends QualificationsPage{

	WebDriver driver;

	public LanguagesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Languages");
	}

}
