package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class AttendanceSummaryPage extends ReportsTimePage{

	private WebDriver driver;

	public AttendanceSummaryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("AttendanceSummary");
	}
}
