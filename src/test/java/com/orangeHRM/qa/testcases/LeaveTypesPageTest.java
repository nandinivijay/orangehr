package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigureLeavePage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.pages.LeaveTypesPage;

public class LeaveTypesPageTest extends BaseClass{
	LeavePage leavePage;
	ConfigureLeavePage configureLeavePage;
	LeaveTypesPage leaveTypesPage;
	@BeforeClass
	public void verifyLeaveTypesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		configureLeavePage = leavePage.navigatingToConfigureLeave();
		leaveTypesPage = configureLeavePage.navigatingToLeaveTypes();
		Assert.assertTrue(leaveTypesPage.getcurrentUrl());
		System.out.println("Clicked Leave Types and asserted URL");
	}
	
	@Test(priority = 2)
	public void leaveTypesTesting()
	{
		System.out.println("Leave Types clicked");
	}

}
