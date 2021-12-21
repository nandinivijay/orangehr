package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ProjectReportsPage;
import com.orangeHRM.qa.pages.ReportsTimePage;
import com.orangeHRM.qa.pages.TimePage;

public class ProjectReportsPageTest extends BaseClass{

	TimePage timePage;
	ReportsTimePage reportsTimePage;
	ProjectReportsPage projectReportsPage;
	@BeforeClass
	public void verifyProjectReports()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		reportsTimePage = timePage.navigatingToReportsTime();
		projectReportsPage = reportsTimePage.navigatingToProjectReports();
		Assert.assertTrue(projectReportsPage.getcurrentUrl());
		System.out.println("Clicked Project Reports and asserted URL");
	}
	
	@Test(priority = 4)
	public void projectReportsTesting()
	{
		System.out.println("Project Reports clicked");
	}
}
