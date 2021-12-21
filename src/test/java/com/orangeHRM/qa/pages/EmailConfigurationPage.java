package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class EmailConfigurationPage extends ConfigurationAdminPage{

	WebDriver driver;

	public EmailConfigurationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("MailConfiguration");
	}

	

}
