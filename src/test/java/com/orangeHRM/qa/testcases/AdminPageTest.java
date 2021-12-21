package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.UserManagementPage;
import com.orangeHRM.qa.pages.UsersPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class AdminPageTest extends BaseClass{
	
	BaseVerification baseVerification ;
	AdminPage adminPage;
	
	@BeforeClass
	public void verifyAdminPageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin();
		Assert.assertTrue(adminPage.getcurrentUrl());
		System.out.println("Clicked Admin and asserted URL");
	}
	
	@Test(priority = 0)
	public void validatingAdminSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(baseVerification.getAdmin_id(), driver);
		Assert.assertTrue(adminPage.getUserManagement_id().isDisplayed());
		Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getUserManagement_id().getCssValue("color"));
		System.out.println("UserManagement Displayed");
		Assert.assertTrue(adminPage.getJobAdmin_id().isDisplayed());
		Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getJobAdmin_id().getCssValue("color"));

		System.out.println("Job Admin Displayed");
		Assert.assertTrue(adminPage.getOrganization_id().isDisplayed());
		Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getOrganization_id().getCssValue("color"));

		System.out.println("Organization Displayed");
		Assert.assertTrue(adminPage.getQualifications_id().isDisplayed());
		
		System.out.println("Qualifications Displayed");
		Assert.assertTrue(adminPage.getNationalities_id().isDisplayed());
		Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getNationalities_id().getCssValue("color"));

		System.out.println("Nationalities Displayed");
		Assert.assertTrue(adminPage.getConfigurationAdmin_id().isDisplayed());	
		Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getConfigurationAdmin_id().getCssValue("color"));

		

		System.out.println("Configuration Displayed");
	}
	@Test(priority=1)
	public void verifyColorsOfSubmenuInAdmin()
	{
	baseVerification.getAdmin_id().click();
	Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getUserManagement_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getJobAdmin_id().getCssValue("color"));

	Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getOrganization_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getQualifications_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getNationalities_id().getCssValue("color"));

	Assert.assertEquals(baseVerification.getAdmin_id().getCssValue("color"),adminPage.getConfigurationAdmin_id().getCssValue("color"));
	}
	
	@AfterClass
	public void navigatingToSubMenuOnClickingAdmin()
	{
		UserManagementPage userManagementPage = adminPage.navigatingToUserManagement();
		UsersPage usersPage = userManagementPage.navigatingToUsers();
		Assert.assertEquals(adminPage.getcurrentUrl(), usersPage.getcurrentUrl());
		System.out.println("Admin clicked and Opened users Page");
	}
}
