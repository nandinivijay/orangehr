package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectInfoPage extends TimePage{

	WebDriver driver;
	public ProjectInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By Customers_ID = By.id("menu_admin_viewCustomers");
	By Projects_ID = By.id("menu_admin_viewProjects");
		
	public WebElement getCustomers_id()
	{
		
		return driver.findElement(Customers_ID);
		
	}
	
	public CustomersPage navigatingToCustomers()
	{
		getCustomers_id().click();
		return new CustomersPage(driver);
	}
	
	public WebElement getProjects_id()
	{
		
		return driver.findElement(Projects_ID);
		
	}
	
	public ProjectsPage navigatingToProjects()
	{
		getProjects_id().click();
		return new ProjectsPage(driver);
	}
}
