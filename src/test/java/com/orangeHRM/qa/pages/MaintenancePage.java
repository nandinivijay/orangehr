package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MaintenancePage {
	
	WebDriver driver;
	
	public MaintenancePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("maintenance");
		
	}
	
	By PurgeRecords_ID = By.id("menu_maintenance_PurgeRecords");
	By AccessRecords_ID = By.id("menu_maintenance_accessEmployeeData");
	
	public WebElement getPurgeRecords_id()
	{
		
		return driver.findElement(PurgeRecords_ID);
		
	}
	
	public PurgeRecordsPage navigatingToPurgeRecords()
	{
		getPurgeRecords_id().click();
		return new PurgeRecordsPage(driver);
	}
	
	public WebElement getAccessRecords_id()
	{
		
		return driver.findElement(AccessRecords_ID);
		
	}
	
	public AccessRecordsPage navigatingToAccessRecords()
	{
		getAccessRecords_id().click();
		return new AccessRecordsPage(driver);
	}
}
