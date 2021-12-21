package com.orangeHRM.qa.testcases;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;


public class BaseVerificationTest extends BaseClass{

	BaseVerification baseVerification;
	@Test (priority =0)
	public void verifyCommonElements() throws IOException, InterruptedException
	{
		System.out.println("Entered Verify");
		baseVerification = new BaseVerification(driver);
		//Assert.assertEquals(driver.getTitle(),baseverification.verifyOrangeHRMTitle());
		//System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Title is : "+baseVerification.verifyOrangeHRMTitle());
		Assert.assertTrue(baseVerification.isTitleContains());
		System.out.println("Title Verified");
		Assert.assertTrue(baseVerification.currentUrl("orangehrm"));
		System.out.println("Url Verified");
		Assert.assertTrue(baseVerification.getLogo_id().isDisplayed());
		System.out.println("Logo displayed");
		Assert.assertTrue(baseVerification.getLogindetailsDisplayed_xpath().isDisplayed());
		System.out.println("login details displayed");
		Assert.assertTrue(baseVerification.getLoginPanel_id().isDisplayed());
		System.out.println("login panel displayed");
		Assert.assertTrue(baseVerification.getFooter_id().isDisplayed());
		System.out.println("Footer displayed");
	}
	@Test(priority = 1)
	public void verifyCommonElementsAfterLogin() throws IOException, InterruptedException
	{
		login();
		System.out.println("After login ");
		System.out.println("Logged in Title is : "+baseVerification.verifyOrangeHRMTitle());
		Assert.assertTrue(baseVerification.isTitleContains());
		System.out.println("Title Verified");
		Assert.assertTrue(baseVerification.getAfterLoginLogo_id().isDisplayed());
		System.out.println("Logo displayed");
		Assert.assertTrue(baseVerification.getWelcomeUser_id().isDisplayed());
		System.out.println("Welcome User displayed");
		Assert.assertTrue(baseVerification.getMarketPlace_id().isDisplayed());
		System.out.println("Market Place Id displayed");
		Assert.assertTrue(baseVerification.getBellIcon_id().isDisplayed());
		System.out.println("Bell icon displayed");
		Assert.assertTrue(baseVerification.getSubscribeButton_id().isDisplayed());
		System.out.println("Subscribe button displayed");
		Assert.assertTrue(baseVerification.getHelpIcon_id().isDisplayed());
		System.out.println("Help icon displayed");
		Assert.assertTrue(baseVerification.getTitleBarList_id().isDisplayed());
		System.out.println("TitleBar List displayed");
		Assert.assertTrue(baseVerification.getFooter_id().isDisplayed());
		System.out.println("Footer displayed");
	}
	@Test(priority = 2)
	public void verifyingTitleBarElementsDisplay()
	{
		Assert.assertTrue(baseVerification.getAdmin_id().isDisplayed());
		System.out.println("Admin displayed");
		Assert.assertTrue(baseVerification.getPIM_id().isDisplayed());
		System.out.println("PIM displayed");
		Assert.assertTrue(baseVerification.getLeave_id().isDisplayed());
		System.out.println("Leave displayed");
		Assert.assertTrue(baseVerification.getTime_id().isDisplayed());
		System.out.println("Time displayed");
		Assert.assertTrue(baseVerification.getRecruitment_id().isDisplayed());
		System.out.println("Recruitment displayed");
		Assert.assertTrue(baseVerification.getMyinfo_id().isDisplayed());
		System.out.println("My info displayed");
		Assert.assertTrue(baseVerification.getPerformance_id().isDisplayed());
		System.out.println("Performance displayed");
		Assert.assertTrue(baseVerification.getDashboard_id().isDisplayed());
		System.out.println("Dashboard displayed");
		Assert.assertTrue(baseVerification.getDirectory_id().isDisplayed());
		System.out.println("Directory displayed");
		Assert.assertTrue(baseVerification.getMaintenance_id().isDisplayed());
		System.out.println("Maintenance displayed");
		Assert.assertTrue(baseVerification.getBuzz_id().isDisplayed());
		System.out.println("Buzz displayed");
	}
	
