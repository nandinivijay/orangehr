package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class MyTrackersPage extends PerformancePage{

	WebDriver driver;

	public MyTrackersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("MyPerformanceTrackerList");
		
	}
}
