package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalDetailsPage extends MyInfoPage {

	WebDriver driver;

	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl() {

		return driver.getCurrentUrl().contains("view");
	}

	By FirstName_ID = By.id("personal_txtEmpFirstName");
	By MiddleName_ID = By.id("personal_txtEmpMiddleName");
	By LastName_ID = By.id("personal_txtEmpLastName");
	By Employee_ID = By.id("personal_txtEmployeeId");
	By DriversLicense_ID = By.id("personal_txtLicenNo");
	By SSNNumber_ID = By.id("personal_txtNICNo");
	By Other_ID = By.id("personal_txtOtherID");
	By LicenseExpiryDate_ID = By.id("personal_txtLicExpDate");
	By SINNumber_ID = By.id("personal_txtSINNo");
	By Nationality_ID = By.id("personal_cmbNation");
	By MarritalStatus_ID = By.id("personal_cmbMarital");
	By DateOfBirth_ID = By.id("personal_DOB");
	By NickName_ID = By.id("personal_txtEmpNickName");
	By MilitaryService_ID = By.id("personal_txtMilitarySer");
	By Smoker_ID = By.id("personal_chkSmokeFlag");
	By Edit_ID = By.id("btnSave");

	By Month = By.className("ui-datepicker-month");
	By Year = By.className("ui-datepicker-year");
	By Day = By.xpath("//*[@id='ui-datepicker-div']/table/tbody");
	By editbtn = By.xpath("//input[@id='btnEditCustom']");
	By BldType = By.xpath("//select[@name='custom1']");
	By savebtn = By.xpath("//input[@id='btnEditCustom']");
	By addbtn = By.xpath("//input[@id='btnAddAttachment']");

	By cf = By.xpath("//*[@id='ufile']");

	By cmts = By.xpath("//textarea[@id='txtAttDesc']");
	By uploadBtn = By.xpath("//input[@id='btnSaveAttachment']");
	By cancelbtn = By.xpath("//input[@id='cancelButton']");
	By filecheckboxbtn = By.xpath("//input[@name='chkattdel[]']");
	By deletebtn = By.xpath("//input[@id='btnDeleteAttachment']");
	By editLink = By.xpath("//*[@id='tblAttachments']/tbody/tr[1]/td[8]/a");
	By checkboxAllAttatchment = By.id("attachmentsCheckAll");

	By editCustFields = By.id("btnEditCustom");
	
	By genderMale = By.xpath("//*[@id='personal_optGender_1']");
	By genderFemale = By.xpath(" //*[@id='personal_optGender_2']");

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

	public WebElement addButton()

	{
		return driver.findElement(addbtn);
	}

	public WebElement saveButton()

	{
		return driver.findElement(savebtn);
	}

	public WebElement bloodType() {
		return driver.findElement(BldType);
	}

	public WebElement editButton() {

		return driver.findElement(editbtn);

	}

	public WebElement getFirstName_id() {

		return driver.findElement(FirstName_ID);

	}

	public WebElement getMiddleName_id() {

		return driver.findElement(MiddleName_ID);

	}

	public WebElement getLastName_id() {

		return driver.findElement(LastName_ID);

	}

	public WebElement getEmployee_id() {

		return driver.findElement(Employee_ID);

	}

	public WebElement getDriversLicense_id() {

		return driver.findElement(DriversLicense_ID);

	}

	public WebElement getSSNNumber_id() {

		return driver.findElement(SSNNumber_ID);

	}

	public WebElement getOther_id() {

		return driver.findElement(Other_ID);

	}

	public WebElement getLicenseExpiryDate_id() {

		return driver.findElement(LicenseExpiryDate_ID);

	}

	public WebElement getSINNumber_id() {

		return driver.findElement(SINNumber_ID);

	}

	public WebElement getNationality_id() {

		return driver.findElement(Nationality_ID);

	}

	public WebElement getMarritalStatus_id() {

		return driver.findElement(MarritalStatus_ID);

	}

	public WebElement getDateOfBirth_id() {

		return driver.findElement(DateOfBirth_ID);

	}

	public WebElement getNickName_id() {

		return driver.findElement(NickName_ID);

	}

	public WebElement getMilitaryService_id() {

		return driver.findElement(MilitaryService_ID);

	}

	public WebElement getSmoker_id() {

		return driver.findElement(Smoker_ID);

	}

	public WebElement getEdit_id() {

		return driver.findElement(Edit_ID);

	}

	public WebElement selMonth() {

		return driver.findElement(Month);
	}

	public WebElement SelYear() {

		return driver.findElement(Year);
	}

	public Object selDate() {

		return driver.findElement(Day);
	}
	public WebElement clickMale()
	{
		return driver.findElement(genderMale);
	}
	public WebElement clickFemale()
	{
		return driver.findElement(genderFemale);
	}
	
	

	public WebElement checkboxallAttatchment() {

		return driver.findElement(checkboxAllAttatchment);
	}

	public WebElement geteditCustFields() {

		return driver.findElement(editCustFields);
	}

}
