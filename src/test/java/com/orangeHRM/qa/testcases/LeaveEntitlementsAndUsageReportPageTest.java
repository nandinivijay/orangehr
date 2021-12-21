package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.LeaveEntitlementsAndUsageReportPage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.pages.ReportsLeavePage;


public class LeaveEntitlementsAndUsageReportPageTest extends BaseClass {
	
	LeavePage leavePage;
	ReportsLeavePage reportsLeavePage;
	LeaveEntitlementsAndUsageReportPage leaveEntitlementsAndUsageReportPage;
	
	@BeforeClass
	public void verifyLeaveEntitlementsAndUsageReportPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		reportsLeavePage = leavePage.navigatingToReportsLeave();
		leaveEntitlementsAndUsageReportPage = reportsLeavePage.navigatingToLeaveEntitlementsAndUsageReport_ID();
		Assert.assertTrue(leaveEntitlementsAndUsageReportPage.getcurrentUrl());
		System.out.println("Clicked leaveEntitlementsAndUsageReport and asserted URL");
	}
	
	@Test(priority = 1)
	public void leaveEntitlementsAndUsageReportTesting()
	{
		System.out.println("Leave Entitlements And Usage Report clicked");
	}

}

