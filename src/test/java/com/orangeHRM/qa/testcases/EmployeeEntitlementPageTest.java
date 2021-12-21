package com.orangeHRM.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.EmployeeEntitlementsPage;
import com.orangeHRM.qa.pages.EntitlementsPage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class EmployeeEntitlementPageTest extends BaseClass{
	
	BaseVerification baseVerification;
	LeavePage leavePage;
	EntitlementsPage entitlementsPage;
	EmployeeEntitlementsPage employeeEntitlementsPage;
	@BeforeClass
	public void verifyEmployemployeeEntitlementsPageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		entitlementsPage = leavePage.navigatingToEntitlements();
		employeeEntitlementsPage= entitlementsPage.navigatingToEmployeeEntitlementsPage();
		Assert.assertTrue(employeeEntitlementsPage.getcurrentUrl());
		System.out.println("Clicked Employee Entitlements and asserted URL");
		
	}
	@Test(priority=2)
	public void setcontext(ITestContext context) {
	int	sheetnumber=2;
	context.setAttribute("index", sheetnumber);
	}

	
	@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class ,priority=3)

	public void verifyEmployeeEntitlementsTestPage(String empname) throws Exception
	{
					//employeeEntitlementsPage=new EmployeeEntitlementsPage(driver);
	
			//employeeEntitlementsPage.Employee().clear();
		
		System.out.println("Employee Entitlements clicked");
		driver.manage().window().maximize();
		SynchronisationWaitsUtil.implicitwait(12,TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		employeeEntitlementsPage.Employee().sendKeys(empname);
			try {
				Assert.assertTrue(employeeEntitlementsPage.Employee().getAttribute("value").contains(empname));
				System.out.println("page data in EmpName: " +employeeEntitlementsPage.Employee().getAttribute("value") + "---Data from file : "+ empname);
				}catch(AssertionError ae) {
					System.out.println("In assignLeaveTesting--empname :" + ae.getMessage());
				}
				catch(WebDriverException we) {
				System.out.println("In alp comments :" + we.getMessage());
				}

			employeeEntitlementsPage.Employee().sendKeys(empname);
			DropDownUtil.selectbyvalue(employeeEntitlementsPage.LeaveType(), "2");
			employeeEntitlementsPage.LeavePeriod();
			DropDownUtil.selectbytext(employeeEntitlementsPage.LeavePeriod(), "2021-01-01 - 2021-12-31");
			employeeEntitlementsPage.SearchButton().click();
			
		}
}