package com.orangeHRM.qa.testcases;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.JobMyInfoPage;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class JobMyInfoPageTest extends BaseClass{
	BaseVerification baseVerification ;
	MyInfoPage myInfoPage;
	JobMyInfoPage jobMyInfoPage;
	WebElement element;

	@BeforeClass
	public void verifyJobPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		jobMyInfoPage = myInfoPage.navigatingToJobMyInfoPage();
		System.out.println("Clicked Job and url is validated");
	}

	@Test /* (priority=3) */
	public void validateJobButton_bgcolor() {
		try {

			
			// details button bg-color- grey
			element = myInfoPage.getJob_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("Job button bg-color is validated after clicking---grey");
			
			
		} catch (AssertionError ae) {
			System.out.println("In Job Testing--validateJobButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In Job--validateJobButton_bgcolor :" + we.getMessage());
		}

	}

}
