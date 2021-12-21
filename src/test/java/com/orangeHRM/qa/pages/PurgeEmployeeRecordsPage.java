package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class PurgeEmployeeRecordsPage extends PurgeRecordsPage{

	WebDriver driver;

	public PurgeEmployeeRecordsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("purgeEmployee");
		
	}
}
