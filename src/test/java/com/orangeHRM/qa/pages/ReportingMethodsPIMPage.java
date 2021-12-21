package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ReportingMethodsPIMPage extends ConfigurationPIMPage{

	WebDriver driver;

	public ReportingMethodsPIMPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("ReportingMethods");
	}
}
