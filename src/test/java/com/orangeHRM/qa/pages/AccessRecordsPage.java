package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class AccessRecordsPage extends MaintenancePage{

	WebDriver driver;

	public AccessRecordsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("accessEmployeeData");
		
	}
}
