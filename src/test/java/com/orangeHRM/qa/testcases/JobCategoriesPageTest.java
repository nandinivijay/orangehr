package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.JobAdminPage;
import com.orangeHRM.qa.pages.JobCategoriesPage;

public class JobCategoriesPageTest extends BaseClass{

	AdminPage adminPage;
	JobAdminPage jobAdminPage;
	JobCategoriesPage jobCategoriesPage;
	@BeforeClass
	public void verifyJobCategoriesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		jobAdminPage = adminPage.navigatingToJobAdmin();
		jobCategoriesPage = jobAdminPage.navigatingToJobCategories();
		Assert.assertTrue(jobCategoriesPage.getcurrentUrl());
		System.out.println("Clicked Job Categories and asserted URL");
	}
	
	@Test(priority = 2)
	public void jobCategoriesTesting()
	{
		System.out.println("Job Categories clicked");
	}
}
