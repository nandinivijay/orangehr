package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class LeavePeriodPage extends ConfigureLeavePage{

	WebDriver driver;

	public LeavePeriodPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("LeavePeriod");
	}
}
