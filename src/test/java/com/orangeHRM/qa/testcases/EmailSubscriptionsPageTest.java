package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.ConfigurationAdminPage;
import com.orangeHRM.qa.pages.EmailSubscriptionsPage;

public class EmailSubscriptionsPageTest extends BaseClass{
	AdminPage adminPage;
	ConfigurationAdminPage configurationAdminPage;
	EmailSubscriptionsPage emailSubscriptionsPage;
	@BeforeClass
	public void verifyEmailSubscriptionsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		configurationAdminPage = adminPage.navigatingToConfigurationAdmin();
		emailSubscriptionsPage = configurationAdminPage.navigatingToEmailSubscriptions();
		Assert.assertTrue(emailSubscriptionsPage.getcurrentUrl());
		System.out.println("Clicked Email Subscriptions and asserted URL");
	}
	
	@Test(priority = 4)
	public void emailSubscriptionsTesting()
	{
		System.out.println("Email Subscriptions clicked");
	}
}
