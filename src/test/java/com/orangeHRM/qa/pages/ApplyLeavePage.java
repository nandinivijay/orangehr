package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ApplyLeavePage extends LeavePage{

	WebDriver driver;
	public ApplyLeavePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("applyLeave");
		
	}
}
