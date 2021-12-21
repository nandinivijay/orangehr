package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.pages.MyLeaveEntitlementsAndUsageReportPage;
import com.orangeHRM.qa.pages.ReportsLeavePage;

public class  MyLeaveEntitlementsAndUsageReportPageTest extends BaseClass{
	
	LeavePage leavePage;
	ReportsLeavePage reportsLeavePage;
	MyLeaveEntitlementsAndUsageReportPage myLeaveEntitlementsAndUsageReportPage;
	
	@BeforeClass
	public void verifyMyLeaveEntitlementsAndUsageReportPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		reportsLeavePage = leavePage.navigatingToReportsLeave();
		myLeaveEntitlementsAndUsageReportPage = reportsLeavePage.navigatingToMyLeaveEntitlementsAndUsageReport();
		Assert.assertTrue(myLeaveEntitlementsAndUsageReportPage.getcurrentUrl());
		System.out.println("Clicked Leave Period and asserted URL");
	}
	
	@Test(priority = 4)
	public void myLeaveEntitlementsAndUsageReportTesting()
	{
		System.out.println("My Leave Entitlements And Usage Report clicked");
	}

}
