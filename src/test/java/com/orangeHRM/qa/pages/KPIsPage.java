package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class KPIsPage extends ConfigurePerformancePage{

	WebDriver driver;

	public KPIsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Kpi");
		
	}
}
