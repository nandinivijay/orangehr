package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.EmployeeListPIMPage;
import com.orangeHRM.qa.pages.PIMPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class PIMPageTest extends BaseClass{

	BaseVerification baseVerification ;
	PIMPage pimPage;
	@BeforeClass
	public void verifyPIMPageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		pimPage = baseVerification.navigatingToPIM();
		Assert.assertTrue(pimPage.getcurrentUrl());
		System.out.println("Clicked PIM and asserted URL");
	}
	
		
	@Test(priority = 0)
	public void validatingPIMSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(baseVerification.getPIM_id(), driver);
		Assert.assertTrue(pimPage.getConfiguration_id().isDisplayed());
		Assert.assertEquals(baseVerification.getPIM_id().getCssValue("color"),pimPage.getConfiguration_id().getCssValue("color"));

		System.out.println("Configuration PIM Displayed");
		Assert.assertTrue(pimPage.getEmployeeList_id().isDisplayed());
		Assert.assertEquals(baseVerification.getPIM_id().getCssValue("color"),pimPage.getEmployeeList_id().getCssValue("color"));

		System.out.println("Employee List Displayed");
		Assert.assertTrue(pimPage.getAddEmployee_id().isDisplayed());
		Assert.assertEquals(baseVerification.getPIM_id().getCssValue("color"),pimPage.getAddEmployee_id().getCssValue("color"));

		System.out.println("Add Employee Displayed");
		Assert.assertTrue(pimPage.getReports_id().isDisplayed());
		Assert.assertEquals(baseVerification.getPIM_id().getCssValue("color"),pimPage.getReports_id().getCssValue("color"));

		System.out.println("Reports Displayed");
	}
	@Test(priority=1)
	public void verifyColorsOfSubmenuInPim()
	{
	baseVerification.getPIM_id().click();
	Assert.assertEquals(baseVerification.getPIM_id().getCssValue("color"),pimPage.getConfiguration_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getPIM_id().getCssValue("color"),pimPage.getEmployeeList_id().getCssValue("color"));

	Assert.assertEquals(baseVerification.getPIM_id().getCssValue("color"),pimPage.getAddEmployee_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getPIM_id().getCssValue("color"),pimPage.getReports_id().getCssValue("color"));
	
	
	}

	
	@AfterClass
	public void navigatingToSubMenuOnClickingPIM()
	{
		EmployeeListPIMPage employeeListPage = pimPage.navigatingToEmployeeList();
		Assert.assertEquals(pimPage.getcurrentUrl(), employeeListPage.getcurrentUrl());
		System.out.println("PIM clicked Opened Employee List Page");
	}
}
