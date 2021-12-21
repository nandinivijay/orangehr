package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.QualificationsPage;
import com.orangeHRM.qa.pages.SkillsPage;


public class SkillsPageTest extends BaseClass{
	AdminPage adminPage;
	QualificationsPage qualificationsPage;
	SkillsPage skillsPage;
	@BeforeClass
	public void verifySkillsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		qualificationsPage = adminPage.navigatingToQualifications();
		skillsPage = qualificationsPage.navigatingToSkills();
		Assert.assertTrue(skillsPage.getcurrentUrl());
		System.out.println("Clicked Skills and asserted URL");
	}
	
	@Test(priority = 4)
	public void skillsTesting()
	{
		System.out.println("Skills clicked");
	}
}
