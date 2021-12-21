package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MaintenancePage;
import com.orangeHRM.qa.pages.PurgeRecordsPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class PurgeRecordsPageTest extends BaseClass{

	MaintenancePage maintenancePage;
	PurgeRecordsPage purgeRecordsPage;
	@BeforeClass
	public void verifyPurgeRecordsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		maintenancePage = baseVerification.navigatingToMaintenance();
		purgeRecordsPage = maintenancePage.navigatingToPurgeRecords();
		System.out.println("Clicked PurgeRecords");
	}
	
	@Test(priority = 2)
	public void validatingPurgeRecordsSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(maintenancePage.getPurgeRecords_id(), driver);
		Assert.assertTrue(purgeRecordsPage.getPurgeEmployeeRecords_id().isDisplayed());
		System.out.println("Purge Employees Displayed");
		Assert.assertTrue(purgeRecordsPage.getPurgeCandidatesRecords_id().isDisplayed());
		System.out.println("Purge Candidates Displayed");
	}
	
	@Test(priority = 3)
	public void purgeRecordsTesting()
	{
		System.out.println("PurgeRecords clicked");
	}
}
