package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.LicensesPage;
import com.orangeHRM.qa.pages.QualificationsPage;

public class LicensesPageTest extends BaseClass{
	AdminPage adminPage;
	QualificationsPage qualificationsPage;
	LicensesPage licensesPage;
	@BeforeClass
	public void verifyLicensesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		qualificationsPage = adminPage.navigatingToQualifications();
		licensesPage = qualificationsPage.navigatingToLicenses();
		Assert.assertTrue(licensesPage.getcurrentUrl());
		System.out.println("Clicked Licenses and asserted URL");
	}
	
	@Test(priority = 4)
	public void licensesTesting()
	{
		System.out.println("Licenses clicked");
	}
}
