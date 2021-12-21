package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.JobAdminPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class JobAdminPageTest extends BaseClass{
	AdminPage adminPage;
	JobAdminPage jobAdminPage;
	@BeforeClass
	public void verifyJobAdminPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		jobAdminPage = adminPage.navigatingToJobAdmin();
		System.out.println("Clicked Job Admin");
	}
	
	@Test(priority = 2)
	public void validatingJobAdminSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(adminPage.getJobAdmin_id(), driver);
		Assert.assertTrue(jobAdminPage.getJobTitles_id().isDisplayed());
		System.out.println("Job Titles Displayed");
		Assert.assertTrue(jobAdminPage.getPayGrades_id().isDisplayed());
		System.out.println("Pay Grades Displayed");
		Assert.assertTrue(jobAdminPage.getJobCategories_id().isDisplayed());
		System.out.println("Job Categories Displayed");
		Assert.assertTrue(jobAdminPage.getEmploymentStatus_id().isDisplayed());
		System.out.println("Employment Status Displayed");
		Assert.assertTrue(jobAdminPage.getWorkShifts_id().isDisplayed());
		System.out.println("Work Shifts Displayed");
	}
	
	@Test(priority = 3)
	public void jobAdminTesting()
	{
		System.out.println("Job Admin clicked");
	}
}
