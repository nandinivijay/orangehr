package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.ConfigurationAdminPage;
import com.orangeHRM.qa.pages.LocalizationPage;

public class LocalizationPageTest extends BaseClass{
	AdminPage adminPage;
	ConfigurationAdminPage configurationAdminPage;
	LocalizationPage localizationPage;
	@BeforeClass
	public void verifyLocalizationPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		configurationAdminPage = adminPage.navigatingToConfigurationAdmin();
		localizationPage = configurationAdminPage.navigatingToLocalization();
		Assert.assertTrue(localizationPage.getcurrentUrl());
		System.out.println("Clicked Localization and asserted URL");
	}
	
	@Test(priority = 4)
	public void localizationTesting()
	{
		System.out.println("Localization clicked");
	}
}
