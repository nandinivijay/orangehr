package com.orangeHRM.qa.testcases;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.ApplyLeavePage;
import com.orangeHRM.qa.pages.AssignLeavePage;
import com.orangeHRM.qa.pages.DashboardPage;
import com.orangeHRM.qa.pages.EmployeeTimeSheetsPage;
import com.orangeHRM.qa.pages.LeaveListPage;
import com.orangeHRM.qa.pages.MyLeavePage;
import com.orangeHRM.qa.pages.MyTimeSheetsPage;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;


public class DashboardPageTest extends BaseClass{

	BaseVerification baseVerification ;
	DashboardPage dashboardpage;
	@BeforeClass
	public void verifyDashboardPageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		dashboardpage = baseVerification.navigatingToDashboard();
		Assert.assertTrue(dashboardpage.getcurrentUrl());
		System.out.println("Clicked Dashboard and asserted URL");
	}
	
	@Test
	public void dashboardTesting() throws Throwable
	{
		System.out.println("Dashboard Clicked");
		SynchronisationWaitsUtil.pageloadtimeout(3000, TimeUnit.SECONDS, driver);

		// checking presence of common elements of page after clicking on Dashboard
		try {
			Assert.assertTrue(baseVerification.getBellIcon_id().isDisplayed());
			Assert.assertTrue(baseVerification.getFooter_id().isDisplayed());
			Assert.assertTrue(baseVerification.getHelpIcon_id().isDisplayed());
			Assert.assertTrue(baseVerification.getMarketPlace_id().isDisplayed());
			Assert.assertTrue(baseVerification.getSubscribeButton_id().isDisplayed());
			Assert.assertTrue(baseVerification.getWelcomeUser_id().isDisplayed());
			Assert.assertTrue(baseVerification.getWelcomeUser_id().getText().contains("Welcome"));
		} catch (AssertionError ae) {
			System.out.println("checking Objec reposity elements present" + ae);

			// TakeScreenshotUtil.takeScreenshot("dashboard_BasicElements", driver);
		} catch (WebDriverException we) {
			System.out.println("checking Objec reposity elements present" + we);

		}

		dashboardpage = new DashboardPage(driver);

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		System.out.println("Dashboard url is validated");
		Assert.assertTrue(dashboardpage.quickLaunchIsDisplayed());
		System.out.println("quicklaunch is displayed");

		Assert.assertTrue(dashboardpage.AssignLeaveIsDisplayed());
		System.out.println("AssignLeave is displayed");

		Assert.assertTrue(dashboardpage.ApplyLeaveIsDisplayed());
		System.out.println("ApplyLeave is displayed");

		Assert.assertTrue(dashboardpage.LeaveListIsDisplayed());
		System.out.println("LeaveList is displayed");

		Assert.assertTrue(dashboardpage.TimeSheetsIsDispalyed());
		System.out.println("TimeSheets is displayed");

		Assert.assertTrue(dashboardpage.MyLeaveIsDisplayed());
		System.out.println("MyLeave is displayed");

		Assert.assertTrue(dashboardpage.MyTimeSheetIsDisplayed());
		System.out.println("MyTimeSheet is displayed");

		Assert.assertTrue(dashboardpage.emp_DistributionIsDisplayed());
		System.out.println("emp_Distribution is displayed");

		Assert.assertTrue(dashboardpage.legendIsDisplayed());
		System.out.println("legend is displayed");

		Assert.assertTrue(dashboardpage.pending_leave_requestIsDisplayed());
		System.out.println("pending_leave_request is displayed");

		// checking the url of quicklaunch elements.

		// AssignLeave Page url is validating here
		AssignLeavePage assignleavepage = dashboardpage.clickAssignLeave();
		Assert.assertTrue(assignleavepage.getcurrentUrl());
		System.out.println("AssignLeave url is validated");
		driver.navigate().back();

		// ApplyLeave Page url is validating here
		ApplyLeavePage applyleavepage = dashboardpage.clickApplyLeave();
		Assert.assertTrue(applyleavepage.getcurrentUrl());
		System.out.println("ApplyLeave url is validated");
		driver.navigate().back();

		// Leavelist Page url is validated here
		LeaveListPage leavelistpage = dashboardpage.clickLeaveList();
		Assert.assertTrue(leavelistpage.getcurrentUrl());
		System.out.println("LeaveList url is validated");
		driver.navigate().back();

		// MyLeave Page url is validated here
		MyLeavePage myleavepage = dashboardpage.clickMyLeave();
		Assert.assertTrue(myleavepage.getcurrentUrl());
		System.out.println("MyLeave url is validated");
		driver.navigate().back();
		
		  //Timesheets url is validated here MyTimeSheetPage
		MyTimeSheetsPage mytimesheetpage= dashboardpage.clickMyTimeSheet();
		  Assert.assertTrue(mytimesheetpage.getcurrentUrl());
		  System.out.println("MYTimesSheetPage url is validated");
		  driver.navigate().back();
		  
		  
		  
		 //Timesheets url is validated here EmployeeTimeSheetsPage
		  EmployeeTimeSheetsPage employeetimesheetspage=dashboardpage.clickTimeSheets();
		  Assert.assertTrue(employeetimesheetspage.getcurrentUrl());
		  System.out.println("TimesSheetPage url is validated");
		  driver.navigate().back();
		  
		  
		 

		// Graph validations
		try {
			Assert.assertTrue(dashboardpage.getSegmentsList().size() == 7);
		} catch (AssertionError ae) {
			System.out.println("In checkGraph_NoOfSegment ---should be 7 : " + ae);
			//TakeScreenshotUtil.takeScreenshot("dashboard_piechart", driver);
		} catch (WebDriverException we) {
			System.out.println("In checkGraph_NoOfSegment  :" + we);
		}

		// checking number of tooltips displayed
		int numberOfToolTips = 0;
		Pair<Map, List> expectedp = dashboardpage.getTooltipTotalPercentage();
		// List<Integer> expectedl=expectedp.second();
		List<Integer> tooltipvalue = expectedp.second();
		Map<String, String> expectedm = expectedp.first();
		try {

			numberOfToolTips = expectedp.first().size(); // size of map containg tooltip text and its color
		//	System.out.println("Number of Tooltip'd displayed are : " + numberOfToolTips);
			Assert.assertTrue(numberOfToolTips == 7);
		//	System.out.println("All 7 tooltip percentage is printed.");
		} catch (AssertionError ae) {
			System.out.println("Number tooltip displayed-----should be 7" + ae);
			//TakeScreenshotUtil.captureScreenshot("dashboard_piechart");
		} catch (WebDriverException we) {
			System.out.println("Number tooltip displayed-----should be 7" + we);

		}
		// to validate all tooltipvalues added up to 100%
		int sum = 0;

		System.out.println("numberOfToolTips : before checking the sum of percentages" + numberOfToolTips);
		for (int i = 0; i < tooltipvalue.size(); i++) {
			sum = sum + (int) tooltipvalue.get(i);
		}
		System.out.println("pie chart--tooltip text sum is : " + sum);
		try {
			Assert.assertTrue(sum == 100);
		} catch (AssertionError ae) {
			System.out.println("In tooltiptotalpercentage ---should be 100 : " + ae);
		} catch (WebDriverException we) {
			System.out.println("In tooltipvalue.size()-----should be 7" + we);
			System.out.println("In tooltiptotalpercentage ---should be 100 : " + we);
		}

		// validating tooltip text with graph text percentage after roundup and
		// rounddown of decimal <.5 to lower and >.5 to upper number
		List<WebElement> chartpercentage = dashboardpage.getSegmentsList();
		for (int i = 0; i < tooltipvalue.size(); i++) {

			Long graphSegmentValue = (Long) NumberFormat.getNumberInstance(java.util.Locale.US)
					.parse(chartpercentage.get(i).getText());
			try {
			//	System.out.println("graphSegmentValue" + graphSegmentValue);
				Assert.assertTrue(tooltipvalue.get(i) == graphSegmentValue.intValue());
			} catch (AssertionError ae) {
				System.out.println("checking tooltip percentage with grap percentage : " + ae);
			} catch (WebDriverException we) {
				System.out.println("checking tooltip percentage with grap percentage :" + we);

			}

		}

		// validating color of the tooltip text with the legentcolor----I gave a try
		// with multiple for loop
		List<WebElement> legendtext = dashboardpage.getlegentText();
		List<WebElement> legendcolor = dashboardpage.getlegendColorBox();
//		for(int i=0;i<legendtext.size();i++) {
		for (String key : expectedm.keySet())
			for (WebElement text : legendtext) 
				for (WebElement color : legendcolor) {
					if (key == text.getText()) {
				//		System.out.println("color.getCssValue(color))" + color.getCssValue("color"));
						Assert.assertTrue(expectedm.get(key).equalsIgnoreCase(color.getCssValue("color")));
					}

				}
		}
	


}
