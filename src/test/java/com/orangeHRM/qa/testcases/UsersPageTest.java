package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.UserManagementPage;
import com.orangeHRM.qa.pages.UsersPage;

public class UsersPageTest extends BaseClass{

	AdminPage adminPage;
	UserManagementPage userManagementPage;
	UsersPage usersPage;
	@BeforeClass
	public void verifyUsersPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		userManagementPage = adminPage.navigatingToUserManagement();
		usersPage = userManagementPage.navigatingToUsers();
		Assert.assertTrue(usersPage.getcurrentUrl());
		System.out.println("Clicked Users and asserted URL");
	}
	
	@Test(priority = 4)
	public void usersTesting()
	{
		System.out.println("Users clicked");
	}
}
