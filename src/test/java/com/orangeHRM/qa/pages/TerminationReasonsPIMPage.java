package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class TerminationReasonsPIMPage extends ConfigurationPIMPage{

	WebDriver driver;

	public TerminationReasonsPIMPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("TerminationReasons");
	}
}
