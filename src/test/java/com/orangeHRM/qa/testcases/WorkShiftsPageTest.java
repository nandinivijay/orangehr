package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.JobAdminPage;
import com.orangeHRM.qa.pages.WorkShiftsPage;

public class WorkShiftsPageTest extends BaseClass{

	AdminPage adminPage;
	JobAdminPage jobAdminPage;
	WorkShiftsPage workShiftsPage;
	@BeforeClass
	public void verifyWorkShiftsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		jobAdminPage = adminPage.navigatingToJobAdmin();
		workShiftsPage = jobAdminPage.navigatingToWorkShifts();
		Assert.assertTrue(workShiftsPage.getcurrentUrl());
		System.out.println("Clicked  Work Shifts and asserted URL");
	}
	
	@Test(priority = 4)
	public void  workShiftsTesting()
	{
		System.out.println(" Work Shifts clicked");
	}
}
