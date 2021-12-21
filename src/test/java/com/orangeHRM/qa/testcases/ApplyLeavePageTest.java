package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ApplyLeavePage;
import com.orangeHRM.qa.pages.LeavePage;


public class ApplyLeavePageTest extends BaseClass{

	ApplyLeavePage applyLeavePage;
	@BeforeClass
	public void verifyApplyLeaveNavigationPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		LeavePage leavePage = baseVerification.navigatingToLeave(); 
		applyLeavePage = leavePage.navigatingToApply();
		Assert.assertTrue(applyLeavePage.getcurrentUrl());
		System.out.println("Clicked Apply Leave ,Navigated to Apply Leave Page and asserted URL");
	}
	
	@Test(priority = 2)
	public void applyLeaveTesting()
	{
		System.out.println("Apply Leave clicked");
	}
}
