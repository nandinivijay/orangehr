package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class CustomFieldsPIMPage extends ConfigurationPIMPage{

	WebDriver driver;

	public CustomFieldsPIMPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("CustomFields");
	}
}
