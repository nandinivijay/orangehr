package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigureLeavePage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.pages.WorkWeekPage;

public class WorkWeekPageTest extends BaseClass{
	LeavePage leavePage;
	ConfigureLeavePage configureLeavePage;
	WorkWeekPage workweekPage;
	@BeforeClass
	public void verifyWorkWeekPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		configureLeavePage = leavePage.navigatingToConfigureLeave();
		workweekPage = configureLeavePage.navigatingToWorkWeek();
		Assert.assertTrue(workweekPage.getcurrentUrl());
		System.out.println("Clicked Work Week and asserted URL");
	}
	
	@Test(priority = 2)
	public void workWeekTesting()
	{
		System.out.println("Work Week clicked");
	}

}
