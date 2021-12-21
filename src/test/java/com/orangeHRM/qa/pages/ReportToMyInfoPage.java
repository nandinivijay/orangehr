package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ReportToMyInfoPage extends MyInfoPage{
	WebDriver driver;

	public ReportToMyInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("viewReportToDetails");
	}

}
