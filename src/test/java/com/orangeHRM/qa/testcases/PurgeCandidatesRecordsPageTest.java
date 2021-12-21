package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MaintenancePage;
import com.orangeHRM.qa.pages.PurgeCandidatesRecordsPage;
import com.orangeHRM.qa.pages.PurgeRecordsPage;

public class PurgeCandidatesRecordsPageTest extends BaseClass{

	MaintenancePage maintenancePage;
	PurgeRecordsPage purgeRecordsPage;
	PurgeCandidatesRecordsPage purgeCandidatesRecordsPage;
	@BeforeClass
	public void verifyPurgeCandidatesRecordsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		maintenancePage = baseVerification.navigatingToMaintenance();
		purgeRecordsPage = maintenancePage.navigatingToPurgeRecords();
		purgeCandidatesRecordsPage = purgeRecordsPage.navigatingToPurgeCandidatesRecords();
		Assert.assertTrue(purgeCandidatesRecordsPage.getcurrentUrl());
		System.out.println("Clicked PurgeCandidatesRecords and asserted URL");
	}
	
	@Test(priority = 4)
	public void purgeCandidatesRecordsTesting()
	{
		System.out.println("PurgeCandidatesRecords clicked");
	}

}
