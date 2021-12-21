package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.EmployeeTimeSheetsPage;
import com.orangeHRM.qa.pages.TimePage;
import com.orangeHRM.qa.pages.TimeSheetsPage;

public class EmployeeTimeSheetsPageTest extends BaseClass{

	TimePage timePage;
	TimeSheetsPage timeSheetsPage;
	EmployeeTimeSheetsPage employeeTimeSheetsPage;
	@BeforeClass
	public void verifyEmployeeTimeSheets()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		timeSheetsPage = timePage.navigatingToTimeSheets();
		employeeTimeSheetsPage = timeSheetsPage.navigatingToEmployeeTimeSheets();
		Assert.assertTrue(employeeTimeSheetsPage.getcurrentUrl());
		System.out.println("Clicked Employee TimeSheets and asserted URL");
	}
	
	@Test(priority = 4)
	public void employeeTimeSheetsTesting()
	{
		System.out.println("Employee TimeSheets clicked");
	}
}
