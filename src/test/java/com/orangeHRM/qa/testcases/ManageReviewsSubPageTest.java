package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ManageReviewsPage;
import com.orangeHRM.qa.pages.ManageReviewsSubPage;
import com.orangeHRM.qa.pages.PerformancePage;

public class ManageReviewsSubPageTest extends BaseClass{
	PerformancePage performancePage;
	ManageReviewsPage manageReviewsPage;
	ManageReviewsSubPage manageReviewsSubPage;
	@BeforeClass
	public void verifyManageReviewsSubPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		manageReviewsPage = performancePage.navigatingToManageReviews();
		manageReviewsSubPage = manageReviewsPage.navigatingToManageReviewsSubModule();
		Assert.assertTrue(manageReviewsSubPage.getcurrentUrl());
		System.out.println("Clicked Manage Reviews Sub and asserted URL");
	}
	
	@Test(priority = 4)
	public void manageReviewsSubTesting()
	{
		System.out.println("Manage Reviews Sub clicked");
	}
}
