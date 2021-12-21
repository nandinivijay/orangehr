package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigurePerformancePage;
import com.orangeHRM.qa.pages.PerformancePage;
import com.orangeHRM.qa.util.ActionsUtil;

public class ConfigurePerformancePageTest extends BaseClass{
	PerformancePage performancePage;
	ConfigurePerformancePage configurePerformancePage;
	@BeforeClass
	public void verifyConfigurePerformancePageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		configurePerformancePage = performancePage.navigatingToConfigurePerformance();
		System.out.println("Clicked Configure Performance");
	}
	
	@Test(priority = 2)
	public void validatingConfigurePerformanceSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(performancePage.getConfigurePerformance_id(), driver);
		Assert.assertTrue(configurePerformancePage.getKPIs_id().isDisplayed());
		System.out.println("KPIs Displayed");
		Assert.assertTrue(configurePerformancePage.getTrackers_id().isDisplayed());
		System.out.println("Trackers Displayed");
	}
	@Test(priority = 3)
	public void configurePerformanceTesting()
	{
		System.out.println("Configure Performance clicked");
	}
}
