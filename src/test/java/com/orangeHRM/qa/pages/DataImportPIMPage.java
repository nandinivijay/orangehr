package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class DataImportPIMPage extends ConfigurationPIMPage{

	WebDriver driver;

	public DataImportPIMPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("CsvImport");
	}
}
