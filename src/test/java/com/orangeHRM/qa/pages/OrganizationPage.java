package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrganizationPage extends AdminPage{

	WebDriver driver;

	public OrganizationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By GeneralInformation_ID = By.id("menu_admin_viewOrganizationGeneralInformation");
	By Locations_ID = By.id("menu_admin_viewLocations");
	By Structure_ID = By.id("menu_admin_viewCompanyStructure");
	
	
	public WebElement getGeneralInformation_id()
	{
		
		return driver.findElement(GeneralInformation_ID);
		
	}
	
	public GeneralInformationPage navigatingToGeneralInformation()
	{
		getGeneralInformation_id().click();
		return new GeneralInformationPage(driver);
	}
	
	public WebElement getLocations_id()
	{
		
		return driver.findElement(Locations_ID);
		
	}
	
	public LocationsPage navigatingToLocations()
	{
		getLocations_id().click();
		return new LocationsPage(driver);
	}
	
	public WebElement getStructure_id()
	{
		
		return driver.findElement(Structure_ID);
		
	}
	
	public StructurePage navigatingToStructure()
	{
		getStructure_id().click();
		return new StructurePage(driver);
	}
	
	
}
