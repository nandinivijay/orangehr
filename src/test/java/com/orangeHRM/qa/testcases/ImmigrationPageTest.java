
package com.orangeHRM.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import com.orangeHRM.qa.pages.ImmigrationPage;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.AttatchmentsUtil;
import com.orangeHRM.qa.util.ColorValidationUtil;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class ImmigrationPageTest extends BaseClass {
	BaseVerification baseVerification;
	MyInfoPage myInfoPage;
	ImmigrationPage immigrationPage;
	WebElement element;

	@BeforeClass
	public void verifyImmigrationPageNavigation() {

		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		immigrationPage = myInfoPage.navigatingToImmigration();
		System.out.println("Clicked Immigrations and url is validated");
	}

	@Test(priority = 3)
	public void validateImmigationsButton_bgcolor() {
		try {

			// details button bg-color- grey
			element = myInfoPage.getImmigration_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("Immigration button bg-color is validated after clicking---grey");

		} catch (AssertionError ae) {
			System.out.println("In Immigration Testing--validateImmigationsButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In Immigration--validateImmigationsButton_bgcolor :" + we.getMessage());
		}

	}

	@Test(priority = 4)
	public void colorValidationForAddandDeleteButtons() {
		String addhex = ColorValidationUtil.GetColor(immigrationPage.clickonAddButton());
		System.out.println("add button colur" + addhex);
		String deletehex = ColorValidationUtil.GetColor(immigrationPage.clickOnDeleteButton());
		System.out.println("deletebutton colur" + deletehex);
		Assert.assertEquals(addhex, "Green");
		Assert.assertEquals(deletehex, "Red");
		Assert.assertNotEquals(addhex, deletehex);
		System.out.println("add and delete button colors are different");

	}

	/*
	 * @Test(priority = 5) public void mandatoryFieldValidation() {
	 * immigrationPage.clickonAddButton().click();
	 * immigrationPage.savebutton().click(); boolean flag; if
	 * (immigrationPage.enterNumber().getAttribute("value").isEmpty()) { flag =
	 * true; System.out.println("Number Field Is Empty"); } else {
	 * System.out.println("Number Field Is Not Empty"); flag = false; }
	 * Assert.assertTrue(flag);
	 * System.out.println("All Mandatory Fields Are Tested Successfully"); //
	 * driver.quit(); }
	 * 
	 */

	@Test(priority = 6)
	public void setcontext(ITestContext context) {
		int sheetnumber = 11;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 7)

	public void verifyimmigrationTestPage(String number, String issuemonth, String issuedate, String issueyear,
			String expmonth, String expdate, String expyear, String status, String issuedby, String eligiblemonth,
			String eligibledate, String eligibleyear, String cmts) throws Exception {
		Thread.sleep(5000);
		immigrationPage.clickonAddButton().click();
		System.out.println("Add Button Clicked");
		immigrationPage.clickOnVisaradiobtn();
		System.out.println("After radio button click");
		System.out.println("Number : " + number);
		immigrationPage.enterNumber().sendKeys(number);
		immigrationPage.issueDate().click();
		// int issuedate=30;

		DropDownUtil.selectbyvalue(immigrationPage.selmonth(), issuemonth);
		DropDownUtil.selectbyvalue(immigrationPage.selbyYear(), issueyear);
		driver.findElement(
				By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text()," + issuedate + ")]"))
				.click();

		immigrationPage.expireDate().click();

		// int expdate=25;

		DropDownUtil.selectbyvalue(immigrationPage.selmonth(), expmonth);
		DropDownUtil.selectbyvalue(immigrationPage.selbyYear(), expyear);
		driver.findElement(
				By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text()," + expdate + ")]")).click();
		immigrationPage.eligibleStatus().sendKeys(status);

		DropDownUtil.selectbyvalue(immigrationPage.issuedBy(), issuedby);
		immigrationPage.eligiblityReviewDate().click();
		// int eligibledate=14;
		DropDownUtil.selectbyvalue(immigrationPage.selmonth(), eligiblemonth);
		DropDownUtil.selectbyvalue(immigrationPage.selbyYear(), eligibleyear);

		driver.findElement(
				By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text()," + eligibledate + ")]"))
				.click();
		immigrationPage.comments().sendKeys(cmts);
		Thread.sleep(5000);

		immigrationPage.savebutton().click();

	}

	@Test(priority = 8)
	public void tableValidating() {
		List<WebElement> li = driver.findElements(By.xpath("//table[@class='table hover']/thead/tr/th"));
		int n = li.size();
		List<String> s = new ArrayList<String>();
		System.out.println("size of Columns : " + n);
		for (int i = 0; i < n; i++) {
			s.add(li.get(i).getText());
		}

		System.out.println("List String : " + s);
		System.out.println("No . of columns in a table are : " + n);
		Assert.assertEquals(6, n);

		for (int i = 1; i <= n - 1; i++) {
			WebElement header = driver
					.findElement(By.xpath("//table[@class='table hover']/thead/tr/th[" + (i + 1) + "]"));
			System.out.print(header.getText());
			if (header.getText().equalsIgnoreCase("Document")) {
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Document"));
			} else if (header.getText().equalsIgnoreCase("Number")) {
				System.out.println(": is  in the header ");
				Assert.assertTrue(header.getText().contains("Number"));
			} else if (header.getText().equalsIgnoreCase("Issued By")) {
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Issued By"));
			} else if (header.getText().equalsIgnoreCase("Issued Date")) {
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Issued Date"));
			} else if (header.getText().equalsIgnoreCase("Expiry Date")) {
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Expiry Date"));
			}
		}
	}

	@Test(priority = 9)
	public void verifyissueDateFormat() throws Exception {
		driver.findElement(By.xpath("//*[@id='frmImmigrationDelete']/table/tbody/tr/td[2]/a")).click();
		String issueDate = immigrationPage.issueDate().getAttribute("value");
		System.out.println("Here is Issued Date Value: " + issueDate);
		StringBuffer sBuffer = new StringBuffer(issueDate);
		String date, month, year;
		boolean flag;
		year = sBuffer.substring(0, 4);
		month = sBuffer.substring(5, 7);
		date = sBuffer.substring(8, 10);
		System.out.println("Year:" + year + " Mon:" + month + " Date:" + date);

		if (year.matches("^[12][0-9]{3}$") && month.matches("^(0?[1-9]|1[012])$")
				&& date.matches("^(0[1-9]|[12]\\d|3[01])$")) {
			System.out.println("Issued Date Format Matched.");
			flag = true;
		} else {
			System.out.println("Issued Date Format Didn't Matched.");
			flag = false;
		}
		Assert.assertTrue(flag);
		Thread.sleep(2000);
	}

	@Test(priority = 10)
	public void dropdownSortedOrNot() {
		// immigrationPage.clickonAddButton().click();
		WebElement element = driver.findElement(By.xpath("//select[@name='immigration[country]']"));
		Select sel = new Select(element);
		ArrayList<String> originalList = new ArrayList<String>();

		for (WebElement e : sel.getOptions()) {
			originalList.add(e.getText());
		}
		System.out.println("OriginalList:" + originalList);
		ArrayList<String> tempList = originalList;
		Collections.sort(tempList);

		System.out.println("OriginalList:" + originalList);
		System.out.println("TempList:" + tempList);
		Assert.assertEquals(originalList, tempList);
		System.out.println("OriginalList and TempList Dropdowns are in sorted order ");
		immigrationPage.cancelbutton().click();

	}

	@Test(priority = 11)
	public void setcontext3(ITestContext context) {
		int sheetnumber = 17;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 12, dependsOnMethods = {
			"verifyimmigrationTestPage" })
	public void editImmigrationTesting(String number1, String issuemonth1, String issuedate1, String issueyear1,
			String expmonth1, String expdate1, String expyear1, String status1, String issuedby1, String eligiblemonth1,
			String eligibledate1, String eligibleyear1, String cmts1) throws Exception {
		System.out.println("Immigration Page clicked");

		SynchronisationWaitsUtil.implicitwait(12, TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Immigration : " + immigrationPage.getcurrentUrl());

		driver.findElement(By.xpath("//*[@id='frmImmigrationDelete']/table/tbody/tr/td[2]/a")).click();

		immigrationPage.clickOnVisaradiobtn();
		System.out.println("After radio button click");
		SynchronisationWaitsUtil.threadsleep(2000);
		System.out.println("Number : " + number1);
		immigrationPage.enterNumber().clear();
		immigrationPage.enterNumber().sendKeys(number1);
		immigrationPage.issueDate().click();

		DropDownUtil.selectbyvalue(immigrationPage.selmonth(), issuemonth1);
		DropDownUtil.selectbyvalue(immigrationPage.selbyYear(), issueyear1);
		driver.findElement(
				By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text()," + issuedate1 + ")]"))
				.click();

		immigrationPage.expireDate().click();

		DropDownUtil.selectbyvalue(immigrationPage.selmonth(), expmonth1);
		DropDownUtil.selectbyvalue(immigrationPage.selbyYear(), expyear1);
		driver.findElement(
				By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text()," + expdate1 + ")]"))
				.click();
		immigrationPage.eligibleStatus().clear();
		immigrationPage.eligibleStatus().sendKeys(status1);

		DropDownUtil.selectbytext(immigrationPage.issuedBy(), issuedby1);
		immigrationPage.eligiblityReviewDate().click();
		DropDownUtil.selectbyvalue(immigrationPage.selmonth(), eligiblemonth1);
		DropDownUtil.selectbyvalue(immigrationPage.selbyYear(), eligibleyear1);

		driver.findElement(
				By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text()," + eligibledate1 + ")]"))
				.click();
		immigrationPage.comments().clear();
		immigrationPage.comments().sendKeys(cmts1);
		immigrationPage.savebutton().click();

		SynchronisationWaitsUtil.threadsleep(2000);
		String num = driver.findElement(By.xpath("//*[@id=\"frmImmigrationDelete\"]/table/tbody/tr[1]/td[3]"))
				.getText();

		System.out.println("Number : " + num + "number1 " + number1);
		// Assert.assertEquals(num, number1);
		System.out.println("Number Edited Successfully");

		String issuedBy = driver.findElement(By.xpath("//*[@id=\"frmImmigrationDelete\"]/table/tbody/tr[1]/td[4]"))
				.getText();
		Assert.assertEquals(issuedBy, issuedby1);
		System.out.println("issuedby Edited Successfully");

		int im = Integer.parseInt(issuemonth1) + 1;
		String i;
		if (im < 10) {
			i = 0 + "" + String.valueOf(im);
		} else {
			i = String.valueOf(im);
		}
		String idate = issueyear1 + "-" + i + "-" + issuedate1;
		String issuedate = driver.findElement(By.xpath("//*[@id=\"frmImmigrationDelete\"]/table/tbody/tr[1]/td[5]"))
				.getText();

		Assert.assertEquals(idate, issuedate);
		System.out.println("issue date Edited Successfully");
		int em = Integer.parseInt(expmonth1) + 1;
		String e;
		if (em < 10) {
			e = 0 + "" + String.valueOf(em);
		} else {
			e = String.valueOf(em);
		}
		String edate = expyear1 + "-" + e + "-" + expdate1;
		String expirydate = driver.findElement(By.xpath("//*[@id=\"frmImmigrationDelete\"]/table/tbody/tr[1]/td[6]"))
				.getText();
		Assert.assertEquals(edate, expirydate);
		System.out.println("expiry date Edited Successfully");

	}

	@Test(priority = 13)
	public void deletingSingle_ImmigrationRec() throws Exception {

		if (immigrationPage.clickOnDeleteButton().isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='frmImmigrationDelete']/table/tbody/tr/td[1]/input")).click();
			immigrationPage.clickOnDeleteButton().click();
			;
		} else {
			System.out.println("No Rows Displayed");
		}
	}

	@Test(priority = 14)
	public void deletingall_ImmigrationRec() {
		String msg = driver.findElement(By.xpath("//*[@id='frmImmigrationDelete']/table/tbody/tr/td[2]")).getText();
		if (msg.equals("No Records Found")) {
			System.out.println("No Rows To Delete");
		} else {
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='frmImmigrationDelete']/tbody/tr"));

			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			immigrationPage.checkboxallImmigrant().click();
			immigrationPage.clickOnDeleteButton().click();

		}

	}

	@Test(priority = 15)
	public void setcontext1(ITestContext context) {
		int sheetnumber = 7;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 16)
	public void immigrationAttatchmentTesting(String cmt) throws Exception {
		System.out.println("Personal Details Page clicked");
		driver.manage().window().maximize();
		SynchronisationWaitsUtil.implicitwait(12, TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Personal Details : " + immigrationPage.getcurrentUrl());
		immigrationPage.addButton().click();

		SynchronisationWaitsUtil.threadsleep(2000);
		WebElement ele = immigrationPage.chooseFile();
		AttatchmentsUtil.uploadingFileUsingRobot(ele, driver, "smallbird.jpg");

		immigrationPage.commentsatch().sendKeys(cmt);
		SynchronisationWaitsUtil.threadsleep(5000);
		immigrationPage.upload().click();
		System.out.println("Attatchment File Uploaded");
	}

	@Test(priority = 17)
	public void colorOfButtons() {

		WebElement addBtn = immigrationPage.addButton();
		String color = ColorValidationUtil.GetColor(addBtn);
		Assert.assertEquals("Green", color);
		WebElement delBtn = immigrationPage.deleteButton();
		String color2 = ColorValidationUtil.GetColor(delBtn);
		Assert.assertEquals("Red", color2);

	}

	@Test(priority = 18)
	public void tableHeaderValidation() {

		AttatchmentsUtil.validatingTableHeader(driver);
	}

	@Test(priority = 19)
	public void toolTipValidation() {

		WebElement element = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
		AttatchmentsUtil.toolTipValidation(element, driver);

	}

	@Test(priority = 20)
	public void clickingOnEditLink() throws Exception {

		immigrationPage.editLinkClick().click();
		SynchronisationWaitsUtil.threadsleep(3000);
		String str = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a")).getText();
		System.out.println("Current file : " + str);// *[@id="tblAttachments"]/tbody/tr/td[2]/a
		// Assert.assertTrue(driver.findElement(By.id("currentFileLi")).isDisplayed());
		System.out.println("Current File : " + driver.findElement(By.id("currentFileSpan")).getText().contains(str));
		WebElement element = immigrationPage.chooseFile();
		String fname = "smallbird1.jpg";
		AttatchmentsUtil.editFileLink(fname, driver, element);
		SynchronisationWaitsUtil.threadsleep(3000);

	}

	@Test(priority = 21)
	public void example_VerifyDownloadWithFileName() throws Exception {
		WebElement element = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
		AttatchmentsUtil.verifyDownloadWithFileName(element);
	}

	int finalnumRows;

	@Test(priority = 22)
	public void deletingSingle_Attatchment() {
		// driver.findElement(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr/td[1]/input")).click();
		if (immigrationPage.deleteButton().isDisplayed())
//				if (Assert.assertTrue(emergencyContactsPage.deleteButton().isDisplayed())
		{
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tblAttachments']/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr[1]/td[1]/input")).click();
			// emergencyContactsPage.getCheckboxAttatchment().click();
			immigrationPage.deleteButton().click();
			List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			finalnumRows = finalRows.size();
			System.out.println("No. of Rows After Deleting : " + finalnumRows);
			Assert.assertEquals(finalnumRows, numRows - 1);
		} else {
			Assert.assertFalse(immigrationPage.deleteButton().isDisplayed());
			System.out.println("No Rows Displayed");
		}
	}

	@Test(priority = 23)
	public void deletingall_Attatchments() {

		if (finalnumRows > 0) {
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			immigrationPage.checkboxallAttatchment().click();
			immigrationPage.deleteButton().click();

		} else {

			System.out.println("No rows Displayed");
		}
	}

}
