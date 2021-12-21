package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEntitlementsPage extends EntitlementsPage{

	WebDriver driver;
	
	By AMCB = By.xpath("//input[@id='entitlements_filters_bulk_assign']");
	By LC = By.xpath("//select[@id='entitlements_filters_location']");
	By SU = By.xpath("//select[@id='entitlements_filters_subunit']");
	By EP = By.xpath("//input[@id='entitlements_employee_empName']");
	By LT = By.xpath("//select[@id='entitlements_leave_type']");
	By LP = By.xpath("//select[@id='period']");
	By ET = By.xpath("//input[@id='entitlements_entitlement']");
	By Save = By.xpath("//input[@id='btnSave']");
	By Cancel = By.xpath("//input[@id='btnCancel']");
	By Confirm = By.xpath("//input[@id='dialogUpdateEntitlementConfirmBtn']");
	By Delete = By.xpath("//*[@id='btnDelete']");
	By checkEntitlement = By.xpath("//*[@id='ohrmList_chkSelectAll']");
	//By deleteEntitlement = By.xpath("//*[@id='btnDelete']");
	By entitlementRemoveConfirmation = By.xpath("//*[@id='dialogDeleteBtn']");

	public AddEntitlementsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void isMultipleEmployeeCheckBoxIsNotChecked() {
		System.out.println("ADD to multiple employee check box is not selected ");
	}

	public void isMultipleEmployeeCheckBoxIsChecked() {
		System.out.println("ADD to multiple employee check box is  selected ");
	}

	public WebElement employee() {
		return driver.findElement(EP);
	}

	public WebElement location() {
		return driver.findElement(LC);
	}

	public WebElement SubUnit() {
		return driver.findElement(SU);
	}

	public WebElement LeaveType() {
		return driver.findElement(LT);
	}

	public WebElement LeavePeriod() {
		return driver.findElement(LP);
	}

	public WebElement Entitlements() {
		return driver.findElement(ET);
	}

	public WebElement SaveButton() {
		return driver.findElement(Save);
	}

	public WebElement CancelButton() {
		WebElement cl = driver.findElement(Cancel);
		return cl;
	}

	public WebElement confirmButton() {
		WebElement c = driver.findElement(Confirm);
		return c;
	}

	public WebElement checkEntitlement()
	{
		WebElement c = driver.findElement(checkEntitlement);
		return c;
	}
	public WebElement deleteEntitlement() {
		WebElement c = driver.findElement(Delete);
		return c;
	}
	public WebElement confirmDeleteEntitlement(){
		WebElement c = driver.findElement(entitlementRemoveConfirmation);
		return c;
	}
}
