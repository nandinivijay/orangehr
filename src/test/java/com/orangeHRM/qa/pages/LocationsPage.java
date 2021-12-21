package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class LocationsPage extends OrganizationPage{

	WebDriver driver;

	public LocationsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Locations");
	}

}
