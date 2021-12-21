package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EntitlementsPage extends LeavePage{
	
	WebDriver driver;
	public EntitlementsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}
	By AddEntitlements=By.xpath("//a[normalize-space()='Add Entitlements']");
	By EmployeeEntitlements=By.xpath("//a[normalize-space()='Employee Entitlements']");
	By MyEntitlements =By.xpath("//a[normalize-space()='My Entitlements']");
	
	
	/*AddEntitlements AE=new AddEntitlements(driver);
	EmployeeEntitlements EE=new EmployeeEntitlements(driver);
	MyEntitlements ME=new MyEntitlements(driver) ;*/
	
	
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Entitlement");
		
	}
	public WebElement getAddEntitlements_id()
	{
		   return driver.findElement(AddEntitlements);
	}
	public AddEntitlementsPage navigatingToAddEntitlementsPage()
	{
		getAddEntitlements_id().click();
		return new AddEntitlementsPage(driver);
	}
	
	public WebElement getEmployeeEntitlements_id()
	{
		return driver.findElement(EmployeeEntitlements);
		
	}
	public EmployeeEntitlementsPage navigatingToEmployeeEntitlementsPage()
	{
		getEmployeeEntitlements_id().click();
		return new EmployeeEntitlementsPage(driver);
	}
	
	
	public WebElement getMyEntitlements_id()
	{
		return driver.findElement(MyEntitlements);
		
	}
	public MyEntitlementsPage navigatingToMyEntitlementsPage()
	{
		getMyEntitlements_id().click();
		return new MyEntitlementsPage(driver);
	}
		  
		
	

}
