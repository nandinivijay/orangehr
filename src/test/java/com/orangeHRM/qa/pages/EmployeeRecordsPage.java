package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class EmployeeRecordsPage extends AttendancePage{

	WebDriver driver;

	public EmployeeRecordsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("viewAttendanceRecord");
	}

}
