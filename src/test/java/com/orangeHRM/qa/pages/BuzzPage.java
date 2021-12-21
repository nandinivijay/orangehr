package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class BuzzPage {

	WebDriver driver;
	public BuzzPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("buzz");
	}

}
