package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.ConfigurationAdminPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class ConfigurationAdminPageTest extends BaseClass{
	AdminPage adminPage;
	ConfigurationAdminPage configurationAdminPage;
	@BeforeClass
	public void verifyConfigurationAdminPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		configurationAdminPage = adminPage.navigatingToConfigurationAdmin();
		System.out.println("Clicked Configuration Admin");
	}
	
	@Test(priority = 2)
	public void validatingUserManagementSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(adminPage.getConfigurationAdmin_id(), driver);
		Assert.assertTrue(configurationAdminPage.getEmailConfiguration_id().isDisplayed());
		System.out.println("Email Configuration Displayed");
		Assert.assertTrue(configurationAdminPage.getEmailSubscriptions_id().isDisplayed());
		System.out.println("Email Subscriptions Displayed");
		Assert.assertTrue(configurationAdminPage.getLanguagePackages_id().isDisplayed());
		System.out.println("Language Packages Displayed");
		Assert.assertTrue(configurationAdminPage.getLocalization_id().isDisplayed());
		System.out.println("Localization Displayed");
		Assert.assertTrue(configurationAdminPage.getModules_id().isDisplayed());
		System.out.println("Modules Displayed");
		Assert.assertTrue(configurationAdminPage.getSocialMediaAuthentication_id().isDisplayed());
		System.out.println("Social Media Authentication Displayed");
		Assert.assertTrue(configurationAdminPage.getRegisterOAuthClient_id().isDisplayed());
		System.out.println("RegisterOAuthClient Displayed");
	}
	@Test(priority = 3)
	public void configurationAdminTesting()
	{
		System.out.println("Configuration Admin clicked");
	}
	
}
