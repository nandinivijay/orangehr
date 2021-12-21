package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ModulesPage extends ConfigurationAdminPage{

	WebDriver driver;

	public ModulesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Modules");
	}
}
