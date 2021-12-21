package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class MemberShips_AdminPage extends QualificationsPage{

	WebDriver driver;

	public MemberShips_AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("membership");
	}

}
