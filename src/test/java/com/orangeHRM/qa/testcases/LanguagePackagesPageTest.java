package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.ConfigurationAdminPage;
import com.orangeHRM.qa.pages.LanguagePackagesPage;

public class LanguagePackagesPageTest extends BaseClass{
	AdminPage adminPage;
	ConfigurationAdminPage configurationAdminPage;
	LanguagePackagesPage languagePackagesPage;
	@BeforeClass
	public void verifyLanguagePackagesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		configurationAdminPage = adminPage.navigatingToConfigurationAdmin();
		languagePackagesPage = configurationAdminPage.navigatingToLanguagePackages();
		Assert.assertTrue(languagePackagesPage.getcurrentUrl());
		System.out.println("Clicked Language Packages and asserted URL");
	}
	
	@Test(priority = 4)
	public void languagePackagesTesting()
	{
		System.out.println("Language Packages clicked");
	}
}
