package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.TimePage;
import com.orangeHRM.qa.pages.TimeSheetsPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class TimeSheetsPageTest extends BaseClass{

	TimePage timePage;
	TimeSheetsPage timeSheetsPage;
	@BeforeClass
	public void verifyTimeSheetsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		timeSheetsPage = timePage.navigatingToTimeSheets();
		System.out.println("Clicked Time Sheets");
	}
	
	@Test(priority = 2)
	public void validatingTimeSheetsSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(timePage.getTimeSheets_id(), driver);
		Assert.assertTrue(timeSheetsPage.getEmployeeTimeSheets_id().isDisplayed());
		System.out.println("Employee Time Sheets Displayed");
		Assert.assertTrue(timeSheetsPage.getMyTimeSheets_id().isDisplayed());
		System.out.println("My Time Sheets Displayed");
	}
	
	@Test(priority = 3)
	public void timeSheetsTesting()
	{
		System.out.println("Time Sheets clicked");
	}
}
