package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.pages.MyLeavePage;

public class MyLeavePageTest extends BaseClass {

	MyLeavePage myLeavePage;
	@BeforeClass
	public void verifyMyLeavePageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		LeavePage leavePage = baseVerification.navigatingToLeave(); 
		myLeavePage = leavePage.navigatingToMyLeave();
		Assert.assertTrue(myLeavePage.getcurrentUrl());
		System.out.println("Clicked My Leave and asserted URL");
	}
	
	@Test(priority = 2)
	public void myLeaveTesting()
	{
		System.out.println("My Leave clicked");
	}
}
