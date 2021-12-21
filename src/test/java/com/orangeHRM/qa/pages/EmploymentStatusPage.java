package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class EmploymentStatusPage extends JobAdminPage{

	WebDriver driver;

	public EmploymentStatusPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("employmentStatus");
	}
}
