package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VacanciesPage extends RecruitmentPage{

	WebDriver driver;

	public VacanciesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Vacancy");
		
	}
	
	By addJobVacancytitle = By.xpath("//*[@id='addJobVacancy']/div[1]/h1");
	By addjobTitle = By.xpath("//*[@id='addJobVacancy_jobTitle']");
	By addvacancyName = By.id("addJobVacancy_name");
	By addhiringManager = By.id("addJobVacancy_hiringManager");
	By nop = By.id("addJobVacancy_noOfPositions");
	By description = By.id("addJobVacancy_description");
	By active = By.id("addJobVacancy_status");
	By publish = By.id("addJobVacancy_publishedInFeed");
	By vacancyCheckall = By.id("ohrmList_chkSelectAll");
	
	By addbtn = By.id("btnAdd");
	By delbtn = By.id("btnDelete");
	By savebtn = By.xpath("//*[@id='btnSave']");
	By backbtn = By.xpath("//*[@id='btnBack']");
	//By backbtn = By.xpath("//*[@id='frmAddJobVacancy']/fieldset/p/input[2]");
	By okbtn = By.id("dialogDeleteBtn");
	By cancelbtn = By.xpath("//*[@id='deleteConfirmation']/div[3]/input[2]");
	
	// Search Button
		By searchButton = By.xpath("//input[@id='btnSrch']");

		// Reset Button
		By resetButton = By.xpath("//input[@id='btnRst']");

		// Job Title Dropdown
		By jobTitle = By.xpath("//select[@name='vacancySearch[jobTitle]']");

		// Job Vacancy Dropdown
		By vacancy = By.xpath("//select[@name='vacancySearch[jobVacancy]']");

		// Hiring Manager Dropdown
		By hiringManager = By.xpath("//select[@name='vacancySearch[hiringManager]']");

		// Status Dropdown
		By status = By.xpath("//*[@id='vacancySearch_status']");

		// Vacancy Table
		By vacancyTable = By.xpath("//table[@id = 'resultTable']");

	public WebElement addvacancyButton() {
		return driver.findElement(addbtn);
	}

	public WebElement delvacancyButton() {
		return driver.findElement(delbtn);
	}
	
	public WebElement savevacancyButton()
	{
		return driver.findElement(savebtn);
	}
	
	public WebElement backvacancyButton()
	{
		return driver.findElement(backbtn);
	}
	
	public boolean getAddJobVacancyUrl()
	{
		return driver.getCurrentUrl().contains("addJobVacancy");
		
	}
	
	public WebElement addJobvacancytitle()
	{
		return driver.findElement(addJobVacancytitle);
	}

	public WebElement getJobTitleId() 
	{
		return driver.findElement(addjobTitle); 
	}
	
	public WebElement getVacancyNameId() 
	{
		return driver.findElement(addvacancyName); 
	}
	
	public WebElement getHiringManagerId() 
	{
		return driver.findElement(addhiringManager); 
	}
	
	public WebElement getNoOfPositionsId() 
	{
		return driver.findElement(nop); 
	}
	
	public WebElement getDescriptionId() 
	{
		return driver.findElement(description); 
	}
	
	public WebElement getActiveId() 
	{
		return driver.findElement(active); 
	}
	
	public WebElement getPublishId() 
	{
		return driver.findElement(publish); 
	}
	
	public WebElement getVacancyCheckall() 
	{
		return driver.findElement(vacancyCheckall);
	}
	
	public WebElement getOkbutton()
	{
		return driver.findElement(okbtn);
	}
	
	public WebElement getcancelbutton()
	{
		return driver.findElement(cancelbtn);
	}
	
	public WebElement SearchButton() {
		return driver.findElement(searchButton);
	}

	public WebElement ResetButton() {
		return driver.findElement(resetButton);
	}

	public WebElement SelectJobTitle() {
		return driver.findElement(jobTitle);
	}

	public WebElement SelectVacancy() {
		return driver.findElement(vacancy);
	}

	public WebElement SelectHiringManager() {
		return driver.findElement(hiringManager);
	}

	public WebElement SelectStatus() {
		return driver.findElement(searchButton);
	}

	public WebElement VacancyTable() {
		return driver.findElement(vacancyTable);
	}
}
