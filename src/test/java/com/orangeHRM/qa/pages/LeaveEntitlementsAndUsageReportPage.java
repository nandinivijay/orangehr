package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class LeaveEntitlementsAndUsageReportPage extends ReportsLeavePage{

	WebDriver driver;
	public LeaveEntitlementsAndUsageReportPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("LeaveBalanceReport");
	}

	
}
