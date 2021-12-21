package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigurationPIMPage;
import com.orangeHRM.qa.pages.PIMPage;
import com.orangeHRM.qa.pages.TerminationReasonsPIMPage;

public class TerminationReasonsPIMPageTest extends BaseClass{
	PIMPage pimPage;
	ConfigurationPIMPage configurationPIMPage;
	TerminationReasonsPIMPage terminationReasonsPIMPage;
	@BeforeClass
	public void verifyTerminationReasonsPIMPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		configurationPIMPage = pimPage.navigatingToConfiguration();
		terminationReasonsPIMPage = configurationPIMPage.navigatingToTerminationReasons();
		Assert.assertTrue(terminationReasonsPIMPage.getcurrentUrl());
		System.out.println("Clicked Termination Reasons PIM and asserted URL");
	}
	
	@Test(priority = 4)
	public void terminationReasonsPIMTesting()
	{
		System.out.println("Termination Reasons PIM clicked");
	}
}
