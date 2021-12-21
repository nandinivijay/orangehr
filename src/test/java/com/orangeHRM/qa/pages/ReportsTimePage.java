package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportsTimePage extends TimePage{
	

	WebDriver driver;
	public ReportsTimePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By ProjectReports_ID = By.id("menu_time_displayProjectReportCriteria");
	By EmployeeReports_ID = By.id("menu_time_displayEmployeeReportCriteria");
	By AttendanceSummary_ID = By.id("menu_time_displayAttendanceSummaryReportCriteria");
		
	public WebElement getProjectReports_id()
	{
		
		return driver.findElement(ProjectReports_ID);
		
	}
	
	public ProjectReportsPage navigatingToProjectReports()
	{
		getProjectReports_id().click();
		return new ProjectReportsPage(driver);
	}
	
	public WebElement getEmployeeReports_id()
	{
		
		return driver.findElement(EmployeeReports_ID);
		
	}
	
	public EmployeeReportsPage navigatingToEmployeeReports()
	{
		getEmployeeReports_id().click();
		return new EmployeeReportsPage(driver);
	}
	
	public WebElement getAttendanceSummary_id()
	{
		
		return driver.findElement(AttendanceSummary_ID);
		
	}
	
	public AttendanceSummaryPage navigatingToAttendanceSummary()
	{
		getAttendanceSummary_id().click();
		return new AttendanceSummaryPage(driver);
	}
}
