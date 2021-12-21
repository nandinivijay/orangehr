package com.orangeHRM.qa.testcases;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.LeaveListPage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.DropDownUtil;

public class LeaveListPageTest extends BaseClass {

	LeavePage leavePage;
	LeaveListPage leaveListPage;
	@BeforeClass
	public void verifyLeaveListPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		leavePage = baseVerification.navigatingToLeave(); 
		leaveListPage = leavePage.navigatingToLeaveList();
		Assert.assertTrue(leaveListPage.getcurrentUrl());
		System.out.println("Clicked Leave List and asserted URL");
	}
	
	@Test(priority = 1)
	public void leaveListTesting()
	{
		System.out.println("Leave List clicked");
	}
	@Test(priority=2)
	public void setcontext(ITestContext context) {
	int	sheetnumber=6;
	context.setAttribute("index", sheetnumber);
	}
	@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class ,priority=3)
	
	public void verifyleavelist(String empname) throws Exception
	{
		System.out.println("Inside verifyleavelist");
		
		leaveListPage.fromdatecalender().click();
		DropDownUtil.selectbytext(leaveListPage.frommonth(), "May");
		DropDownUtil.selectbytext(leaveListPage.fromyear() ,"2021");
		int fday = 15;
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td/a[contains(text(),"+fday+")]")).click();
				
		leaveListPage.todate().click();
		DropDownUtil.selectbytext(leaveListPage.frommonth(), "Dec");
		DropDownUtil.selectbytext(leaveListPage.fromyear() ,"2021");
		int tday = 30;
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td/a[contains(text(),"+tday+")]")).click();
Thread.sleep(2000);

		//leaveListPage.todate().click();
		leaveListPage.checkbox().click();
		Thread.sleep(3000);
		leaveListPage.employeename().sendKeys(empname);
		//leaveListPage.SubUnitDropdown().
		Thread.sleep(3000);

		DropDownUtil.selectbyvalue(leaveListPage.SubUnitDropdown(), "5");
		Thread.sleep(3000);

		leaveListPage.pastEmployee().click();
		leaveListPage.searchButton().click();
	String txt = leaveListPage.tableHeaders().getText();
	System.out.println(txt);
		
		
	}
	@Test(priority=4)
	public void duplicatesindropdown()
	{
		WebElement ele = leaveListPage.SubUnitDropdown();
		Select sel=new Select(ele);
		List<WebElement> list = sel.getOptions();
		Set<String> s = new LinkedHashSet<String>();
	    for (WebElement w : list) {
	        s.add(w.getText());
	    }

	    Assert.assertEquals(list.size(),s.size());
			
		}
		
		
	}
	


