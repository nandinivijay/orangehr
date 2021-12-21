package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.CandidatesPage;
import com.orangeHRM.qa.pages.RecruitmentPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class RecruitmentPageTest extends BaseClass{

	BaseVerification baseVerification ;
	RecruitmentPage recruitmentPage;
	@BeforeClass
	public void verifyRecruitmentPageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		recruitmentPage = baseVerification.navigatingToRecruitment();
		Assert.assertTrue(recruitmentPage.getcurrentUrl());
		System.out.println("Entered before class and asserted URL");
	}
	
	@Test(priority = 0)
	public void validatingRecruitmentSubMenuDisplay()
	{
		ActionsUtil.MouseHoover(baseVerification.getRecruitment_id(), driver);
		Assert.assertTrue(recruitmentPage.getCandidates_id().isDisplayed());
		Assert.assertEquals(baseVerification.getRecruitment_id().getCssValue("color"),recruitmentPage.getCandidates_id().getCssValue("color"));

		System.out.println("Candidates Displayed");
		Assert.assertTrue(recruitmentPage.getVacancies_id().isDisplayed());
		Assert.assertEquals(baseVerification.getRecruitment_id().getCssValue("color"),recruitmentPage.getVacancies_id().getCssValue("color"));
		

		System.out.println("Vacancies Displayed");
	}
	@Test(priority=2)
	public void verifyColorsOfSubmenuInRecruitment()
	{
	
	baseVerification.getRecruitment_id().click();
	Assert.assertEquals(baseVerification.getRecruitment_id().getCssValue("color"),recruitmentPage.getCandidates_id().getCssValue("color"));
	Assert.assertEquals(baseVerification.getRecruitment_id().getCssValue("color"),recruitmentPage.getVacancies_id().getCssValue("color"));
		
	
	}

	
	
	@AfterClass
	public void navigatingToSubMenuOnClickingRecruitment()
	{
		CandidatesPage candidatesPage = recruitmentPage.navigatingToCandidates();
		Assert.assertEquals(recruitmentPage.getcurrentUrl(), candidatesPage.getcurrentUrl());
		System.out.println("Recritment clicked and Opened Candidates Page");
	}
}
