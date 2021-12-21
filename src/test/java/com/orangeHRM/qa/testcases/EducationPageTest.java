package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.EducationPage;
import com.orangeHRM.qa.pages.QualificationsPage;

public class EducationPageTest extends BaseClass{
	AdminPage adminPage;
	QualificationsPage qualificationsPage;
	EducationPage educationPage;
	@BeforeClass
	public void verifyEmailConfigurationPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		qualificationsPage = adminPage.navigatingToQualifications();
		educationPage = qualificationsPage.navigatingToEducation();
		Assert.assertTrue(educationPage.getcurrentUrl());
		System.out.println("Clicked Education and asserted URL");
	}
	
	@Test(priority = 4)
	public void educationTesting()
	{
		System.out.println("Education clicked");
	}
}
