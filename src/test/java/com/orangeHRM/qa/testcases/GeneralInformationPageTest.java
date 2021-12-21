package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.GeneralInformationPage;
import com.orangeHRM.qa.pages.OrganizationPage;

public class GeneralInformationPageTest extends BaseClass{
	AdminPage adminPage;
	OrganizationPage organizationPage;
	GeneralInformationPage generalInformationPage;
	@BeforeClass
	public void verifyGeneralInformationPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		organizationPage = adminPage.navigatingToOrganization();
		generalInformationPage = organizationPage.navigatingToGeneralInformation();
		Assert.assertTrue(generalInformationPage.getcurrentUrl());
		System.out.println("Clicked General Information and asserted URL");
	}
	
	@Test(priority = 4)
	public void generalInformationTesting()
	{
		System.out.println("General Information clicked");
	}
}
