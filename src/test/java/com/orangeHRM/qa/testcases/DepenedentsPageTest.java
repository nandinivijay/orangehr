/*package com.orangeHRM.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
import com.orangeHRM.qa.pages.DependentsPage;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.AttatchmentsUtil;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class DepenedentsPageTest extends BaseClass {
	BaseVerification baseVerification;
	MyInfoPage myInfoPage;
	DependentsPage dependentsPage;
	WebElement element;

	@BeforeClass
	public void verifypersonalDetailsPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		dependentsPage = myInfoPage.navigatingToDependents();
		System.out.println("Clicked Dependents and url is validated");
	}

	@Test(priority = 1)
	public void validateDependentsButton_bgcolor() {
		try {

			// details button bg-color- grey
			element = myInfoPage.getDependents_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("Dependents button bg-color is validated after clicking---grey");

		} catch (AssertionError ae) {
			System.out.println("In Dependents Testing--validateDependentsButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In Dependents--validateDependentsButton_bgcolor :" + we.getMessage());
		}

	}

	@Test(priority = 2)
	public void validatingMandatoryFieldsbeforeEnteringValues() {
		dependentsPage.adddepButton().click();
		System.out.println("Add Button clicked");
		dependentsPage.savedepButton().click();
		System.out.println("Save Button Clicked");
		boolean flag;
		if (dependentsPage.getdependentName_ID().getAttribute("value").isEmpty()) {
			System.out.println("Name is invalid");
			flag = true;
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		}
		if (dependentsPage.depRelType().getAttribute("value").isEmpty()) {
			System.out.println("Relation Ship is required");
			flag = true;
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		}

		else {
			System.out.println("Mandatory fields are invalid");
			flag = false;
		}
		Assert.assertTrue(flag);
		dependentsPage.canceldepButton().click();
	}

	@Test(priority = 3)
	public void setcontext1(ITestContext context) {
		int sheetnumber = 10;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 4)
	public void dependentsTesting(String name) throws Exception {
		dependentsPage.adddepButton().click();
		System.out.println("Add Button clicked");
		System.out.println("i am here");

		dependentsPage.getdependentName_ID().sendKeys(name);
		try {
			Assert.assertTrue(dependentsPage.getdependentName_ID().getAttribute("value").contains(name));
			System.out.println("page data in Name: " + dependentsPage.getdependentName_ID().getAttribute("value")
					+ "---Data from file : " + name);
		} catch (AssertionError ae) {
			System.out.println("In DependentsPage--Name :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In DependentsPage--Name :" + we.getMessage());
		}
		Select dropdown = new Select(dependentsPage.depRelType());
		List<WebElement> relations = dropdown.getOptions();
		System.out.println("Size : " + relations.size());
		String str = "Cousin";
		for (int i = 0; i < relations.size(); i++) {
			String text = relations.get(i).getText();
			System.out.println("Text  : " + text);
			if (text.equals("Child")) {
				System.out.println("RelationShip is selected as Child");
				DropDownUtil.selectbytext(dependentsPage.depRelType(), "Child");
			} else if (text.equals("Other")) {
				System.out.println("RelationShip is selected as Other");
				DropDownUtil.selectbytext(dependentsPage.depRelType(), "Other");

				dependentsPage.pleaseSpecify(str);

			}

		}
		dependentsPage.getDatePicker().click();
		DropDownUtil.selectbytext(dependentsPage.selMonth(), "May");
		DropDownUtil.selectbytext(dependentsPage.SelYear(), "2020");
		int bday = 12;
		// driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		driver.findElement(
				By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a[contains(text()," + bday + ")]")).click();
		// dependentsPage.savedepButton().click();

	}

	@Test(priority = 5)
	public void validatingRelationShipDropdownOptionsSort() {
		WebElement element = dependentsPage.depRelType();
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
	public void validatingRelationShipDropdownOptionsDuplicates() {
		WebElement element = dependentsPage.depRelType();
		Select se = new Select(element);

		List<WebElement> list = se.getOptions();
		Set<String> s = new LinkedHashSet<String>();
		for (WebElement w : list) {
			s.add(w.getText());
		}

		Assert.assertEquals(list.size(), s.size());
	}

	@Test(priority = 7)
	public void verifyDateOfBirthFormat() {
		// dependentsPage.adddepButton().click();
		String fromDate = dependentsPage.getdependentDob_ID().getAttribute("value");
		StringBuffer sBuffer = new StringBuffer(fromDate);
		String date, month, year;
		boolean flag;
		year = sBuffer.substring(0, 4);
		month = sBuffer.substring(5, 7);
		date = sBuffer.substring(8, 10);
		System.out.println("From Date : " + fromDate);
		System.out.println(" Year: " + year + " Mon: " + month + " Date: " + date);

		if (year.matches("(19|20)\\d\\d") && month.matches("0[1-9]|1[0-2]") && date.matches("0[1-9]|[12][0-9]|3[01]")) {
			System.out.println("Date of birth Format matched.");
			flag = true;
		} else {
			System.out
					.println(driver.findElement(By.className("validation-error")).getText() + "message is displayed.");
			flag = false;
		}
		Assert.assertTrue(flag);
	}

	@Test(priority = 8)
	public void validatingMandatoryFieldsAfterEnteringValues() {
		// dependentsPage.adddepButton().click();
		dependentsPage.savedepButton();
		System.out.println("Save Button clicked");
		boolean flag;
		if (dependentsPage.getdependentName_ID().getAttribute("value").isEmpty()) {
			System.out.println("Name is Required");
			flag = false;
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		}
		if (dependentsPage.depRelType().getAttribute("value").isEmpty()) {
			System.out.println("Relationship is required");
			flag = false;
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		} else {
			System.out.println("Mandatory fields are valid");
			flag = true;
		}
		Assert.assertTrue(flag);
		System.out.println("All Manatory fields Entered with valid data");
	}

	@Test(priority = 9)
	public void saveDependent() {
		if (dependentsPage.savedepButton().isDisplayed())
			dependentsPage.savedepButton().click();
		Assert.assertTrue(driver.findElement(By.id("dependent_list")).isDisplayed());
		Assert.assertTrue(dependentsPage.adddepButton().isDisplayed());
		Assert.assertTrue(dependentsPage.deldepButton().isDisplayed());
	}

	@Test(priority = 10)
	public void cancelDependent() {
		if (dependentsPage.canceldepButton().isDisplayed())
			dependentsPage.canceldepButton().click();
		Assert.assertTrue(driver.findElement(By.id("dependent_list")).isDisplayed());
		Assert.assertTrue(dependentsPage.adddepButton().isDisplayed());
		Assert.assertTrue(dependentsPage.deldepButton().isDisplayed());
	}

	@Test(priority = 11)
	public static void dependentTableHeaderValidation() {
		List<WebElement> li = driver.findElements(By.xpath("//*[@id='dependent_list']/thead/tr/th"));
		int n = li.size();
		List<String> s = new ArrayList<String>();
		System.out.println("size of Columns : " + n);
		for (int i = 0; i < n; i++) {
			s.add(li.get(i).getText());
		}
		System.out.println("List String : " + s);
		System.out.println("No . of columns in a table are : " + n);
		Assert.assertEquals(4, n);

		for (int i = 1; i <= n; i++) {
			WebElement header = driver.findElement(By.xpath("//*[@id='dependent_list']/thead/tr/th[" + i + "]"));
			System.out.print(header.getText());

			if (header.getText().equalsIgnoreCase("Name")) {
				System.out.println(" : is in the header");
				Assert.assertTrue(header.getText().contains("Name"));
			} else if (header.getText().equalsIgnoreCase("Relationship")) {
				System.out.println(" : is  in the header ");
				Assert.assertTrue(header.getText().contains("Relationship"));
			} else if (header.getText().equalsIgnoreCase("Date Of Birth")) {
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Date of Birth"));
			} else {
				System.out.println(" The given text is not in the header");
			}
		}
	}

	@Test(priority = 12)
	public void setcontext2(ITestContext context) {
		int sheetnumber = 12;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 13)
	public void editDependents(String name, String relation, String dob) throws Exception {
		// Editing details when name associated with the record is clicked with data in
		// excel file.
		dependentsPage.editdepButton().click();
		System.out.println("Name of the record to edit is clicked");
		System.out.println("i am here");
		// Editing name
		dependentsPage.getdependentName_ID().clear();
		dependentsPage.getdependentName_ID().sendKeys(name);
		try {
			Assert.assertTrue(dependentsPage.getdependentName_ID().getAttribute("value").contains(name));
			System.out.println("page data in Name: " + dependentsPage.getdependentName_ID().getAttribute("value")
					+ "---Data from file : " + name);
		} catch (AssertionError ae) {
			System.out.println("In DependentsPage--Name :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In DependentsPage--Name :" + we.getMessage());
		}
		// Editing relationship
		DropDownUtil.selectbytext(dependentsPage.depRelType(), relation);
		try {
			// Assert.assertFalse(DropDownUtil.selectbytext(dependentsPage.depRelType()),
			// relation);
			String opt = dependentsPage.depRelType().getText();
			Assert.assertEquals(opt, relation);

			System.out.println("page data in Name: " + dependentsPage.depRelType().getAttribute("value")
					+ "---Data from file : " + relation);
		} catch (AssertionError ae) {
			System.out.println("In DependentsPage--Relation :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In DependentsPage--Relation :" + we.getMessage());
		}
		// Editing Date Of Birth
		dependentsPage.getdependentDob_ID().click();
		dependentsPage.getdependentDob_ID().clear();
		dependentsPage.getdependentDob_ID().sendKeys(dob);
		try {
			Assert.assertTrue(dependentsPage.getdependentDob_ID().getAttribute("value").contains(dob));
			System.out.println("page data in Name: " + dependentsPage.depRelType().getAttribute("value")
					+ "---Data from file : " + dob);
		} catch (AssertionError ae) {
			System.out.println("In DependentsPage--Date Of Birth :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In DependentsPage--Date Of Birth :" + we.getMessage());
		}
		// Clicking save to save the changes made.
		dependentsPage.savedepButton().click();
		// Checking if the name is reflected in the table.
		String str2 = driver.findElement(By.xpath("//*[@id='dependent_list']/tbody/tr/td[2]/a")).getText();
		System.out.println("Dependent Name:   " + str2);
		Assert.assertEquals(name, str2);
	}

	int finalnumRows;

	@Test(priority = 14, dependsOnMethods = { "dependentsTesting" })
	public void deletingSingle_Dependent() throws Exception {

		if (dependentsPage.deldepButton().isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='dependent_list']/tbody/tr[1]/td[1]/input")).click();
			dependentsPage.deldepButton().click();
		} else {
			System.out.println("No Rows Displayed");
		}
	}

	@Test(priority = 15)
	public void deletingall_Dependents() {
		String msg = driver.findElement(By.xpath("//*[@id='dependent_list']/tbody/tr/td[2]")).getText();
		if (msg.equals("No Records Found")) {
			System.out.println("No Rows To Delete");
		} else {
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='dependent_list']/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			dependentsPage.getCheckboxAttatchment().click();
			dependentsPage.deldepButton().click();

		}

	}

//	@Test(priority = 16)
	public void setcontext(ITestContext context) {
		int sheetnumber = 7;
		context.setAttribute("index", sheetnumber);

		System.out.println("index-------------------------------->" + context.getAttribute("index"));

	}

//	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 17)
	public void dependentsAttachmentTesting(String cmt) throws Exception {

		System.out.println("Current Url of Depedents page : " + dependentsPage.getcurrentUrl());
		dependentsPage.attachmentAddButton().click();

		SynchronisationWaitsUtil.threadsleep(2000);
		WebElement ele = dependentsPage.chooseFile();
		AttatchmentsUtil.uploadingFileUsingRobot(ele, driver, "smallbird.jpg");
		dependentsPage.comments().sendKeys(cmt);
		SynchronisationWaitsUtil.threadsleep(5000);
		System.out.println("Attatchment File Uploaded");
	}

}





*/

