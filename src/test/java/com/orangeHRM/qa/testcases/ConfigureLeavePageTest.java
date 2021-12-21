package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigureLeavePage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.util.ActionsUtil;

public class ConfigureLeavePageTest extends BaseClass{

	LeavePage leavePage;
	ConfigureLeavePage configureLeavePage;
	@BeforeClass
	public void verifyConfigureLeavePageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		configureLeavePage = leavePage.navigatingToConfigureLeave();
		System.out.println("Clicked Configure Leave ");
	}
	
	@Test(priority = 2)
	public void validatingConfigureLeaveSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(leavePage.getConfigureLeave_id(), driver);
		Assert.assertTrue(configureLeavePage.getLeavePeriod_id().isDisplayed());
		System.out.println("Leave Period Displayed");
		Assert.assertTrue(configureLeavePage.getLeaveTypes_id().isDisplayed());
		System.out.println("Leave Types Displayed");
		Assert.assertTrue(configureLeavePage.getHolidays_id().isDisplayed());
		System.out.println("Holidays Displayed");
		Assert.assertTrue(configureLeavePage.getWorkWeek_id().isDisplayed());
		System.out.println("WorkWeek Displayed");
	}
	
	
	@Test(priority = 3)
	public void configureLeaveTesting()
	{
		System.out.println("Configure Leave clicked");
	}
}
