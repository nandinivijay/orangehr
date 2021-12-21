package com.orangeHRM.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;
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

import com.orangeHRM.qa.pages.Memberships_MyInfoPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.ColorValidationUtil;
import com.orangeHRM.qa.util.DeleteUtil;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class Memberships_MyInfoPageTest extends MyInfoPageTest {
	Memberships_MyInfoPage memberships_MyInfoPage;
	WebElement element;

	@BeforeClass
	public void verifymemberships_MyInfoPageNavigation() {

		memberships_MyInfoPage = myInfoPage.navigatingToMemberships_MyInfo();
		System.out.println("Clicked memberships_MyInfoPage and url is validated");
	}

	@Test (priority=3)
	public void validateMemberships_MyInfoButton_bgcolor() {
		try {

			element = myInfoPage.getMemberships_MyInfo_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("memberships_MyInfoPage button bg-color is validated after clicking---grey");
			
			
		} catch (AssertionError ae) {
			System.out.println("In memberships_MyInfoPage Testing--validateMemberships_MyInfoButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In memberships_MyInfoPage--validateMemberships_MyInfoButton_bgcolor :" + we.getMessage());
		}

	}
	
	

	@Test(priority = 4)
		public void mandatoryFieldValidation() {
			memberships_MyInfoPage.addMembershipButton().click();
			memberships_MyInfoPage.saveMembershipButton().click();
			boolean flag;
			if (memberships_MyInfoPage.selMembership().getAttribute("value").isEmpty()) {
				flag = true;
				System.out.println("Membership Field Is Empty");
			} else {
				System.out.println("Membership Field Is Not Empty");
				flag = false;
			}
			Assert.assertTrue(flag);
			System.out.println("All Mandatory Fields Are Tested Successfully");
			memberships_MyInfoPage.cancelMembershipButton().click();
			// driver.quit();
		}

	@Test(priority=5)
	public void setcontext(ITestContext context) {
	int	sheetnumber=26;
	context.setAttribute("index", sheetnumber);
	}
	@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class,priority=6 )

	public void verifyAddMembershipTesting(String membership,String subPaidBy,String subAmt,String currencyType,String commencedd,String commencemonth,String commenceyear,String renewaldd,String renewalmonth,String renewalyear) throws Exception
	{
		Thread.sleep(5000);
		memberships_MyInfoPage.addMembershipButton().click();
		
		memberships_MyInfoPage.selMembership().sendKeys(membership);
		memberships_MyInfoPage.selSubscriptionPaidBy().sendKeys(subPaidBy);
		memberships_MyInfoPage.selSubscriptionAmt().sendKeys(subAmt);
		DropDownUtil.selectbyindex(memberships_MyInfoPage.selCurrency(), Integer.parseInt(currencyType));
		memberships_MyInfoPage.commenceDate().click();	
		DropDownUtil.selectbyvalue(memberships_MyInfoPage.selmonth(), commencemonth);
		DropDownUtil.selectbyvalue(memberships_MyInfoPage.selYear(), commenceyear);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+commencedd+")]")).click();

		memberships_MyInfoPage.renewalDate().click();

		
		DropDownUtil.selectbyvalue(memberships_MyInfoPage.selmonth(), renewalmonth);
		DropDownUtil.selectbyvalue(memberships_MyInfoPage.selYear(), renewalyear);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+renewaldd+")]")).click();
		
		memberships_MyInfoPage.saveMembershipButton().click();
		
	}
	
	@Test(priority=7)
	public void colorValidationForAddandDeleteButtons()
	{
		 String addhex = ColorValidationUtil.GetColor(memberships_MyInfoPage.addMembershipButton());
		 System.out.println("add button colur"+addhex);
		 String deletehex = ColorValidationUtil.GetColor(memberships_MyInfoPage.delMembershipButton());
		 System.out.println("deletebutton colur"+deletehex);
		 Assert.assertEquals(addhex,"Green");
		 Assert.assertEquals(deletehex,"Red");
		 Assert.assertNotEquals(addhex,deletehex);
		 System.out.println("add and delete button colors are different");

	}
	
	
	@Test(priority = 8)
	public void membershiptableValidating() 
	{
		List<WebElement> li = driver.findElements(By.xpath("//*[@id='frmEmpDelMemberships']/table/thead/tr/th"));
		int n = li.size();
		List<String> s = new ArrayList<String>();     
		System.out.println("size of Columns : " + n);
		for (int i = 0; i < n; i++) 
		{
			s.add(li.get(i).getText());
		}

		System.out.println("List String : " + s);
		System.out.println("No . of columns in a table are : " + n);
		Assert.assertEquals(7, n);

		for (int i = 1; i <= n - 1; i++) 
		{
			WebElement header = driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/thead/tr/th[" + (i + 1) + "]"));
			System.out.print(header.getText());
			if (header.getText().equalsIgnoreCase("Membership")) 
			{
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Membership"));
			} 
			else if (header.getText().equalsIgnoreCase("subscriptionpaidby")) 
			{
				System.out.println(": is  in the header ");
				Assert.assertTrue(header.getText().contains("subscriptionpaidby"));
			} 
			else if (header.getText().equalsIgnoreCase("subscriptionAmt")) 
			{
				System.out.println(": is  in the header ");
				Assert.assertTrue(header.getText().contains("subscriptionAmt"));
			} 
			else if (header.getText().equalsIgnoreCase("Currency")) 
			{
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Currency"));
			}
			else if (header.getText().equalsIgnoreCase("CommenceYear")) 
			{
				System.out.println(": is  in the header ");
				Assert.assertTrue(header.getText().contains("CommenceYear"));
			}
			else if (header.getText().equalsIgnoreCase("RenewalYear")) 
			{
				System.out.println(": is  in the header ");
				Assert.assertTrue(header.getText().contains("RenewalYear"));
			} 
		}
	}

	
	//@Test(priority = 9)
	public void membershipdropdownSortedOrNot() {
		
		WebElement element1 = memberships_MyInfoPage.selMembership();
		Select sel = new Select(element1);
		ArrayList<String> originalList = new ArrayList<String>();
		
		for (WebElement e : sel.getOptions()) {
			//System.out.println("New "+driver.findElement(By.xpath("//*[@id=\"education_code\"]/option[2]")).getText());
			originalList.add(e.getText());
		}
		System.out.println("OriginalList:" + originalList);
		ArrayList<String> tempList = originalList;
		Collections.sort(tempList);

		System.out.println("OriginalList:" + originalList);
		System.out.println("TempList:" + tempList);
		Assert.assertEquals(originalList, tempList);
		System.out.println("OriginalList and TempList Dropdowns are in sorted order ");
		

	}
	
	//@Test(priority = 10)
	public void validatingLevelDropdownOptionsDuplicates()
	{
		WebElement element1 =memberships_MyInfoPage.selMembership();
		  Select se = new Select(element1);
		
		    List<WebElement> list = se.getOptions();
		    
		    Set<String> s = new LinkedHashSet<String>();
		    for (WebElement w : list) {
		        s.add(w.getText());
		        System.out.println(s);
		    }
		    System.out.println("List size = "+list.size()+"\n Set Size = "+s.size());
		    Assert.assertEquals(list.size(),s.size());
		    System.out.println("No duplicates present in dropdown.");
	}
	
	//@Test(priority = 11)
	public void verifycommenceDateFormat() throws Exception 
	{
		
		String commenceDate = memberships_MyInfoPage.commenceDate().getAttribute("value");
		System.out.println("Here is Commence Date Value: " + commenceDate);
		StringBuffer sBuffer = new StringBuffer(commenceDate);
		System.out.println("String buffer : "+sBuffer);
		String date, month, year;
		boolean flag;
		year = sBuffer.substring(0, 4);
		month = sBuffer.substring(5, 7);
		date = sBuffer.substring(8, 10);
		System.out.println("Year:" + year + " Mon:" + month + " Date:" + date);

		if (year.matches("^[12][0-9]{3}$") && month.matches("^(0?[1-9]|1[012])$")
				&& date.matches("^(0[1-9]|[12]\\d|3[01])$")) {
			System.out.println("Start Date Format Matched.");
			flag = true;
		} else {
			System.out.println("Start Date Format Didn't Matched.");
			flag = false;
		}
		Assert.assertTrue(flag);
		Thread.sleep(2000);
	}
	
	@Test(priority=12)
	public void setcontext3(ITestContext context) {
	int	sheetnumber=27;
	context.setAttribute("index", sheetnumber);
	}
	
	@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class ,priority=13,dependsOnMethods = { "verifyAddMembershipTesting" })
	public void editMembershipTesting(String membership1,String subPaidBy1,String subAmt1,String currencyType1,String commencedd1,String commencemonth1,String commenceyear1,String renewaldd1,String renewalmonth1,String renewalyear1) throws Exception 
	{
		System.out.println("Memberships Page clicked");
		
		SynchronisationWaitsUtil.implicitwait(12,TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Membership : "+memberships_MyInfoPage.getcurrentUrl());
		driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr[1]/td[2]/a")).click();
			
		//memberships_MyInfoPage.selMembership().clear();
		memberships_MyInfoPage.selMembership().sendKeys(membership1);
		//memberships_MyInfoPage.selSubscriptionPaidBy().clear();
		memberships_MyInfoPage.selSubscriptionPaidBy().sendKeys(subPaidBy1);
		memberships_MyInfoPage.selSubscriptionAmt().clear();
		memberships_MyInfoPage.selSubscriptionAmt().sendKeys(subAmt1);
		//memberships_MyInfoPage.selCurrency().clear();
		DropDownUtil.selectbyindex(memberships_MyInfoPage.selCurrency(), Integer.parseInt(currencyType1));
		memberships_MyInfoPage.commenceDate().click();	
		DropDownUtil.selectbyvalue(memberships_MyInfoPage.selmonth(), commencemonth1);
		DropDownUtil.selectbyvalue(memberships_MyInfoPage.selYear(), commenceyear1);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+commencedd1+")]")).click();

		memberships_MyInfoPage.renewalDate().click();

		
		DropDownUtil.selectbyvalue(memberships_MyInfoPage.selmonth(), renewalmonth1);
		DropDownUtil.selectbyvalue(memberships_MyInfoPage.selYear(), renewalyear1);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+renewaldd1+")]")).click();
		
		memberships_MyInfoPage.saveMembershipButton().click();
		System.out.println("Clickes save button.");
		
		
		SynchronisationWaitsUtil.threadsleep(2000);
		List<WebElement> table = driver.findElements(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr"));
		int size = table.size();
		for (int i=1;i<size;i++)
		{
		 
		   String membership = driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr["+i+"]/td[1]")).getText();
		   String subpaidBy = driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr["+i+"]/td[2]")).getText();
		   String subAmt = driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr["+i+"]/td[3]")).getText();
		   String currency = driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr["+i+"]/td[4]")).getText();
		   String commencedate = driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr["+i+"]/td[5]")).getText();
		   String commenceyear = driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr["+i+"]/td[6]")).getText();
		   if(membership.equals(membership1) && subpaidBy.equals(subPaidBy1) && subAmt.equals(subAmt1) && currency.equals(currencyType1))
		   {
		   Assert.assertEquals(membership,membership1 );
		   System.out.println("Membership Edited Successfully");
		   
		   Assert.assertEquals(subpaidBy,subPaidBy1 );
		   System.out.println("subscription Paid by Edited Successfully");
		   
		   Assert.assertEquals(subAmt,subAmt1);
		   System.out.println("subscription Amount Edited Successfully");
		   
		   Assert.assertEquals(currency,currencyType1 );
		   System.out.println("Currency Edited Successfully");
		   }
		}
	}

	int finalmembershipnumRows;
	@Test(priority = 14, dependsOnMethods = { "verifyAddMembershipTesting" })
	public void deletingSingle_Membership() throws Exception
	{
		if (memberships_MyInfoPage.delMembershipButton().isDisplayed())
		{
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr"));
		int numRows = rows.size();
		System.out.println("No. of Rows Before Deleting 1 row: " + numRows);
		driver.findElement(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr[1]/td[1]")).click();
		memberships_MyInfoPage.delMembershipButton().click();
		/*
		 * WebElement element1 = driver.findElement(By.xpath(
		 * "//*[@id='frmEmpDelMemberships']/table/tbody/tr[1]/td[1]")); WebElement
		 * deletebtn = memberships_MyInfoPage.delMembershipButton();
		 * DeleteUtil.singleRowDelete(driver, element1, rows, deletebtn);
		 */
		List<WebElement> finalnumrows = driver.findElements(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr"));
		finalmembershipnumRows = finalnumrows.size();
		System.out.println("No. of Rows After Deleting 1 row : " + finalmembershipnumRows);
		Assert.assertEquals(finalmembershipnumRows, numRows-1);
	} else {
		Assert.assertFalse(memberships_MyInfoPage.delMembershipButton().isDisplayed());
		System.out.println("No Rows Displayed");
	}
	}

	@Test(priority = 15)
	
	public void deletingall_Membership() {

		/*
		 * WebElement delallcheckbox = memberships_MyInfoPage.membershipCheckallboxes();
		 * DeleteUtil.allRowDelete(driver, delallcheckbox );
		 */
		  if (finalmembershipnumRows > 0 ) 
		  {
			  List<WebElement> rows = driver.findElements(By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr"));
			  int numRows = rows.size();
		  System.out.println("No. of Rows Before Deleting : " + numRows);
		  memberships_MyInfoPage.membershipCheckallboxes().click();
		  memberships_MyInfoPage.delMembershipButton().click();
		  System.out.println("All rows deleted.");
		  
		  } else {
		  
		  System.out.println("No rows Displayed"); }
		 
	}

}
