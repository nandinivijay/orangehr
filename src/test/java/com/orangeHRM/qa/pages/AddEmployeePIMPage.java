package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class AddEmployeePIMPage extends PIMPage{
	
	
	WebDriver driver;
	
	public  AddEmployeePIMPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("addEmployee");
		
	}

}
