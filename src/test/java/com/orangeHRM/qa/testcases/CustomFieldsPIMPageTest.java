package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigurationPIMPage;
import com.orangeHRM.qa.pages.CustomFieldsPIMPage;
import com.orangeHRM.qa.pages.PIMPage;


public class CustomFieldsPIMPageTest extends BaseClass{
	PIMPage pimPage;
	ConfigurationPIMPage configurationPIMPage;
	CustomFieldsPIMPage customFieldsPIMPage;
	@BeforeClass
	public void verifyCustomFieldsPIMPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		configurationPIMPage = pimPage.navigatingToConfiguration();
		customFieldsPIMPage = configurationPIMPage.navigatingToCustomFields();
		Assert.assertTrue(customFieldsPIMPage.getcurrentUrl());
		System.out.println("Clicked Custom Fields and asserted URL");
	}
	
	@Test(priority = 4)
	public void customFieldsPIMTesting()
	{
		System.out.println("Custom Fields PIM clicked");
	}
}
