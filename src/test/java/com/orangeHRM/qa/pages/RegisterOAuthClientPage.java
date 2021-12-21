package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class RegisterOAuthClientPage extends ConfigurationAdminPage{

	WebDriver driver;

	public RegisterOAuthClientPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("registerOAuthClient");
	}
}
