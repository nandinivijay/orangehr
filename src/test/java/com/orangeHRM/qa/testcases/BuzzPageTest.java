package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.BuzzPage;

public class BuzzPageTest extends BaseClass{

	BaseVerification baseVerification ;
	BuzzPage buzzPage;
	@BeforeClass
	public void verifyBuzzPageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		buzzPage = baseVerification.navigatingToBuzz();
		Assert.assertTrue(buzzPage.getcurrentUrl());
		System.out.println("Clicked Buzz and asserted URL");
	}
	
	@Test
	public void buzzTesting()
	{
		System.out.println("Buzz Clicked");
	}
	
}
