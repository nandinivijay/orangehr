package com.orangeHRM.qa.testcases;

import java.math.BigDecimal;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AddEntitlementsPage;
import com.orangeHRM.qa.pages.EmployeeEntitlementsPage;
import com.orangeHRM.qa.pages.EntitlementsPage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.pages.MyEntitlementsPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class MyEntitlementsPageTest extends BaseClass {
	BaseVerification baseVerification;
	LeavePage leavePage;
	EntitlementsPage entitlementsPage;
	MyEntitlementsPage myEntitlementsPage;

	@BeforeClass
	public void verifyMyEntitlementsPageNavigation() 
	{
		login();
		baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		entitlementsPage = leavePage.navigatingToEntitlements();
		myEntitlementsPage = entitlementsPage.navigatingToMyEntitlementsPage();
		Assert.assertTrue(myEntitlementsPage.getcurrentUrl());
		System.out.println("Clicked Employee Entitlements and asserted URL");
	}

	@Test(priority = 3)
	public void setcontext(ITestContext context) 
	{
		int sheetnumber = 3;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 4)
	public void verifyMyEntitlementTestPage(String empname, String num) throws Exception 
	{
		double leavedays = Double.parseDouble(num);
		num = String.format("%.2f", new BigDecimal(leavedays));
		SynchronisationWaitsUtil.threadsleep(1000);
		myEntitlementsPage.AddButton().click();
		AddEntitlementsPage addEntitlementsPage = new AddEntitlementsPage(driver);
		addEntitlementsPage.isMultipleEmployeeCheckBoxIsNotChecked();
		EmployeeEntitlementsPage employeeEntitlementsPage = new EmployeeEntitlementsPage(driver);
		employeeEntitlementsPage.Employee().clear();
		employeeEntitlementsPage.Employee().sendKeys(empname);
		employeeEntitlementsPage.Employee().sendKeys(Keys.ARROW_DOWN);
		employeeEntitlementsPage.Employee().sendKeys(Keys.ENTER);    
		/*try {
			Assert.assertTrue(employeeEntitlementsPage.Employee().getAttribute("value").contains(empname));
			System.out.println("page data in EmpName: " + employeeEntitlementsPage.Employee().getAttribute("value") + "---Data from file : " + empname);
		} 
		catch (AssertionError aes) 
		{
			System.out.println("In assignLeaveTesting--empname :" + aes.getMessage());
		} 
		catch (WebDriverException we) 
		{
			System.out.println("In alp comments :" + we.getMessage());
		}*/
		/*employeeEntitlementsPage.Employee().sendKeys(Keys.ARROW_DOWN);
		employeeEntitlementsPage.Employee().sendKeys(Keys.ENTER);*/
		DropDownUtil.selectbyvalue(employeeEntitlementsPage.LeaveType(), "8");
		employeeEntitlementsPage.LeavePeriod();
		DropDownUtil.selectbytext(employeeEntitlementsPage.LeavePeriod(), "2021-01-01 - 2021-12-31");
		addEntitlementsPage.Entitlements().clear();
		addEntitlementsPage.Entitlements().sendKeys(num);
		try {
			Assert.assertTrue(addEntitlementsPage.Entitlements().getAttribute("value").contains(num));
			System.out.println(
					"page data in EmpName: " + addEntitlementsPage.Entitlements().getAttribute("value") + "---Data from file : " + num);
		} catch (AssertionError ae) {
			System.out.println("In assignLeaveTesting--empname :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In alp comments :" + we.getMessage());
		}

		employeeEntitlementsPage.saveButton().click();
		SynchronisationWaitsUtil.threadsleep(1000);
		employeeEntitlementsPage.clickonaddCheckBox().click();
		System.out.println("Here i am before deleting selected entitilement: ");
		employeeEntitlementsPage.deleteButton().click();
		employeeEntitlementsPage.confirmDeleteDialogButton().click();
	}
}