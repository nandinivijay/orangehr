package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.pages.EmailConfigurationPage;

public class EmailConfigurationPageTest extends ConfigurationAdminPageTest{

	EmailConfigurationPage emailConfigurationPage;
	@BeforeClass
	public void verifyEmailConfigurationPageNavigation()
	{
		emailConfigurationPage = configurationAdminPage.navigatingToEmailConfiguration();
		Assert.assertTrue(emailConfigurationPage.getcurrentUrl());
		System.out.println("Clicked Email Configuration and asserted URL");
	}
	
	@Test(priority = 4)
	public void emailConfigurationTesting()
	{
		System.out.println("Email Configuration clicked");
	}
}
