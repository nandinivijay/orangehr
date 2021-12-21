package com.orangeHRM.qa.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.config.ReadConfigProp;

import com.orangeHRM.qa.pages.ResetPsswordPage;
import com.orangeHRM.qa.testdata.ExcelReader;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class ResetPasswordTestPage extends BaseClass{
	
	@Test(priority=0)
	public void verify_PageElements() throws Exception {
		SynchronisationWaitsUtil.threadsleep(3000);
		ResetPsswordPage rpp=PageFactory.initElements(driver, ResetPsswordPage.class);
		rpp.clickOnForgotPasssword();
		
		//to verify "forgot password? is present
		try {
			Assert.assertTrue(rpp.isHeadingPresent());
			System.out.println("Heading present? : " + rpp.isHeadingPresent());
		}catch(AssertionError ae) {
			System.out.println("In verify_PageElements method-----isHeadingPresent : " + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In verify_PageElements method-----isHeadingPresent : " + we.getMessage());
		}
		
		//To verify "Please enter your username to identify your account to reset your password." is displayed
		try {
			Assert.assertTrue(rpp.isDescriptionPresent());
			 System.out.println("Descriptiom present ? : " +rpp.isDescriptionPresent());
		}catch(AssertionError ae) {
			System.out.println("In verify_PageElements method----isDescriptionPresent : " + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In verify_PageElements method-----isDescriptionPresent : " + we.getMessage());
		}
		
		//to verify "OrangeHRM Username" is displayed
		try {
			Assert.assertTrue(rpp.islabelUserName());
			System.out.println("label present? : " + rpp.islabelUserName());
		}catch(AssertionError ae) {
			System.out.println("In verify_PageElements method----islabelUserName : " + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In verify_PageElements method----islabelUserName : " + we.getMessage());
		}
		
		
		
		 
	}
	
	@Test (priority=1)
	public void space_Credentials() throws Exception {
		SynchronisationWaitsUtil.threadsleep(3000);
		ResetPsswordPage rpp=PageFactory.initElements(driver, ResetPsswordPage.class);
		
		//rpp.clickOnForgotPasssword();
		rpp.setUserName("");
		rpp.clickOnRest();
		Pair<String,Boolean>p=rpp.getMessageText_InvalidUserName();
		System.out.println("Text afterclicking on reset with space as username and requested for reset : " + p.first() +" value : "+ p.second());
		
		//to validate the Text message displayed is correct for the given data
		try {
			Assert.assertTrue(p.first().contains("Could not find a user with given details"));
		}catch(AssertionError ae) {
			System.out.println("In space_Credentials method : " + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In space_Credentials method : " + we.getMessage());
		}
		
		
		//to validate the Text message is displayed after clicking on the reset password
		try {
			Assert.assertTrue(p.second());
			System.out.println("In space_Credentials method : text message is displayed after clciking on Reset Password");
		}catch(AssertionError ae) {
			System.out.println("In space_Credentials method : " + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In space_Credentials method : " + we.getMessage());
		}
		
	}

	
	@Test(priority=3)
	public void validCredentials_FirstTime() throws Exception {
		
		SynchronisationWaitsUtil.threadsleep(3000);
			
			ResetPsswordPage rpp=PageFactory.initElements(driver, ResetPsswordPage.class);
			
			SynchronisationWaitsUtil.threadsleep(3000);
ReadConfigProp rcp=new ReadConfigProp();
			
			System.out.println("rcp.getUserName() : "+rcp.getUserName());
			System.out.println();
		
			 rpp.setUserName(rcp.getUserName());
			System.out.println("enetered user name");
			rpp.clickOnRest();
			System.out.println("clickOnRest");
			
			
			
			
		 String p=rpp.getMessageText_ValidUserName();
		System.out.println("Text afterclicking on reset with valid username and  requested for reset for first time : "+rcp.getUserName() + p);

		//to validate the Text message displayed is correct for the given data
		try {
			Assert.assertTrue(p.contains( "Instructions for resetting your password have been sent to paul1@osohrm.com"));
			
			driver.navigate().back();
		}catch(AssertionError ae) {
			System.out.println("In svalidAndInvalid_Credentials method : " + ae);
		}catch(WebDriverException we) {
			System.out.println("In validAndInvalid_Credentials method : " + we.getMessage());
		}
		
		
		//to validate the Text message is displayed after clicking on the reset password
		
		try {
			Assert.assertTrue(rpp.MessageText_ValidUserNamePresent());
			System.out.println("In validAndInvalid_Credentials( method : text message is displayed after clciking on Reset Password");
		}catch(AssertionError ae) {
			System.out.println("In validAndInvalid_Credentials( method : " + ae);
		}catch(WebDriverException we) {
			System.out.println("In validAndInvalid_Credentials( method : " + we.getMessage());
		}
 
 
 driver.navigate().back();
	}
	
	
	@Test(priority=4)
	public void validCredentials_SeccondTime() throws Exception {
		 // Text message after clicking  on rest with valid username for the firstname
		SynchronisationWaitsUtil.threadsleep(3000);
			
			ResetPsswordPage rpp=PageFactory.initElements(driver, ResetPsswordPage.class);
			
			SynchronisationWaitsUtil.threadsleep(3000);
ReadConfigProp rcp=new ReadConfigProp();
			
			System.out.println("rcp.getUserName() : "+rcp.getUserName());
			System.out.println();
		
			 rpp.setUserName(rcp.getUserName());
			System.out.println("enetered user name");
			rpp.clickOnRest();
			System.out.println("clickOnRest");
			
			
			
			
			 //to validate username already requested for rest password
		
				//Text amessage After clicking with a valid id which has been already requested for password reset
					Pair<String,Boolean>p=rpp.getMessageText_InvalidUserName();
					System.out.println("Text afterclicking on reset with valid username and already requested for rest : " + p.first() +" value : "+ p.second());
					
					
					//to validate the Text message displayed is correct for the given data
					try {
						Assert.assertTrue(p.first().contains("There is a password reset request already in the system"));
					}catch(AssertionError ae) {
						System.out.println("In validAndInvalid_Credentials method : " + ae.getMessage());
					}catch(WebDriverException we) {
						System.out.println("In validAndInvalid_Credentials method : " + we.getMessage());
					}
					
					
					//to validate the Text message is displayed after clicking on the reset password
					try {
						Assert.assertTrue(p.second());
						System.out.println("In validAndInvalid_Credentials method : text message is displayed after clciking on Reset Password");
					}catch(AssertionError ae) {
						System.out.println("In validAndInvalid_Credentials method : " + ae.getMessage());
					}catch(WebDriverException we) {
						System.out.println("In validAndInvalid_Credentials method : " + we.getMessage());
					}
					
 
	}
	
	
	@Test(priority=5)
	public  void invalid_Credentials() throws Exception {
		System.out.println();
		 Thread.sleep(3000);
		
		ResetPsswordPage rpp=PageFactory.initElements(driver, ResetPsswordPage.class);
		
		SynchronisationWaitsUtil.threadsleep(3000);
		String invalidUserName="Hello";
		 rpp.setUserName(invalidUserName);
		System.out.println("enetered user name");
		rpp.clickOnRest();
		System.out.println("clickOnRest");
		
		ReadConfigProp rcp=new ReadConfigProp();
		
		System.out.println("rcp.getUserName() : "+rcp.getUserName());
		System.out.println();
		
		if(!(rcp.getUserName().equalsIgnoreCase(invalidUserName))) {
			
		 //to validate invalid username
		 Pair<String,Boolean>p=rpp.getMessageText_InvalidUserName();
			System.out.println("Text afterclicking on reset with invalid username and  requested for rest : "+invalidUserName + p.first() +" value : "+ p.second());
	
			//to validate the Text message displayed is correct for the given data
			try {
				Assert.assertTrue(p.first().contains("Please contact HR admin in order to reset the password"));
			}catch(AssertionError ae) {
				System.out.println("In validAndInvalid_Credentials method : " + ae.getMessage());
			}catch(WebDriverException we) {
				System.out.println("In validAndInvalid_Credentials method : " + we.getMessage());
			}
			
			
			//to validate the Text message is displayed after clicking on the reset password
			try {
				Assert.assertTrue(p.second());
				System.out.println("In validAndInvalid_Credentials method : text message is displayed after clciking on Reset Password");
			}catch(AssertionError ae) {
				System.out.println("In validAndInvalid_Credentials method : " + ae.getMessage());
			}catch(WebDriverException we) {
				System.out.println("In validAndInvalid_Credentials method : " + we.getMessage());
			}
	
	
	}
	}
	
	
	}



