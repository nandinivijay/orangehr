package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class LanguagePackagesPage extends ConfigurationAdminPage{

	WebDriver driver;

	public LanguagePackagesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("languagePackage");
	}
}
