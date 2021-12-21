package com.orangeHRM.qa.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;


import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.util.ActionsUtil;

public class MyInfoPageTest extends BaseClass{

	BaseVerification baseVerification ;
	MyInfoPage myInfoPage;
	private static List<String> SIDENAV_EXP_TITLES= new ArrayList<String>();
	private static final String SIDENAV_HOVERDEFAULTCOLOR="#f19a52";// orange
//	private static final List<String> SIDENAV_URLS= new ArrayList<String>();

	
{
	SIDENAV_EXP_TITLES.clear();
		SIDENAV_EXP_TITLES.add("Personal Details");
		SIDENAV_EXP_TITLES.add("Contact Details");
		SIDENAV_EXP_TITLES.add("Emergency Contacts");
		SIDENAV_EXP_TITLES.add("Dependents");
		SIDENAV_EXP_TITLES.add("Immigration");
		SIDENAV_EXP_TITLES.add("Job");
		SIDENAV_EXP_TITLES.add("Salary");
		SIDENAV_EXP_TITLES.add("Tax Exemptions");
		SIDENAV_EXP_TITLES.add("Report-to");
		SIDENAV_EXP_TITLES.add("Qualifications");
		SIDENAV_EXP_TITLES.add("Memberships");
		
		/*
		 * SIDENAV_URLS.add("viewPersonalDetails"); SIDENAV_URLS.add("contactDetails");
		 * SIDENAV_URLS.add("viewEmergencyContacts");
		 * SIDENAV_URLS.add("viewDependents"); SIDENAV_URLS.add("viewImmigration");
		 * SIDENAV_URLS.add("viewJobDetails"); SIDENAV_URLS.add("viewSalaryList");
		 * SIDENAV_URLS.add("viewUsTaxExemptions");
		 * SIDENAV_URLS.add("viewReportToDetails");
		 * SIDENAV_URLS.add("viewQualifications"); SIDENAV_URLS.add("viewMemberships");
		 */
		}
	
		
	@BeforeClass
	public void a_verifyMyInfoPageNavigation()
	{
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		Assert.assertTrue(myInfoPage.getcurrentUrl());
		System.out.println("Clicked My Info and asserted URL");
		
	}
	
	
	@BeforeClass
	public void b_myInfoTesting() throws Throwable
	{
		Assert.assertTrue( myInfoPage.checkProfilePicPresence());
		System.out.println("Profice pic frame is displayed");
		Assert.assertTrue(myInfoPage.gettext_profilepic().contains(baseVerification.getWelcomeUser_id().getText().substring(8)));
		System.out.println("profile name is verified with welcome user");
		Assert.assertTrue(myInfoPage.checkSideNavPresence());
		System.out.println("SideNav is present");
		Assert.assertTrue(myInfoPage.getColor_Sidenav(myInfoPage.getsidenav()).equalsIgnoreCase("#f28c38"));
		System.out.println("color of sidenav is correct : orange(#f28c38)");
	
		
		
		//validating list of elements on sidenav
		List<WebElement>sideNavOptions=myInfoPage.optionsAtSideNav();
		Assert.assertEquals(sideNavOptions.size(), SIDENAV_EXP_TITLES.size());
		System.out.println("SideNav size is correct" );
		System.out.println("SideNave options are: ");
		for(int i=0,j=0;i<sideNavOptions.size() && j<SIDENAV_EXP_TITLES.size();i++,j++) {
			//System.out.println("Option from site : " + sideNavOptions.get(i).getText() +" Expected option : "+ SIDENAV_EXP_TITLES.get(j) );
			Assert.assertEquals(sideNavOptions.get(i).getText(),SIDENAV_EXP_TITLES.get(j));
			
		}
		System.out.println("Sidenav options are validated");
		
		
		//vaidating, mouse over color change on sidenav background of elements
		
		
		for(int i=0;i<sideNavOptions.size();i++) {
			ActionsUtil.MouseHoover(sideNavOptions.get(i), driver);
			//System.out.println(sideNavOptions.get(i).getText()+ ": "+sideNavOptions.get(i).getCssValue("background-color"));
			String hexcolor=myInfoPage.getColor_Sidenav(sideNavOptions.get(i));
			System.out.println("hexcolor" +hexcolor);
			if(i==0) {
			Assert.assertTrue(hexcolor.equalsIgnoreCase(myInfoPage.SIDENAV_CLICKEDCOLOR));
			
			System.out.println("Personel details bgcolor is validated");
			}else {
				Assert.assertTrue(hexcolor.equalsIgnoreCase(myInfoPage.SIDENAV_HOVERCOLOR));	
				System.out.println("sidenav options bgcolor is validated upon mosehover");
			}
			//checking,upon moushover on an option,default orange bgcolor is retained on other options on side nav.
			Set<String> options=myInfoPage.getColor_SideNav(i,sideNavOptions);
			System.out.println("options size :" +options.size() +"options value : " + options);
			Assert.assertTrue(options.contains(SIDENAV_HOVERDEFAULTCOLOR));
			System.out.println("options-other than mousehover elements are validated for default color");
		
		}
	
		
}
}
