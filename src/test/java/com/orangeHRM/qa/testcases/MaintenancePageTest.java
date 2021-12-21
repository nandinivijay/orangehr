 package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MaintenancePage;
import com.orangeHRM.qa.pages.PurgeEmployeeRecordsPage;
import com.orangeHRM.qa.pages.PurgeRecordsPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class MaintenancePageTest extends BaseClass{

	BaseVerification baseVerification ;
	MaintenancePage maintenancePage;
	
	@BeforeClass
	public void verifyMaintenancePageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		maintenancePage = baseVerification.navigatingToMaintenance();
		Assert.assertTrue(maintenancePage.getcurrentUrl());
		System.out.println("Entered Maintenance and asserted URL");
	}
	
	
	@Test(priority = 0)
	public void validatingMaintenanceSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(baseVerification.getMaintenance_id(), driver);
		Assert.assertTrue(maintenancePage.getPurgeRecords_id().isDisplayed());
		Assert.assertEquals(baseVerification.getMaintenance_id().getCssValue("color"),maintenancePage.getPurgeRecords_id().getCssValue("color"));

		System.out.println("Purge Records Displayed");
		Assert.assertTrue(maintenancePage.getAccessRecords_id().isDisplayed());
		Assert.assertEquals(baseVerification.getMaintenance_id().getCssValue("color"),maintenancePage.getAccessRecords_id().getCssValue("color"));
		System.out.println("Access Records Displayed");
	}
	
	@Test (priority = 1)
	public void maintenanceTesting()
	{
		System.out.println("Maintenance Clicked");
	}
	@Test(priority=2)
	public void verifyColorsOfSubmenuInMaintenance()
	{
	
baseVerification.getMaintenance_id().click();
	Assert.assertEquals(baseVerification.getMaintenance_id().getCssValue("color"),maintenancePage.getPurgeRecords_id().getCssValue("color"));
Assert.assertEquals(baseVerification.getMaintenance_id().getCssValue("color"),maintenancePage.getAccessRecords_id().getCssValue("color"));
	
	
	}

	@AfterClass
	public void navigatingToSubMenuOnClickingMaintenance()
	{
		PurgeRecordsPage purgeRecordsPage = maintenancePage.navigatingToPurgeRecords();
		PurgeEmployeeRecordsPage purgeEmployeeRecordsPage = purgeRecordsPage.navigatingToPurgeEmployeeRecords();
		Assert.assertEquals(maintenancePage.getcurrentUrl(),purgeEmployeeRecordsPage.getcurrentUrl());
		System.out.println("Maintenance clicked and Opened Purge Employee Records Page");
	}
	
}
