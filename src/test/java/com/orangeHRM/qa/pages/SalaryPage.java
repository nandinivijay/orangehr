package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class SalaryPage extends MyInfoPage{
	WebDriver driver;

	public SalaryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("viewSalaryList");
	}
}
