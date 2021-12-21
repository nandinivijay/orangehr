package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigurationPIMPage;
import com.orangeHRM.qa.pages.DataImportPIMPage;
import com.orangeHRM.qa.pages.PIMPage;

public class DataImportPIMPageTest extends BaseClass{
	PIMPage pimPage;
	ConfigurationPIMPage configurationPIMPage;
	DataImportPIMPage dataImportPIMPage;
	@BeforeClass
	public void verifyDataImportPIMPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		configurationPIMPage = pimPage.navigatingToConfiguration();
		dataImportPIMPage = configurationPIMPage.navigatingToDataImport();
		Assert.assertTrue(dataImportPIMPage.getcurrentUrl());
		System.out.println("Clicked DataImport PIM and asserted URL");
	}
	
	@Test(priority = 4)
	public void dataImportPIMTesting()
	{
		System.out.println("DataImport PIM clicked");
	}
}
