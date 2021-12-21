package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ReportsTimePage;
import com.orangeHRM.qa.pages.TimePage;
import com.orangeHRM.qa.util.ActionsUtil;

public class ReportsTimePageTest extends BaseClass{

	TimePage timePage;
	ReportsTimePage reportsTimePage;
	@BeforeClass
	public void verifyReportsTimePageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		reportsTimePage = timePage.navigatingToReportsTime();
		System.out.println("Clicked Reports Time ");
	}
	
	@Test(priority = 2)
	public void validatingTimeSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(timePage.getReportsTime_id(), driver);
		Assert.assertTrue(reportsTimePage.getProjectReports_id().isDisplayed());
		System.out.println("Project Reports Displayed");
		Assert.assertTrue(reportsTimePage.getEmployeeReports_id().isDisplayed());
		System.out.println("Employee Reports Displayed");
		Assert.assertTrue(reportsTimePage.getAttendanceSummary_id().isDisplayed());
		System.out.println("Attendance Summary Displayed");
	}
	
	@Test(priority = 3)
	public void reportsTimeTesting()
	{
		System.out.println("Reports Time clicked");
	}
}
