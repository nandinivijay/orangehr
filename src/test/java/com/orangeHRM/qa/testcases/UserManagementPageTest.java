package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.UserManagementPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class UserManagementPageTest extends BaseClass{
	AdminPage adminPage;
	UserManagementPage userManagementPage;
	@BeforeClass
	public void verifyUserManagementPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		userManagementPage = adminPage.navigatingToUserManagement();
		System.out.println("Clicked User Management");
	}
	
	@Test(priority = 2)
	public void validatingUserManagementSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(adminPage.getUserManagement_id(), driver);
		Assert.assertTrue(userManagementPage.getUsers_id().isDisplayed());
		System.out.println("Users Displayed");
	}
	
	@Test(priority = 3)
	public void userManagementTesting()
	{
		System.out.println("User Management clicked");
	}
}
