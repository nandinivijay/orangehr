package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.OrganizationPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class OrganizationPageTest extends BaseClass{
	AdminPage adminPage;
	OrganizationPage organizationPage;
	@BeforeClass
	public void verifyOrganization()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		organizationPage = adminPage.navigatingToOrganization();
		System.out.println("Clicked Organization ");
	}
	
	@Test(priority = 2)
	public void validatingUserManagementSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(adminPage.getOrganization_id(), driver);
		Assert.assertTrue(organizationPage.getGeneralInformation_id().isDisplayed());
		System.out.println("General Information Displayed");
		Assert.assertTrue(organizationPage.getLocations_id().isDisplayed());
		System.out.println("Locations Displayed");
		Assert.assertTrue(organizationPage.getStructure_id().isDisplayed());
		System.out.println("Structure Displayed");
	}
	
	@Test(priority = 3)
	public void organizationTesting()
	{
		System.out.println("Organization clicked");
	}
}
