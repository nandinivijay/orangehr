package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MaintenancePage;
import com.orangeHRM.qa.pages.PurgeEmployeeRecordsPage;
import com.orangeHRM.qa.pages.PurgeRecordsPage;

public class PurgeEmployeeRecordsPageTest extends BaseClass{

	MaintenancePage maintenancePage;
	PurgeRecordsPage purgeRecordsPage;
	PurgeEmployeeRecordsPage purgeEmployeeRecordsPage;
	@BeforeClass
	public void verifyPurgeEmployeeRecordsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		maintenancePage = baseVerification.navigatingToMaintenance();
		purgeRecordsPage = maintenancePage.navigatingToPurgeRecords();
		purgeEmployeeRecordsPage = purgeRecordsPage.navigatingToPurgeEmployeeRecords();
		Assert.assertTrue(purgeEmployeeRecordsPage.getcurrentUrl());
		System.out.println("Clicked PurgeEmployeeRecords and asserted URL");
	}
	
	@Test(priority = 4)
	public void purgeEmployeeRecordsTesting()
	{
		System.out.println("PurgeEmployeeRecords clicked");
	}
}
