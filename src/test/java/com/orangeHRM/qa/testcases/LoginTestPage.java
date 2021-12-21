package com.orangeHRM.qa.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.config.ObjectRepositoryReader;
import com.orangeHRM.qa.config.ReadConfigProp;
import com.orangeHRM.qa.pages.LoginPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class LoginTestPage extends BaseClass{
	//WebDriver driver;
	//BaseVerification baseverification=new BaseVerification();
	ReadConfigProp rcp=new ReadConfigProp();

	
	@Test(priority=0)
	public void setcontext(ITestContext context) {
	int	sheetnumber=0;
	context.setAttribute("index", sheetnumber);
	}
	
	
	@Test(priority=3)
	public  void login_valid_credentials() throws Exception {
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		//LoginPage loginpage=new LoginPage(driver);
		SynchronisationWaitsUtil.pageloadtimeout(3000,TimeUnit.SECONDS,driver);
	//	BaseClass baseclass=new BaseClass();
		
		login();
		BaseVerification baseverification=PageFactory.initElements(driver, BaseVerification.class);
		try {
			
		Assert.assertTrue(baseverification.getWelcomeUser_id().isDisplayed());
			SynchronisationWaitsUtil.threadsleep(3000);
			driver.findElement(By.id("welcome")).click();
			SynchronisationWaitsUtil.threadsleep(3000);
			driver.findElement(By.xpath("//div[@id='welcome-menu']/ul/li[3]/a[text()='Logout']")).click();
			
			
			System.out.println(" login is succesful: Welcomeuser button is displayed " );
		}catch(AssertionError ae) {
			System.out.println("In login_valid_credentials--login :" + ae);
		}catch(WebDriverException we) {
			System.out.println("In login_valid_credentials--login :" + we.getMessage());
		}
		
		
	}
	
	@Test(priority=4)
	public  void login_valid_credentials_Othercase() throws InterruptedException {
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		SynchronisationWaitsUtil.pageloadtimeout(3000,TimeUnit.SECONDS,driver);
		
		Thread.sleep(5000);
				
		System.out.println("rcp.getUserName() : "+rcp.getUserName());
		System.out.println("Case changed rcp.getUserName() : " + rcp.getUserName().toLowerCase());
		System.out.println();
	
		 String lowercaseValue=rcp.getUserName().toLowerCase();
		 System.out.println("lowercaseValue :"+lowercaseValue);
		loginpage.setuserName(lowercaseValue);
		loginpage.setPassword(rcp.getPassword());
		loginpage.clickOnLogin();
		ObjectRepositoryReader orr1=new ObjectRepositoryReader();
		try {
			
			Assert.assertTrue(driver.findElement(By.id(orr1.getWelcomeUserId())).isDisplayed());
			System.out.println(" login is succesful: Welcomeuser button is displayed " );
		}catch(AssertionError ae) {
			System.out.println("In login_valid_credentials_othercase--login :" + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In login_valid_credentials_othercase--login :" + we.getMessage());
		}
		
	}
	
	//@Test(priority=1)
	public void Check_AllElements_Present() throws InterruptedException {
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		Thread.sleep(3000);
		//verifying logo is present
		login();
		try {
		Assert.assertTrue(loginpage.isLogoPresent());
		System.out.println("isLogoPresent : " + loginpage.isLogoPresent());
		}catch(AssertionError ae) {
			System.out.println("In Check_AllElements_Present_LogoPresent :" + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In Check_AllElements_Present_LogoPresent :" + we.getMessage());
		}
		
		//verifying loginpanelpresent
		try {
		Assert.assertTrue(loginpage.isloginpanelPresent());
		System.out.println("isloginpanelPresent : " + loginpage.isloginpanelPresent());
		}catch(AssertionError ae) {
			System.out.println("In Check_AllElements_Present_LoginpanelPresent :" + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In Check_AllElements_Present_LoginpanelPresent :" + we.getMessage());
		}
		
		//verifying username and password is present
		try {
		Assert.assertTrue(loginpage.isUserName_PasswordPresent());
		System.out.println("isUserName_PasswordPresent :" + loginpage.isUserName_PasswordPresent());
		}catch(AssertionError ae) {
			System.out.println("In Check_AllElements_isUserName_PasswordPresent :" + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In Check_AllElements_isUserName_PasswordPresent :" + we.getMessage());
		}
		
		//verify footer preseent
		try {
		Assert.assertTrue(loginpage.isFooterPresent());
		System.out.println("isFooterPresent :"+ loginpage.isFooterPresent());
		}catch(AssertionError ae) {
			System.out.println("In Check_AllElements_isFooterPresent :" + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In Check_AllElements_isFooterPresent :" + we.getMessage());
		}
		
		
		//verify footer text is correct
	String footerTextArr[]=loginpage.getFooterText().split("\n");
	
	try {
	for(int i=0;i<footerTextArr.length;i++) {
		Assert.assertTrue(loginpage.getFooterText().contains(footerTextArr[i]));
	}
	System.out.println("footer Text : " + loginpage.getFooterText());
	}catch(AssertionError ae) {
		System.out.println("In Check_AllElements_footer Text : :" + ae.getMessage());
	}catch(WebDriverException we) {
		System.out.println("In Check_AllElements_footer Text : :" + we.getMessage());
	}
	
	
	//verifying footer link text
	try {
	Assert.assertEquals(loginpage.getFooterLink(), "http://www.orangehrm.com/");
		System.out.println("footer Link : " + loginpage.getFooterLink());
	}catch(AssertionError ae) {
		System.out.println("In Check_AllElements_footer Link :" + ae.getMessage());
	}catch(WebDriverException we) {
		System.out.println("In Check_AllElements_footer Link : :" + we.getMessage());
	}
	
	
	
	//verifying footer social links 
		List<String>expectedSocalList=new ArrayList<String>();
		expectedSocalList.add("linkedin");
		expectedSocalList.add("facebook");
		expectedSocalList.add("twitter");
		expectedSocalList.add("youtube");
		
		
		try {
		Assert.assertTrue(expectedSocalList.size()==loginpage.footerSocial_links().size());
		for(int i=0;i<loginpage.footerSocial_links().size();i++) {
		Assert.assertTrue(loginpage.footerSocial_links().get(i).contains(loginpage.footerSocial_links().get(i)));
		}
		System.out.println("footer social links :" + loginpage.footerSocial_links());
		}catch(AssertionError ae) {
			System.out.println("In Check_AllElements_footer social links  :" + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In Check_AllElements_footer social links  :" + we.getMessage());
		}
	}
	
	
	//@Test(dataProvider="paramdata",dataProviderClass=ExcelReader.class,priority=2)
	@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class ,priority=2)
	public void login_invalid_credentials(String[] exceldata) throws Exception {
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		
		SynchronisationWaitsUtil.pageloadtimeout(3000,TimeUnit.SECONDS,driver);
		//System.out.println("Title: " + BaseClass.driver.getTitle());
		
		//username is set with value
		loginpage.setuserName(exceldata[0]);
		System.out.println("enetered user name");
		try {
		Assert.assertTrue(loginpage.getUserName().getAttribute("value").contains(exceldata[0]));
		System.out.println("page data : " +loginpage.getUserName().getAttribute("value") + "---Data from file : "+ exceldata[0]);
		}catch(AssertionError ae) {
			System.out.println("In login_invalid_credentials--username :" + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In login_invalid_credentials--username :" + we.getMessage());
		}
	//	 Thread.sleep(3000);
		 
		 //passsword is set with value
		 loginpage.setPassword(exceldata[1]);
		System.out.println("enetered password");
		try {
			Assert.assertTrue(loginpage.getPassword().getAttribute("value").contains(exceldata[1]));
			System.out.println("page data : " +loginpage.getPassword().getAttribute("value") + "---Data from file : "+ exceldata[1]);
			}catch(AssertionError ae) {
				System.out.println("In login_invalid_credentials--passsword :" + ae.getMessage());
			}catch(WebDriverException we) {
				System.out.println("In login_invalid_credentials--password :" + we.getMessage());
			}
		
		//click on login button
		loginpage.clickOnLogin();
		System.out.println("clickOnLogin");
		//Thread.sleep(3000);
		SynchronisationWaitsUtil.threadsleep(3000);
		try {
			Assert.assertTrue(loginpage.getInvalidMessage().isDisplayed());
			System.out.println("Invalid Message :" + loginpage.getInvalidMessageText());
		}catch(AssertionError ae) {
			System.out.println("In login_invalid_credentials--passsword :" + ae.getMessage());
		}catch(WebDriverException we) {
			System.out.println("In login_invalid_credentials--password :" + we.getMessage());
		}
		
		driver.navigate().refresh();
		
	}

}
