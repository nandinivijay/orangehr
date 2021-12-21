package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class PunchInOutPage extends AttendancePage{

	WebDriver driver;

	public PunchInOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("punch");
	}
}
