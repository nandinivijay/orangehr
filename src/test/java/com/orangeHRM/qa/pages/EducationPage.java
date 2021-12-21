package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class EducationPage extends QualificationsPage{

	WebDriver driver;

	public EducationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Education");
	}
}
