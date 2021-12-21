package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class JobCategoriesPage extends JobAdminPage{

	WebDriver driver;

	public JobCategoriesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("jobCategory");
	}

}
