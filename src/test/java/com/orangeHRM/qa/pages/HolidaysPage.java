package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class HolidaysPage extends ConfigureLeavePage{

	WebDriver driver;

	public HolidaysPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("HolidayList");
	}

}
