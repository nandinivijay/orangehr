package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class StructurePage extends OrganizationPage{

	WebDriver driver;

	public StructurePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Structure");
	}

}
