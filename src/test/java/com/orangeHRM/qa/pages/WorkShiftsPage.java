package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class WorkShiftsPage extends JobAdminPage{

	WebDriver driver;

	public WorkShiftsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("workShift");
	}

}
