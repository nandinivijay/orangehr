package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigureLeavePage extends LeavePage{

	WebDriver driver;
	public ConfigureLeavePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By LeavePeriod_ID = By.id("menu_leave_defineLeavePeriod");
	By LeaveTypes_ID = By.id("menu_leave_leaveTypeList");
	By WorkWeek_ID = By.id("menu_leave_defineWorkWeek");
	By Holidays_ID = By.id("menu_leave_viewHolidayList");
	
	public WebElement getLeavePeriod_id()
	{
		
		return driver.findElement(LeavePeriod_ID);
		
	}
	
	public LeavePeriodPage navigatingToLeavePeriod()
	{
		getLeavePeriod_id().click();
		return new LeavePeriodPage(driver);
	}
	
	public WebElement getLeaveTypes_id()
	{
		
		return driver.findElement(LeaveTypes_ID);
		
	}
	
	public LeaveTypesPage navigatingToLeaveTypes()
	{
		getLeaveTypes_id().click();
		return new LeaveTypesPage(driver);
	}
	
	public WebElement getWorkWeek_id()
	{
		
		return driver.findElement(WorkWeek_ID);
		
	}
	
	public WorkWeekPage navigatingToWorkWeek()
	{
		getWorkWeek_id().click();
		return new WorkWeekPage(driver);
	}
	
	public WebElement getHolidays_id()
	{
		
		return driver.findElement( Holidays_ID);
		
	}
	
	public  HolidaysPage navigatingToHolidays()
	{
		getHolidays_id().click();
		return new  HolidaysPage(driver);
	}
}
