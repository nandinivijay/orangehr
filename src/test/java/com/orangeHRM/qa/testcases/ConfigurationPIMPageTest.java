package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigurationPIMPage;
import com.orangeHRM.qa.pages.PIMPage;
import com.orangeHRM.qa.util.ActionsUtil;


public class ConfigurationPIMPageTest extends BaseClass{
	PIMPage pimPage;
	ConfigurationPIMPage configurationPIMPage;
	
	@BeforeClass
	public void verifyConfigurationPIMPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		configurationPIMPage = pimPage.navigatingToConfiguration();
		System.out.println("Clicked Configuration PIM");
	}
	
	@Test(priority = 2)
	public void validatingConfigurePIMSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(pimPage.getConfiguration_id(), driver);
		Assert.assertTrue(configurationPIMPage.getCustomFields_id().isDisplayed());
		System.out.println("Custom Fields Displayed");
		Assert.assertTrue(configurationPIMPage.getOptionalFields_id().isDisplayed());
		System.out.println("Optional Fields Displayed");
		Assert.assertTrue(configurationPIMPage.getDataImport_id().isDisplayed());
		System.out.println("Data Import Displayed");
		Assert.assertTrue(configurationPIMPage.getReportingMethods_id().isDisplayed());
		System.out.println("Reporting Methods Displayed");
		Assert.assertTrue(configurationPIMPage.getTerminationReasons_id().isDisplayed());
		System.out.println("Termination Reasons Displayed");
	}
	@Test(priority = 3)
	public void ConfigurationPIMTesting()
	{
		System.out.println("Configuration PIM clicked");
	}

}
