package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.PIMPage;
import com.orangeHRM.qa.pages.ReportsPIMPage;


public class ReportsPIMPageTest extends BaseClass{
	PIMPage pimPage;
	ReportsPIMPage reportsPIMPage;
	
	@BeforeClass
	public void verifyReportsPIMPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		reportsPIMPage = pimPage.navigatingToReports();
		Assert.assertTrue(reportsPIMPage.getcurrentUrl());
		System.out.println("Clicked Reports PIM and asserted URL");
	}
	
	@Test(priority = 2)
	public void reportsPIMTesting()
	{
		System.out.println("Reports PIM clicked");
	}

}
