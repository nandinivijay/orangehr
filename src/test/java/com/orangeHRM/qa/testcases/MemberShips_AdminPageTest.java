package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.MemberShips_AdminPage;
import com.orangeHRM.qa.pages.QualificationsPage;

public class MemberShips_AdminPageTest extends BaseClass{
	AdminPage adminPage;
	QualificationsPage qualificationsPage;
	MemberShips_AdminPage memberShipsPage;
	@BeforeClass
	public void verifyMemberShipsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		qualificationsPage = adminPage.navigatingToQualifications();
		memberShipsPage = qualificationsPage.navigatingToMemberShips();
		Assert.assertTrue(memberShipsPage.getcurrentUrl());
		System.out.println("Clicked MemberShips and asserted URL");
	}
	
	@Test(priority = 4)
	public void memberShipsTesting()
	{
		System.out.println("MemberShips clicked");
	}


}