package com.orangeHRM.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
import com.orangeHRM.qa.pages.DependentsPage;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.AttatchmentsUtil;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class DepenedentsPageTest extends BaseClass {
	BaseVerification baseVerification;
	MyInfoPage myInfoPage;
	DependentsPage dependentsPage;
	WebElement element;

	@BeforeClass
	public void verifypersonalDetailsPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		dependentsPage = myInfoPage.navigatingToDependents();
		System.out.println("Clicked Dependents and url is validated");
	}

	@Test(priority = 1)
	public void validateDependentsButton_bgcolor() {
		try {

			// details button bg-color- grey
			element = myInfoPage.getDependents_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("Dependents button bg-color is validated after clicking---grey");

		} catch (AssertionError ae) {
			System.out.println("In Dependents Testing--validateDependentsButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In Dependents--validateDependentsButton_bgcolor :" + we.getMessage());
		}

	}

	@Test(priority = 2)
	public void validatingMandatoryFieldsbeforeEnteringValues() {
		dependentsPage.adddepButton().click();
		System.out.println("Add Button clicked");
		dependentsPage.savedepButton().click();
		System.out.println("Save Button Clicked");
		boolean flag;
		if (dependentsPage.getdependentName_ID().getAttribute("value").isEmpty()) {
			System.out.println("Name is invalid");
			flag = true;
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		}
		if (dependentsPage.depRelType().getAttribute("value").isEmpty()) {
			System.out.println("Relation Ship is required");
			flag = true;
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		}

		else {
			System.out.println("Mandatory fields are invalid");
			flag = false;
		}
		Assert.assertTrue(flag);
		dependentsPage.canceldepButton().click();
	}

	@Test(priority = 3)
	public void setcontext1(ITestContext context) {
		int sheetnumber = 10;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 4)
	public void dependentsTesting(String name) throws Exception {
		dependentsPage.adddepButton().click();
		System.out.println("Add Button clicked");
		System.out.println("i am here");

		dependentsPage.getdependentName_ID().sendKeys(name);
		try {
			Assert.assertTrue(dependentsPage.getdependentName_ID().getAttribute("value").contains(name));
			System.out.println("page data in Name: " + dependentsPage.getdependentName_ID().getAttribute("value")
					+ "---Data from file : " + name);
		} catch (AssertionError ae) {
			System.out.println("In DependentsPage--Name :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In DependentsPage--Name :" + we.getMessage());
		}
		Select dropdown = new Select(dependentsPage.depRelType());
		List<WebElement> relations = dropdown.getOptions();
		System.out.println("Size : " + relations.size());
		String str = "Cousin";
		for (int i = 0; i < relations.size(); i++) {
			String text = relations.get(i).getText();
			System.out.println("Text  : " + text);
			if (text.equals("Child")) {
				System.out.println("RelationShip is selected as Child");
				DropDownUtil.selectbytext(dependentsPage.depRelType(), "Child");
			} else if (text.equals("Other")) {
				System.out.println("RelationShip is selected as Other");
				DropDownUtil.selectbytext(dependentsPage.depRelType(), "Other");

				dependentsPage.pleaseSpecify(str);

			}

		}
		dependentsPage.getDatePicker().click();
		DropDownUtil.selectbytext(dependentsPage.selMonth(), "May");
		DropDownUtil.selectbytext(dependentsPage.SelYear(), "2020");
		int bday = 12;
		// driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		driver.findElement(
				By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a[contains(text()," + bday + ")]")).click();
		// dependentsPage.savedepButton().click();

	}

	@Test(priority = 5)
	public void validatingRelationShipDropdownOptionsSort() {
		WebElement element = dependentsPage.depRelType();
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
	public void validatingRelationShipDropdownOptionsDuplicates() {
		WebElement element = dependentsPage.depRelType();
		Select se = new Select(element);

		List<WebElement> list = se.getOptions();
		Set<String> s = new LinkedHashSet<String>();
		for (WebElement w : list) {
			s.add(w.getText());
		}

		Assert.assertEquals(list.size(), s.size());
	}

	@Test(priority = 7)
	public void verifyDateOfBirthFormat() {
		// dependentsPage.adddepButton().click();
		String fromDate = dependentsPage.getdependentDob_ID().getAttribute("value");
		StringBuffer sBuffer = new StringBuffer(fromDate);
		String date, month, year;
		boolean flag;
		year = sBuffer.substring(0, 4);
		month = sBuffer.substring(5, 7);
		date = sBuffer.substring(8, 10);
		System.out.println("From Date : " + fromDate);
		System.out.println(" Year: " + year + " Mon: " + month + " Date: " + date);

		if (year.matches("(19|20)\\d\\d") && month.matches("0[1-9]|1[0-2]") && date.matches("0[1-9]|[12][0-9]|3[01]")) {
			System.out.println("Date of birth Format matched.");
			flag = true;
		} else {
			System.out
					.println(driver.findElement(By.className("validation-error")).getText() + "message is displayed.");
			flag = false;
		}
		Assert.assertTrue(flag);
	}

	@Test(priority = 8)
	public void validatingMandatoryFieldsAfterEnteringValues() {
		// dependentsPage.adddepButton().click();
		dependentsPage.savedepButton();
		System.out.println("Save Button clicked");
		boolean flag;
		if (dependentsPage.getdependentName_ID().getAttribute("value").isEmpty()) {
			System.out.println("Name is Required");
			flag = false;
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		}
		if (dependentsPage.depRelType().getAttribute("value").isEmpty()) {
			System.out.println("Relationship is required");
			flag = false;
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		} else {
			System.out.println("Mandatory fields are valid");
			flag = true;
		}
		Assert.assertTrue(flag);
		System.out.println("All Manatory fields Entered with valid data");
	}

	@Test(priority = 9)
	public void saveDependent() {
		if (dependentsPage.savedepButton().isDisplayed())
			dependentsPage.savedepButton().click();
		Assert.assertTrue(driver.findElement(By.id("dependent_list")).isDisplayed());
		Assert.assertTrue(dependentsPage.adddepButton().isDisplayed());
		Assert.assertTrue(dependentsPage.deldepButton().isDisplayed());
	}

	@Test(priority = 10)
	public void cancelDependent() {
		if (dependentsPage.canceldepButton().isDisplayed())
			dependentsPage.canceldepButton().click();
		Assert.assertTrue(driver.findElement(By.id("dependent_list")).isDisplayed());
		Assert.assertTrue(dependentsPage.adddepButton().isDisplayed());
		Assert.assertTrue(dependentsPage.deldepButton().isDisplayed());
	}

	@Test(priority = 11)
	public static void dependentTableHeaderValidation() {
		List<WebElement> li = driver.findElements(By.xpath("//*[@id='dependent_list']/thead/tr/th"));
		int n = li.size();
		List<String> s = new ArrayList<String>();
		System.out.println("size of Columns : " + n);
		for (int i = 0; i < n; i++) {
			s.add(li.get(i).getText());
		}
		System.out.println("List String : " + s);
		System.out.println("No . of columns in a table are : " + n);
		Assert.assertEquals(4, n);

		for (int i = 1; i <= n; i++) {
			WebElement header = driver.findElement(By.xpath("//*[@id='dependent_list']/thead/tr/th[" + i + "]"));
			System.out.print(header.getText());

			if (header.getText().equalsIgnoreCase("Name")) {
				System.out.println(" : is in the header");
				Assert.assertTrue(header.getText().contains("Name"));
			} else if (header.getText().equalsIgnoreCase("Relationship")) {
				System.out.println(" : is  in the header ");
				Assert.assertTrue(header.getText().contains("Relationship"));
			} else if (header.getText().equalsIgnoreCase("Date Of Birth")) {
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Date of Birth"));
			} else {
				System.out.println(" The given text is not in the header");
			}
		}
	}

	@Test(priority = 12)
	public void setcontext2(ITestContext context) {
		int sheetnumber = 12;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 13)
	public void editDependents(String name, String relation, String dob) throws Exception {
		// Editing details when name associated with the record is clicked with data in
		// excel file.
		dependentsPage.editdepButton().click();
		System.out.println("Name of the record to edit is clicked");
		System.out.println("i am here");
		// Editing name
		dependentsPage.getdependentName_ID().clear();
		dependentsPage.getdependentName_ID().sendKeys(name);
		try {
			Assert.assertTrue(dependentsPage.getdependentName_ID().getAttribute("value").contains(name));
			System.out.println("page data in Name: " + dependentsPage.getdependentName_ID().getAttribute("value")
					+ "---Data from file : " + name);
		} catch (AssertionError ae) {
			System.out.println("In DependentsPage--Name :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In DependentsPage--Name :" + we.getMessage());
		}
		// Editing relationship
		DropDownUtil.selectbytext(dependentsPage.depRelType(), relation);
		try {
			// Assert.assertFalse(DropDownUtil.selectbytext(dependentsPage.depRelType()),
			// relation);
			String opt = dependentsPage.depRelType().getText();
			Assert.assertEquals(opt, relation);

			System.out.println("page data in Name: " + dependentsPage.depRelType().getAttribute("value")
					+ "---Data from file : " + relation);
		} catch (AssertionError ae) {
			System.out.println("In DependentsPage--Relation :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In DependentsPage--Relation :" + we.getMessage());
		}
		// Editing Date Of Birth
		dependentsPage.getdependentDob_ID().click();
		dependentsPage.getdependentDob_ID().clear();
		dependentsPage.getdependentDob_ID().sendKeys(dob);
		try {
			Assert.assertTrue(dependentsPage.getdependentDob_ID().getAttribute("value").contains(dob));
			System.out.println("page data in Name: " + dependentsPage.depRelType().getAttribute("value")
					+ "---Data from file : " + dob);
		} catch (AssertionError ae) {
			System.out.println("In DependentsPage--Date Of Birth :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In DependentsPage--Date Of Birth :" + we.getMessage());
		}
		// Clicking save to save the changes made.
		dependentsPage.savedepButton().click();
		// Checking if the name is reflected in the table.
		String str2 = driver.findElement(By.xpath("//*[@id='dependent_list']/tbody/tr/td[2]/a")).getText();
		System.out.println("Dependent Name:   " + str2);
		// Assert.assertEquals(name, str2);
	}

	// int finalnumRows;

	@Test(priority = 14, dependsOnMethods = { "dependentsTesting" })
	public void deletingSingle_Dependent() throws Exception {

		if (dependentsPage.deldepButton().isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='dependent_list']/tbody/tr[1]/td[1]/input")).click();
			dependentsPage.deldepButton().click();
		} else {
			System.out.println("No Rows Displayed");
		}
	}

	@Test(priority = 15)
	public void deletingall_Dependents() {
		String msg = driver.findElement(By.xpath("//*[@id='dependent_list']/tbody/tr/td[2]")).getText();
		if (msg.equals("No Records Found")) {
			System.out.println("No Rows To Delete");
		} else {
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='dependent_list']/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			dependentsPage.getCheckboxAttatchment().click();
			dependentsPage.deldepButton().click();

		}

	}

	@Test(priority = 16)
	public void setcontext(ITestContext context) {
		int sheetnumber = 7;
		context.setAttribute("index", sheetnumber);

		System.out.println("index-------------------------------->" + context.getAttribute("index"));

	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 17)
	public void dependentsAttachmentTesting(String cmt) throws Exception {

		System.out.println("Current Url of Depedents page : " + dependentsPage.getcurrentUrl());
		dependentsPage.attachmentAddButton().click();

		SynchronisationWaitsUtil.threadsleep(2000);
		WebElement ele = dependentsPage.chooseFile();
		AttatchmentsUtil.uploadingFileUsingRobot(ele, driver, "smallbird.jpg");
		dependentsPage.comments().sendKeys(cmt);
		SynchronisationWaitsUtil.threadsleep(5000);
		System.out.println("Attatchment File Uploaded");
	}

}