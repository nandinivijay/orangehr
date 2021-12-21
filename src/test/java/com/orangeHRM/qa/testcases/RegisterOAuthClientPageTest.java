package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.ConfigurationAdminPage;
import com.orangeHRM.qa.pages.RegisterOAuthClientPage;


public class RegisterOAuthClientPageTest extends BaseClass{
	AdminPage adminPage;
	ConfigurationAdminPage configurationAdminPage;
	RegisterOAuthClientPage registerOAuthClientPage;
	@BeforeClass
	public void verifyRegisterOAuthClientPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		configurationAdminPage = adminPage.navigatingToConfigurationAdmin();
		registerOAuthClientPage = configurationAdminPage.navigatingToRegisterOAuthClient();
		Assert.assertTrue(registerOAuthClientPage.getcurrentUrl());
		System.out.println("Clicked Register O Auth Client and asserted URL");
	}
	
	@Test(priority = 4)
	public void registerOAuthClientTesting()
	{
		System.out.println("Register O Auth Client clicked");
	}
}
