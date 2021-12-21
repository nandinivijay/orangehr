package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.PerformancePage;
import com.orangeHRM.qa.util.ActionsUtil;

public class PerformancePageTest extends BaseClass{

	BaseVerification baseVerification ;
	PerformancePage performancePage;
	@BeforeClass
	public void verifyPerformancePageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		System.out.println("Entered Performance");
	}
	
	@Test(priority = 0)
	public void validatingPerformanceSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(baseVerification.getPerformance_id(), driver);
		Assert.assertTrue(performancePage.getConfigurePerformance_id().isDisplayed());
		Assert.assertEquals(baseVerification.getPerformance_id().getCssValue("color"),performancePage.getConfigurePerformance_id().getCssValue("color"));
		System.out.println("Configure Performance Displayed");
		Assert.assertTrue(performancePage.getManageReviews_id().isDisplayed());
		Assert.assertEquals(baseVerification.getPerformance_id().getCssValue("color"),performancePage.getManageReviews_id().getCssValue("color"));
		System.out.println("Manage Reviews Displayed");
		Assert.assertTrue(performancePage.getMyTrackers_id().isDisplayed());
		Assert.assertEquals(baseVerification.getPerformance_id().getCssValue("color"),performancePage.getMyTrackers_id().getCssValue("color"));

		System.out.println("My Trackers Displayed");
		Assert.assertTrue(performancePage.getEmployeeTrackers_id().isDisplayed());
		Assert.assertEquals(baseVerification.getPerformance_id().getCssValue("color"),performancePage.getEmployeeTrackers_id().getCssValue("color"));
		System.out.println("Employee Trackers Displayed");
	}
	@Test(priority=2)
	public void verifyColorsOfSubmenuInPerformance()
	{
	
baseVerification.getPerformance_id().click();
	Assert.assertEquals(baseVerification.getPerformance_id().getCssValue("color"),performancePage.getConfigurePerformance_id().getCssValue("color"));
Assert.assertEquals(baseVerification.getPerformance_id().getCssValue("color"),performancePage.getManageReviews_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getPerformance_id().getCssValue("color"),performancePage.getMyTrackers_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getPerformance_id().getCssValue("color"),performancePage.getEmployeeTrackers_id().getCssValue("color"));
			
	
	}
	@Test (priority =1)
	public void performanceTesting()
	{
		System.out.println("Performance Clicked");
	}
}
