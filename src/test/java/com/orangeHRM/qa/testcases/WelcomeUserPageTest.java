package com.orangeHRM.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.WelcomeUserPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class WelcomeUserPageTest extends BaseClass {
	
	BaseVerification baseVerification ;
	WelcomeUserPage welcomeUserPage;
	
	@BeforeClass
	public void verifyWelcomeUserPage()
	{
		login();
		baseVerification = new BaseVerification(driver);
		welcomeUserPage = baseVerification.navigatingToWelcomeUser();
		System.out.println("Clicked WelcomeUserPage and asserted URL");
	}
	
	@Test(priority = 1)
	public void welcomeUserPage()
	{
        
		System.out.println(" welcomeUserPage is navigated ");
	}
	
	@Test(priority = 2)
	public void aboutPageclick()
	{
		ActionsUtil.MouseHoover(welcomeUserPage.getAbout_id(), driver);
		driver.findElement(By.id("aboutDisplayLink")).click();
		String text = driver.findElement(By.id("displayAbout")).getText();
		String texts = driver.findElement(By.xpath("//*[@id=\"companyInfo\"]/ul")).getText();
		System.out.println("Text inside the Display box are : " +  texts);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"companyInfo\"]/ul")).isDisplayed());
		System.out.println("Text in the display box is :" + text);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"companyInfo\"]/ul/li[1]/p")).getText().contains("Company Name"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"companyInfo\"]/ul/li[2]/p")).getText().contains("Version"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"companyInfo\"]/ul/li[3]/p")).getText().contains("Active Employees"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"companyInfo\"]/ul/li[4]/p")).getText().contains("Employees Terminated"));
		Assert.assertTrue(driver.findElement(By.id("displayAbout")).isDisplayed());
		driver.findElement(By.className("close")).click();
		System.out.println("Display box is closed");
		
		
		
		
	}


}
