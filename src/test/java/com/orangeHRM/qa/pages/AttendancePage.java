package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AttendancePage extends TimePage{

	WebDriver driver;
	public AttendancePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By MyRecords_ID = By.id("menu_attendance_viewMyAttendanceRecord");
	By PunchInOut_ID = By.id("menu_attendance_punchIn");
	By EmployeeRecords_ID = By.id("menu_attendance_viewAttendanceRecord");
	By ConfigurationTime_ID = By.id("menu_attendance_configure");
	
	public WebElement getMyRecords_id()
	{
		
		return driver.findElement(MyRecords_ID);
		
	}
	
	public MyRecordsPage navigatingToMyRecords()
	{
		getMyRecords_id().click();
		return new MyRecordsPage(driver);
	}
	
	public WebElement getPunchInOut_id()
	{
		
		return driver.findElement(PunchInOut_ID);
		
	}
	
	public PunchInOutPage navigatingToPunchInOut()
	{
		getPunchInOut_id().click();
		return new PunchInOutPage(driver);
	}
	
	public WebElement getEmployeeRecords_id()
	{
		
		return driver.findElement(EmployeeRecords_ID);
		
	}
	
	public EmployeeRecordsPage navigatingToEmployeeRecords()
	{
		getEmployeeRecords_id().click();
		return new EmployeeRecordsPage(driver);
	}
	
	public WebElement getConfigurationTime_id()
	{
		
		return driver.findElement(ConfigurationTime_ID);
		
	}
	
	public  ConfigurationTimePage navigatingToConfigurationTime()
	{
		getConfigurationTime_id().click();
		return new  ConfigurationTimePage(driver);
	}
	
}
