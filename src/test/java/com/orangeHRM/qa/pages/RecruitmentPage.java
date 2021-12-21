package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecruitmentPage {

	WebDriver driver;
	public RecruitmentPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("recruitment");
		
	}
	
	By Candidates_ID = By.id("menu_recruitment_viewCandidates");
	By Vacancies_ID = By.id("menu_recruitment_viewJobVacancy");
	
	public WebElement getCandidates_id()
	{
		
		return driver.findElement(Candidates_ID);
		
	}
	
	public CandidatesPage navigatingToCandidates()
	{
		getCandidates_id().click();
		return new CandidatesPage(driver);
	}
	
	public WebElement getVacancies_id()
	{
		
		return driver.findElement(Vacancies_ID);
		
	}
	
	public VacanciesPage navigatingToVacancies()
	{
		getVacancies_id().click();
		return new VacanciesPage(driver);
	}
}
