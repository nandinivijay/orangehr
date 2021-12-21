package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.EmployeeListPIMPage;
import com.orangeHRM.qa.pages.PIMPage;

public class EmployeeListPIMPageTest extends BaseClass{

	PIMPage pimPage;
	EmployeeListPIMPage employeeListPIMPage;
	
	@BeforeClass
	public void verifyEmployeeListPIMPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		employeeListPIMPage = pimPage.navigatingToEmployeeList();
		Assert.assertTrue(employeeListPIMPage.getcurrentUrl());
		System.out.println("Clicked Employee List PIM and asserted URL");
	}
	
	@Test(priority = 2)
	public void addEmployeePIMTesting()
	{
		System.out.println("Add Employee PIM clicked");
	}

}
