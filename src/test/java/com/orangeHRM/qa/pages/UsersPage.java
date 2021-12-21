package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class UsersPage extends UserManagementPage{

	WebDriver driver;
	public UsersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("viewSystemUsers");
		
	}

}
