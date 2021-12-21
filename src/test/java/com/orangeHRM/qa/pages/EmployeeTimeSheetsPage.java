package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class EmployeeTimeSheetsPage extends TimeSheetsPage{

	WebDriver driver;

	public EmployeeTimeSheetsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("EmployeeTimesheet");
	}

	
}
