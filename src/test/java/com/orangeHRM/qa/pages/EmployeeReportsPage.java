package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class EmployeeReportsPage extends ReportsTimePage{

	WebDriver driver;

	public EmployeeReportsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("EmployeeReport");
	}

}
