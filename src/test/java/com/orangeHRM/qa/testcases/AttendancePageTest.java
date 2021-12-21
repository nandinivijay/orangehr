package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AttendancePage;
import com.orangeHRM.qa.pages.TimePage;
import com.orangeHRM.qa.util.ActionsUtil;

public class AttendancePageTest extends BaseClass {
	TimePage timePage;
	AttendancePage attendancePage;
	@BeforeClass
	public void verifyAttendancePageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		attendancePage = timePage.navigatingToAttendance();
		System.out.println("Clicked Attendance");
	}
	
	@Test(priority = 2)
	public void validatingAttendanceSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(timePage.getAttendance_id(), driver);
		Assert.assertTrue(attendancePage.getMyRecords_id().isDisplayed());
		System.out.println("My Records Displayed");
		Assert.assertTrue(attendancePage.getPunchInOut_id().isDisplayed());
		System.out.println("Punch In Out Displayed");
		Assert.assertTrue(attendancePage.getEmployeeRecords_id().isDisplayed());
		System.out.println("Employee Records Displayed");
		Assert.assertTrue(attendancePage.getConfigurationTime_id().isDisplayed());
		System.out.println("Configuration Displayed");
		
	}
	
	@Test(priority = 3)
	public void attendanceTesting()
	{
		System.out.println("Attendance clicked");
	}
}
