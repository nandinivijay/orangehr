package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.OrganizationPage;
import com.orangeHRM.qa.pages.StructurePage;

public class StructurePageTest extends BaseClass{
	AdminPage adminPage;
	OrganizationPage organizationPage;
	StructurePage structurePage;
	@BeforeClass
	public void verifyStructurePageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		organizationPage = adminPage.navigatingToOrganization();
		structurePage = organizationPage.navigatingToStructure();
		Assert.assertTrue(structurePage.getcurrentUrl());
		System.out.println("Clicked Structure and asserted URL");
	}
	
	@Test(priority = 4)
	public void structureTesting()
	{
		System.out.println("Structure clicked");
	}
}
