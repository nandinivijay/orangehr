package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.EmployeeTrackersPage;
import com.orangeHRM.qa.pages.PerformancePage;

public class EmployeeTrackersPageTest extends BaseClass{
	PerformancePage performancePage;
	EmployeeTrackersPage employeeTrackersPage;
	@BeforeClass
	public void verifyEmployeeTrackersPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		employeeTrackersPage = performancePage.navigatingToEmployeeTrackers();
		Assert.assertTrue(employeeTrackersPage.getcurrentUrl());
		System.out.println("Clicked Employee Trackers and asserted URL");
	}
	
	@Test(priority = 2)
	public void employeeTrackersTesting()
	{
		System.out.println("Employee Trackers clicked");
	}
}
