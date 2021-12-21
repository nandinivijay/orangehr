package com.orangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.ConfigurationAdminPage;
import com.orangeHRM.qa.pages.ModulesPage;


public class ModulesPageTest extends BaseClass{
	AdminPage adminPage;
	ConfigurationAdminPage configurationAdminPage;
	ModulesPage modulesPage;
	@BeforeClass
	public void verifyModulesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		adminPage = baseVerification.navigatingToAdmin(); 
		configurationAdminPage = adminPage.navigatingToConfigurationAdmin();
		modulesPage = configurationAdminPage.navigatingToModules();
		Assert.assertTrue(modulesPage.getcurrentUrl());
		System.out.println("Clicked Modules and asserted URL");
	}
	
	@Test(priority = 4)
	public void modulesTesting()
	{
		System.out.println("Modules clicked");
	}
}
