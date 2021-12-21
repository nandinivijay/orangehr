package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeaveListPage extends LeavePage{

	WebDriver driver;
	public LeaveListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("LeaveList");
		
	}
	By fd=By.xpath("//input[@id='calFromDate']");
	By Td=By.xpath("//input[@id='calToDate']");
	By  allcheckbox=By.xpath("//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']");
	By fdmonth=By.className("ui-datepicker-month");
	By fdyear=By.className("ui-datepicker-year");
	By fddate=By.xpath(" //a[contains(text(),'14')]");
	By EmpName=By.xpath("//input[@id='leaveList_txtEmployee_empName']");
	By subunit=By.xpath("//select[@id='leaveList_cmbSubunit']");
	By pastEmployee=By.xpath("//input[@id='leaveList_cmbWithTerminated']");
	By searchbtn=By.xpath("//input[@id='btnSearch']");
	By resetbtn=By.xpath("//input[@id='btnReset']");
	By tableheader=By.xpath("//table[@id=\"resultTable\"]/thead/tr");
	
	
	
	public WebElement fromdatecalender()
	{
		return driver.findElement(fd);
		
	}
	public WebElement todate()
	{
		return driver.findElement(Td);
	}
	public WebElement fromdate()
	
	{
		return driver.findElement(fddate);
		
	}
	public WebElement frommonth()
	{
		return driver.findElement(fdmonth);
		
	}
	public WebElement fromyear()
	{
		return driver.findElement(fdyear);
		
	}
	public WebElement checkbox()
	{
		return driver.findElement(allcheckbox);
		
	}
	public WebElement employeename()
	{
		return driver.findElement(EmpName);
		
	}
	public WebElement SubUnitDropdown()
	{
		return driver.findElement(subunit);
		
	}
	public WebElement pastEmployee()
	{
			return driver.findElement(pastEmployee);
			
		}
	public WebElement tableHeaders()
	{
		return driver.findElement(tableheader);
		
	}
	public WebElement searchButton()
	{
		return driver.findElement(searchbtn);
			
	}
	public WebElement resetButton()
	{
		return driver.findElement(resetbtn );
		
	}

		
	}

