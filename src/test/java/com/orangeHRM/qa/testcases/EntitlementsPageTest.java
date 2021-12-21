package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.EntitlementsPage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.util.ActionsUtil;

public class EntitlementsPageTest extends BaseClass {
	EntitlementsPage entitlementsPage;
	LeavePage leavePage;
	
	@BeforeClass
	public void verifyEntitlementsPageNavigation() throws Exception
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
			entitlementsPage = leavePage.navigatingToEntitlements();
			System.out.println("Clicked Entitlements Leave ");
	}
	
	@Test(priority = 2)
	public void validatingEntitlementsSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(leavePage.getEntitlements_id(), driver);
		Assert.assertTrue(entitlementsPage.getAddEntitlements_id().isDisplayed());
		System.out.println("Add Entitlements Displayed");
		Assert.assertTrue(entitlementsPage.getEmployeeEntitlements_id().isDisplayed());
		System.out.println("Employee Entitlements Displayed");
		Assert.assertTrue(entitlementsPage.getMyEntitlements_id().isDisplayed());
		System.out.println("My Entitlements Displayed");
	}
	
		
	@Test(priority = 3)
	public void entitlementsTesting()
	{
		System.out.println("entitlements clicked");
	}

		
	}
