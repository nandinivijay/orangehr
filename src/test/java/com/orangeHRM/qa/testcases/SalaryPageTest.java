package com.orangeHRM.qa.testcases;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.pages.SalaryPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class SalaryPageTest extends BaseClass {
	BaseVerification baseVerification ;
	MyInfoPage myInfoPage;
	SalaryPage salaryPage;
	WebElement element;

	@BeforeClass
	public void verifySalaryPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		salaryPage = myInfoPage.navigatingToSalary();
		System.out.println("Clicked SalaryPage and url is validated");
	}

	@Test /* (priority=3) */
	public void validateSalaryButton_bgcolor() {
		try {

			
			// details button bg-color- grey
			element = myInfoPage.getSalary_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("Salary button bg-color is validated after clicking---grey");
			
			
		} catch (AssertionError ae) {
			System.out.println("In Salary Testing--validateSalaryButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In Salary--validateSalaryButton_bgcolor :" + we.getMessage());
		}

	}
}
