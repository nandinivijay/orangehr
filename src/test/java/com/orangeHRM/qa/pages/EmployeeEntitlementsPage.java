package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeEntitlementsPage extends EntitlementsPage{
	WebDriver driver;
	
	By EL=By.xpath("//input[@id='entitlements_employee_empName']");
	By LT=By.xpath("//select[@id='entitlements_leave_type']");
	By LP=By.xpath("//select[@id='period']");
	By Search=By.xpath("//input[@id='searchBtn']");
	By Added=By.xpath("//input[@name='chkSelectRow[]']");
	By ET=By.xpath("//input[@id='ohrmList_chkSelectAll']");
	By Delete=By.xpath("//input[@id='btnDelete']");
	By SaveButton = By.xpath("//input[@id='btnSave']");
	By Confirm=By.xpath("//input[@id='dialogUpdateEntitlementConfirmBtn']");
	By dialogButtonDeleteConfirm = By.xpath("//*[@id='dialogDeleteBtn']");

	public EmployeeEntitlementsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("viewLeaveEntitlements");
		
	}
	public WebElement Employee()
	{
		WebElement employeename = driver.findElement(EL);
		//employeename.clear();
		return employeename;
	}
	public WebElement LeaveType()
	{
		return driver.findElement(LT);		
	}
	public WebElement LeavePeriod()
	{
		return driver.findElement(LP);
	}
	public WebElement SearchButton()
	{
		return driver.findElement(Search);
	}
	public  WebElement clickonaddCheckBox()
	{
		return driver.findElement(Added);
	}
	public WebElement clickOnAllCheckBox()
	{
		return driver.findElement(ET);
	}
	public WebElement deleteButton()
	{
		return driver.findElement(Delete);
	}
	public WebElement saveButton()
	{
		return driver.findElement(SaveButton);
	}
	public WebElement confirmButton()
	{
		WebElement c = driver.findElement(Confirm);
		return c;
	}
	public WebElement confirmDeleteDialogButton()
	{
		WebElement c = driver.findElement(dialogButtonDeleteConfirm);
		return c;
	}
}
