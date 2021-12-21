package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.DirectoryPage;

public class DirectoryPageTest extends BaseClass{

	BaseVerification baseVerification ;
	DirectoryPage directoryPage;
	@BeforeClass
	public void verifyDirectoryPageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		directoryPage = baseVerification.navigatingToDirectory();
		Assert.assertTrue(directoryPage.getcurrentUrl());
		System.out.println("Clicked Directory and asserted URL");
	}
	
	@Test
	public void directoryTesting()
	{
		System.out.println("Directory Clicked");
	}
	
}
