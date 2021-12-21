package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigureLeavePage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.pages.LeavePeriodPage;

public class LeavePeriodPageTest extends BaseClass{
	LeavePage leavePage;
	ConfigureLeavePage configureLeavePage;
	LeavePeriodPage leavePeriodPage;
	@BeforeClass
	public void verifyLeavePeriodPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		configureLeavePage = leavePage.navigatingToConfigureLeave();
		leavePeriodPage = configureLeavePage.navigatingToLeavePeriod();
		Assert.assertTrue(leavePeriodPage.getcurrentUrl());
		System.out.println("Clicked Leave Period and asserted URL");
	}
	
	@Test(priority = 2)
	public void leavePeriodTesting()
	{
		System.out.println("Leave Period clicked");
	}

}
