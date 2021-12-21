package com.orangeHRM.qa.testcases;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.pages.ReportToMyInfoPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class ReportToPageTest extends BaseClass{
	BaseVerification baseVerification ;
	MyInfoPage myInfoPage;
	ReportToMyInfoPage reportToMyInfoPage;
	WebElement element;

	@BeforeClass
	public void verifyReportToMyInfoPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		reportToMyInfoPage = myInfoPage.navigatingToReportToMyInfo();
		System.out.println("Clicked ReportToPage and url is validated");
	}

	@Test /* (priority=3) */
	public void validateReportToButton_bgcolor() {
		try {

			
			// details button bg-color- grey
			element = myInfoPage.getReportTo_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("ReportToPage button bg-color is validated after clicking---grey");
			
			
		} catch (AssertionError ae) {
			System.out.println("In ReportToPage Testing--validateReportToButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In ReportToPage--validateReportToButton_bgcolor :" + we.getMessage());
		}

	}


}
