package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ProjectReportsPage extends ReportsTimePage{

	WebDriver driver;

	public ProjectReportsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("ProjectReport");
	}

}
