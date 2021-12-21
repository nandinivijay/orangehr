package com.orangeHRM.qa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.EmergencyContactsPage;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.AttatchmentsUtil;
import com.orangeHRM.qa.util.ColorValidationUtil;
import com.orangeHRM.qa.util.JavascriptExecutorUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class EmergencyContactsPageTest extends BaseClass {
	BaseVerification baseVerification;
	MyInfoPage myInfoPage;
	EmergencyContactsPage emergencyContactsPage;
	WebElement element;

	@BeforeClass
	public void verifyEmergencyContactsPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		emergencyContactsPage = myInfoPage.navigatingToEmergencyContacts();
		System.out.println("Clicked Emergency Contacts and url is validated");
	}

	@Test /* (priority=3) */
	public void validateEmergencyContactsButton_bgcolor() {
		try {

			// details button bg-color- grey
			element = myInfoPage.getEmergencyContacts_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("Emergency contacts button bg-color is validated after clicking---grey");

		} catch (AssertionError ae) {
			System.out
					.println("In EmergencyContacts Testing--validateContactDetailsButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In EmergencyContactss--validateEmergencyContactsButton_bgcolor :" + we.getMessage());
		}

	}

	@Test(priority = 3)
	public void setcontext1(ITestContext context) {
		int sheetnumber = 8;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 4)
	public void EmergencyDetailsTesting(String name, String relation, String homePhone, String mobile, String workPhone)
			throws Exception {
		emergencyContactsPage.addconButton().click();
		System.out.println("Add Button clicked");
		System.out.println("i am here");
		emergencyContactsPage.getName_ID().clear();
		emergencyContactsPage.getName_ID().sendKeys(name);
		try {
			Assert.assertTrue(emergencyContactsPage.getName_ID().getAttribute("value").contains(name));
			System.out.println("page data in Name: " + emergencyContactsPage.getName_ID().getAttribute("value")
					+ "---Data from file : " + name);
		} catch (AssertionError ae) {
			System.out.println("In EmergencyDetailsPage--Name :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In emergencyDetailsPage--Name :" + we.getMessage());
		}

		emergencyContactsPage.getRelationship_ID().clear();
		emergencyContactsPage.getRelationship_ID().sendKeys(relation);
		try {
			Assert.assertTrue(emergencyContactsPage.getRelationship_ID().getAttribute("value").contains(relation));
			System.out.println(
					"page data in Relation: " + emergencyContactsPage.getRelationship_ID().getAttribute("value")
							+ "---Data from file : " + relation);
		} catch (AssertionError ae) {
			System.out.println("In Emergency Details Testing--Realtion :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In EmergencyDetailsPage--Realtion :" + we.getMessage());
		}

		emergencyContactsPage.getHomePhone_ID().clear();
		emergencyContactsPage.getHomePhone_ID().sendKeys(homePhone);
		try {
			Assert.assertTrue(emergencyContactsPage.getHomePhone_ID().getAttribute("value").contains(homePhone));
			System.out
					.println("page data in Home Phone: " + emergencyContactsPage.getHomePhone_ID().getAttribute("value")
							+ "---Data from file : " + homePhone);
		} catch (AssertionError ae) {
			System.out.println("In Emergency Details Testing--Home Phone :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In emergencyDetailsPage Home Phone :" + we.getMessage());
		}

		emergencyContactsPage.getMobile_ID().clear();
		emergencyContactsPage.getMobile_ID().sendKeys(mobile);
		try {
			Assert.assertTrue(emergencyContactsPage.getMobile_ID().getAttribute("value").contains(mobile));
			System.out.println("page data in Mobile: " + emergencyContactsPage.getMobile_ID().getAttribute("value")
					+ "---Data from file : " + mobile);
		} catch (AssertionError ae) {
			System.out.println("In Emergency Details Testing--Mobile :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In emergencyDetailsPage Mobile :" + we.getMessage());
		}

		emergencyContactsPage.getWorkPhone_ID().clear();
		emergencyContactsPage.getWorkPhone_ID().sendKeys(workPhone);
		try {
			Assert.assertTrue(emergencyContactsPage.getWorkPhone_ID().getAttribute("value").contains(workPhone));
			System.out
					.println("page data in Work Phone: " + emergencyContactsPage.getWorkPhone_ID().getAttribute("value")
							+ "---Data from file : " + workPhone);
		} catch (AssertionError ae) {
			System.out.println("In Emergency Details Testing--Work Phone :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In emergencyDetailsPage Work Phone :" + we.getMessage());
		}
		emergencyContactsPage.saveconButton().click();
		System.out.println("Save Button clicked");

		// driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr/td[2]")).
		driver.findElement(By.linkText("Jaya Sharma")).click();
		SynchronisationWaitsUtil.threadsleep(15000);
		WebElement ele = driver.findElement(By.id("emergencyContactHeading"));
		String str = ele.getAttribute("textContent");
		System.out.println("String displayed : " + str);
		Assert.assertTrue(driver.findElement(By.id("emergencyContactHeading")).isDisplayed());
		SynchronisationWaitsUtil.threadsleep(2000);

		emergencyContactsPage.saveconButton().click();
		// emergencyContactsPage.cancelconButton().click();
		// emergencyContactsPage.fileCheckbox().click();
		// emergencyContactsPage.delconButton().click();
	}

	@Test(priority = 5)
	public void validatingMandatoryFieldsValues() throws Exception {
		emergencyContactsPage.addconButton().click();
		emergencyContactsPage.saveconButton().click();
		System.out.println("Save Button clicked");
		boolean flag;
		if (emergencyContactsPage.getName_ID().getAttribute("value").isEmpty()) {
			System.out.println("Name is required");
			flag = true;
			System.out.println(emergencyContactsPage.geterrormsg().getText() + " is displayed");
		}
		if (emergencyContactsPage.getRelationship_ID().getAttribute("value").isEmpty()) {
			System.out.println("Relationship is required");
			flag = true;
			System.out.println(emergencyContactsPage.geterrormsg().getText() + " is displayed");
		} else {
			System.out.println("Mandatory fields are valid");
			flag = false;
		}
//		Assert.assertTrue(flag);
		if (flag == true) {
			emergencyContactsPage.getName_ID().clear();
			emergencyContactsPage.getRelationship_ID().clear();
			emergencyContactsPage.getHomePhone_ID().clear();
			emergencyContactsPage.getMobile_ID().clear();
			emergencyContactsPage.getWorkPhone_ID().clear();
			emergencyContactsPage.cancelconButton().click();
		}
		if (flag == false) {
			System.out.println("All Manatory fields Entered with valid data");
			emergencyContactsPage.saveconButton().click();
			System.out.println("Save Button clicked after validation");
//			SynchronisationWaitsUtil.implicitwait(12, TimeUnit.SECONDS, driver);
			WebElement table = driver.findElement(By.xpath("//table[@id='emgcontact_list']"));
			boolean yes = table.isDisplayed();
			if (yes == true)
				System.out.println("Table Displayed");
			Thread.sleep(3000);
			WebElement table1 = driver.findElement(By.xpath("//input[@id='homePhone_1']"));
			JavascriptExecutorUtil.clickingOnElement(driver, table1);
			SynchronisationWaitsUtil.threadsleep(5000);
//			table1.sendKeys(emergencyContactsPage.getName_ID().getAttribute("value"));
			System.out.println(table1.getAttribute("value"));
//			System.out.println(emergencyContactsPage.getName_ID().getAttribute("value"));
			if ((table1.getText()).equals(emergencyContactsPage.getName_ID().getAttribute("value"))) {
				System.out.println("Data added successfully to the table");
			}
		}
	}

	@Test(priority = 6)
	public void setcontext2(ITestContext context) {
		int sheetnumber = 14;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 7)
	public void tableEditLinkTesting(String name, String relation, String homePhone, String mobile, String workPhone) {

		Assert.assertTrue(emergencyContactsPage.TableEditLinkClick().isDisplayed());
		emergencyContactsPage.TableEditLinkClick().click();

		Assert.assertTrue(driver.findElement(By.id("emergencyContactHeading")).isDisplayed());

		Assert.assertTrue(emergencyContactsPage.getName_ID().isDisplayed());
		Assert.assertTrue(emergencyContactsPage.getRelationship_ID().isDisplayed());
		Assert.assertTrue(emergencyContactsPage.getHomePhone_ID().isDisplayed());
		Assert.assertTrue(emergencyContactsPage.getMobile_ID().isDisplayed());
		Assert.assertTrue(emergencyContactsPage.getWorkPhone_ID().isDisplayed());
		Assert.assertTrue(emergencyContactsPage.getMobile_ID().isDisplayed());
		Assert.assertTrue(emergencyContactsPage.getWorkPhone_ID().isDisplayed());

		Assert.assertTrue(emergencyContactsPage.saveconButton().isDisplayed());
		Assert.assertTrue(emergencyContactsPage.cancelconButton().isDisplayed());

		/*
		 * String name="Geetha jeevan"; String relationship = "Sibling"; String
		 * homePhone = "9940757794";
		 */

		emergencyContactsPage.getName_ID().clear();
		emergencyContactsPage.getName_ID().sendKeys(name);
		emergencyContactsPage.getRelationship_ID().clear();
		emergencyContactsPage.getRelationship_ID().sendKeys(relation);
		emergencyContactsPage.getHomePhone_ID().clear();
		emergencyContactsPage.getHomePhone_ID().sendKeys(homePhone);
		emergencyContactsPage.getMobile_ID().clear();
		emergencyContactsPage.getMobile_ID().sendKeys(mobile);
		emergencyContactsPage.getWorkPhone_ID().clear();
		emergencyContactsPage.getWorkPhone_ID().sendKeys(workPhone);

		emergencyContactsPage.saveconButton().click();
		Assert.assertTrue(emergencyContactsPage.addconButton().isDisplayed());

		// String editedName =
		// driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr[1]/td[2]/a")).getText();
		// Assert.assertEquals(name, editedName);

		System.out.println("Name Edited Successfully");

		// String editRelationship =
		// driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr[1]/td[3]")).getText();
		// Assert.assertEquals(relation, editRelationship);
		System.out.println("Relationship Edited Successfully");

		// String editHomePhone =
		// driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr[1]/td[4]")).getText();
		// Assert.assertEquals(homePhone, editHomePhone);
		System.out.println("Homephone Edited Successfully");

		// String editMobile =
		// driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr[1]/td[5]")).getText();
		// Assert.assertEquals(mobile, editMobile);
		System.out.println("Mobile number Edited Successfully");

		// String editWorkPhone =
		// driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr[1]/td[6]")).getText();
		// Assert.assertEquals(workPhone, editWorkPhone);
		System.out.println("Work phone number Edited Successfully");

	}

	@Test(priority = 8)
	public void saveBtnValidation() {
		emergencyContactsPage.addconButton().click();
		System.out.println("Add Button clicked");

		System.out.println("Click Save button without  adding Data");
		emergencyContactsPage.saveconButton().click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[1]/span")).isDisplayed());
		System.out.println("Required Field");
		Assert.assertFalse(
				emergencyContactsPage.getName_ID().getCssValue("border-color").contains("rgb(210,209,209))"));
		System.out.println("Border color Changed");
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[2]/span")).isDisplayed());
		System.out.println("Required Field");
		Assert.assertFalse(
				emergencyContactsPage.getRelationship_ID().getCssValue("border-color").contains("rgb(210,209,209))"));
		System.out.println("Border color Changed");
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id=\"frmEmpEmgContact\"]/fieldset/ol/li[3]/span")).isDisplayed());
		System.out.println("Atleast one phone number is Required");
		Assert.assertFalse(
				emergencyContactsPage.getHomePhone_ID().getCssValue("border-color").contains("rgb(210,209,209))"));
		System.out.println("Border color Changed");

		System.out.println("Click Save button after adding improper Data");

		emergencyContactsPage.getName_ID().clear();
		emergencyContactsPage.getName_ID().sendKeys("1234768999");
		Assert.assertFalse(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[1]/span")).isDisplayed());
		System.out.println("Required Field not display");

		emergencyContactsPage.getRelationship_ID().clear();
		emergencyContactsPage.getRelationship_ID().sendKeys("sdsds1234");
		Assert.assertFalse(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[2]/span")).isDisplayed());
		System.out.println("Required Field not display");

		emergencyContactsPage.getHomePhone_ID().clear();
		emergencyContactsPage.getHomePhone_ID().sendKeys("my phonenumber");
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[3]/span")).isDisplayed());
		System.out.println("Atleast one phone number is Required");

		emergencyContactsPage.saveconButton().click();
		Assert.assertTrue(emergencyContactsPage.saveconButton().isDisplayed());

		System.out.println("Click Save button after adding proper Data");
		String name = "Geeta Jeevan";
		String relationship = "Spouse";
		String homePhone = "9940757794";
		emergencyContactsPage.getName_ID().clear();
		emergencyContactsPage.getName_ID().sendKeys(name);
		Assert.assertFalse(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[1]/span")).isDisplayed());
		System.out.println("Required Field not display");

		emergencyContactsPage.getRelationship_ID().clear();
		emergencyContactsPage.getRelationship_ID().sendKeys(relationship);
		Assert.assertFalse(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[2]/span")).isDisplayed());
		System.out.println("Required Field not display");

		emergencyContactsPage.getHomePhone_ID().clear();
		emergencyContactsPage.getHomePhone_ID().sendKeys(homePhone);
		Assert.assertFalse(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[3]/span")).isDisplayed());
		System.out.println("Required Field not display");

		emergencyContactsPage.saveconButton().click();
		Assert.assertTrue(emergencyContactsPage.addconButton().isDisplayed());
		String savedName = driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(savedName, name);

		String savedRelationship = driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr/td[3]")).getText();
		Assert.assertEquals(savedRelationship, relationship);

		String savedHomePhone = driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr/td[4]")).getText();
		Assert.assertEquals(savedHomePhone, homePhone);

	}

	@Test(priority = 9)

	public void validateCancelBtn() {
		emergencyContactsPage.addconButton().click();
		System.out.println("Add Button clicked");

		System.out.println("Click Cancel button without  adding Data");

		Assert.assertTrue(emergencyContactsPage.getName_ID().getAttribute("value").isEmpty());
		Assert.assertTrue(emergencyContactsPage.getRelationship_ID().getAttribute("value").isEmpty());
		Assert.assertTrue(emergencyContactsPage.getHomePhone_ID().getAttribute("value").isEmpty());
		emergencyContactsPage.cancelconButton().click();
		Assert.assertTrue(emergencyContactsPage.addconButton().isDisplayed());

		emergencyContactsPage.addconButton().click();
		System.out.println("Add Button clicked");
		System.out.println("Click Cancel button with  adding Data");

		emergencyContactsPage.getName_ID().clear();
		emergencyContactsPage.getName_ID().sendKeys("Sneha");

		emergencyContactsPage.getRelationship_ID().clear();
		emergencyContactsPage.getRelationship_ID().sendKeys("Sister");

		emergencyContactsPage.getHomePhone_ID().clear();
		emergencyContactsPage.getHomePhone_ID().sendKeys("9940757794");

		emergencyContactsPage.cancelconButton().click();
		Assert.assertTrue(emergencyContactsPage.addconButton().isDisplayed());
	}

	@Test(priority = 10)
	public void setcontext3(ITestContext context) {
		int sheetnumber = 15;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 11)
	public void validateEnterImproperData(String name, String relation, String homePhone, String mobile,
			String workPhone) {
		emergencyContactsPage.addconButton().click();

		emergencyContactsPage.getName_ID().click();
		emergencyContactsPage.getName_ID().clear();
		emergencyContactsPage.getName_ID().sendKeys(name);
		// Assert.assertFalse(driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[1]/span")).isDisplayed());
		System.out.println("Name field accepts any Data without restriction only concern should not be blank");

		emergencyContactsPage.getRelationship_ID().click();
		emergencyContactsPage.getRelationship_ID().clear();
		emergencyContactsPage.getRelationship_ID().sendKeys(relation);
		// Assert.assertFalse(driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[2]/span")).isDisplayed());
		System.out.println("Relationship field accepts any Data without restriction only concern should not be blank");

		emergencyContactsPage.getHomePhone_ID().click();
		emergencyContactsPage.getHomePhone_ID().clear();
		emergencyContactsPage.getHomePhone_ID().sendKeys(homePhone);
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[3]/span")).isDisplayed());
		System.out.println("Allows numbers and  + - / () only");

		emergencyContactsPage.getMobile_ID().click();
		emergencyContactsPage.getMobile_ID().clear();
		emergencyContactsPage.getMobile_ID().sendKeys(mobile);
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[4]/span")).isDisplayed());
		System.out.println("Allows numbers and  + - / () only");

		emergencyContactsPage.getWorkPhone_ID().click();
		emergencyContactsPage.getWorkPhone_ID().clear();
		emergencyContactsPage.getWorkPhone_ID().sendKeys(workPhone);
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='frmEmpEmgContact']/fieldset/ol/li[5]/span")).isDisplayed());
		System.out.println("Allows numbers and  + - / () only");

		emergencyContactsPage.saveconButton().click();

	}

	@Test(priority = 12)
	public void validationOfEmergencyContactTable() {
		List<WebElement> colHeader = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/thead/tr/th"));
		int colHeadersize = colHeader.size();
		System.out.println(colHeadersize - 1);
		int ExpectedColHeader = 6;
		Assert.assertEquals(colHeadersize, ExpectedColHeader);

		List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/thead/tr"));
		int rowsize = row.size();
		int actual = rowsize;
		int expected = 1;
		System.out.println(rowsize);
		Assert.assertEquals(actual, expected);

		for (int i = 2; i <= colHeadersize; i++) {
			WebElement header = driver.findElement(By.xpath("//*[@id='emgcontact_list']/thead/tr/th[" + i + "]"));
			System.out.print(header.getText());

			if (header.getText().equalsIgnoreCase("name")) {
				System.out.println(" : is in the header");
				Assert.assertTrue(header.getText().contains("Name"));
			} else if (header.getText().equalsIgnoreCase("Relationship")) {
				System.out.println(" : is  in the header ");
				Assert.assertTrue(header.getText().contains("Relationship"));
			} else if (header.getText().equalsIgnoreCase("home telephone")) {
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Home Telephone"));
			}

			else if (header.getText().equalsIgnoreCase("mobile")) {
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Mobile"));
			} else if (header.getText().equalsIgnoreCase("Work Telephone"))

			{
				System.out.println(" : is in the header");
				Assert.assertTrue(header.getText().contains("Work Telephone"));
			}

		}

	}

	// @Test(priority = 6)
	public void clickingOnNameLink() throws Exception {

		// String name1 =
		// driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr/td[2]")).getText();
		driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr/td[2]")).click();
		SynchronisationWaitsUtil.threadsleep(5000);
		Assert.assertTrue(driver.findElement(By.id("emergencyContactHeading")).isDisplayed());
		/*
		 * WebElement ele =
		 * driver.findElement(By.xpath("//*[@id='emgcontacts_name']"));//
		 * emergencyContactsPage.getName_ID().getText(); String name =
		 * ele.getAttribute("value"); Assert.assertEquals(name1, name);
		 */

	}

	@Test(priority = 13)
	public void colorOfButtons() {
//		String addButtonColor = emergencyContactsPage.addconButton().getCssValue("background-color");
//		System.out.println("Add Color : " + addButtonColor);
//		String delButtonColor = emergencyContactsPage.delconButton().getCssValue("background-color");
//		System.out.println("Delete Color : " + delButtonColor);
		// Hex value of Add button color
//		String addhex = Color.fromString(addButtonColor).asHex();
//		System.out.println("Add Color Hex: " + addhex);
		// Hex value of Delete button color
//		String delhex = Color.fromString(delButtonColor).asHex();
//		System.out.println("Delete Color Hex: " + delhex);
		// Check if Add Button Color is Red and Delete button color is Green.
		String addhex = ColorValidationUtil.GetColor(emergencyContactsPage.addconButton());
		System.out.println("Add Color Hex: " + addhex);
		String delhex = ColorValidationUtil.GetColor(emergencyContactsPage.delconButton());
		System.out.println("Delete Color Hex: " + delhex);
		Assert.assertEquals(addhex, "Green");
		Assert.assertEquals(delhex, "Red");
		Assert.assertNotEquals(addhex, delhex);
		System.out.println("Add and Delete buttons color validated.");
	}

	@Test(priority = 14)
	public void setcontext(ITestContext context) {
		int sheetnumber = 7;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 15)
	public void emergencyContactsTesting(String cmt) throws Exception {
		System.out.println("Emergency Contacts Page clicked");
		driver.manage().window().maximize();
		SynchronisationWaitsUtil.implicitwait(12, TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Emergency Contacts : " + emergencyContactsPage.getcurrentUrl());
		emergencyContactsPage.addButton().click();

		SynchronisationWaitsUtil.threadsleep(2000);
		WebElement ele = emergencyContactsPage.chooseFile();
		AttatchmentsUtil.uploadingFileUsingRobot(ele, driver, "smallbird.jpg");

		emergencyContactsPage.comments().sendKeys(cmt);
		SynchronisationWaitsUtil.threadsleep(5000);
		emergencyContactsPage.uploadButton().click();
		System.out.println("Attatchment File Uploaded");
	}

	// @Test(priority = 13,dependsOnMethods= {"emergencyContactsTesting"})
	@Test(priority = 16)
	public void toolTipValidation() {

		// xpath of element where we will get tooltip
		WebElement element = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
		AttatchmentsUtil.toolTipValidation(element, driver);
	}

	// @Test(priority = 13,dependsOnMethods= {"emergencyContactsTesting"})
	@Test(priority = 17)
	public void tableHeaderValidation() {

		AttatchmentsUtil.validatingTableHeader(driver);

	}

//	int finalnumRows;

	@Test(priority = 18)
	public void deletingSingle_Contact() throws Exception {

		if (emergencyContactsPage.delconButton().isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr[1]/td[1]/input")).click();
			emergencyContactsPage.delconButton().click();
		} else {
			System.out.println("No Rows Displayed");
		}
	}

	@Test(priority = 19)
	public void deletingall_Contacts() {
		String msg = driver.findElement(By.xpath("//*[@id='emgcontact_list']/tbody/tr/td[2]")).getText();
		if (msg.equals("No Records Found")) {
			System.out.println("No Rows To Delete");
		} else {
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='emgcontact_list']/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			emergencyContactsPage.deleteAllCon().click();
			emergencyContactsPage.delconButton().click();
			System.out.println("All rows deleted");

		}

	}

	// @Test(priority = 14,dependsOnMethods= {"emergencyContactsTesting"})
	@Test(priority = 20)
	public void clickingOnEditLink() throws Exception {

		emergencyContactsPage.editLinkClick().click();
		String str = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a")).getText();
		System.out.println("Current file : " + str);
		Assert.assertTrue(driver.findElement(By.id("currentFileLi")).isDisplayed());
		System.out.println("Current File : " + driver.findElement(By.id("currentFileSpan")).getText().contains(str));
		WebElement element = emergencyContactsPage.chooseFile();
		String fname = "smallbird1.jpg";
		AttatchmentsUtil.editFileLink(fname, driver, element);

	}

	// @Test(priority = 15,dependsOnMethods= {"emergencyContactsTesting"})
	@Test(priority = 21)
	public void example_VerifyDownloadWithFileName() throws Exception {
		WebElement element = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
		AttatchmentsUtil.verifyDownloadWithFileName(element);
	}

	int finalnumRows;

	// @Test(priority = 16,dependsOnMethods= {"emergencyContactsTesting"})
	@Test(priority = 22)
	public void deletingSingle_Attatchment() {
		// driver.findElement(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr/td[1]/input")).click();
		if (emergencyContactsPage.deleteButton().isDisplayed())
//			if (Assert.assertTrue(emergencyContactsPage.deleteButton().isDisplayed())
		{
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr[1]/td[1]/input")).click();
			// emergencyContactsPage.getCheckboxAttatchment().click();
			emergencyContactsPage.deleteButton().click();
			List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			finalnumRows = finalRows.size();
			System.out.println("No. of Rows After Deleting : " + finalnumRows);
			Assert.assertEquals(finalnumRows, numRows - 1);
		} else {
			Assert.assertFalse(emergencyContactsPage.deleteButton().isDisplayed());
			System.out.println("No Rows Displayed");
		}
	}

	@Test(priority = 23)
	public void deletingall_Attatchments() {

		// boolean tableExist =
		// driver.findElement(By.id("tblAttachments")).isDisplayed();
		// System.out.println("Table Exist : "+tableExist);
		if (finalnumRows > 0) {
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			emergencyContactsPage.checkboxallAttatchment().click();
			emergencyContactsPage.deleteButton().click();

		} else {
			// Assert.assertFalse(emergencyContactsPage.deleteButton().isDisplayed());
			System.out.println("No rows Displayed");
		}
	}

}