package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AccessRecordsPage;
import com.orangeHRM.qa.pages.MaintenancePage;


public class AccessRecordsPageTest extends BaseClass{

	MaintenancePage maintenancePage;
	AccessRecordsPage accessRecordsPage;
	@BeforeClass
	public void verifyAccessRecordsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		maintenancePage = baseVerification.navigatingToMaintenance();
		accessRecordsPage = maintenancePage.navigatingToAccessRecords();
		Assert.assertTrue(accessRecordsPage.getcurrentUrl());
		System.out.println("Clicked AccessRecords and asserted URL");
	}
	
	@Test(priority = 2)
	public void accessRecordsTesting()
	{
		System.out.println("AccessRecords clicked");
	}
}
