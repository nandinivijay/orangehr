package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigurationPIMPage extends PIMPage{

WebDriver driver;
	
	public  ConfigurationPIMPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	By OptionalFields_ID = By.id("menu_pim_configurePim");
	By CustomFields_ID = By.id("menu_pim_listCustomFields");
	By DataImport_ID = By.id("menu_admin_pimCsvImport");
	By ReportingMethods_ID = By.id("menu_pim_viewReportingMethods");
	By TerminationReasons_ID = By.id("menu_pim_viewTerminationReasons");
	
	
	public WebElement getOptionalFields_id()
	{
		
		return driver.findElement(OptionalFields_ID);
		
	}
	
	public OptionalFieldsPIMPage navigatingToOptionalFields()
	{
		getOptionalFields_id().click();
		return new OptionalFieldsPIMPage(driver);
	}
	
	public WebElement getCustomFields_id()
	{
		
		return driver.findElement(CustomFields_ID);
		
	}
	
	public CustomFieldsPIMPage navigatingToCustomFields()
	{
		getCustomFields_id().click();
		return new CustomFieldsPIMPage(driver);
	}
	
	public WebElement getDataImport_id()
	{
		
		return driver.findElement(DataImport_ID);
		
	}
	
	public DataImportPIMPage navigatingToDataImport()
	{
		getDataImport_id().click();
		return new DataImportPIMPage(driver);
	}
	
	public WebElement getReportingMethods_id()
	{
		
		return driver.findElement( ReportingMethods_ID);
		
	}
	
	public  ReportingMethodsPIMPage navigatingToReportingMethods()
	{
		getReportingMethods_id().click();
		return new ReportingMethodsPIMPage(driver);
	}
	
	public WebElement getTerminationReasons_id()
	{
		
		return driver.findElement( TerminationReasons_ID);
		
	}
	
	public  TerminationReasonsPIMPage navigatingToTerminationReasons()
	{
		getTerminationReasons_id().click();
		return new TerminationReasonsPIMPage(driver);
	}
	
}
