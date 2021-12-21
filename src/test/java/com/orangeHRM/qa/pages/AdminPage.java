package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	
	WebDriver driver;
	
	public AdminPage(WebDriver driver) {
			
		this.driver = driver;
	}
	 
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("admin");
		
	}	
	
	By UserManagement_ID = By.id("menu_admin_UserManagement");
	By JobAdmin_ID = By.id("menu_admin_Job");
	By Organization_ID = By.id("menu_admin_Organization");
	By Qualifications_ID = By.id("menu_admin_Qualifications");
	By Nationalities_ID = By.id("menu_admin_nationality");
	By ConfigurationAdmin_ID = By.id("menu_admin_Configuration");
	
	public WebElement getUserManagement_id()
	{
		
		return driver.findElement(UserManagement_ID);
		
	}
	
	public UserManagementPage navigatingToUserManagement()
	{
		getUserManagement_id().click();
		return new UserManagementPage(driver);
	}
	
	public WebElement getJobAdmin_id()
	{
		
		return driver.findElement(JobAdmin_ID);
		
	}
	
	public JobAdminPage navigatingToJobAdmin()
	{
		getJobAdmin_id().click();
		return new JobAdminPage(driver);
	}
	
	public WebElement getOrganization_id()
	{
		
		return driver.findElement(Organization_ID);
		
	}
	
	public OrganizationPage navigatingToOrganization()
	{
		getOrganization_id().click();
		return new OrganizationPage(driver);
	}
	
	public WebElement getQualifications_id()
	{
		
		return driver.findElement(Qualifications_ID);
		
	}
	
	public QualificationsPage navigatingToQualifications()
	{
		getQualifications_id().click();
		return new QualificationsPage(driver);
	}
	
	public WebElement getNationalities_id()
	{
		
		return driver.findElement(Nationalities_ID);
		
	}
	
	public NationalitiesPage navigatingToNationalities()
	{
		getNationalities_id().click();
		return new NationalitiesPage(driver);
	}
	
	public WebElement getConfigurationAdmin_id()
	{
		
		return driver.findElement(ConfigurationAdmin_ID);
		
	}
	
	public ConfigurationAdminPage navigatingToConfigurationAdmin()
	{
		getConfigurationAdmin_id().click();
		return new ConfigurationAdminPage(driver);
	}
	
}
