package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.CustomersPage;
import com.orangeHRM.qa.pages.ProjectInfoPage;
import com.orangeHRM.qa.pages.TimePage;

public class CustomersPageTest extends BaseClass{
	
	TimePage timePage;
	ProjectInfoPage projectInfoPage;
	CustomersPage customersPage;
	@BeforeClass
	public void verifyCustomersPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		projectInfoPage = timePage.navigatingToProjectInfo();
		customersPage = projectInfoPage.navigatingToCustomers();
		Assert.assertTrue(customersPage.getcurrentUrl());
		System.out.println("Clicked Customers and asserted URL");
	}
	
	@Test(priority = 4)
	public void customersTesting()
	{
		System.out.println("Customers clicked");
	}

}
