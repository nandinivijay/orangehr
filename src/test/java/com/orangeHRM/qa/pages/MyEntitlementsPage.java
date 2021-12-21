package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyEntitlementsPage extends EntitlementsPage{
	 WebDriver driver;
	 
	 By LT=By.xpath("//select[@id='entitlements_leave_type']");
	 By LP=By.xpath("//select[@id='period']");
	 By Search=By.xpath("//input[@id='searchBtn']");
	 By AB=By.xpath("//input[@name='btnAdd']");
	 By DB= By.xpath("//input[@name='btnDelete']");
     By ACB=By.xpath("//input[@name='chkSelectAll']");
     By confirm =By.xpath("//input[@id='dialogUpdateEntitlementConfirmBtn']");
     
	public MyEntitlementsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	public  WebElement LeaveType()
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
	public  WebElement AddButton()
	{
		return driver.findElement(AB);
	}
	public WebElement DeleteButton()
	{
		return driver.findElement(DB);
	}
	public WebElement ClickOnAllCheckBox()
	{
		return driver.findElement(ACB);
		
	}
	

}
