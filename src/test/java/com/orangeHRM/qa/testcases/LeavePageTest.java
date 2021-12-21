package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.LeaveListPage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.util.ActionsUtil;

public class LeavePageTest extends BaseClass{

	BaseVerification baseVerification;
	LeavePage leavePage;
	LeaveListPage leaveListPage ;
	@BeforeClass
	public void verifyLeavePageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave();
		Assert.assertTrue(leavePage.getcurrentUrl());
		System.out.println("Clicked Leave and asserted URL");
	}
	
	@Test(priority = 0)
	public void validatingLeaveSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(baseVerification.getLeave_id(), driver);
		Assert.assertTrue(leavePage.getApplyLeave_id().isDisplayed());
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getApplyLeave_id().getCssValue("color"));

		System.out.println("Apply Leave Displayed");
		Assert.assertTrue(leavePage.getMyLeave_id().isDisplayed());
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getMyLeave_id().getCssValue("color"));
		System.out.println("My leave Displayed");
		Assert.assertTrue(leavePage.getEntitlements_id().isDisplayed());
		
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getEntitlements_id().getCssValue("color"));

		System.out.println("Entitlements Displayed");
		Assert.assertTrue(leavePage.getReportsLeave_id().isDisplayed());
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getReportsLeave_id().getCssValue("color"));

		System.out.println("Reports Leave Displayed");
		Assert.assertTrue(leavePage.getLeaveList_id().isDisplayed());
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getLeaveList_id().getCssValue("color"));

		System.out.println("Leave List Displayed");
		Assert.assertTrue(leavePage.getAssignLeave_id().isDisplayed());
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getAssignLeave_id().getCssValue("color"));

		System.out.println("Assign Leave Displayed");
	}
	@Test(priority=20)
	public void verifyColurOfSubMenu()
	
	{
		baseVerification.getLeave_id().click();
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getApplyLeave_id().getCssValue("color"));
		System.out.println("Leave page id and apply colors are same");
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getMyLeave_id().getCssValue("color"));
		System.out.println("Leave page id and my leave  colors are same");
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getEntitlements_id().getCssValue("color"));
		System.out.println("Leave page id and entitlements colors are same");
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getReportsLeave_id().getCssValue("color"));
		System.out.println("Leave page id and getreportsleave colors are same");
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getLeaveList_id().getCssValue("color"));
		System.out.println("Leave page id and getleavelist colors are same");
		Assert.assertEquals(baseVerification.getLeave_id().getCssValue("color"),leavePage.getAssignLeave_id().getCssValue("color"));
		System.out.println("Leave page id and assignleave colors are same");


	}
	
	@AfterClass
	public void navigatingToSubMenuOnClickingLeave()
	{
		leaveListPage = leavePage.navigatingToLeaveList();
		Assert.assertEquals(leavePage.getcurrentUrl(), leaveListPage.getcurrentUrl());
		System.out.println("Leave clicked and Opened Leave List Page");
	}
	
	
}
