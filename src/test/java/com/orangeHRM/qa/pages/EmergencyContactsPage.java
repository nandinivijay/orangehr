package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmergencyContactsPage extends MyInfoPage {
	WebDriver driver;

	public EmergencyContactsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl() {

		return driver.getCurrentUrl().contains("viewEmergencyContacts");
	}

	By addbtn = By.xpath("//*[@id='btnAddAttachment']");
	By cf = By.xpath("//*[@id='ufile']");
	By commentId = By.id("txtAttDesc");
	By uploadBtn = By.id("btnSaveAttachment");
	By editLink = By.xpath("//*[@id='tblAttachments']/tbody/tr[1]/td[8]/a");// *[@id="tblAttachments"]/tbody/tr/td[8]/a
	By delbtn = By.id("btnDeleteAttachment");
	By checkboxClassAttatchment = By.className("checkboxAtch");
	By checkboxAllAttatchment = By.id("attachmentsCheckAll");

	By delallcon = By.xpath("//input[@id='checkAll']");

	By addcon = By.xpath("//*[@id='btnAddContact']");
	By delcon = By.xpath("//input[@id='delContactsBtn']");
	By Name_ID = By.xpath("//input[@id='emgcontacts_name']");
	By Relationship_ID = By.xpath("//input[@id='emgcontacts_relationship']");
	By HomePhone_ID = By.xpath("//input[@id='emgcontacts_homePhone']");
	By Mobile_ID = By.xpath("//input[@id='emgcontacts_mobilePhone']");
	By WorkPhone_ID = By.xpath("//input[@id='emgcontacts_workPhone']");
	By savecon = By.xpath("//input[@id='btnSaveEContact']");
	By cancelcon = By.xpath("//input[@id='btnCancel']");
	By errormsg = By.xpath("//span[@class='validation-error']");
	By checkboxClassname = By.className("checkbox");
	By tableEditLink = By.xpath("//*[@id='emgcontact_list']/tbody/tr/td[2]/a");

	public WebElement addconButton()

	{
		return driver.findElement(addcon);
	}

	public WebElement delconButton()

	{
		return driver.findElement(delcon);
	}

	public WebElement getName_ID()

	{
		return driver.findElement(Name_ID);
	}

	public WebElement getRelationship_ID()

	{
		return driver.findElement(Relationship_ID);
	}

	public WebElement getHomePhone_ID()

	{
		return driver.findElement(HomePhone_ID);
	}

	public WebElement getMobile_ID()

	{
		return driver.findElement(Mobile_ID);
	}

	public WebElement getWorkPhone_ID()

	{
		return driver.findElement(WorkPhone_ID);
	}

	public WebElement saveconButton()

	{
		return driver.findElement(savecon);
	}

	public WebElement cancelconButton()

	{
		return driver.findElement(cancelcon);
	}

	public WebElement geterrormsg()

	{
		return driver.findElement(errormsg);
	}

	public WebElement addButton()

	{
		return driver.findElement(addbtn);
	}

	public WebElement chooseFile() {

		return driver.findElement(cf);
	}

	public WebElement comments() {

		return driver.findElement(commentId);
	}

	public WebElement uploadButton()

	{
		return driver.findElement(uploadBtn);
	}

	public WebElement fileCheckbox() {

		return driver.findElement(checkboxClassname);
	}

	public WebElement checkboxallAttatchment()

	{
		return driver.findElement(checkboxAllAttatchment);
	}

	public WebElement deleteButton()

	{
		return driver.findElement(delbtn);
	}

	public WebElement deleteAllCon()

	{
		return driver.findElement(delallcon);
	}

	public WebElement editLinkClick() {

		return driver.findElement(editLink);
	}

	public WebElement getCheckboxAttatchment() {

		return driver.findElement(checkboxClassAttatchment);
	}

	public WebElement TableEditLinkClick() {
		return driver.findElement(tableEditLink);
	}

}
