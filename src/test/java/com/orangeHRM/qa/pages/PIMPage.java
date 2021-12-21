package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PIMPage {

	WebDriver driver;
	
	public PIMPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("pim");
		
	}
	
	
	By Configuration_ID = By.id("menu_pim_Configuration");
	By EmployeeList_ID = By.id("menu_pim_viewEmployeeList");
	By AddEmployee_ID = By.id("menu_pim_addEmployee");
	By Reports_ID = By.id("menu_core_viewDefinedPredefinedReports");
	
	
	
	public WebElement getConfiguration_id()
	{
		
		return driver.findElement(Configuration_ID);
		
	}
	
	public ConfigurationPIMPage navigatingToConfiguration()
	{
		getConfiguration_id().click();
		return new ConfigurationPIMPage(driver);
	}
	
	public WebElement getEmployeeList_id()
	{
		
		return driver.findElement(EmployeeList_ID);
		
	}
	
	public EmployeeListPIMPage navigatingToEmployeeList()
	{
		getEmployeeList_id().click();
		return new EmployeeListPIMPage(driver);
	}
	
	public WebElement getAddEmployee_id()
	{
		
		return driver.findElement(AddEmployee_ID);
		
	}
	
	public AddEmployeePIMPage navigatingToAddEmployee()
	{
		getAddEmployee_id().click();
		return new AddEmployeePIMPage(driver);
	}
	
	public WebElement getReports_id()
	{
		
		return driver.findElement( Reports_ID);
		
	}
	
	public  ReportsPIMPage navigatingToReports()
	{
		getReports_id().click();
		return new  ReportsPIMPage(driver);
	}

	
}
