package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class SkillsPage extends QualificationsPage{

	WebDriver driver;

	public SkillsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Skills");
	}
}
