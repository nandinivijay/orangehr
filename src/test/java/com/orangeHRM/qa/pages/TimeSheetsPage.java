package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeSheetsPage  extends TimePage{

	WebDriver driver;
	public TimeSheetsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By MyTimeSheets_ID = By.id("menu_time_viewMyTimesheet");
	By EmployeeTimeSheets_ID = By.id("menu_time_viewEmployeeTimesheet");
	
	public WebElement getMyTimeSheets_id()
	{
		
		return driver.findElement(MyTimeSheets_ID);
		
	}
	
	public MyTimeSheetsPage navigatingToMyTimeSheets()
	{
		getMyTimeSheets_id().click();
		return new MyTimeSheetsPage(driver);
	}
	
	public WebElement getEmployeeTimeSheets_id()
	{
		
		return driver.findElement(EmployeeTimeSheets_ID);
		
	}
	
	public EmployeeTimeSheetsPage navigatingToEmployeeTimeSheets()
	{
		getEmployeeTimeSheets_id().click();
		return new EmployeeTimeSheetsPage(driver);
	}

}
