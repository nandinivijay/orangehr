package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class OptionalFieldsPIMPage extends ConfigurationPIMPage{

	WebDriver driver;

	public OptionalFieldsPIMPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("configurePim");
	}
}
