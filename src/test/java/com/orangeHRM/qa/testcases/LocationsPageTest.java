package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.LocationsPage;
import com.orangeHRM.qa.pages.OrganizationPage;


public class LocationsPageTest extends BaseClass{
	AdminPage adminPage;
	OrganizationPage organizationPage;
	LocationsPage locationsPage;
	@BeforeClass
	public void verifyLocationsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		organizationPage = adminPage.navigatingToOrganization();
		locationsPage = organizationPage.navigatingToLocations();
		Assert.assertTrue(locationsPage.getcurrentUrl());
		System.out.println("Clicked Locations and asserted URL");
	}
	
	@Test(priority = 4)
	public void locationsTesting()
	{
		System.out.println("Locations clicked");
	}
}