	@Test(priority = 3)
	public void verifyingNavigation()
	{
		baseVerification.navigatingToAdmin();
		Assert.assertTrue(baseVerification.currentUrl("admin"));
		baseVerification.navigatingToPIM();
		Assert.assertTrue(baseVerification.currentUrl("pim"));
		baseVerification.navigatingToLeave();
		Assert.assertTrue(baseVerification.currentUrl("leave"));
		baseVerification.navigatingToTime();
		Assert.assertTrue(baseVerification.currentUrl("time"));
		baseVerification.navigatingToRecruitment();
		Assert.assertTrue(baseVerification.currentUrl("recruitment"));
		baseVerification.navigatingToMyInfo();
		Assert.assertTrue(baseVerification.currentUrl("pim"));
		/*
		 * baseverification.navigatingToPerformance(); Assert.assertTrue(baseverification.currentUrl("performance"));
		 */
		baseVerification.navigatingToDashboard();
		Assert.assertTrue(baseVerification.currentUrl("dashboard"));
		baseVerification.navigatingToDirectory();
		Assert.assertTrue(baseVerification.currentUrl("directory"));
		baseVerification.navigatingToMaintenance();
		Assert.assertTrue(baseVerification.currentUrl("maintenance"));
		baseVerification.navigatingToBuzz();
		Assert.assertTrue(baseVerification.currentUrl("buzz"));
	}
	
	@Test(priority = 4)
	public void afterLoginLogoClick()
	{
		baseVerification.getAfterLoginLogo_id().click();
		
	    String parent_window=driver.getWindowHandle();
		
		Set<String> windows=driver.getWindowHandles();
		
		java.util.Iterator<String> Iterate =  windows.iterator();
		
		
		while(Iterate.hasNext())
		{
			String Child_Window=Iterate.next();
			
			if(!parent_window.equals(Child_Window))
			{
			   driver.switchTo().window(Child_Window);
			   String ChildWindowUrl = driver.switchTo().window(Child_Window).getCurrentUrl();
			   System.out.println("The Child Wind Url is "  + ChildWindowUrl );
			   String ChildWindowTitle = driver.switchTo().window(Child_Window).getTitle();
			   System.out.println("The Child Wind Title is "  + ChildWindowTitle );
			   Assert.assertEquals(ChildWindowUrl, "https://www.orangehrm.com/");
			   Assert.assertEquals(ChildWindowTitle, "OrangeHRM HR Software | Free HR Software | HRMS | HRIS");
			   System.out.println("When I click AfterLoginLogo its navigating to \"https://www.orangehrm.com/\" ");
			  driver.close();	
			}
		}
		driver.switchTo().window(parent_window);
	}
	
	@Test(priority = 5)
	public void helpIdClick()
	{
		baseVerification.getHelpIcon_id().click();
		 String helpIcon_prnt_window=driver.getWindowHandle();
			
			Set<String> windows=driver.getWindowHandles();
			
			java.util.Iterator<String> Iterate =  windows.iterator();
			
			while(Iterate.hasNext())
			{
				String HelpIconChild_Window=Iterate.next();
				
				if(!helpIcon_prnt_window.equals(HelpIconChild_Window))
				{
					driver.switchTo().window(HelpIconChild_Window);
				
				    String helpIconchildwindowUrl=driver.switchTo().window(HelpIconChild_Window).getCurrentUrl();
					System.out.println("Help Id Child window URL is  "  + helpIconchildwindowUrl);
				 String helpIconchildwindowTitle = driver.switchTo().window(HelpIconChild_Window).getTitle();
					System.out.println("Help Id Child window Title is  "  +helpIconchildwindowTitle);
				
					Assert.assertEquals(helpIconchildwindowUrl,"https://starterhelp.orangehrm.com/hc/en-us");
					Assert.assertEquals( helpIconchildwindowTitle, "OrangeHRM");
					System.out.println("When I click Help Icon its navigating to ==> https://starterhelp.orangehrm.com/hc/en-us ");
					
				}
			}
			
	}
	

}


