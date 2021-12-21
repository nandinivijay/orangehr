package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MyTimeSheetsPage;
import com.orangeHRM.qa.pages.TimePage;
import com.orangeHRM.qa.pages.TimeSheetsPage;

public class MyTimeSheetsPageTest extends BaseClass{

	TimePage timePage;
	TimeSheetsPage timeSheetsPage;
	MyTimeSheetsPage myTimeSheetsPage;
	@BeforeClass
	public void verifyMyTimeSheetsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		timeSheetsPage = timePage.navigatingToTimeSheets();
		myTimeSheetsPage = timeSheetsPage.navigatingToMyTimeSheets();
		Assert.assertTrue(myTimeSheetsPage.getcurrentUrl());
		System.out.println("Clicked MyTimeSheets and asserted URL");
	}
	
	@Test(priority = 4)
	public void myTimeSheetsTesting()
	{
		System.out.println("MyTimeSheets clicked");
	}
}
