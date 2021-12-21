package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.EmployeeTimeSheetsPage;
import com.orangeHRM.qa.pages.TimePage;
import com.orangeHRM.qa.pages.TimeSheetsPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class TimePageTest extends BaseClass{

	BaseVerification baseVerification ;
	TimePage timePage;
	@BeforeClass
	public void verifyTimePageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		Assert.assertTrue(timePage.getcurrentUrl());
		System.out.println("Clicked Time and asserted URL");
	}
	
	@Test(priority = 0)
	public void validatingTimeSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(baseVerification.getTime_id(), driver);
		Assert.assertTrue(timePage.getTimeSheets_id().isDisplayed());
		Assert.assertEquals(baseVerification.getTime_id().getCssValue("color"),timePage.getTimeSheets_id().getCssValue("color"));
		System.out.println("Time Sheets Displayed");
		Assert.assertTrue(timePage.getAttendance_id().isDisplayed());
		Assert.assertEquals(baseVerification.getTime_id().getCssValue("color"),timePage.getAttendance_id().getCssValue("color"));

		System.out.println("Attendance Displayed");
		Assert.assertTrue(timePage.getReportsTime_id().isDisplayed());
		Assert.assertEquals(baseVerification.getTime_id().getCssValue("color"),timePage.getReportsTime_id().getCssValue("color"));

		System.out.println("Reports Displayed");
		Assert.assertTrue(timePage.getProjectInfo_id().isDisplayed());
		Assert.assertEquals(baseVerification.getTime_id().getCssValue("color"),timePage.getProjectInfo_id().getCssValue("color"));
		System.out.println("Project Info Displayed");
	}
	@Test(priority = 1)
	public void timeTesting()
	{
		System.out.println("Time Clicked");
	}
	@Test(priority=2)
	public void verifyColorsOfSubmenuInTime()
	{
	
	baseVerification.getTime_id().click();
	Assert.assertEquals(baseVerification.getTime_id().getCssValue("color"),timePage.getTimeSheets_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getTime_id().getCssValue("color"),timePage.getAttendance_id().getCssValue("color"));

	Assert.assertEquals(baseVerification.getTime_id().getCssValue("color"),timePage.getReportsTime_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getTime_id().getCssValue("color"),timePage.getProjectInfo_id().getCssValue("color"));
	
	
	}

	

	
	@AfterClass
	public void navigatingToSubMenuOnClickingTime()
	{
		TimeSheetsPage timeSheetsPage = timePage.navigatingToTimeSheets();
		EmployeeTimeSheetsPage  employeeTimeSheetsPage = timeSheetsPage.navigatingToEmployeeTimeSheets();
		Assert.assertEquals(timePage.getcurrentUrl(), employeeTimeSheetsPage.getcurrentUrl());
		System.out.println("Time clicked and Opened EmployeeTimeSheetsPage");
	}
}
