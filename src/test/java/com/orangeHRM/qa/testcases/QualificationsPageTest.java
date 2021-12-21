package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.QualificationsPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class QualificationsPageTest extends BaseClass {
	AdminPage adminPage;
	QualificationsPage qualificationsPage;
	@BeforeClass
	public void verifyQualificationsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		qualificationsPage = adminPage.navigatingToQualifications();
		System.out.println("Clicked Qualifications ");
	}
	
	@Test(priority = 2)
	public void validatingUserManagementSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(adminPage.getQualifications_id(), driver);
		Assert.assertTrue(qualificationsPage.getSkills_id().isDisplayed());
		System.out.println("Skills Displayed");
		Assert.assertTrue(qualificationsPage.getEducation_id().isDisplayed());
		System.out.println("Education Displayed");
		Assert.assertTrue(qualificationsPage.getLicenses_id().isDisplayed());
		System.out.println("Licenses Displayed");
		Assert.assertTrue(qualificationsPage.getLanguages_id().isDisplayed());
		System.out.println("Languages Displayed");
		Assert.assertTrue(qualificationsPage.getMemberShips_id().isDisplayed());
		System.out.println("Memberships Displayed");
	}
	@Test(priority = 3)
	public void qualificationsTesting()
	{
		System.out.println("Qualifications clicked");
	}
}
