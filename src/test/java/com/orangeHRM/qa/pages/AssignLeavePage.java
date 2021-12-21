package com.orangeHRM.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.orangeHRM.qa.util.DropDownUtil;

public class AssignLeavePage extends LeavePage{
	
	WebDriver driver;
	
	public  AssignLeavePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("assign");
		
	}
	
	By EN = By.xpath("//input[@id='assignleave_txtEmployee_empName']");
	By LT = By.xpath("//*[@id='assignleave_txtLeaveType']");
	By LB = By.xpath("//*[@id='balance_total']");
	By FD = By.id("assignleave_txtFromDate");
	By TD = By.id("assignleave_txtToDate");
	By PD = By.id("assignleave_partialDays");
	By Comment = By.id("assignleave_txtComment");
	By AB = By.id("assignBtn");
	By Month = By.className("ui-datepicker-month");
	By Year = By.className("ui-datepicker-year");
	By Day = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody");
	By SDurType = By.id("assignleave_firstDuration_duration");
	By SDurDay = By.id("assignleave_firstDuration_ampm");
	By EDurType = By.id("assignleave_secondDuration_duration");
	By EDurDay = By.id("assignleave_secondDuration_ampm");
	By SFtime = By.id("assignleave_firstDuration_time_from");
	By STtime = By.id("assignleave_firstDuration_time_to");
	By EFtime = By.id("assignleave_secondDuration_time_from");
	By ETtime = By.id("assignleave_secondDuration_time_to");
	By dur = By.className("time_range_duration");
	public WebElement empName()
	{
		return driver.findElement(EN);
	}
	
	public WebElement leaveType()
	{
		return driver.findElement(LT);
	}
	
	public WebElement leaveBalance()
	{
		return driver.findElement(LB);
	}
	
	public WebElement fromDate()
	{
		return driver.findElement(FD);
	}
	
	
	public WebElement toDate()
	{
		return driver.findElement(TD);
	}

	public WebElement partialDays()
	{
		return driver.findElement(PD);
	}
	
	public WebElement comment()
	{
		return driver.findElement(Comment);
	}
	
	public WebElement assignButton()
	{
		return driver.findElement(AB);
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
	
	public WebElement startdurType()
	{
		return driver.findElement(SDurType);
	}
	
	public WebElement startdurDay()
	{
		return driver.findElement(SDurDay);
	}
	
	public WebElement enddurType()
	{
		return driver.findElement(EDurType);
	}
	
	public WebElement enddurDay()
	{
		return driver.findElement(EDurDay);
	}
	
	public WebElement startfromtime()
	{
		return driver.findElement(SFtime);
	}
	
	public WebElement starttoTime()
	{
		return driver.findElement(STtime);
	}
	
	public WebElement endfromtime()
	{
		return driver.findElement(EFtime);
	}
	
	public WebElement endtoTime()
	{
		return driver.findElement(ETtime);
	}
	
	public WebElement duration()
	{
		return driver.findElement(dur);
	}
	
	public void dropdownsMethodForStart()
	{
		Select dropdown1 = new Select(startdurType());
		List<WebElement> dtype = dropdown1.getOptions();
		System.out.println("Duration type Size : "+dtype.size());
		for(int j=0;j<dtype.size();j++) 
		{ 
			  String text1 = dtype.get(j).getText();
			  System.out.println("text 1 "+text1);
			  if(text1.equals("Half Day")) 
			  {
				  System.out.println("HalfDay is selected");
				  DropDownUtil.selectbytext(startdurType(), "Half Day");
				  Assert.assertTrue(startdurDay().isDisplayed());
				  Assert.assertTrue(startdurType().isDisplayed());
				  DropDownUtil.selectbyindex(startdurDay(),0);
				  //DropDownUtil.selectbyindex(startdurDay(),1);
			  } 
			  else if(text1.equals("Specify Time"))
			  {
				  System.out.println("Specify Time is selected");
				  DropDownUtil.selectbytext(startdurType(), "Specify Time");
				  Assert.assertTrue(startfromtime().isDisplayed());
				  Assert.assertTrue(starttoTime().isDisplayed());
				  DropDownUtil.selectbyindex(startfromtime(),5);
				  DropDownUtil.selectbyindex(starttoTime(), 14);  
				  String timeduration = duration().getAttribute("Value");
				  System.out.println("TimeDuration : "+timeduration);
			  }
		  
		}
	}
		
	public void dropdownsMethodForEnd()
	{
		Select dropdown1 = new Select(enddurType());
		List<WebElement> dtype = dropdown1.getOptions();
		System.out.println("Duration type Size : "+dtype.size());
		for(int j=0;j<dtype.size();j++) 
		{ 
			  String text1 = dtype.get(1).getText();
			  System.out.println("text 1 "+text1);
			  if(text1.equals("Half Day")) 
			  {
				  System.out.println("HalfDay is selected");
				  DropDownUtil.selectbytext(enddurType(), "Half Day");
				  Assert.assertTrue(enddurDay().isDisplayed());
				  Assert.assertTrue(enddurType().isDisplayed());
				  DropDownUtil.selectbyindex(enddurDay(),1);
				//DropDownUtil.selectbyindex(enddurDay(),0);
			  } 
			  else if(text1.equals("Specify Time"))
			  {
				  System.out.println("Specify Time is selected");
				  DropDownUtil.selectbytext(enddurType(), "Specify Time");
				  Assert.assertTrue(endfromtime().isDisplayed());
				  Assert.assertTrue(endtoTime().isDisplayed());
				  DropDownUtil.selectbyindex(endfromtime(),9);
				  DropDownUtil.selectbyindex(endtoTime(), 18);  
				  String timeduration = duration().getAttribute("Value");
				  System.out.println("TimeDuration : "+timeduration);
			  }
		  
		}
	}

	
}
