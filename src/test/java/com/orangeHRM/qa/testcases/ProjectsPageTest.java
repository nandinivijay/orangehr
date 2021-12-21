package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ProjectInfoPage;
import com.orangeHRM.qa.pages.ProjectsPage;
import com.orangeHRM.qa.pages.TimePage;

public class ProjectsPageTest extends BaseClass{
	TimePage timePage;
	ProjectInfoPage projectInfoPage;
	ProjectsPage projectsPage;
	@BeforeClass
	public void verifyProjectsPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		timePage = baseVerification.navigatingToTime();
		projectInfoPage = timePage.navigatingToProjectInfo();
		projectsPage = projectInfoPage.navigatingToProjects();
		Assert.assertTrue(projectsPage.getcurrentUrl());
		System.out.println("Clicked Projects and asserted URL");
	}
	
	@Test(priority = 3)
	public void projectsTesting()
	{
		System.out.println("Projects clicked");
	}
	
}
