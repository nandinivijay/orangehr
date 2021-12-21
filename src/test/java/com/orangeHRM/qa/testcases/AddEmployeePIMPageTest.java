package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AddEmployeePIMPage;
import com.orangeHRM.qa.pages.PIMPage;


public class AddEmployeePIMPageTest extends BaseClass{
	PIMPage pimPage;
	AddEmployeePIMPage addEmployeePIMPage;
	
	@BeforeClass
	public void verifyAddEmployeePIMPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		addEmployeePIMPage = pimPage.navigatingToAddEmployee();
		Assert.assertTrue(addEmployeePIMPage.getcurrentUrl());
		System.out.println("Clicked Add Employee PIM and asserted URL");
	}
	
	@Test(priority = 2)
	public void addEmployeePIMTesting()
	{
		System.out.println("Add Employee PIM clicked");
	}

}
