package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class WorkWeekPage extends ConfigureLeavePage{

	WebDriver driver;

	public WorkWeekPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("WorkWeek");
	}

}
