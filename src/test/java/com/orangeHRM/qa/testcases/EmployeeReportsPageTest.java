package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.EmployeeReportsPage;
import com.orangeHRM.qa.pages.ReportsTimePage;
import com.orangeHRM.qa.pages.TimePage;

public class EmployeeReportsPageTest extends BaseClass{

	TimePage timePage;
	ReportsTimePage reportsTimePage;
	EmployeeReportsPage employeeReportsPage;
	@BeforeClass
	public void verifyEmployeeReportsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		reportsTimePage = timePage.navigatingToReportsTime();
		employeeReportsPage = reportsTimePage.navigatingToEmployeeReports();
		Assert.assertTrue(employeeReportsPage.getcurrentUrl());
		System.out.println("Clicked Employee Reports and asserted URL");
	}
	
	@Test(priority = 4)
	public void employeeReportsTesting()
	{
		System.out.println("Employee Reports clicked");
	}

}
