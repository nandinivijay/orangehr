package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class EmailSubscriptionsPage extends ConfigurationAdminPage{

	WebDriver driver;

	public EmailSubscriptionsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("EmailNotification");
	}
}
