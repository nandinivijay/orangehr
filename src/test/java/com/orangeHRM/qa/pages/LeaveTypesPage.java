package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class LeaveTypesPage extends ConfigureLeavePage{

	WebDriver driver;

	public LeaveTypesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("leaveType");
	}
}
