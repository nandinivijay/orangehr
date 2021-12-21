package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigureLeavePage;
import com.orangeHRM.qa.pages.HolidaysPage;
import com.orangeHRM.qa.pages.LeavePage;

public class HolidaysPageTest extends BaseClass{
	LeavePage leavePage;
	ConfigureLeavePage configureLeavePage;
	HolidaysPage holidaysPage;
	@BeforeClass
	public void verifyHolidaysPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		configureLeavePage = leavePage.navigatingToConfigureLeave();
		holidaysPage = configureLeavePage.navigatingToHolidays();
		Assert.assertTrue(holidaysPage.getcurrentUrl());
		System.out.println("Clicked Holidays and asserted URL");
	}
	
	@Test(priority = 4)
	public void holidaysTesting()
	{
		System.out.println("Holidays clicked");
	}

}
