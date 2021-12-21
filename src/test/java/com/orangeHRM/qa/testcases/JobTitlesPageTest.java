package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.JobAdminPage;
import com.orangeHRM.qa.pages.JobTitlesPage;

public class JobTitlesPageTest extends BaseClass{

	AdminPage adminPage;
	JobAdminPage jobAdminPage;
	JobTitlesPage jobTitlesPage;
	@BeforeClass
	public void verifyJobTitlesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		jobAdminPage = adminPage.navigatingToJobAdmin();
		jobTitlesPage = jobAdminPage.navigatingToJobTitles();
		Assert.assertTrue(jobTitlesPage.getcurrentUrl());
		System.out.println("Clicked Job Titles and asserted URL");
	}
	
	@Test(priority = 4)
	public void jobTitlesTesting()
	{
		System.out.println("Job Titles clicked");
	}
}
