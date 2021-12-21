package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ProjectInfoPage;
import com.orangeHRM.qa.pages.TimePage;
import com.orangeHRM.qa.util.ActionsUtil;

public class ProjectInfoPageTest extends BaseClass{

	TimePage timePage;
	ProjectInfoPage projectInfoPage;
	@BeforeClass
	public void verifyProjectInfoPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		projectInfoPage = timePage.navigatingToProjectInfo();
		System.out.println("Clicked Project Info");
	}
	
	@Test(priority = 2)
	public void validatingProjectInfoSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(timePage.getProjectInfo_id(), driver);
		Assert.assertTrue(projectInfoPage.getCustomers_id().isDisplayed());
		System.out.println("Customers Displayed");
		Assert.assertTrue(projectInfoPage.getProjects_id().isDisplayed());
		System.out.println("Projects Displayed");
	}
	
	@Test(priority = 3)
	public void projectInfoTesting()
	{
		System.out.println("Project Info clicked");
	}
}
