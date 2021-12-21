package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class PayGradesPage extends JobAdminPage{

	WebDriver driver;

	public PayGradesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("PayGrades");
	}
	
}
