package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AttendanceSummaryPage;
import com.orangeHRM.qa.pages.ReportsTimePage;
import com.orangeHRM.qa.pages.TimePage;

public class AttendanceSummaryPageTest extends BaseClass{

	TimePage timePage;
	ReportsTimePage reportsTimePage;
	AttendanceSummaryPage attendanceSummaryPage;
	@BeforeClass
	public void verifyAttendanceSummaryPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		reportsTimePage = timePage.navigatingToReportsTime();
		attendanceSummaryPage = reportsTimePage.navigatingToAttendanceSummary();
		Assert.assertTrue(attendanceSummaryPage.getcurrentUrl());
		System.out.println("Clicked Attendance Summary and asserted URL");
	}
	
	@Test(priority = 4)
	public void attendanceSummaryTesting()
	{
		System.out.println("Attendance Summary clicked");
	}
}
