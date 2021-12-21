package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactDetailsPage extends MyInfoPage {

	WebDriver driver;

	public ContactDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl() {

		return driver.getCurrentUrl().contains("contactDetails");
	}

	By Street1_ID = By.id("contact_street1");
	By Street2_ID = By.id("contact_street2");
	By City_ID = By.id("contact_city");
	By StateProvince_ID = By.id("contact_province");
	By ZipPostal_ID = By.id("contact_emp_zipcode");
	By Country_ID = By.id("contact_country");

	By HomeTele_ID = By.id("contact_emp_hm_telephone");
	By Mobile_ID = By.id("contact_emp_mobile");
	By workTele_ID = By.id("contact_emp_work_telephone");

	By WorkEmail_ID = By.id("contact_emp_work_email");
	By OtherEmail_ID = By.id("contact_emp_oth_email");

	By EditContactDetails_ID = By.id("btnSave");
	By SaveContactDetails_ID = By.id("btnSave");
	By CustomFieldsName_ID = By.id("custom2");
	By CustomFieldsEmployee_ID = By.id("custom3");
	By EditCustomFieldsbtn_ID = By.id("btnEditCustom");

	By AddAttatchmentBtn_ID = By.id("btnAddAttachment");
	By cf = By.xpath("//*[@id='ufile']");
	By cmts = By.xpath("//textarea[@id='txtAttDesc']");
	By uploadBtn = By.xpath("//input[@id='btnSaveAttachment']");
	By cancelbtn = By.xpath("//input[@id='cancelButton']");
	By filecheckboxbtn = By.xpath("//input[@name='chkattdel[]']");
	By deletebtn = By.xpath("//input[@id='btnDeleteAttachment']");

	By editLink = By.xpath("//*[@id='tblAttachments']/tbody/tr/td[8]/a");

	By checkboxAllAttatchment = By.id("attachmentsCheckAll");

	public WebElement getstreet1_id() {

		return driver.findElement(Street1_ID);
	}

	public WebElement getstreet2_id() {

		return driver.findElement(Street2_ID);
	}

	public WebElement getcity_id() {
		return driver.findElement(City_ID);
	}

	public WebElement getstateOrProvince_id() {
		return driver.findElement(StateProvince_ID);
	}

	public WebElement getzipOrPostal_id() {
		return driver.findElement(ZipPostal_ID);
	}

	public WebElement getcountry_id() {
		return driver.findElement(Country_ID);

	}

	public WebElement gethomeTelephone_id() {
		return driver.findElement(HomeTele_ID);
	}

	public WebElement getmobile_id()

	{
		return driver.findElement(Mobile_ID);
	}

	public WebElement getworkTelephone_id()

	{
		return driver.findElement(workTele_ID);
	}

	public WebElement getworkEmail_id() {
		return driver.findElement(WorkEmail_ID);
	}

	public WebElement getotherEmail_id() {

		return driver.findElement(OtherEmail_ID);

	}

	public WebElement geteditContactDetailsButton_id() {

		return driver.findElement(EditContactDetails_ID);

	}

	public WebElement getsaveContactDetailsButton_id() {

		return driver.findElement(SaveContactDetails_ID);

	}

	public WebElement getcustomFieldsName_id() {

		return driver.findElement(CustomFieldsName_ID);

	}

	public WebElement getcustomFieldsEmployee_id() {

		return driver.findElement(CustomFieldsEmployee_ID);

	}

	public WebElement geteditCustomFieldsbtn_id() {

		return driver.findElement(EditCustomFieldsbtn_ID);

	}

	public WebElement addAttatchmentBtn() {

		return driver.findElement(AddAttatchmentBtn_ID);

	}

	public WebElement editLinkClick() {

		return driver.findElement(editLink);
	}

	public WebElement checkboxallAttatchment() {

		return driver.findElement(checkboxAllAttatchment);
	}

	public WebElement deleteButton() {

		return driver.findElement(deletebtn);
	}

	public WebElement fileCheckbox() {
		return driver.findElement(filecheckboxbtn);
	}

	public WebElement cancel() {
		return driver.findElement(cancelbtn);
	}

	public WebElement upload() {
		return driver.findElement(uploadBtn);
	}

	public WebElement chooseFile() {
		return driver.findElement(cf);

	}

	public WebElement comments() {
		return driver.findElement(cmts);
	}

}
