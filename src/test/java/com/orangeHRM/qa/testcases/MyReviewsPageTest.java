package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ManageReviewsPage;
import com.orangeHRM.qa.pages.MyReviewsPage;
import com.orangeHRM.qa.pages.PerformancePage;

public class MyReviewsPageTest extends BaseClass{
	PerformancePage performancePage;
	ManageReviewsPage manageReviewsPage;
	MyReviewsPage myReviewsPage;
	@BeforeClass
	public void verifyMyReviewsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		manageReviewsPage = performancePage.navigatingToManageReviews();
		myReviewsPage =manageReviewsPage.navigatingToMyReviews();
		Assert.assertTrue(myReviewsPage.getcurrentUrl());
		System.out.println("Clicked My Reviews and asserted URL");
	}
	
	@Test(priority = 3)
	public void myReviewsTesting()
	{
		System.out.println("My Reviews clicked");
	}
}
