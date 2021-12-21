package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigurePerformancePage extends PerformancePage{

	WebDriver driver;

	public ConfigurePerformancePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By KPIs_ID = By.id("menu_performance_searchKpi");
	By Trackers_ID = By.id("menu_performance_addPerformanceTracker");
	
	
	public WebElement getKPIs_id()
	{
		
		return driver.findElement(KPIs_ID);
		
	}
	
	public KPIsPage navigatingToKPIs()
	{
		getKPIs_id().click();
		return new KPIsPage(driver);
	}
	
	public WebElement getTrackers_id()
	{
		
		return driver.findElement(Trackers_ID);
		
	}
	
	public TrackersPage navigatingToTrackers()
	{
		getTrackers_id().click();
		return new TrackersPage(driver);
	}
	

}
