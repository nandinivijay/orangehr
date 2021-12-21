package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimePage {
	
	WebDriver driver;
	public TimePage(WebDriver driver) {
		
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("time");
		
	}
	
	By TimeSheets_ID = By.id("menu_time_Timesheets");
	By Attendance_ID = By.id("menu_attendance_Attendance");
	By ReportsTime_ID = By.id("menu_time_Reports");
	By ProjectInfo_ID = By.id("menu_admin_ProjectInfo");
	
	public WebElement getTimeSheets_id()
	{
		
		return driver.findElement(TimeSheets_ID);
		
	}
	
	public TimeSheetsPage navigatingToTimeSheets()
	{
		getTimeSheets_id().click();
		return new TimeSheetsPage(driver);
	}
	
	public WebElement getAttendance_id()
	{
		
		return driver.findElement(Attendance_ID);
		
	}
	
	public  AttendancePage navigatingToAttendance()
	{
		getAttendance_id().click();
		return new AttendancePage(driver);
	}
	
	public WebElement getReportsTime_id()
	{
		
		return driver.findElement(ReportsTime_ID);
		
	}
	
	public  ReportsTimePage navigatingToReportsTime()
	{
		getReportsTime_id().click();
		return new ReportsTimePage(driver);
	}
	
	public WebElement getProjectInfo_id()
	{
		
		return driver.findElement(ProjectInfo_ID);
		
	}
	
	public  ProjectInfoPage navigatingToProjectInfo()
	{
		getProjectInfo_id().click();
		return new ProjectInfoPage(driver);
	}
	
	
}
