package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.pages.ReportsLeavePage;
import com.orangeHRM.qa.util.ActionsUtil;
public class ReportsLeavePageTest extends BaseClass {

	LeavePage leavePage;
	ReportsLeavePage reportsLeavePage;
	@BeforeClass
	public void verifyReportsLeavePageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		reportsLeavePage = leavePage.navigatingToReportsLeave();
		System.out.println("Clicked Reports Leave ");
	}
	
	@Test(priority = 2)
	public void validatingReortsLeaveSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(leavePage.getReportsLeave_id(), driver);
		Assert.assertTrue(reportsLeavePage.getLeaveEntitlementsAndUsageReport_id().isDisplayed());
		System.out.println("LeaveEntitlementsAndUsageReport Displayed");
		Assert.assertTrue(reportsLeavePage.getMyLeaveEntitlementsAndUsageReport_id().isDisplayed());
		System.out.println("MyLeaveEntitlementsAndUsageReport Displayed");
		
	}
	
	
	@Test(priority = 3)
	public void reportsLeaveTesting()
	{
		System.out.println("Reports Leave clicked");
	}
}
