package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigurationPIMPage;
import com.orangeHRM.qa.pages.OptionalFieldsPIMPage;
import com.orangeHRM.qa.pages.PIMPage;

public class OptionalFieldsPIMPageTest extends BaseClass{
	PIMPage pimPage;
	ConfigurationPIMPage configurationPIMPage;
	OptionalFieldsPIMPage optionalFieldsPIMPage;
	@BeforeClass
	public void verifyOptionalFieldsPIMPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		configurationPIMPage = pimPage.navigatingToConfiguration();
		optionalFieldsPIMPage = configurationPIMPage.navigatingToOptionalFields();
		Assert.assertTrue(optionalFieldsPIMPage.getcurrentUrl());
		System.out.println("Clicked Optional Fields and asserted URL");
	}
	
	@Test(priority = 4)
	public void optionalFieldsPIMTesting()
	{
		System.out.println("Optional Fields PIM clicked");
	}
}
