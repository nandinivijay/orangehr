package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.EmploymentStatusPage;
import com.orangeHRM.qa.pages.JobAdminPage;

public class EmploymentStatusPageTest extends BaseClass{

	AdminPage adminPage;
	JobAdminPage jobAdminPage;
	EmploymentStatusPage employmentStatusPage;
	@BeforeClass
	public void verifyEmploymentStatusPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		jobAdminPage = adminPage.navigatingToJobAdmin();
		employmentStatusPage = jobAdminPage.navigatingToEmploymentStatus();
		Assert.assertTrue(employmentStatusPage.getcurrentUrl());
		System.out.println("Clicked Employment Status and asserted URL");
	}
	
	@Test(priority = 4)
	public void employmentStatusTesting()
	{
		System.out.println("Employment Status clicked");
	}
}
