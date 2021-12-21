package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportsLeavePage extends LeavePage{

	WebDriver driver;
	public ReportsLeavePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By LeaveEntitlementsAndUsageReport_ID = By.id("menu_leave_viewLeaveBalanceReport");
	By MyLeaveEntitlementsAndUsageReport_ID = By.id("menu_leave_viewMyLeaveBalanceReport"); 
	
	public WebElement getLeaveEntitlementsAndUsageReport_id()
	{
		
		return driver.findElement(LeaveEntitlementsAndUsageReport_ID);
		
	}
	
	public  LeaveEntitlementsAndUsageReportPage navigatingToLeaveEntitlementsAndUsageReport_ID()
	{
		getLeaveEntitlementsAndUsageReport_id().click();
		return new LeaveEntitlementsAndUsageReportPage(driver);
	}
	
	public WebElement getMyLeaveEntitlementsAndUsageReport_id()
	{
		
		return driver.findElement(MyLeaveEntitlementsAndUsageReport_ID);
		
	}
	
	public MyLeaveEntitlementsAndUsageReportPage navigatingToMyLeaveEntitlementsAndUsageReport()
	{
		getMyLeaveEntitlementsAndUsageReport_id().click();
		return new MyLeaveEntitlementsAndUsageReportPage(driver);
	}

}
