package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigurationAdminPage extends AdminPage{

	WebDriver driver;

	public ConfigurationAdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By EmailConfiguration_ID = By.id("menu_admin_listMailConfiguration");
	By EmailSubscriptions_ID = By.id("menu_admin_viewEmailNotification");
	By Localization_ID = By.id("menu_admin_localization");
	By LanguagePackages_ID = By.id("menu_admin_languagePackage");
	By Modules_ID = By.id("menu_admin_viewModules");
	By SocialMediaAuthentication_ID = By.id("menu_admin_openIdProvider");
	By RegisterOAuthClient_ID = By.id("menu_admin_registerOAuthClient");
	
	
	public WebElement getEmailConfiguration_id()
	{
		
		return driver.findElement(EmailConfiguration_ID);
		
	}
	
	public EmailConfigurationPage navigatingToEmailConfiguration()
	{
		getEmailConfiguration_id().click();
		return new EmailConfigurationPage(driver);
	}
	
	public WebElement getEmailSubscriptions_id()
	{
		
		return driver.findElement(EmailSubscriptions_ID);
		
	}
	
	public EmailSubscriptionsPage navigatingToEmailSubscriptions()
	{
		getEmailSubscriptions_id().click();
		return new EmailSubscriptionsPage(driver);
	}
	
	public WebElement getLocalization_id()
	{
		
		return driver.findElement(Localization_ID);
		
	}
	
	public LocalizationPage navigatingToLocalization()
	{
		getLocalization_id().click();
		return new LocalizationPage(driver);
	}
	
	public WebElement getLanguagePackages_id()
	{
		
		return driver.findElement(LanguagePackages_ID);
		
	}
	
	public  LanguagePackagesPage navigatingToLanguagePackages()
	{
		getLanguagePackages_id().click();
		return new LanguagePackagesPage(driver);
	}
	
	public WebElement getModules_id()
	{
		
		return driver.findElement(Modules_ID);
		
	}
	
	public  ModulesPage navigatingToModules()
	{
		getModules_id().click();
		return new  ModulesPage(driver);
	}
	
	public WebElement getSocialMediaAuthentication_id()
	{
		
		return driver.findElement(SocialMediaAuthentication_ID);
		
	}
	
	public  SocialMediaAuthenticationPage navigatingToSocialMediaAuthentication()
	{
		getSocialMediaAuthentication_id().click();
		return new  SocialMediaAuthenticationPage(driver);
	}
	
	public WebElement getRegisterOAuthClient_id()
	{
		
		return driver.findElement(RegisterOAuthClient_ID);
		
	}
	
	public  RegisterOAuthClientPage navigatingToRegisterOAuthClient()
	{
		getRegisterOAuthClient_id().click();
		return new  RegisterOAuthClientPage(driver);
	}
}
