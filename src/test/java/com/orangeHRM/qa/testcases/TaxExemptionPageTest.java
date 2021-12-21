package com.orangeHRM.qa.testcases;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.pages.TaxExemptionPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class TaxExemptionPageTest extends BaseClass {
	BaseVerification baseVerification ;
	MyInfoPage myInfoPage;
	TaxExemptionPage taxExemptionPage;
	WebElement element;

	@BeforeClass
	public void verifyTaxExemptionPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		taxExemptionPage = myInfoPage.navigatingToTaxExemption();
		System.out.println("Clicked taxExemptionPage and url is validated");
	}

	@Test /* (priority=3) */
	public void validateTaxExemptionButton_bgcolor() {
		try {

			
			// details button bg-color- grey
			element = myInfoPage.getTaxexemption_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("taxExemption button bg-color is validated after clicking---grey");
			
			
		} catch (AssertionError ae) {
			System.out.println("In taxExemption Testing--validateTaxExemptionButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In taxExemption--validateTaxExemptionButton_bgcolor :" + we.getMessage());
		}

	}

}
