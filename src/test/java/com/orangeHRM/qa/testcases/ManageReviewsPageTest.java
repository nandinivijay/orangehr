package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ManageReviewsPage;
import com.orangeHRM.qa.pages.PerformancePage;
import com.orangeHRM.qa.util.ActionsUtil;

public class ManageReviewsPageTest extends BaseClass{
	PerformancePage performancePage;
	ManageReviewsPage manageReviewsPage;
	@BeforeClass
	public void verifyManageReviewsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		manageReviewsPage = performancePage.navigatingToManageReviews();
		System.out.println("Clicked Manage Reviews");
	}
	
	@Test(priority = 2)
	public void validatingManageReviewsSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(performancePage.getManageReviews_id(), driver);
		Assert.assertTrue(manageReviewsPage.getManageReviewsSub_id().isDisplayed());
		System.out.println("Manage Reviews Sub Displayed");
		Assert.assertTrue(manageReviewsPage.getMyReviews_id().isDisplayed());
		System.out.println("My Reviews Displayed");
		Assert.assertTrue(manageReviewsPage.getReviewList_id().isDisplayed());
		System.out.println("Review List Displayed");
	}
	
	@Test(priority = 3)
	public void manageReviewsTesting()
	{
		System.out.println("Manage Reviews clicked");
	}
}
