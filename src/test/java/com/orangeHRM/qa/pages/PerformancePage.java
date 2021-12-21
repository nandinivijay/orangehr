package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PerformancePage {

	WebDriver driver;
	public PerformancePage(WebDriver driver) {

		this.driver = driver;
		
	}

	By ConfigurePerformance_ID = By.id("menu_performance_Configure");
	By ManageReviews_ID = By.id("menu_performance_ManageReviews");
	By MyTrackers_ID = By.id("menu_performance_viewMyPerformanceTrackerList");
	By EmployeeTrackers_ID = By.id("menu_performance_viewEmployeePerformanceTrackerList");
	
	
	public WebElement getConfigurePerformance_id()
	{
		
		return driver.findElement(ConfigurePerformance_ID);
		
	}
	
	public ConfigurePerformancePage navigatingToConfigurePerformance()
	{
		getConfigurePerformance_id().click();
		return new ConfigurePerformancePage(driver);
	}
	
	public WebElement getManageReviews_id()
	{
		
		return driver.findElement(ManageReviews_ID);
		
	}
	
	public ManageReviewsPage navigatingToManageReviews()
	{
		getManageReviews_id().click();
		return new ManageReviewsPage(driver);
	}
	
	public WebElement getMyTrackers_id()
	{
		
		return driver.findElement(MyTrackers_ID);
		
	}
	
	public MyTrackersPage navigatingToMyTrackers()
	{
		getMyTrackers_id().click();
		return new MyTrackersPage(driver);
	}
	
	public WebElement getEmployeeTrackers_id()
	{
		
		return driver.findElement(EmployeeTrackers_ID);
		
	}
	
	public EmployeeTrackersPage navigatingToEmployeeTrackers()
	{
		getEmployeeTrackers_id().click();
		return new EmployeeTrackersPage(driver);
	}
	
	
}
