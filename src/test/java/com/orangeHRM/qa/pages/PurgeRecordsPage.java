package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurgeRecordsPage extends MaintenancePage{

	WebDriver driver;

	public PurgeRecordsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By PurgeEmployeeRecords_ID = By.id("menu_maintenance_purgeEmployee");
	By PurgeCandidatesRecords_ID = By.id("menu_maintenance_purgeCandidateData");
	
	public WebElement getPurgeEmployeeRecords_id()
	{
		
		return driver.findElement(PurgeEmployeeRecords_ID);
		
	}
	
	public PurgeEmployeeRecordsPage navigatingToPurgeEmployeeRecords()
	{
		getPurgeEmployeeRecords_id().click();
		return new PurgeEmployeeRecordsPage(driver);
	}
	
	public WebElement getPurgeCandidatesRecords_id()
	{
		
		return driver.findElement(PurgeCandidatesRecords_ID);
		
	}
	
	public PurgeCandidatesRecordsPage navigatingToPurgeCandidatesRecords()
	{
		getPurgeCandidatesRecords_id().click();
		return new PurgeCandidatesRecordsPage(driver);
	}
}
