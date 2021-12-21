package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class EmployeeTrackersPage extends PerformancePage{

	WebDriver driver;

	public EmployeeTrackersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("EmployeePerformanceTrackerList");
		
	}

}
