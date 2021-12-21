package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QualificationsPage extends AdminPage{

	WebDriver driver;
	public QualificationsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By Skills_ID = By.id("menu_admin_viewSkills");
	By Education_ID = By.id("menu_admin_viewEducation");
	By Licenses_ID = By.id("menu_admin_viewLicenses");
	By Languages_ID = By.id("menu_admin_viewLanguages");
	By MemberShips_ID = By.id("menu_admin_membership");
	
	
	public WebElement getSkills_id()
	{
		
		return driver.findElement(Skills_ID);
		
	}
	
	public SkillsPage navigatingToSkills()
	{
		getSkills_id().click();
		return new SkillsPage(driver);
	}
	
	public WebElement getEducation_id()
	{
		
		return driver.findElement(Education_ID);
		
	}
	
	public EducationPage navigatingToEducation()
	{
		getEducation_id().click();
		return new EducationPage(driver);
	}
	
	public WebElement getLicenses_id()
	{
		
		return driver.findElement(Licenses_ID);
		
	}
	
	public LicensesPage navigatingToLicenses()
	{
		getLicenses_id().click();
		return new LicensesPage(driver);
	}
	
	public WebElement getLanguages_id()
	{
		
		return driver.findElement( Languages_ID);
		
	}
	
	public  LanguagesPage navigatingToLanguages()
	{
		getLanguages_id().click();
		return new  LanguagesPage(driver);
	}
	
	public WebElement getMemberShips_id()
	{
		
		return driver.findElement(MemberShips_ID);
		
	}
	
	public  MemberShips_AdminPage navigatingToMemberShips()
	{
		getMemberShips_id().click();
		return new  MemberShips_AdminPage(driver);
	}
}
