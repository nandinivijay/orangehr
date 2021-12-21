package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class EmployeeListPIMPage extends PIMPage{

	WebDriver driver;
	
	public  EmployeeListPIMPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("EmployeeList");
		
	}
}
