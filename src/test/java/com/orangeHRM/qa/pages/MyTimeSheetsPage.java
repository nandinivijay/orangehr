package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class MyTimeSheetsPage extends TimeSheetsPage{

	WebDriver driver;

	public MyTimeSheetsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("MyTimesheet");
	}

}
