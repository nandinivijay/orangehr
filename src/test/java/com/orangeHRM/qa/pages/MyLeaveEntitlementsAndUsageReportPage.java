package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class MyLeaveEntitlementsAndUsageReportPage extends ReportsLeavePage{

	WebDriver driver;

	public MyLeaveEntitlementsAndUsageReportPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("MyLeaveBalanceReport");
	}
}
