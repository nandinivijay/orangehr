package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.NationalitiesPage;

public class NationalitiesPageTest extends BaseClass{
	AdminPage adminPage;
	NationalitiesPage nationalitiesPage;
	@BeforeClass
	public void verifyNationalitiesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		nationalitiesPage = adminPage.navigatingToNationalities();
		Assert.assertTrue(nationalitiesPage.getcurrentUrl());
		System.out.println("Clicked Nationalities and asserted URL");
	}
	
	@Test(priority = 2)
	public void nationalitiesTesting()
	{
		System.out.println("Nationalities clicked");
	}
}
