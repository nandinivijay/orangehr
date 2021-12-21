package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImmigrationPage extends MyInfoPage {
	WebDriver driver;

	public ImmigrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl() {

		return driver.getCurrentUrl().contains("viewImmigration");
	}

	By addbtn = By.id("btnAdd");
	By delbtn = By.xpath("//input[@id='btnDelete']");
	// *[@id="btnAdd"]
	By visabtn = By.xpath("//label[@for='immigration_type_flag_2']");
	By passportbtn = By.xpath("//input[@id='immigration_type_flag_1']");
	By number = By.xpath("//input[@id='immigration_number']");
	By issuedte = By.xpath("//input[@id='immigration_passport_issue_date']");
	By expdate = By.xpath("//input[@id='immigration_passport_expire_date']");
	By eligstatus = By.xpath("//input[@id='immigration_i9_status']");
	By issuedby = By.xpath("//select[@id='immigration_country']");
	By eligiblereviewdate = By.xpath("//input[@id='immigration_i9_review_date']");
	By comts = By.xpath("//textarea[@id='immigration_comments']");
	By savebtn = By.xpath("//input[@id='btnSave']");
	By month = By.className("ui-datepicker-month");
	By year = By.className("ui-datepicker-year");
	By cancelbtn = By.xpath("//input[@id='btnCancel']");

	By addbtnatch = By.xpath("//input[@id='btnAddAttachment']");

	By cf = By.xpath("//*[@id='ufile']");
	By cmts = By.xpath("//textarea[@id='txtAttDesc']");
	By uploadBtn = By.xpath("//input[@id='btnSaveAttachment']");
	By cancelatchbtn = By.xpath("//input[@id='cancelButton']");
	By filecheckboxbtn = By.xpath("//input[@name='chkattdel[]']");
	By deletebtn = By.xpath("//input[@id='btnDeleteAttachment']");
	By editLink = By.xpath("//*[@id='tblAttachments']/tbody/tr[1]/td[8]/a");
	By checkboxAllAttatchment = By.id("attachmentsCheckAll");
	By checkboxAllImmigrant = By.id("immigrationCheckAll");

	public WebElement editLinkClick() {

		return driver.findElement(editLink);
	}

	public WebElement deleteButton() {

		return driver.findElement(deletebtn);
	}

	public WebElement fileCheckbox() {
		return driver.findElement(filecheckboxbtn);
	}

	public WebElement cancel() {
		return driver.findElement(cancelatchbtn);
	}

	public WebElement upload() {
		return driver.findElement(uploadBtn);
	}

	public WebElement chooseFile() {
		return driver.findElement(cf);

	}

	public WebElement commentsatch() {
		return driver.findElement(cmts);
	}

	public WebElement addButton()

	{
		return driver.findElement(addbtnatch);
	}

	public WebElement checkboxallAttatchment() {

		return driver.findElement(checkboxAllAttatchment);
	}

	public WebElement checkboxallImmigrant() {

		return driver.findElement(checkboxAllImmigrant);
	}

	public WebElement clickOnDeleteButton() {
		return driver.findElement(delbtn);

	}

	public WebElement selmonth() {
		return driver.findElement(month);
	}

	public WebElement selbyYear() {
		return driver.findElement(year);
	}

	public WebElement clickonAddButton() {

		return driver.findElement(addbtn);
	}

	public WebElement clickOnVisaradiobtn() {

		return driver.findElement(visabtn);
	}

	public WebElement enterNumber() {

		return driver.findElement(number);
	}

	public WebElement issueDate() {
		return driver.findElement(issuedte);
	}

	public WebElement expireDate() {
		return driver.findElement(expdate);

	}

	public WebElement eligibleStatus() {
		return driver.findElement(eligstatus);
	}

	public WebElement issuedBy() {
		return driver.findElement(issuedby);

	}

	public WebElement eligiblityReviewDate() {

		return driver.findElement(eligiblereviewdate);
	}

	public WebElement comments() {

		return driver.findElement(comts);
	}

	public WebElement savebutton() {

		return driver.findElement(savebtn);
	}

	public WebElement cancelbutton() {

		return driver.findElement(cancelbtn);
	}

	public WebElement passPort() {

		return driver.findElement(passportbtn);
	}

}
