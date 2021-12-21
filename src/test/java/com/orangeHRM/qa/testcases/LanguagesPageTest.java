package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.LanguagesPage;
import com.orangeHRM.qa.pages.QualificationsPage;

public class LanguagesPageTest extends BaseClass{
	AdminPage adminPage;
	QualificationsPage qualificationsPage;
	LanguagesPage languagesPage;
	@BeforeClass
	public void verifyLanguagesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		qualificationsPage = adminPage.navigatingToQualifications();
		languagesPage = qualificationsPage.navigatingToLanguages();
		Assert.assertTrue(languagesPage.getcurrentUrl());
		System.out.println("Clicked Languages and asserted URL");
	}
	
	@Test(priority = 4)
	public void languagesTesting()
	{
		System.out.println("Languages clicked");
	}
}
