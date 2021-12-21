package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class TaxExemptionPage extends MyInfoPage{
	WebDriver driver;

	public TaxExemptionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("viewUsTaxExemptions");
	}
}
