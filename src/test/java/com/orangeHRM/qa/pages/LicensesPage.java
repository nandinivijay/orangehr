package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class LicensesPage extends QualificationsPage{

	WebDriver driver;

	public LicensesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Licenses");
	}

}
