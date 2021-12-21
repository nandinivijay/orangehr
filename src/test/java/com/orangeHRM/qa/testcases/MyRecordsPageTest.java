package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AttendancePage;
import com.orangeHRM.qa.pages.MyRecordsPage;
import com.orangeHRM.qa.pages.TimePage;

public class MyRecordsPageTest extends BaseClass{
	TimePage timePage;
	AttendancePage attendancePage;
	MyRecordsPage myRecordsPage;
	@BeforeClass
	public void verifyMyRecordsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		attendancePage = timePage.navigatingToAttendance();
		myRecordsPage = attendancePage.navigatingToMyRecords();
		Assert.assertTrue(myRecordsPage.getcurrentUrl());
		System.out.println("My Records and asserted URL");
	}
	
	@Test(priority = 4)
	public void myRecordsTesting()
	{
		System.out.println("MyRecords clicked");
	}

}
