package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class LocalizationPage extends ConfigurationAdminPage{

	WebDriver driver;

	public LocalizationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("localization");
	}
}
