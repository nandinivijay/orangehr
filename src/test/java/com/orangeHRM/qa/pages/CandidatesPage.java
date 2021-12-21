package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CandidatesPage extends RecruitmentPage{

	WebDriver driver;

	public CandidatesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Candidates");
		
	}
	
	By addbutton_candidates=By.xpath("//*[@name='btnAdd']");
	By firstname=By.xpath("//*[@id='addCandidate_firstName']");
	By middlename=By.xpath("//input[@id='addCandidate_middleName']");
	By lastname=By.xpath("//input[@id='addCandidate_lastName']");
	By email=By.xpath("//input[@id='addCandidate_email']");
	By contactno=By.xpath("//input[@id='addCandidate_contactNo']");
	By jobvaccancy=By.xpath("//select[@id='addCandidate_vacancy']");
	By choosefile=By.xpath("//input[@id='addCandidate_resume']");
	By keywords=By.xpath("//input[@id='addCandidate_keyWords']");
	By comments=By.xpath("//textarea[@id='addCandidate_comment']");
	By dateofapplication=By.xpath("//input[@id='addCandidate_appliedDate']");
	By consenttokeepdata=By.xpath("//input[@id='addCandidate_consentToKeepData']");
	By savebutton=By.xpath("//input[@id='btnSave']");
	By repcurrfile = By.xpath("//input[@id = 'addCandidate_resumeUpdate_3']");
	
	// To Select Action
		By action = By.xpath("//select[@class='actionDrpDown']");

		// Edit Button to edit candidate.
		By editbutton = By.xpath("//input[@id='btnSave']");

		// Back Button
		By backbutton = By.xpath("//input[@id='btnBack']");

		// Heading for edit candidates
		By editcandidateheading = By.xpath("//div[@class='head']/h1");

		// Cancel Button
		By cancelbutton = By.xpath("//input[@class='cancel']");

		// Heading for candidate page
		By candidateheading = By.xpath("//div[@class='head']/h1");

		// Candidate fiels from candidate table.
		By candidateclicktable = By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[3]/a");

		// Candidate History Section
		By candidatehistory = By.xpath("//div[@id='search-results']/div");
	
	public WebElement addButton()
	{
		return driver.findElement(addbutton_candidates);
	}
	
	public WebElement FirstName()
	{
		return driver.findElement(firstname);
	}
	public WebElement middleName()
	{
		return driver.findElement(middlename);
	}
	public WebElement lastName()
	{
		return driver.findElement(lastname);
	}
	public WebElement Email()
	{
		return driver.findElement(email);
	}
	public WebElement contactNo()
	{
		return driver.findElement(contactno);
	}
	public WebElement jobVaccancy()
	{
		return driver.findElement(jobvaccancy);
	}
	public WebElement chooseFile()
	{
		return driver.findElement(choosefile);
	}
	public WebElement KeyWords()
	{
		return driver.findElement(keywords);
	}

	public WebElement Comments()
	{
		return driver.findElement(comments);
	}
	public WebElement consentToKeepData()
	{
		return driver.findElement(consenttokeepdata);
	}
		

	public WebElement DateOfApplication()
	{
		return driver.findElement(dateofapplication);
	}

	public WebElement SaveButton()
	{
		return driver.findElement(savebutton);
	}
	
	public WebElement SelectAction() {
		return driver.findElement(action);
	}

	public WebElement EditButton() {
		return driver.findElement(editbutton);
	}

	public WebElement EditCandHeading() {
		return driver.findElement(editcandidateheading);
	}

	public WebElement CandHeading() {
		return driver.findElement(candidateheading);
	}

	public WebElement BackButton() {
		return driver.findElement(backbutton);
	}

	public WebElement CancelButton() {
		return driver.findElement(cancelbutton);
	}

	public WebElement ReplaceCurrent() {
		return driver.findElement(repcurrfile);
	}

	public WebElement ChooseCandidate() {

		return driver.findElement(candidateclicktable);
	}

	public WebElement CandidateHistory() {

		return driver.findElement(candidatehistory);
	}

	
	// Reset button and search button, xpaths for candidate section at the bottom
		
	By job_titleCandidate = By.id("candidateSearch_jobTitle");
	By vacancy_Candidate = By.id("candidateSearch_jobVacancy");
	By hiring_managerCandidate = By.id("candidateSearch_hiringManager");
	By status_Candidate = By.id("candidateSearch_status");
	By candidate_name = By.id("candidateSearch_candidateName");
	By fromdate = By.id("candidateSearch_fromDate");
	By yrOfApli = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
	By monthOfApli = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
	//By dateOfApli = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a");	
	By searchBtnClkCand = By.id("btnSrch");
	By resetBtnClkCand = By.id("btnRst");
	
	
	public WebElement job_titleCandidate()
	{
		return driver.findElement(job_titleCandidate);
	}
	
	public WebElement vacancy_Candidate()
	{
		return driver.findElement(vacancy_Candidate);
	}
	
	public WebElement hiring_managerCandidate()
	{
		return driver.findElement(hiring_managerCandidate);
	}
	
	public WebElement status_Candidate()
	{
		return driver.findElement(status_Candidate);
	}
	
	public WebElement candidate_name()
	{
		return driver.findElement(candidate_name);
	}
	
	public WebElement fromdate()
	{
		return driver.findElement(fromdate);
	}
		
	public WebElement yrOfApli()
	{
		return driver.findElement(yrOfApli);
	}
	
	public WebElement monthOfApli()
	{
		return driver.findElement(monthOfApli);
	}
		
	public WebElement searchBtnClkCand()
	{
		return driver.findElement(searchBtnClkCand);
	}
	
	public WebElement resetBtnClkCand()
	{
		return driver.findElement(resetBtnClkCand);
	}
	
	
	//Table header of Candidate table.
	
	By candidate_table_header = By.id("srchCandidates");
		
	public WebElement candidate_table_header() 
	{
		return driver.findElement(candidate_table_header);
	}
	
	// Vacancy column from Candidates History Table
	By candVacancy_column = By.xpath("//*[@id='resultTable']/thead/tr/th[2]");
	
	public WebElement cand_VacancyColumn()
	{
		return driver.findElement(candVacancy_column);
	}
}

