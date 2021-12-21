package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ManageReviewsPage;
import com.orangeHRM.qa.pages.PerformancePage;
import com.orangeHRM.qa.pages.ReviewListPage;

public class ReviewListPageTest extends BaseClass{
	PerformancePage performancePage;
	ManageReviewsPage manageReviewsPage;
	ReviewListPage reviewListPage;
	@BeforeClass
	public void verifyMyTrackersPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		manageReviewsPage = performancePage.navigatingToManageReviews();
		reviewListPage = manageReviewsPage.navigatingToReviewList();
		Assert.assertTrue(reviewListPage.getcurrentUrl());
		System.out.println("Clicked Review List and asserted URL");
	}
	
	@Test(priority = 4)
	public void reviewListTesting()
	{
		System.out.println("Review List clicked");
	}
}
