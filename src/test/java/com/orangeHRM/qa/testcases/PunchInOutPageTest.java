package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AttendancePage;
import com.orangeHRM.qa.pages.PunchInOutPage;
import com.orangeHRM.qa.pages.TimePage;

public class PunchInOutPageTest extends BaseClass{
	TimePage timePage;
	AttendancePage attendancePage;
	PunchInOutPage punchInOutPage;
	@BeforeClass
	public void verifyPunchInOutPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		attendancePage = timePage.navigatingToAttendance();
		punchInOutPage = attendancePage.navigatingToPunchInOut();
		Assert.assertTrue(punchInOutPage.getcurrentUrl());
		System.out.println("Clicked PunchInOut and asserted URL");
	}
	
	@Test(priority = 4)
	public void punchInOutTesting()
	{
		System.out.println("PunchInOut clicked");
	}

}
