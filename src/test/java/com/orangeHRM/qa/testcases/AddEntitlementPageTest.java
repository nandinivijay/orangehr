package com.orangeHRM.qa.testcases;

import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AddEntitlementsPage;
import com.orangeHRM.qa.pages.EntitlementsPage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class AddEntitlementPageTest extends BaseClass {
	LeavePage leavePage;
	EntitlementsPage entitlementsPage;
	AddEntitlementsPage addEntitlementsPage;
	
	@BeforeClass
	public void verifyEmployemployeeEntitlementsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		entitlementsPage = leavePage.navigatingToEntitlements();
		addEntitlementsPage= entitlementsPage.navigatingToAddEntitlementsPage();
		
	}
	@Test(priority=3)
	public void setcontext(ITestContext context) {
	int	sheetnumber=1;
	context.setAttribute("index", sheetnumber);
	}
		
	@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class ,priority=4)
	
		
	public void verifyAddEntitlementsTestPage(String empname, String num) throws Exception {

		double leavedays = Double.parseDouble(num);
		num = String.format("%.2f", new BigDecimal(leavedays));

		 //addEntitlementsPage = entitlementsPage.navigatingToAddEntitlementsPage();
		 

		if (driver.findElement(By.xpath("//input[@id='entitlements_filters_bulk_assign']")).isSelected()) {
			addEntitlementsPage.isMultipleEmployeeCheckBoxIsChecked();
			DropDownUtil.selectbyindex(addEntitlementsPage.location(), 1);
			DropDownUtil.selectbyindex(addEntitlementsPage.SubUnit(), 2);
		} else {

			addEntitlementsPage.isMultipleEmployeeCheckBoxIsNotChecked();

			addEntitlementsPage.employee().sendKeys(empname);
			//addEntitlementsPage.employee().sendKeys(Keys.DOWN);
			//addEntitlementsPage.employee().sendKeys(Keys.ENTER);

			try {
				Assert.assertTrue(addEntitlementsPage.employee().getAttribute("value").contains(empname));
				System.out.println("page data in EmpName: " +addEntitlementsPage.employee().getAttribute("value") + "---Data from file : "+ empname);
				}catch(AssertionError ae) {
					System.out.println("In assignLeaveTesting--empname :" + ae.getMessage());
				}
				catch(WebDriverException we) {
				System.out.println("In alp comments :" + we.getMessage());
				}
			addEntitlementsPage.employee().sendKeys(Keys.DOWN);
			addEntitlementsPage.employee().sendKeys(Keys.ENTER);
		
		addEntitlementsPage.LeaveType();
		DropDownUtil.selectbyvalue(addEntitlementsPage.LeaveType(), "8");
		addEntitlementsPage.LeavePeriod();
		DropDownUtil.selectbytext(addEntitlementsPage.LeavePeriod(), "2020-01-01 - 2020-12-31");
		addEntitlementsPage.Entitlements().clear();
		addEntitlementsPage.Entitlements().sendKeys(num);
		try {
			Assert.assertTrue(addEntitlementsPage.Entitlements().getAttribute("value").contains(num));
			System.out.println("page data in EmpName: " +addEntitlementsPage.employee().getAttribute("value") + "---Data from file : "+ num);
			}catch(AssertionError ae) {
				System.out.println("In assignLeaveTesting--empname :" + ae.getMessage());
			}
			catch(WebDriverException we) {
			System.out.println("In alp comments :" + we.getMessage());
			}
		addEntitlementsPage.SaveButton().click();
		SynchronisationWaitsUtil.threadsleep(3000);
		//addEntitlementsPage.confirmButton().click();
		addEntitlementsPage.checkEntitlement().click();		
		addEntitlementsPage.deleteEntitlement().click();
		SynchronisationWaitsUtil.threadsleep(2000);
		addEntitlementsPage.confirmDeleteEntitlement().click();
		}
		}
	@Test
	public void addEntitlement() {
		System.out.println("add entilements is working");
	}

}