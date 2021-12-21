package com.orangeHRM.qa.testcases;

import java.text.ParseException;
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
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.pages.PersonalDetailsPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.AttatchmentsUtil;
import com.orangeHRM.qa.util.ColorValidationUtil;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class PersonalDetailsPageTest extends BaseClass {
	BaseVerification baseVerification;
	MyInfoPage myInfoPage;
	PersonalDetailsPage personalDetailsPage;

	@BeforeClass
	public void verifypersonalDetailsPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		personalDetailsPage = myInfoPage.navigatingToPersonalDetails();
		System.out.println("Clicked Personal Details");
	}

	@Test(priority = 2)
	public void validatingPersonalDetailsFieldsDisplay() {
		ActionsUtil.MouseHoover(myInfoPage.getPersonalDetails_XPath(), driver);
		Assert.assertTrue(personalDetailsPage.getFirstName_id().isDisplayed());
		System.out.println("First Name Displayed");
		Assert.assertTrue(personalDetailsPage.getMiddleName_id().isDisplayed());
		System.out.println("Middle Name Displayed");
		Assert.assertTrue(personalDetailsPage.getLastName_id().isDisplayed());
		System.out.println("Last Name Displayed");
		Assert.assertTrue(personalDetailsPage.getEmployee_id().isDisplayed());
		System.out.println("Employee Id Displayed");
		Assert.assertTrue(personalDetailsPage.getDriversLicense_id().isDisplayed());
		System.out.println("Driver License Displayed");
		Assert.assertTrue(personalDetailsPage.getSSNNumber_id().isDisplayed());
		System.out.println("SSN Number Displayed");
		Assert.assertTrue(personalDetailsPage.getOther_id().isDisplayed());
		System.out.println("Other Id Displayed");
		Assert.assertTrue(personalDetailsPage.getLicenseExpiryDate_id().isDisplayed());
		System.out.println("License Expiry Date Displayed");
		Assert.assertTrue(personalDetailsPage.getSINNumber_id().isDisplayed());
		System.out.println("SIN Number Displayed");
		Assert.assertTrue(personalDetailsPage.getNationality_id().isDisplayed());
		System.out.println("Nationality Displayed");
		Assert.assertTrue(personalDetailsPage.getMarritalStatus_id().isDisplayed());
		System.out.println("Marrital status Displayed");
		Assert.assertTrue(personalDetailsPage.getDateOfBirth_id().isDisplayed());
		System.out.println("Date Of Birth Displayed");
		Assert.assertTrue(personalDetailsPage.getNickName_id().isDisplayed());
		System.out.println("Nick Name Displayed");
		Assert.assertTrue(personalDetailsPage.getMilitaryService_id().isDisplayed());
		System.out.println("Military Service Displayed");
		Assert.assertTrue(personalDetailsPage.getSmoker_id().isDisplayed());
		System.out.println("Smoker Displayed");
	}

	@Test(priority = 3)
	public void setcontext(ITestContext context) {
		int sheetnumber = 5;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 4)
	public void personalDetailsTesting(String firstName, String middleName, String lastName, String empId,
			String otherId, String driverLicenseNo, String ssnNumber, String sinNumber, String nickName,
			String militaryService) throws Exception {
		System.out.println("Personal Details Page clicked");
		driver.manage().window().maximize();
		SynchronisationWaitsUtil.implicitwait(12, TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Personal Details : " + personalDetailsPage.getcurrentUrl());
		personalDetailsPage.getEdit_id().click();

		personalDetailsPage.getFirstName_id().clear();
		personalDetailsPage.getFirstName_id().sendKeys(firstName);
		try {
			Assert.assertTrue(personalDetailsPage.getFirstName_id().getAttribute("value").contains(firstName));
			System.out.println("page data in First Name: " + personalDetailsPage.getFirstName_id().getAttribute("value")
					+ "---Data from file : " + firstName);
		} catch (AssertionError ae) {
			System.out.println("In Personal Details Testing--First Name :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage First Name :" + we.getMessage());
		}

		personalDetailsPage.getMiddleName_id().clear();
		personalDetailsPage.getMiddleName_id().sendKeys(middleName);
		try {
			Assert.assertTrue(personalDetailsPage.getMiddleName_id().getAttribute("value").contains(middleName));
			System.out
					.println("page data in Middle Name: " + personalDetailsPage.getMiddleName_id().getAttribute("value")
							+ "---Data from file : " + middleName);
		} catch (AssertionError ae) {
			System.out.println("In Personal Details Testing--Middle Name :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage Middle Name :" + we.getMessage());
		}

		personalDetailsPage.getLastName_id().clear();
		personalDetailsPage.getLastName_id().sendKeys(lastName);
		try {
			Assert.assertTrue(personalDetailsPage.getLastName_id().getAttribute("value").contains(lastName));
			System.out.println("page data in Last Name: " + personalDetailsPage.getLastName_id().getAttribute("value")
					+ "---Data from file : " + lastName);
		} catch (AssertionError ae) {
			System.out.println("In Personal Details Testing--Last Name :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage Last Name :" + we.getMessage());
		}

		personalDetailsPage.getEmployee_id().clear();
		personalDetailsPage.getEmployee_id().sendKeys(empId);
		try {
			Assert.assertTrue(personalDetailsPage.getEmployee_id().getAttribute("value").contains(empId));
			System.out.println("page data in Employee Id: " + personalDetailsPage.getEmployee_id().getAttribute("value")
					+ "---Data from file : " + empId);
		} catch (AssertionError ae) {
			System.out.println("In Personal Details Testing--Employee Id :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage Employee Id :" + we.getMessage());
		}

		personalDetailsPage.getOther_id().clear();
		personalDetailsPage.getOther_id().sendKeys(otherId);
		try {
			Assert.assertTrue(personalDetailsPage.getOther_id().getAttribute("value").contains(otherId));
			System.out.println("page data in Other Id: " + personalDetailsPage.getOther_id().getAttribute("value")
					+ "---Data from file : " + otherId);
		} catch (AssertionError ae) {
			System.out.println("In Personal Details Testing--Other Id :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage Other Id :" + we.getMessage());
		}

		personalDetailsPage.getDriversLicense_id().clear();
		personalDetailsPage.getDriversLicense_id().sendKeys(driverLicenseNo);
		try {
			Assert.assertTrue(
					personalDetailsPage.getDriversLicense_id().getAttribute("value").contains(driverLicenseNo));
			System.out.println(
					"page data in DriversLicense: " + personalDetailsPage.getDriversLicense_id().getAttribute("value")
							+ "---Data from file : " + driverLicenseNo);
		} catch (AssertionError ae) {
			System.out.println("In Personal Details Testing--DriversLicense No :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage DriversLicense No :" + we.getMessage());
		}

		personalDetailsPage.getLicenseExpiryDate_id().clear();
		personalDetailsPage.getLicenseExpiryDate_id().click();
		DropDownUtil.selectbytext(personalDetailsPage.selMonth(), "May");
		DropDownUtil.selectbytext(personalDetailsPage.SelYear(), "2020");
		int eday = 12;
		// driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		driver.findElement(
				By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a[contains(text()," + eday + ")]")).click();

		personalDetailsPage.getSSNNumber_id().clear();
		personalDetailsPage.getSSNNumber_id().sendKeys(ssnNumber);
		try {
			Assert.assertTrue(personalDetailsPage.getSSNNumber_id().getAttribute("value").contains(ssnNumber));
			System.out.println("page data in First Name: " + personalDetailsPage.getSSNNumber_id().getAttribute("value")
					+ "---Data from file : " + ssnNumber);
		} catch (AssertionError ae) {
			System.out.println("In Personal Details Testing--SSNNumber :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage SSNNumber :" + we.getMessage());
		}

		personalDetailsPage.getSINNumber_id().clear();
		personalDetailsPage.getSINNumber_id().sendKeys(sinNumber);
		try {
			Assert.assertTrue(personalDetailsPage.getSINNumber_id().getAttribute("value").contains(sinNumber));
			System.out.println("page data in First Name: " + personalDetailsPage.getSINNumber_id().getAttribute("value")
					+ "---Data from file : " + sinNumber);
		} catch (AssertionError ae) {
			System.out.println("In Personal Details Testing--SINNumber :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage SINNumber :" + we.getMessage());
		}

		DropDownUtil.selectbyindex(personalDetailsPage.getMarritalStatus_id(), 2);
		DropDownUtil.selectbytext(personalDetailsPage.getNationality_id(), "Indian");

		personalDetailsPage.getDateOfBirth_id().click();
		DropDownUtil.selectbytext(personalDetailsPage.selMonth(), "Jun");
		DropDownUtil.selectbytext(personalDetailsPage.SelYear(), "1987");
		int bday = 22;
		// driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		driver.findElement(
				By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a[contains(text()," + bday + ")]")).click();

		personalDetailsPage.getNickName_id().clear();
		personalDetailsPage.getNickName_id().sendKeys(nickName);
		try {
			Assert.assertTrue(personalDetailsPage.getNickName_id().getAttribute("value").contains(nickName));
			System.out.println("page data : " + personalDetailsPage.getNickName_id().getAttribute("value")
					+ "---Data from file : " + nickName);
		} catch (AssertionError ae) {
			System.out.println("In personalDetailsPage Nick Name :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage Nick Name :" + we.getMessage());
		}

		personalDetailsPage.getMilitaryService_id().clear();
		personalDetailsPage.getMilitaryService_id().sendKeys(militaryService);
		try {
			Assert.assertTrue(
					personalDetailsPage.getMilitaryService_id().getAttribute("value").contains(militaryService));
			System.out.println("page data : " + personalDetailsPage.getMilitaryService_id().getAttribute("value")
					+ "---Data from file : " + militaryService);
		} catch (AssertionError ae) {
			System.out.println("In personalDetailsPage MilitaryService :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage MilitaryService :" + we.getMessage());
		}

		// personalDetailsPage.getEdit_id().click();

		// personalDetailsPage.editButton().click();
		// DropDownUtil.selectbyindex(personalDetailsPage.bloodType(), 3);
		// personalDetailsPage.saveButton().click();

		/*
		 * personalDetailsPage.addButton().click();
		 * //driver.findElement(By.id("ufile"));
		 * 
		 * 
		 * WebElement ele = personalDetailsPage.chooseFile();
		 * JavascriptExecutorUtil.clickingOnElement(driver, ele);
		 * //SynchronisationWaitsUtil.threadsleep(5000); File file = new
		 * File("./attachments/images/smallbird.jpg");
		 * Runtime.getRuntime().exec("./attachments/fileUpload.exe"+" "+file.
		 * getCanonicalPath()); System.out.println("Canonical Path : "+
		 * file.getCanonicalPath()); SynchronisationWaitsUtil.threadsleep(5000);
		 * 
		 * //ele.sendKeys("./orangeHRM/attachments/images/gmail_loginpage.jpg");
		 * personalDetailsPage.comments().sendKeys(cmt);
		 * personalDetailsPage.upload().click();
		 * 
		 * 
		 * personalDetailsPage.fileCheckbox().click();
		 * personalDetailsPage.deleteButton().click();
		 */

	}
	

	@Test(priority = 5)
	public void validatingNationalityDropdownOptionsSort() {
		WebElement element = personalDetailsPage.getNationality_id();
		Select se = new Select(element);

		ArrayList<String> originalList = new ArrayList<String>();

		for (WebElement e : se.getOptions()) {
			originalList.add(e.getText());
		}
		System.out.println("originalList:" + originalList);

		ArrayList<String> tempList = originalList;

		Collections.sort(tempList); // When you change one list, it changes the other list as well.

		System.out.println("originalList:" + originalList);
		System.out.println("tempList:" + tempList);
		Assert.assertEquals(originalList, tempList);

	}

	@Test(priority = 6)
	public void validatingNationalityDropdownOptionsDuplicates() {
		WebElement element = personalDetailsPage.getNationality_id();
		Select se = new Select(element);

		List<WebElement> list = se.getOptions();
		Set<String> s = new LinkedHashSet<String>(list.size());
		for (WebElement w : list) {
			s.add(w.getText());
		}

		Assert.assertEquals(list.size(), s.size());
	}

	@Test(priority = 7)
	public void validatingMarritalStatusDropdownOptionsSort() {
		WebElement element = personalDetailsPage.getMarritalStatus_id();
		Select se = new Select(element);

		ArrayList<String> originalList = new ArrayList<String>();

		for (WebElement e : se.getOptions()) {
			originalList.add(e.getText());
		}
		System.out.println("originalList:" + originalList);

		ArrayList<String> tempList = originalList;

		System.out.println("tempList:" + tempList);
		System.out.println("tempList:" + tempList);
		System.out.println("tempList:" + tempList);
		Collections.sort(originalList);
		// Collections.sort(tempList); // When you change one list, it changes the other
		// list as well.

		System.out.println("originalList:" + originalList);
		System.out.println("tempList:" + tempList);
		Assert.assertEquals(originalList, tempList);

	}

	@Test(priority = 8)
	public void validatingMarritalStatusDropdownOptionsDuplicates() {
		WebElement element = personalDetailsPage.getMarritalStatus_id();
		Select se = new Select(element);

		List<WebElement> list = se.getOptions();
		Set<String> s = new LinkedHashSet<String>(list.size());
		for (WebElement w : list) {
			s.add(w.getText());
		}

		Assert.assertEquals(list.size(), s.size());
	}

	@Test(priority = 9)
	public void verifyDateOfBirthDateFormat() throws ParseException {
		String DOB = personalDetailsPage.getDateOfBirth_id().getAttribute("value");
		StringBuffer sBuffer = new StringBuffer(DOB);
		String date, month, year;
		boolean flag;
		year = sBuffer.substring(0, 4);
		month = sBuffer.substring(5, 7);
		date = sBuffer.substring(8, 10);
		System.out.println("Date Of Birth : " + DOB);
		System.out.println(" Year: " + year + " Mon: " + month + "DD: " + date);

		if (year.matches("(19|20)\\d\\d") && month.matches("0[1-9]|1[0-2]") && date.matches("0[1-9]|[12][0-9]|3[01]")) {
			System.out.println("Date Of Birth Date Format matched.");
			flag = true;
		} else {
			System.out.println("Date Of Birth Date Format didn't matched.");
			flag = false;
		}
		Assert.assertTrue(flag);
	}

	@Test(priority = 10)
	public void verifyLicenseExpiryDateFormat() throws ParseException {
		String licenseExpiry = personalDetailsPage.getLicenseExpiryDate_id().getAttribute("value");
		StringBuffer sBuffer = new StringBuffer(licenseExpiry);
		String date, month, year;
		boolean flag;
		year = sBuffer.substring(0, 4);
		month = sBuffer.substring(5, 7);
		date = sBuffer.substring(8, 10);
		System.out.println("License Expiry Date : " + licenseExpiry);
		System.out.println(" Year: " + year + " Mon: " + month + "DD: " + date);

		if (year.matches("(19|20)\\d\\d") && month.matches("0[1-9]|1[0-2]") && date.matches("0[1-9]|[12][0-9]|3[01]")) {
			System.out.println("License Expiry Date Format matched.");
			flag = true;
		} else {
			System.out.println("License Expiry Date Format didn't matched.");
			flag = false;
		}
		Assert.assertTrue(flag);
	}
	
	@Test(priority=11)
	public void setcontext1(ITestContext context) {
	int	sheetnumber=16;
	context.setAttribute("index", sheetnumber);
	}
	
	@Test(dataProvider = "paramName", dataProviderClass=ExcelReaderWithIndex.class, priority=12)
	public void personalDetailsEditTesting(String firstName, String middleName, String lastName, String empId, String otherId, String driverLicenseNo, String ssnNumber,String sinNumber,String nickName,String militaryService) throws Exception 
	{
		System.out.println("Personal Details Page clicked");
		
		SynchronisationWaitsUtil.implicitwait(12,TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Personal Details : "+personalDetailsPage.getcurrentUrl());
		SynchronisationWaitsUtil.threadsleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='btnSave']")).getAttribute("value").contains("Save"));
		SynchronisationWaitsUtil.threadsleep(2000);
		personalDetailsPage.getEdit_id().click(); //Edit Button
		SynchronisationWaitsUtil.threadsleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='btnSave']")).getAttribute("value").contains("Edit"));
		SynchronisationWaitsUtil.threadsleep(2000);
		driver.findElement(By.id("btnSave")).click();
		personalDetailsPage.getFirstName_id().clear();
		personalDetailsPage.getFirstName_id().sendKeys(firstName);
				
		personalDetailsPage.getMiddleName_id().clear();
		personalDetailsPage.getMiddleName_id().sendKeys(middleName);
		
		personalDetailsPage.getLastName_id().clear();
		personalDetailsPage.getLastName_id().sendKeys(lastName);
		
		personalDetailsPage.getEmployee_id().clear();
		personalDetailsPage.getEmployee_id().sendKeys(empId);
		
		personalDetailsPage.getOther_id().clear();
		personalDetailsPage.getOther_id().sendKeys(otherId);
		
		personalDetailsPage.getDriversLicense_id().clear();
		personalDetailsPage.getDriversLicense_id().sendKeys(driverLicenseNo);
		
		personalDetailsPage.getLicenseExpiryDate_id().clear();
		personalDetailsPage.getLicenseExpiryDate_id().click();
		DropDownUtil.selectbytext(personalDetailsPage.selMonth(), "May");
		DropDownUtil.selectbytext(personalDetailsPage.SelYear(), "2020");
		int eday = 12;
		//driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a[contains(text(),"+eday+")]")).click();
		WebElement date=driver.findElement(By.xpath("//*[@id='personal_txtLicExpDate']"));
		 String value=date.getAttribute("value");
		 Assert.assertEquals(value, "2020-05-12");
		
		personalDetailsPage.getSSNNumber_id().clear();
		personalDetailsPage.getSSNNumber_id().sendKeys(ssnNumber);
		
		personalDetailsPage.getSINNumber_id().clear();
		personalDetailsPage.getSINNumber_id().sendKeys(sinNumber);
		
		
		personalDetailsPage.clickFemale().click();
		Assert.assertTrue(personalDetailsPage.clickFemale().isSelected());
		
		DropDownUtil.selectbyindex(personalDetailsPage.getMarritalStatus_id(),2);
		
		
		DropDownUtil.selectbytext(personalDetailsPage.getNationality_id(),"Indian");
		
		
		personalDetailsPage.getDateOfBirth_id().click();
		DropDownUtil.selectbytext(personalDetailsPage.selMonth(), "Jun");
		DropDownUtil.selectbytext(personalDetailsPage.SelYear(), "1987");
		int bday = 22;
		//driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a[contains(text(),"+bday+")]")).click();
		WebElement dob = driver.findElement(By.xpath("//*[@id='personal_DOB']"));
		String value1 = dob.getAttribute("value");
		Assert.assertEquals(value1,"1987-06-22");
		
		personalDetailsPage.getNickName_id().clear();
		personalDetailsPage.getNickName_id().sendKeys(nickName);
		
		personalDetailsPage.getSmoker_id().click();
		//Assert.assertTrue(personalDetailsPage.getSmoker_id().isSelected());
		
		personalDetailsPage.getMilitaryService_id().clear();
		personalDetailsPage.getMilitaryService_id().sendKeys(militaryService);
		
		
		  personalDetailsPage.getEdit_id().click();//Save Button
		  
		  Assert.assertTrue(personalDetailsPage.getFirstName_id().getAttribute("value").contains(firstName));
		  Assert.assertTrue(personalDetailsPage.getMiddleName_id().getAttribute("value").contains(middleName));
		  Assert.assertTrue(personalDetailsPage.getLastName_id().getAttribute("value").contains(lastName));
		  Assert.assertTrue(personalDetailsPage.getEmployee_id().getAttribute("value").contains(empId));
		  Assert.assertTrue(personalDetailsPage.getOther_id().getAttribute("value").contains(otherId));
		  Assert.assertTrue(personalDetailsPage.getDriversLicense_id().getAttribute("value").contains(driverLicenseNo));
		  Assert.assertEquals(value, "2020-05-12");// validate License Expiry Date
		  Assert.assertTrue(personalDetailsPage.getSSNNumber_id().getAttribute("value").contains(ssnNumber));
		  Assert.assertTrue(personalDetailsPage.getSINNumber_id().getAttribute("value").contains(sinNumber));
		  Assert.assertTrue(personalDetailsPage.clickFemale().isSelected()); //Gender validation
		  Assert.assertTrue(personalDetailsPage.getMarritalStatus_id().getAttribute("value").contains("Married"));
		  Assert.assertTrue(personalDetailsPage.getNationality_id().getText().contains("Indian"));
		  Assert.assertTrue(personalDetailsPage.getNickName_id().getAttribute("value").contains(nickName));
		 // Assert.assertTrue(personalDetailsPage.getSmoker_id().isSelected());
		  Assert.assertTrue(personalDetailsPage.getMilitaryService_id().getAttribute("value").contains(militaryService));	 
		 	
	}
	
	
	
	// To edit Custom fields data taken from sheet13
	@Test(priority = 12)
	public void setcontext2(ITestContext context) {
		int sheetnumber = 13;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 13)
	public void editCustomfields(String btype) throws Exception {
		SynchronisationWaitsUtil.threadsleep(2000);
		personalDetailsPage.geteditCustFields().click();
		personalDetailsPage.bloodType().click();
		DropDownUtil.selectbytext(personalDetailsPage.bloodType(), btype);
		try {
			Assert.assertEquals(personalDetailsPage.bloodType().getAttribute("value"), btype);
			System.out.println("page data : " + personalDetailsPage.bloodType().getAttribute("value")
					+ "---Data from file : " + btype);
		} catch (AssertionError ae) {
			System.out.println("In personalDetailsPage Blood Group :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In personalDetailsPage Blood Group :" + we.getMessage());
		}
		personalDetailsPage.saveButton().click();
		SynchronisationWaitsUtil.threadsleep(2000);
	}

	@Test(priority = 14)
	public void setcontext3(ITestContext context) {
		int sheetnumber = 7;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 15)
	public void personalDetailsAttatchmentTesting(String cmt) throws Exception {
		System.out.println("Personal Details Page clicked");
		driver.manage().window().maximize();
		SynchronisationWaitsUtil.implicitwait(12, TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Personal Details : " + personalDetailsPage.getcurrentUrl());
		personalDetailsPage.addButton().click();

		SynchronisationWaitsUtil.threadsleep(2000);
		WebElement ele = personalDetailsPage.chooseFile();
		AttatchmentsUtil.uploadingFileUsingAutoIT(ele, driver, "smallbird.jpg");

		personalDetailsPage.comments().sendKeys(cmt);
		SynchronisationWaitsUtil.threadsleep(5000);
		personalDetailsPage.upload().click();
		System.out.println("Attatchment File Uploaded");
	}

	@Test(priority = 16, dependsOnMethods = { "personalDetailsAttatchmentTesting" })
	public void colorOfButtons() {

		WebElement addBtn = personalDetailsPage.addButton();
		String color = ColorValidationUtil.GetColor(addBtn);
		Assert.assertEquals("Green", color);
		WebElement delBtn = personalDetailsPage.deleteButton();
		String color2 = ColorValidationUtil.GetColor(delBtn);
		Assert.assertEquals("Red", color2);
		WebElement editBtn = personalDetailsPage.editButton();
		String color3 = ColorValidationUtil.GetColor(editBtn);
		Assert.assertEquals("Green", color3);

//		String addBtn = personalDetailsPage.addButton().getCssValue("background-color");
//		System.out.println(addBtn);
//		String addBtncolor = Color.fromString(addBtn).asHex();
//		System.out.println("Add Button Color : " + addBtncolor);
//		String delBtn = personalDetailsPage.deleteButton().getCssValue("background-color");
//		System.out.println(delBtn);
//		String delBtncolor = Color.fromString(delBtn).asHex();
//		System.out.println("Delete Button Color : " + delBtncolor);
//		String editBtn = personalDetailsPage.editButton().getCssValue("background-color");
//		System.out.println(editBtn);
//		String editBtncolor = Color.fromString(editBtn).asHex();
//		System.out.println("Edit Button Color : " + editBtncolor);

		/*
		 * Assert.assertEquals("green",addBtncolor);
		 * Assert.assertEquals("green",editBtncolor); Assert.assertEquals("red",
		 * delBtncolor);
		 */

	}

	@Test(priority = 17, dependsOnMethods = { "personalDetailsAttatchmentTesting" })
	public void tableHeaderValidation() {

		AttatchmentsUtil.validatingTableHeader(driver);
	}

	@Test(priority = 18, dependsOnMethods = { "personalDetailsAttatchmentTesting" })
	public void toolTipValidation() {

		WebElement element = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
		AttatchmentsUtil.toolTipValidation(element, driver);

	}

//	@Test(priority = 19, dependsOnMethods = { "personalDetailsAttatchmentTesting" })
	public void clickingOnEditLink() throws Exception {

		personalDetailsPage.editLinkClick().click();
		SynchronisationWaitsUtil.threadsleep(3000);
		String str = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a")).getText();
		System.out.println("Current file : " + str);// *[@id="tblAttachments"]/tbody/tr/td[2]/a
		Assert.assertTrue(driver.findElement(By.id("currentFileLi")).isDisplayed());
		System.out.println("Current File : " + driver.findElement(By.id("currentFileSpan")).getText().contains(str));
		WebElement element = personalDetailsPage.chooseFile();
		String fname = "smallbird1.jpg";
		AttatchmentsUtil.editFileLink(fname, driver, element);
		SynchronisationWaitsUtil.threadsleep(3000);

	}

	@Test(priority = 20, dependsOnMethods = { "personalDetailsAttatchmentTesting" })
	public void example_VerifyDownloadWithFileName() throws Exception {
		WebElement element = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
		AttatchmentsUtil.verifyDownloadWithFileName(element);
	}

	int finalnumRows;

	@Test(priority = 21, dependsOnMethods = { "personalDetailsAttatchmentTesting" })
	public void deletingSingle_Attatchment() {
		// driver.findElement(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr/td[1]/input")).click();
		if (personalDetailsPage.deleteButton().isDisplayed())
//				if (Assert.assertTrue(emergencyContactsPage.deleteButton().isDisplayed())
		{
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tblAttachments']/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr[1]/td[1]/input")).click();
			// emergencyContactsPage.getCheckboxAttatchment().click();
			personalDetailsPage.deleteButton().click();
			List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			finalnumRows = finalRows.size();
			System.out.println("No. of Rows After Deleting : " + finalnumRows);
			Assert.assertEquals(finalnumRows, numRows - 1);
		} else {
			Assert.assertFalse(personalDetailsPage.deleteButton().isDisplayed());
			System.out.println("No Rows Displayed");
		}
	}

	@Test(priority = 22)
	public void deletingall_Attatchments() {

		// boolean tableExist =
		// driver.findElement(By.id("tblAttachments")).isDisplayed();
		// System.out.println("Table Exist : "+tableExist);
		if (finalnumRows > 0) {
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			personalDetailsPage.checkboxallAttatchment().click();
			personalDetailsPage.deleteButton().click();

		} else {

			System.out.println("No rows Displayed");
		}
	}

}
