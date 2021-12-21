package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeavePage {

	WebDriver driver;
	public LeavePage(WebDriver driver) {
		
		this.driver = driver;
	}

	By ApplyLeave_ID = By.id("menu_leave_applyLeave");
	By MyLeave_ID = By.id("menu_leave_viewMyLeaveList");
	By Entitlements_ID = By.id("menu_leave_Entitlements");
	By ReportsLeave_ID = By.id("menu_leave_Reports");
	By ConfigureLeave_ID = By.id("menu_leave_Configure");
	By LeaveList_ID = By.id("menu_leave_viewLeaveList");
	By AssignLeave_ID = By.id("menu_leave_assignLeave");
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("leave");
		
	}
	
	public WebElement getApplyLeave_id()
	{
		
		return driver.findElement(ApplyLeave_ID);
		
	}
	
	public ApplyLeavePage navigatingToApply()
	{
		getApplyLeave_id().click();
		return new ApplyLeavePage(driver);
	}
	
	public WebElement getMyLeave_id()
	{
		
		return driver.findElement(MyLeave_ID);
		
	}
	
	public MyLeavePage navigatingToMyLeave()
	{
		getMyLeave_id().click();
		return new MyLeavePage(driver);
	}
	
	public WebElement getEntitlements_id()
	{
		
		return driver.findElement(Entitlements_ID);
		
	}
	
	public EntitlementsPage navigatingToEntitlements()
	{
		getEntitlements_id().click();
		return new EntitlementsPage(driver);
	}
	
	public WebElement getReportsLeave_id()
	{
		
		return driver.findElement(ReportsLeave_ID);
		
	}
	
	public ReportsLeavePage navigatingToReportsLeave()
	{
		getReportsLeave_id().click();
		return new ReportsLeavePage(driver);
	}
	
	public WebElement getConfigureLeave_id()
	{
		
		return driver.findElement(ConfigureLeave_ID);
		
	}
	
	public ConfigureLeavePage navigatingToConfigureLeave()
	{
		getConfigureLeave_id().click();
		return new ConfigureLeavePage(driver);
	}
	
	public WebElement getLeaveList_id()
	{
		
		return driver.findElement(LeaveList_ID);
		
	}
	
	public LeaveListPage navigatingToLeaveList()
	{
		getLeaveList_id().click();
		return new LeaveListPage(driver);
	}
	public WebElement getAssignLeave_id()
	{
		return driver.findElement(AssignLeave_ID);
		
	}
	
	public AssignLeavePage navigatingToAssignLeave()
	{
		getAssignLeave_id().click();
		return new AssignLeavePage(driver);
	}
	
}
