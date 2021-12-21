package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class SocialMediaAuthenticationPage extends ConfigurationAdminPage{

	WebDriver driver;

	public SocialMediaAuthenticationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("openIdProvider");
	}
}
