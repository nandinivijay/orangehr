package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ConfigurePerformancePage;
import com.orangeHRM.qa.pages.KPIsPage;
import com.orangeHRM.qa.pages.PerformancePage;

public class KPIsPageTest extends BaseClass{
	PerformancePage performancePage;
	ConfigurePerformancePage configurePerformancePage;
	KPIsPage kPIsPage;
	@BeforeClass
	public void verifyKPIsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		performancePage = baseVerification.navigatingToPerformance();
		configurePerformancePage = performancePage.navigatingToConfigurePerformance();
		kPIsPage = configurePerformancePage.navigatingToKPIs();
		Assert.assertTrue(kPIsPage.getcurrentUrl());
		System.out.println("Clicked KPIs and asserted URL");
	}
	
	@Test(priority = 4)
	public void kPIsTesting()
	{
		System.out.println("KPIs clicked");
	}
}
