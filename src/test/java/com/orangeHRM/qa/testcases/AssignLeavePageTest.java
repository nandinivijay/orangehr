package com.orangeHRM.qa.testcases;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AssignLeavePage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;


public class AssignLeavePageTest extends BaseClass{

AssignLeavePage assignLeavePage;
	
	@BeforeClass
	public void verifyAssignLeavePageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		LeavePage leavePage = baseVerification.navigatingToLeave(); 
		assignLeavePage = leavePage.navigatingToAssignLeave();
		Assert.assertTrue(assignLeavePage.getcurrentUrl());
		System.out.println("Clicked Assign Leave and asserted URL");
	}
	
	@Test(priority = 2)
	public void validatingMandatoryFieldsbeforeEnteringValues()
	{
		driver.findElement(By.id("assignBtn")).click();
		System.out.println("Assign Button clicked");
		boolean flag ;
		if(assignLeavePage.empName().getAttribute("value").isEmpty())
		{
			System.out.println("Emp Name is invalid");
			flag = true;
			System.out.println(driver.findElement(By.className("validation-error")).getText()+" is displayed");
		}
		if(assignLeavePage.leaveType().getAttribute("value").isEmpty())
		{
			System.out.println("Leave Type is required");
			flag = true;
		}
		if(assignLeavePage.fromDate().getAttribute("value").isEmpty())
		{
			System.out.println("from date should be a valid date in yyyy-mm-dd format ");
			flag = true;
		}
		if(assignLeavePage.toDate().getAttribute("value").isEmpty())
		{
			System.out.println("to date should be a valid date in yyyy-mm-dd format ");
			flag = true;
		}
		else
		{
			System.out.println("Mandatory fields are valid");
			flag = false;
		}
		Assert.assertTrue(flag);
		System.out.println("All Manatory fields Entered with valid data");
	}
	
	@Test(priority=3)
	public void setcontext(ITestContext context) {
	int	sheetnumber=4;
	context.setAttribute("index", sheetnumber);
	}
	
	@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class ,priority=4)
	public void assignLeaveTesting(String empName,String comments) throws Exception 
	{
		System.out.println("Assign Leave clicked");
		driver.manage().window().maximize();
		SynchronisationWaitsUtil.implicitwait(12,TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of AssignLeave : "+assignLeavePage.getcurrentUrl());
		assignLeavePage.empName().sendKeys(empName);
		System.out.println("i'm here");
		try {
			Assert.assertTrue(assignLeavePage.empName().getAttribute("value").contains(empName));
			System.out.println("page data in EmpName: " +assignLeavePage.empName().getAttribute("value") + "---Data from file : "+ empName);
			}catch(AssertionError ae) {
				System.out.println("In assignLeaveTesting--empname :" + ae.getMessage());
			}
			catch(WebDriverException we) {
			System.out.println("In assignLeavePage comments :" + we.getMessage());
		}
		DropDownUtil.selectbyvalue(assignLeavePage.leaveType(),"5");
		driver.findElement(By.id("leaveBalance_details_link")).click();
		String leaveBal = assignLeavePage.leaveBalance().getText();
		System.out.println("Leave Balance : "+leaveBal);
		driver.findElement(By.id("closeButton")).click();
		assignLeavePage.fromDate().click();
		//SynchronisationWaitsUtil.implicitwait(5,TimeUnit.SECONDS, driver);
		DropDownUtil.selectbytext(assignLeavePage.selMonth(), "May");
		DropDownUtil.selectbytext(assignLeavePage.SelYear(), "2020");
		int fday = 12;
		//driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a[contains(text(),"+fday+")]")).click();
		// assignLeavePage.fromCal().click();
		assignLeavePage.toDate().click();
		DropDownUtil.selectbytext(assignLeavePage.selMonth(), "Jun");
		DropDownUtil.selectbytext(assignLeavePage.SelYear(), "2020");
		int tday = 14;
		//driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a[contains(text(),"+tday+")]")).click();
		//assignLeavePage.toCal().click();
		Select dropdown = new Select(assignLeavePage.partialDays());
		List<WebElement> pdays = dropdown.getOptions();
		System.out.println("Size : "+pdays.size());
		for(int i=0;i<pdays.size();i++)
		{
			String text = pdays.get(i).getText();
			System.out.println("Text  : "+text);
			if(text.equals("None"))
			{
				System.out.println("Partial Days is selected as none");
				DropDownUtil.selectbytext(assignLeavePage.partialDays(), "None");
			}
			else if(text.equals("All Days"))
			{
				System.out.println("Partial Days is selected as All Days");
				DropDownUtil.selectbytext(assignLeavePage.partialDays(), "All Days");
				assignLeavePage.dropdownsMethodForStart();
			}
			else if(text.equals("Start Day Only"))
			{
				System.out.println("Partial Days is selected as Start Day Only");
				DropDownUtil.selectbytext(assignLeavePage.partialDays(), "Start Day Only");
				assignLeavePage.dropdownsMethodForStart();
			}
			else if(text.equals("End Day Only"))
			{
				System.out.println("Partial Days is selected as End Day Only");
				DropDownUtil.selectbytext(assignLeavePage.partialDays(), "End Day Only");
				assignLeavePage.dropdownsMethodForEnd();
			}
			else if(text.equals("Start and End Day"))
			{
				System.out.println("Partial Days is selected as Start and End Day");
				DropDownUtil.selectbytext(assignLeavePage.partialDays(), "Start and End Day");
				System.out.println("For Start Day");
				assignLeavePage.dropdownsMethodForStart();
				System.out.println("For End Day");
				assignLeavePage.dropdownsMethodForEnd();
			}
		}
		//assignLeavePage.comment().sendKeys("No Comments");
		assignLeavePage.comment().sendKeys(comments);
		System.out.println("enetered comments");
		try {
			Assert.assertTrue(assignLeavePage.comment().getAttribute("value").contains(comments));
			System.out.println("page data : " +assignLeavePage.comment().getAttribute("value") + "---Data from file : "+ comments);
			}catch(AssertionError ae) {
				System.out.println("In assignLeavePage comments :" + ae.getMessage());
			}catch(WebDriverException we) {
				System.out.println("In assignLeavePage comments :" + we.getMessage());
			}
		SynchronisationWaitsUtil.threadsleep(5000);
		assignLeavePage.assignButton().click();	
		Thread.sleep(15000);
		driver.findElement(By.id("confirmOkButton")).click();
		
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/h1")).isDisplayed());
	}
	
	
	@Test(priority = 5)
	public void validatingLeaveBalanceDropdownOptionsSort()
	{
		WebElement element = assignLeavePage.leaveType();
		  Select se = new Select(element);

		  ArrayList<String> originalList = new ArrayList<String>();

		  for (WebElement e : se.getOptions()) {
		   originalList.add(e.getText());
		  }
		  System.out.println("originalList:" + originalList);

		  ArrayList<String> tempList = originalList;
		  Collections.sort(tempList); // When you change one list, it changes the other list as well.

		  System.out.println("originalList:" + originalList);
		  System.out.println("tempList:" + tempList);
		  Assert.assertEquals(originalList, tempList);

	}
	
	@Test(priority = 6)
	public void validatingLeaveBalanceDropdownOptionsDuplicates()
	{
		WebElement element = assignLeavePage.leaveType();
		  Select se = new Select(element);

		    List<WebElement> list = se.getOptions();
		    Set<String> s = new LinkedHashSet<String>();
		    for (WebElement w : list) {
		        s.add(w.getText());
		    }

		    Assert.assertEquals(list.size(),s.size());
	}
	
	@Test(priority = 7)
	public void verifyEmpNameContainsCharacters()
	{

		String str = assignLeavePage.empName().getAttribute("Value");
		System.out.println("Emp Name : "+str);
		/*
		 * String alpha = new String();
		 * 
		 * for (int i=0;i<str.length();i++) { if
		 * (Character.isAlphabetic(str.charAt(i))||str.contains(" ")) {
		 * alpha+=(str.charAt(i));
		 * 
		 * } else break; } System.out.println("Emp Name : "+str
		 * +"\nAlpha String : "+alpha);
		 * Assert.assertEquals(str.length(),alpha.length());
		 */
	    boolean flag = true;
	    for(int i=0;i<str.length();i++)
	    {
	    	if(Character.isDigit(str.charAt(i)))
	    	{
	    		flag = false;
	    		break;
	    	}
	    }
	    Assert.assertTrue(flag);
	}
	
	@Test(priority = 8)
	public void verifyToDateShouldBeAfterFromDate() throws ParseException
	{
		String fromDate = assignLeavePage.fromDate().getAttribute("value");
		String toDate = assignLeavePage.toDate().getAttribute("value");
		boolean flag;
		System.out.println("From Date : "+fromDate);
		System.out.println("To Date : "+toDate);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate1 = formatter.parse(fromDate);
		Date toDate1 = formatter.parse(toDate);
		System.out.println("From date after : "+fromDate1+"\nTo DAte after : "+toDate1);
		if(toDate1.after(fromDate1))
			flag = true;
		else
			flag = false;
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 9)
	public void verifyCommentsCharacters() throws ParseException
	{
		String comments = assignLeavePage.comment().getAttribute("value");
		System.out.println("Comments : "+comments);
		boolean flag;
		if(comments.length()>250)
		{
			flag = false;
			System.out.println("Comments should be less than 250 characters.");
		}
		else
		{
			flag = true;
		}
		Assert.assertTrue(flag);
		System.out.println("Comments are less than 250 characters.");
	}
	
	@Test(priority = 10)
	public void verifyFromDateFormat()
	{
		String fromDate = assignLeavePage.fromDate().getAttribute("value");
		StringBuffer sBuffer = new StringBuffer(fromDate);
		String date,month,year;
		boolean flag;
		year = sBuffer.substring(0,4);
		month = sBuffer.substring(5,7);
		date = sBuffer.substring(8,10);
		System.out.println("From Date : "+fromDate);
		System.out.println(" Year: "+ year+" Mon: "+ month +" Date: "+ date);
   	    
		if(year.matches("(19|20)\\d\\d") &&month.matches("0[1-9]|1[0-2]") && date.matches("0[1-9]|[12][0-9]|3[01]") )
	    {
			 System.out.println("From Date Format matched.");
			 flag = true;
		}
		else
		{
			System.out.println("From Date Format didn't matched.");
			flag =  false;
		}
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 11)
	public void verifyToDateFormat()
	{
		String toDate = assignLeavePage.toDate().getAttribute("value");
		StringBuffer sBuffer = new StringBuffer(toDate);
		String date,month,year;
		boolean flag;
		year = sBuffer.substring(0,4);
		month = sBuffer.substring(5,7);
		date = sBuffer.substring(8,10);
		System.out.println("To Date : "+toDate);
		System.out.println(" Year: "+ year+" Mon: "+ month +" Date: "+ date);
   	    
		if(year.matches("(19|20)\\d\\d") &&month.matches("0[1-9]|1[0-2]") && date.matches("0[1-9]|[12][0-9]|3[01]") )
	    {
			 System.out.println("To Date Format matched.");
			 flag = true;
		}
		else
		{
			System.out.println("To Date Format didn't matched.");
			flag =  false;
		}
		Assert.assertTrue(flag);
	}
	@Test(priority = 12)
	public void validatingMandatoryFields()
	{
		driver.findElement(By.id("assignBtn")).click();
		System.out.println("Assign Button clicked");
		boolean flag ;
		if(assignLeavePage.empName().getAttribute("value").isEmpty())
		{
			System.out.println("Emp Name is invalid");
			flag = false;
			System.out.println(driver.findElement(By.className("validation-error")).getText()+" is displayed");
		}
		if(assignLeavePage.leaveType().getAttribute("value").isEmpty())
		{
			System.out.println("Leave Type is required");
			flag = false;
		}
		if(assignLeavePage.fromDate().getAttribute("value").isEmpty())
		{
			System.out.println("from date should be a valid date in yyyy-mm-dd format ");
			flag = false;
		}
		if(assignLeavePage.toDate().getAttribute("value").isEmpty())
		{
			System.out.println("to date should be a valid date in yyyy-mm-dd format ");
			flag = false;
		}
		else
		{
			System.out.println("Mandatory fields are valid");
			flag = true;
		}
		Assert.assertTrue(flag);
		System.out.println("All Manatory fields Entered with valid data");
	}
	
	
	@Test(priority = 13)
	public void verifyPartialDaysAsNone() 
	{
		DropDownUtil.selectbytext(assignLeavePage.partialDays(), "None");
		System.out.println("Partial Days is selected as none"); 
	}
	
	@Test (priority = 14)
	public void verifyPartialDaysAsAllDays() 
	{
		DropDownUtil.selectbytext(assignLeavePage.partialDays(), "All Days");
		System.out.println("Partial Days is selected as All Days");
		assignLeavePage.dropdownsMethodForStart();
	}
	
	@Test (priority = 15)
	public void verifyPartialDaysAsStartDayOnly() 
	{
		DropDownUtil.selectbytext(assignLeavePage.partialDays(), "Start Day Only");
		System.out.println("Partial Days is selected as Start Day Only");
		assignLeavePage.dropdownsMethodForStart();
	}
	
	@Test (priority = 16)
	public void verifyPartialDaysAsEndDayOnly()
	{
		DropDownUtil.selectbytext(assignLeavePage.partialDays(), "End Day Only");
		System.out.println("Partial Days is selected as End Day Only");
		assignLeavePage.dropdownsMethodForEnd();
	}
	
	@Test (priority = 17)
	public void verifyPartialDaysAsStartandEndDay()
	{
		DropDownUtil.selectbytext(assignLeavePage.partialDays(), "Start and End Day");
		System.out.println("Partial Days is selected as Start and End Day");
		System.out.println("For Start Day");
		assignLeavePage.dropdownsMethodForStart();
		System.out.println("For End Day");
		assignLeavePage.dropdownsMethodForEnd();
	}
	//@AfterClass
	public void navigatingToAssignLeaveSubMenu()
	{
		System.out.println("After Class Assign Leave");
	}
}
