package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobAdminPage extends AdminPage{

	WebDriver driver;

	public JobAdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By JobTitles_ID = By.id("menu_admin_viewJobTitleList");
	By PayGrades_ID = By.id("menu_admin_viewPayGrades");
	By EmploymentStatus_ID = By.id("menu_admin_employmentStatus");
	By JobCategories_ID = By.id("menu_admin_jobCategory");
	By WorkShifts_ID = By.id("menu_admin_workShift");
	
	
	public WebElement getJobTitles_id()
	{
		
		return driver.findElement(JobTitles_ID);
		
	}
	
	public JobTitlesPage navigatingToJobTitles()
	{
		getJobTitles_id().click();
		return new JobTitlesPage(driver);
	}
	
	public WebElement getPayGrades_id()
	{
		
		return driver.findElement(PayGrades_ID);
		
	}
	
	public PayGradesPage navigatingToPayGrades()
	{
		getPayGrades_id().click();
		return new PayGradesPage(driver);
	}
	
	public WebElement getEmploymentStatus_id()
	{
		
		return driver.findElement(EmploymentStatus_ID);
		
	}
	
	public EmploymentStatusPage navigatingToEmploymentStatus()
	{
		getEmploymentStatus_id().click();
		return new EmploymentStatusPage(driver);
	}
	
	public WebElement getJobCategories_id()
	{
		
		return driver.findElement( JobCategories_ID);
		
	}
	
	public  JobCategoriesPage navigatingToJobCategories()
	{
		getJobCategories_id().click();
		return new  JobCategoriesPage(driver);
	}
	
	public WebElement getWorkShifts_id()
	{
		
		return driver.findElement( WorkShifts_ID);
		
	}
	
	public  WorkShiftsPage navigatingToWorkShifts()
	{
		getWorkShifts_id().click();
		return new  WorkShiftsPage(driver);
	}
}
