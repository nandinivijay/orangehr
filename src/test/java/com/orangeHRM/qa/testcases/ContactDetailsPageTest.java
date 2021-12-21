package com.orangeHRM.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ContactDetailsPage;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.AttatchmentsUtil;
import com.orangeHRM.qa.util.ColorValidationUtil;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class ContactDetailsPageTest extends BaseClass {

	BaseVerification baseVerification;
	MyInfoPage myInfoPage;
	ContactDetailsPage contactDetailsPage;
	WebElement element;

	@BeforeClass
	public void verifyContactDetailsPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		contactDetailsPage = myInfoPage.navigatingToContactDetails();
		System.out.println("Clicked ContactDetailsPage and url is validated");
	}

	@Test(priority = 1)
	public void validateContactDetailsButton_bgcolor() {
		try {

			// clicking on contact deatils button andthe checking url of page and contact
			element = myInfoPage.getContactDetails_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR));
			System.out.println("Contact Details button bg-color is validated afetr clicking");
		} catch (AssertionError ae) {
			System.out.println("In Contact Details Testing--validateContactDetailsButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In ContactDetailsPage--validateContactDetailsButton_bgcolor :" + we.getMessage());
		}

	}

	@Test(priority = 2)
	public void validatingContactsDetailsFieldsDisplay() {
		ActionsUtil.MouseHoover(myInfoPage.getContactDetails_XPath(), driver);
		Assert.assertTrue(contactDetailsPage.getstreet1_id().isDisplayed());
		System.out.println("Street 1 Displayed");
		Assert.assertTrue(contactDetailsPage.getstreet2_id().isDisplayed());
		System.out.println("Street 2 Displayed");
		Assert.assertTrue(contactDetailsPage.getcity_id().isDisplayed());
		System.out.println("City Displayed");
		Assert.assertTrue(contactDetailsPage.getstateOrProvince_id().isDisplayed());
		System.out.println("State/Province Displayed");
		Assert.assertTrue(contactDetailsPage.getzipOrPostal_id().isDisplayed());
		System.out.println("Zip/Postal Displayed");
		Assert.assertTrue(contactDetailsPage.getcountry_id().isDisplayed());
		System.out.println("Country Displayed");
		Assert.assertTrue(contactDetailsPage.gethomeTelephone_id().isDisplayed());
		System.out.println("Home Telephone Displayed");
		Assert.assertTrue(contactDetailsPage.getmobile_id().isDisplayed());
		System.out.println("Mobile Displayed");
		Assert.assertTrue(contactDetailsPage.getworkTelephone_id().isDisplayed());
		System.out.println("Work Telephone Displayed");
		Assert.assertTrue(contactDetailsPage.getworkEmail_id().isDisplayed());
		System.out.println("Work Email Displayed");
		Assert.assertTrue(contactDetailsPage.getotherEmail_id().isDisplayed());
		System.out.println("Other Email Displayed");
		Assert.assertTrue(contactDetailsPage.geteditContactDetailsButton_id().isDisplayed());
		System.out.println("Edit Contact Details Button Displayed");
		Assert.assertTrue(contactDetailsPage.addAttatchmentBtn().isDisplayed());
		System.out.println("Add Attatchment Button Displayed");

	}

	@Test(priority = 3)
	public void setcontext(ITestContext context) {
		int sheetnumber = 9;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 4)
	public void ContactsDetailsTesting(String street1, String street2, String city, String stateorProvince, String zip,
			String homeTelephone, String mobile, String workTelephone, String workEmail, String otherEmail)
			throws Exception {
		System.out.println("Contacts Details Page clicked");
		driver.manage().window().maximize();
		SynchronisationWaitsUtil.implicitwait(12, TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Contacts Details : " + contactDetailsPage.getcurrentUrl());
		contactDetailsPage.geteditContactDetailsButton_id().click();

		contactDetailsPage.getstreet1_id().clear();
		contactDetailsPage.getstreet1_id().sendKeys(street1);
		try {
			Assert.assertTrue(contactDetailsPage.getstreet1_id().getAttribute("value").contains(street1));
			System.out.println("page data in First Name: " + contactDetailsPage.getstreet1_id().getAttribute("value")
					+ "---Data from file : " + street1);
		} catch (AssertionError ae) {
			System.out.println("In Contact Details Testing--Street1 :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage Street1 :" + we.getMessage());
		}

		contactDetailsPage.getstreet2_id().clear();
		contactDetailsPage.getstreet2_id().sendKeys(street2);
		try {
			Assert.assertTrue(contactDetailsPage.getstreet2_id().getAttribute("value").contains(street2));
			System.out.println("page data in Middle Name: " + contactDetailsPage.getstreet2_id().getAttribute("value")
					+ "---Data from file : " + street2);
		} catch (AssertionError ae) {
			System.out.println("In Contacts Details Testing--Street2 :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage Street2 :" + we.getMessage());
		}

		contactDetailsPage.getcity_id().clear();
		contactDetailsPage.getcity_id().sendKeys(city);
		try {
			Assert.assertTrue(contactDetailsPage.getcity_id().getAttribute("value").contains(city));
			System.out.println("page data in Last Name: " + contactDetailsPage.getcity_id().getAttribute("value")
					+ "---Data from file : " + city);
		} catch (AssertionError ae) {
			System.out.println("In Contact Details Testing--City :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage City :" + we.getMessage());
		}

		contactDetailsPage.getstateOrProvince_id().clear();
		contactDetailsPage.getstateOrProvince_id().sendKeys(stateorProvince);
		try {
			Assert.assertTrue(
					contactDetailsPage.getstateOrProvince_id().getAttribute("value").contains(stateorProvince));
			System.out.println(
					"page data in Employee Id: " + contactDetailsPage.getstateOrProvince_id().getAttribute("value")
							+ "---Data from file : " + stateorProvince);
		} catch (AssertionError ae) {
			System.out.println("In Contacts Details Testing--State/Province :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage State/Province :" + we.getMessage());
		}

		contactDetailsPage.getzipOrPostal_id().clear();
		contactDetailsPage.getzipOrPostal_id().sendKeys(zip);
		try {
			Assert.assertTrue(contactDetailsPage.getzipOrPostal_id().getAttribute("value").contains(zip));
			System.out.println("page data in Other Id: " + contactDetailsPage.getzipOrPostal_id().getAttribute("value")
					+ "---Data from file : " + zip);
		} catch (AssertionError ae) {
			System.out.println("In Contacts Details Testing--zip :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage zip :" + we.getMessage());
		}

		// contactDetailsPage.getcountry_id().click();
		DropDownUtil.selectbyindex(contactDetailsPage.getcountry_id(), 3);

		contactDetailsPage.gethomeTelephone_id().clear();
		contactDetailsPage.gethomeTelephone_id().sendKeys(homeTelephone);
		try {
			Assert.assertTrue(contactDetailsPage.gethomeTelephone_id().getAttribute("value").contains(homeTelephone));
			System.out.println(
					"page data in DriversLicense: " + contactDetailsPage.gethomeTelephone_id().getAttribute("value")
							+ "---Data from file : " + homeTelephone);
		} catch (AssertionError ae) {
			System.out.println("In Contacts Details Testing--homeTelephone :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage homeTelephone :" + we.getMessage());
		}

		contactDetailsPage.getmobile_id().clear();
		contactDetailsPage.getmobile_id().sendKeys(mobile);
		try {
			Assert.assertTrue(contactDetailsPage.getmobile_id().getAttribute("value").contains(mobile));
			System.out.println("page data in First Name: " + contactDetailsPage.getmobile_id().getAttribute("value")
					+ "---Data from file : " + mobile);
		} catch (AssertionError ae) {
			System.out.println("In Contacts Details Testing--mobile :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage mobile :" + we.getMessage());
		}

		contactDetailsPage.getworkTelephone_id().clear();
		contactDetailsPage.getworkTelephone_id().sendKeys(workTelephone);
		try {
			Assert.assertTrue(contactDetailsPage.getworkTelephone_id().getAttribute("value").contains(workTelephone));
			System.out.println(
					"page data in First Name: " + contactDetailsPage.getworkTelephone_id().getAttribute("value")
							+ "---Data from file : " + workTelephone);
		} catch (AssertionError ae) {
			System.out.println("In Contacts Details Testing--workTelephone :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage workTelephone :" + we.getMessage());
		}

		contactDetailsPage.getworkEmail_id().clear();
		contactDetailsPage.getworkEmail_id().sendKeys(workEmail);
		try {
			Assert.assertTrue(contactDetailsPage.getworkEmail_id().getAttribute("value").contains(workEmail));
			System.out.println("page data : " + contactDetailsPage.getworkEmail_id().getAttribute("value")
					+ "---Data from file : " + workEmail);
		} catch (AssertionError ae) {
			System.out.println("In contactDetailsPage workEmail :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage workEmail :" + we.getMessage());
		}

		contactDetailsPage.getotherEmail_id().clear();
		contactDetailsPage.getotherEmail_id().sendKeys(otherEmail);
		try {
			Assert.assertTrue(contactDetailsPage.getotherEmail_id().getAttribute("value").contains(otherEmail));
			System.out.println("page data : " + contactDetailsPage.getotherEmail_id().getAttribute("value")
					+ "---Data from file : " + otherEmail);
		} catch (AssertionError ae) {
			System.out.println("In contactDetailsPage otherEmail :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In contactDetailsPage otherEmail :" + we.getMessage());
		}

		contactDetailsPage.getsaveContactDetailsButton_id().click();
		Assert.assertEquals(contactDetailsPage.getstreet1_id().getAttribute("value"), street1);
		Assert.assertEquals(contactDetailsPage.getstreet2_id().getAttribute("value"), street2);
		Assert.assertEquals(contactDetailsPage.getcity_id().getAttribute("value"), city);
		Assert.assertEquals(contactDetailsPage.getstateOrProvince_id().getAttribute("value"), stateorProvince);
		Assert.assertEquals(contactDetailsPage.getzipOrPostal_id().getAttribute("value"), zip);
		Assert.assertEquals(contactDetailsPage.gethomeTelephone_id().getAttribute("value"), homeTelephone);
		Assert.assertEquals(contactDetailsPage.getmobile_id().getAttribute("value"), mobile);
		Assert.assertEquals(contactDetailsPage.getworkTelephone_id().getAttribute("value"), workTelephone);
		Assert.assertEquals(contactDetailsPage.getworkEmail_id().getAttribute("value"), workEmail);
		Assert.assertEquals(contactDetailsPage.getotherEmail_id().getAttribute("value"), otherEmail);
	}

	@Test(priority = 5)
	public void validatingCountryDropdownOptionsSort() {
		WebElement element = contactDetailsPage.getcountry_id();
		Select se = new Select(element);

		ArrayList<String> originalList = new ArrayList<String>();

		for (WebElement e : se.getOptions()) {
			originalList.add(e.getText());
		}
		System.out.println("originalList:" + originalList);

		ArrayList<String> tempList = originalList;
		Collections.sort(tempList);

		System.out.println("originalList:" + originalList);
		System.out.println("tempList:" + tempList);
		Assert.assertEquals(originalList, tempList);

	}

	@Test(priority = 6)
	public void validatingCountryDropdownOptionsDuplicates() {
		WebElement element = contactDetailsPage.getcountry_id();
		Select se = new Select(element);

		List<WebElement> list = se.getOptions();
		Set<String> s = new LinkedHashSet<String>();
		for (WebElement w : list) {
			s.add(w.getText());
		}

		Assert.assertEquals(list.size(), s.size());
	}

	@Test(priority = 7)
	public void comparingEmails() {
		String wEmail = contactDetailsPage.getworkEmail_id().getAttribute("value");
		String oEmail = contactDetailsPage.getotherEmail_id().getAttribute("value");
		Assert.assertNotEquals(wEmail, oEmail);
	}

	@Test(priority = 8)
	public void emailContainingCom() {
		String wEmail = contactDetailsPage.getworkEmail_id().getAttribute("value");
		String oEmail = contactDetailsPage.getotherEmail_id().getAttribute("value");
		// int w = wEmail.length();
		// int o = oEmail.length();
		boolean flag = false;
		if (wEmail.contains("@") && oEmail.contains("@") && wEmail.contains(".com") && oEmail.contains(".com"))
			flag = true;
		Assert.assertTrue(flag);

	}

	@Test(priority = 9)
	public void buttonColorValidation() {
		WebElement editbtn = contactDetailsPage.geteditContactDetailsButton_id();
		String color = ColorValidationUtil.GetColor(editbtn);
		Assert.assertEquals("Green", color);
	}

	@Test(priority = 10)
	public void setcontext1(ITestContext context) {
		int sheetnumber = 7;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 11)
	public void contactDetailsAttatchmentTesting(String cmt) throws Exception {
		System.out.println("Contact Details Page clicked");
		driver.manage().window().maximize();
		SynchronisationWaitsUtil.implicitwait(12, TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Personal Details : " + contactDetailsPage.getcurrentUrl());
		contactDetailsPage.addAttatchmentBtn().click();

		SynchronisationWaitsUtil.threadsleep(2000);
		WebElement ele = contactDetailsPage.chooseFile();
		AttatchmentsUtil.uploadingFileUsingAutoIT(ele, driver, "smallbird.jpg");

		contactDetailsPage.comments().sendKeys(cmt);
		SynchronisationWaitsUtil.threadsleep(5000);
		contactDetailsPage.upload().click();
		System.out.println("Attatchment File Uploaded");
	}

	@Test(priority = 12, dependsOnMethods = { "contactDetailsAttatchmentTesting" })
	public void tableHeaderValidation() {

		AttatchmentsUtil.validatingTableHeader(driver);
	}

	@Test(priority = 13, dependsOnMethods = { "contactDetailsAttatchmentTesting" })
	public void toolTipValidation() {

		WebElement element = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
		AttatchmentsUtil.toolTipValidation(element, driver);

	}

	@Test(priority = 14, dependsOnMethods = { "contactDetailsAttatchmentTesting" })
	public void clickingOnEditLink() throws Exception {

		contactDetailsPage.editLinkClick().click();
		SynchronisationWaitsUtil.threadsleep(3000);
		String str = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a")).getText();
		System.out.println("Current file : " + str);// *[@id="tblAttachments"]/tbody/tr/td[2]/a
		Assert.assertTrue(driver.findElement(By.id("currentFileLi")).isDisplayed());
		System.out.println("Current File : " + driver.findElement(By.id("currentFileSpan")).getText().contains(str));
		WebElement element = contactDetailsPage.chooseFile();
		String fname = "smallbird1.jpg";
		AttatchmentsUtil.editFileLink(fname, driver, element);
		SynchronisationWaitsUtil.threadsleep(3000);

	}

	@Test(priority = 15, dependsOnMethods = { "contactDetailsAttatchmentTesting" })
	public void example_VerifyDownloadWithFileName() throws Exception {
		WebElement element = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
		AttatchmentsUtil.verifyDownloadWithFileName(element);
	}

	int finalnumRows;

	@Test(priority = 16, dependsOnMethods = { "contactDetailsAttatchmentTesting" })
	public void deletingSingle_Attatchment() {
		// driver.findElement(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr/td[1]/input")).click();
		if (contactDetailsPage.deleteButton().isDisplayed())
//				if (Assert.assertTrue(emergencyContactsPage.deleteButton().isDisplayed())
		{
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tblAttachments']/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr[1]/td[1]/input")).click();
			// emergencyContactsPage.getCheckboxAttatchment().click();
			contactDetailsPage.deleteButton().click();
			List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			finalnumRows = finalRows.size();
			System.out.println("No. of Rows After Deleting : " + finalnumRows);
			Assert.assertEquals(finalnumRows, numRows - 1);
		} else {
			Assert.assertFalse(contactDetailsPage.deleteButton().isDisplayed());
			System.out.println("No Rows Displayed");
		}
	}

	@Test(priority = 17)
	public void deletingall_Attatchments() {

		// boolean tableExist =
		// driver.findElement(By.id("tblAttachments")).isDisplayed();
		// System.out.println("Table Exist : "+tableExist);
		if (finalnumRows > 0) {
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			contactDetailsPage.checkboxallAttatchment().click();
			contactDetailsPage.deleteButton().click();

		} else {

			System.out.println("No rows Displayed");
		}
	}

}
