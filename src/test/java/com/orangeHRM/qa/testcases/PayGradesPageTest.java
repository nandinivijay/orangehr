package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.JobAdminPage;
import com.orangeHRM.qa.pages.PayGradesPage;

public class PayGradesPageTest extends BaseClass{

	AdminPage adminPage;
	JobAdminPage jobAdminPage;
	PayGradesPage payGradesPage;
	@BeforeClass
	public void verifyPayGradesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		jobAdminPage = adminPage.navigatingToJobAdmin();
		payGradesPage = jobAdminPage.navigatingToPayGrades();
		Assert.assertTrue(payGradesPage.getcurrentUrl());
		System.out.println("Clicked Pay Grades and asserted URL");
	}
	
	@Test(priority = 4)
	public void payGradesTesting()
	{
		System.out.println("Pay Grades clicked");
	}
}
