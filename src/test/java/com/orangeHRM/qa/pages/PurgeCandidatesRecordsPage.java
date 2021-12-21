package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class PurgeCandidatesRecordsPage extends PurgeRecordsPage{

	WebDriver driver;

	public PurgeCandidatesRecordsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("purgeCandidateData");
		
	}
}
