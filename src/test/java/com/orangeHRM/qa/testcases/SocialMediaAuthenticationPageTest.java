package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.ConfigurationAdminPage;
import com.orangeHRM.qa.pages.SocialMediaAuthenticationPage;

public class SocialMediaAuthenticationPageTest extends BaseClass{
	AdminPage adminPage;
	ConfigurationAdminPage configurationAdminPage;
	SocialMediaAuthenticationPage socialMediaAuthenticationPage;
	@BeforeClass
	public void verifySocialMediaAuthenticationPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		configurationAdminPage = adminPage.navigatingToConfigurationAdmin();
		socialMediaAuthenticationPage = configurationAdminPage.navigatingToSocialMediaAuthentication();
		Assert.assertTrue(socialMediaAuthenticationPage.getcurrentUrl());
		System.out.println("Clicked Social Media Authentication and asserted URL");
	}
	
	@Test(priority = 4)
	public void socialMediaAuthenticationTesting()
	{
		System.out.println("Social Media Authentication clicked");
	}
}
