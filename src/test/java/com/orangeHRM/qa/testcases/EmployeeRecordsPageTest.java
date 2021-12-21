package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AttendancePage;
import com.orangeHRM.qa.pages.EmployeeRecordsPage;
import com.orangeHRM.qa.pages.TimePage;

public class EmployeeRecordsPageTest extends BaseClass{
	TimePage timePage;
	AttendancePage attendancePage;
	EmployeeRecordsPage employeeRecordsPage;
	@BeforeClass
	public void verifyEmployeeRecordsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		attendancePage = timePage.navigatingToAttendance();
		employeeRecordsPage = attendancePage.navigatingToEmployeeRecords();
		Assert.assertTrue(employeeRecordsPage.getcurrentUrl());
		System.out.println("Clicked Employee Records and asserted URL");
	}
	
	@Test(priority = 4)
	public void employeeRecordsTesting()
	{
		System.out.println("Employee Records clicked");
	}

}
