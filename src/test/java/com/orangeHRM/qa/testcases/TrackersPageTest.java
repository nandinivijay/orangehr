package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigurePerformancePage;
import com.orangeHRM.qa.pages.PerformancePage;
import com.orangeHRM.qa.pages.TrackersPage;

public class TrackersPageTest extends BaseClass{
	PerformancePage performancePage;
	ConfigurePerformancePage configurePerformancePage;
	TrackersPage trackersPage;
	@BeforeClass
	public void verifyTrackersPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		configurePerformancePage = performancePage.navigatingToConfigurePerformance();
		trackersPage = configurePerformancePage.navigatingToTrackers();
		Assert.assertTrue(trackersPage.getcurrentUrl());
		System.out.println("Clicked Trackers and asserted URL");
	}
	
	@Test(priority = 4)
	public void trackersTesting()
	{
		System.out.println("Trackers clicked");
	}
}
