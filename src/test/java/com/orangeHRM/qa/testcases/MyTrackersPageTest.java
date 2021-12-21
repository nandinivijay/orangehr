package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MyTrackersPage;
import com.orangeHRM.qa.pages.PerformancePage;

public class MyTrackersPageTest extends BaseClass{
	PerformancePage performancePage;
	MyTrackersPage myTrackersPage;
	@BeforeClass
	public void verifyMyTrackersPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		myTrackersPage = performancePage.navigatingToMyTrackers();
		Assert.assertTrue(myTrackersPage.getcurrentUrl());
		System.out.println("Clicked My Trackers and asserted URL");
	}
	
	@Test(priority = 2)
	public void myTrackersTesting()
	{
		System.out.println("My Trackers clicked");
	}
}
