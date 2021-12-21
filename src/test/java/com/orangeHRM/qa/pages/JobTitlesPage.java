package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class JobTitlesPage extends JobAdminPage{

	WebDriver driver;
	public JobTitlesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("JobTitle");
		
	}

}
