package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class TrackersPage extends ConfigurePerformancePage{

	WebDriver driver;

	public TrackersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("addPerformanceTracker");
		
	}
}
