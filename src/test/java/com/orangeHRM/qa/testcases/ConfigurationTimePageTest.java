package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AttendancePage;
import com.orangeHRM.qa.pages.ConfigurationTimePage;
import com.orangeHRM.qa.pages.TimePage;

public class ConfigurationTimePageTest extends BaseClass{
	TimePage timePage;
	AttendancePage attendancePage;
	ConfigurationTimePage configurationTimePage;
	@BeforeClass
	public void verifyConfigurationTimePageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		attendancePage = timePage.navigatingToAttendance();
		configurationTimePage = attendancePage.navigatingToConfigurationTime();
		Assert.assertTrue(configurationTimePage.getcurrentUrl());
		System.out.println("Clicked Configuration Time and asserted URL");
	}
	
	@Test(priority = 4)
	public void configurationTimeTesting()
	{
		System.out.println("Configuration Time clicked");
	}
}
