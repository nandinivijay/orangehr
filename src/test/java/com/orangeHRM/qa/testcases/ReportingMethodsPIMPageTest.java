package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigurationPIMPage;
import com.orangeHRM.qa.pages.PIMPage;
import com.orangeHRM.qa.pages.ReportingMethodsPIMPage;


public class ReportingMethodsPIMPageTest extends BaseClass{
	PIMPage pimPage;
	ConfigurationPIMPage configurationPIMPage;
	ReportingMethodsPIMPage reportingMethodsPIMPage;
	@BeforeClass
	public void verifyReportingMethodsPIMPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		configurationPIMPage = pimPage.navigatingToConfiguration();
		reportingMethodsPIMPage = configurationPIMPage.navigatingToReportingMethods();
		Assert.assertTrue(reportingMethodsPIMPage.getcurrentUrl());
		System.out.println("Clicked Reporting Methods PIM and asserted URL");
	}
	
	@Test(priority = 4)
	public void reportingMethodsPIMTesting()
	{
		System.out.println("Reporting Methods PIM clicked");
	}
}
