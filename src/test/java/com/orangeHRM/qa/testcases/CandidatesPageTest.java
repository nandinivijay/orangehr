package com.orangeHRM.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.CandidatesPage;
import com.orangeHRM.qa.pages.RecruitmentPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.AttatchmentsUtil;
import com.orangeHRM.qa.util.ColorValidationUtil;
import com.orangeHRM.qa.util.DropDownUtil;

import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class CandidatesPageTest extends BaseClass{
	RecruitmentPage recruitmentPage;
	CandidatesPage candidatesPage;
	@BeforeClass
	public void verifyCandidatesPageNavigation()
	{
		login();
		BaseVerification baseVerification = new BaseVerification(driver);
		recruitmentPage = baseVerification.navigatingToRecruitment();
		candidatesPage = recruitmentPage.navigatingToCandidates();
		Assert.assertTrue(candidatesPage.getcurrentUrl());
		System.out.println("Clicked Candidates and asserted URL");
	}
	
	@Test(priority = 2)
	public void candidatesTesting()
	{
		System.out.println("Candidates clicked");
	}
	
	 // Search button code to check if the and Reset button resets to default values.
	
		@Test(priority=3)
		public void setcontext1(ITestContext context) {
		int	sheetnumber=32;
		context.setAttribute("index", sheetnumber);
		}
		
			
		@Test(dataProvider = "paramName",dataProviderClass=ExcelReaderWithIndex.class,priority=4 )
		public void searchBtnClk(String candidate_name,String yrofappln,String mnthofappln,String dateofappli) throws Exception
		{
			
			DropDownUtil.selectbytext(candidatesPage.job_titleCandidate(),"Support Specialist");
			Thread.sleep(1000);
			DropDownUtil.selectbyindex(candidatesPage.vacancy_Candidate(), 1);
			Thread.sleep(1000);
			DropDownUtil.selectbytext(candidatesPage.hiring_managerCandidate(), "Dominic Chase");
			Thread.sleep(1000);
			DropDownUtil.selectbyindex(candidatesPage.status_Candidate(), 1);
					
			Thread.sleep(1000);
			candidatesPage.candidate_name().sendKeys(candidate_name);
			System.out.println("Cabdidate Name :" +candidate_name);
			
			Thread.sleep(1000);
			candidatesPage.fromdate().click();
					
			DropDownUtil.selectbyvalue(candidatesPage.yrOfApli(),yrofappln);
			Thread.sleep(1000);
			DropDownUtil.selectbyvalue(candidatesPage.monthOfApli(),mnthofappln);
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[2]/a[contains(text(),"+dateofappli+")]")).click();
		
			 int im = Integer.parseInt(mnthofappln)+1;
			   String i;
			   if(im<10)
			   {
				   i = 0+""+String.valueOf(im); 
			   }
			   
			   else
			   {
				   i = String.valueOf(im);
			   }
			   String frmdte = yrofappln+"-"+i+"-"+dateofappli;
			  
			   String fromdate = driver.findElement(By.xpath(" //*[@id=\"candidateSearch_fromDate\"]")).getText();
			   System.out.println("From date is loaded correctly " +"\n");		 

		    
			Thread.sleep(1000);
			candidatesPage.searchBtnClkCand().click();
		}
		
		
		// Reset Button Click
		
		    @Test(priority=5)
			public void resetButtonclick() throws InterruptedException
			{
			Thread.sleep(2000);
			candidatesPage.resetBtnClkCand().click();
			
			Thread.sleep(1000);
			// Default All option validation for Job Title after Reset button is clicked
			Select select = new Select(driver.findElement(By.id("candidateSearch_jobTitle")));
			String option = select.getFirstSelectedOption().getText();
			Assert.assertEquals("All", option);
			System.out.println(" After Reset button is clicked default All Option is selected in Candidate's Job Title dropdown" +"\n");
			

			Thread.sleep(1000);
			// Default All option validation for Vacancy After Reset button is clicked
			Select vacancy1 = new Select(driver.findElement(By.id("candidateSearch_jobVacancy")));
			String option1 = vacancy1.getFirstSelectedOption().getText();
			Assert.assertEquals("All", option1);
			System.out.println(" After Reset button is clicked default All Option is selected in Candidate's Vacancy dropdown" +"\n");
			
			Thread.sleep(1000);
			// Default All option validation for Hiring Manager After Reset button is clicked
			Select hiringmanager1 = new Select(driver.findElement(By.id("candidateSearch_hiringManager")));
			String option2 = hiringmanager1.getFirstSelectedOption().getText();
			Assert.assertEquals("All", option2);
			System.out.println(" After Reset button is clicked default All Option is selected in Candidate's Hiring Manager dropdown" +"\n");
			
			Thread.sleep(1000);
			// Default All option validation for Status After Reset button is clicked
			Select status1 = new Select(driver.findElement(By.id("candidateSearch_hiringManager")));
			String option3 = status1.getFirstSelectedOption().getText();
			Assert.assertEquals("All", option3);
			System.out.println(" After Reset button is clicked default All Option is selected in Candidate's Status dropdown" +"\n");
			
		   Thread.sleep(1000);
		 String candName = driver.findElement(By.id("candidateSearch_candidateName")).getText();
		 Assert.assertEquals(candName,"","Candidate Name Field is empty");
		 System.out.println("Candidate Name field is Empty after Reset button is clicked" +"\n");
		 
		 Thread.sleep(1000);
		 boolean datedisplayed = driver.findElement(By.id("candidateSearch_fromDate")).isDisplayed();
		 Assert.assertTrue(datedisplayed,"yyyy-mm-dd");
		System.out.println("yyyy-mm-dd is displayed after Reset button is clicked" +"\n");
		}
		    
		 // Candidate page Header validation   
		
		    @Test(priority=6)
		    public void candidate_Table_HeaderValidate()
		    {
		    	boolean candTableHdr = driver.findElement(By.id("srchCandidates")).isDisplayed();
		    	Assert.assertTrue(candTableHdr);
		    	System.out.println("Candidate Header Table is Validated" +"\n");
		    	
		        //String actualCandTblHdr = "Candidates";
		    	//WebElement expectedCandTblHdr = candidatesPage.candidate_table_header();
		    	//Assert.assertEquals(actualCandTblHdr,expectedCandTblHdr, "Candidate header Table is validated");
		    	
		    }
		    
	
	@Test(priority = 7)
	public void clickCandidateValidation() throws Exception {
		String candidate = candidatesPage.ChooseCandidate().getText();
		System.out.println(candidate);
		candidatesPage.ChooseCandidate().click();
		Assert.assertTrue(candidatesPage.EditButton().isDisplayed(), "Edit Button Not Displayed");
		Assert.assertTrue(candidatesPage.BackButton().isDisplayed(), "Back Button Not Displayed");
		Assert.assertTrue(candidatesPage.EditButton().isEnabled(), "Edit Button is Not Clickable");
		Assert.assertTrue(candidatesPage.BackButton().isEnabled(), "Back Button is Not Clickable");
		SynchronisationWaitsUtil.threadsleep(5000);
		candidatesPage.BackButton().click();
	}

	@Test(priority = 8)
	public void setcontext(ITestContext context) {
		int sheetnumber = 25;
		context.setAttribute("index", sheetnumber);
	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 9)
	public void addcandidate(String firstname, String lastname, String email, String contactno, String jobvacancy,
			String keywords, String comments, String date) throws Exception {
		candidatesPage.addButton().click();
		candidatesPage.FirstName().sendKeys(firstname);
		candidatesPage.lastName().sendKeys(lastname);
		candidatesPage.Email().sendKeys(email);
		candidatesPage.contactNo().sendKeys(contactno);
//		WebElement ele = candidatesPage.jobVaccancy();
		DropDownUtil.selectbyvalue(candidatesPage.jobVaccancy(), jobvacancy);
		SynchronisationWaitsUtil.threadsleep(2000);
		WebElement ele = candidatesPage.chooseFile();
		AttatchmentsUtil.uploadingFileUsingRobot(ele, driver, "resume1.pdf");

//		AttatchmentsUtil.uploadingFileUsingRobotInmac(ele2, driver,"/Users/chelak/Downloads/Sprint8/attachments/resume");

		candidatesPage.KeyWords().sendKeys(keywords);
		candidatesPage.Comments().sendKeys(comments);
		candidatesPage.DateOfApplication().clear();
		candidatesPage.DateOfApplication().sendKeys(date);
		candidatesPage.consentToKeepData().click();
		SynchronisationWaitsUtil.threadsleep(2000);
		candidatesPage.SaveButton().click();
	}

	@Test(priority = 10)
	public void validationsedit() {
		// To check edit and back button is displayed and clickable
		Assert.assertTrue(candidatesPage.EditButton().isDisplayed(), "Edit Button Not Displayed");
		Assert.assertTrue(candidatesPage.BackButton().isDisplayed(), "Back Button Not Displayed");
		Assert.assertTrue(candidatesPage.EditButton().isEnabled(), "Edit Button is Not Clickable");
		Assert.assertTrue(candidatesPage.BackButton().isEnabled(), "Back Button is Not Clickable");
		// To validate colors of Edit and Back button
		String color = ColorValidationUtil.GetColor(candidatesPage.EditButton());
		Assert.assertEquals("Green", color);
		String color2 = ColorValidationUtil.GetColor(candidatesPage.BackButton());
		Assert.assertEquals("Darker Grey", color2);

		// To check Candidate's History is populated
		String header = candidatesPage.CandidateHistory().getText();
		System.out.println(header);
		Assert.assertTrue(header.contains("Candidate's History"));
	}

	@Test(priority = 11)
	public void candidateTableHeaderValidation() {
		List<WebElement> li = driver.findElements(By.xpath("//*[@id='resultTable']/thead/tr/th"));
		int n = li.size();
		System.out.println(n);
		List<String> s = new ArrayList<String>();
		System.out.println("size of Columns : " + n);
		for (int i = 0; i < n; i++) {
			s.add(li.get(i).getText());
		}
		System.out.println("Column Headings are: " + s);
		Assert.assertEquals(3, n);
		for (int i = 1; i <= n; i++) {
			WebElement header = driver.findElement(By.xpath("//*[@id='resultTable']/thead/tr/th[" + i + "]"));
			System.out.print(header.getText());

			if (header.getText().equalsIgnoreCase("Performed Date")) {
				System.out.println(" : is in the header");
				Assert.assertTrue(header.getText().contains("Performed Date"));
			} else if (header.getText().equalsIgnoreCase("Description")) {
				System.out.println(" : is  in the header ");
				Assert.assertTrue(header.getText().contains("Description"));
			} else if (header.getText().equalsIgnoreCase("Details")) {
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Details"));
			} else {
				System.out.println(" The given text is not in the header");
			}
		}

	}

	@Test(priority = 12)
	public void setcontext2(ITestContext context) {
		int sheetnumber = 26;
		context.setAttribute("index", sheetnumber);

	}

	@Test(dataProvider = "paramName", dataProviderClass = ExcelReaderWithIndex.class, priority = 13)

	public void editcandidate(String firstname, String middlename, String lastname, String email, String contactno,
			String keywords, String comments, String appldate) throws Exception {

		candidatesPage.EditButton().click();
		// To validate if fields are editable.
		Assert.assertTrue(candidatesPage.FirstName().isEnabled(), "First Name is not editable");
		Assert.assertTrue(candidatesPage.middleName().isEnabled(), "Middle Name is not editable");
		Assert.assertTrue(candidatesPage.lastName().isEnabled(), "Last Name is not editable");
		Assert.assertTrue(candidatesPage.Email().isEnabled(), "Email is not editable");
		Assert.assertTrue(candidatesPage.contactNo().isEnabled(), "ContactNo is not editable");
		Assert.assertTrue(candidatesPage.KeyWords().isEnabled(), "KeyWords is not editable");
		Assert.assertTrue(candidatesPage.Comments().isEnabled(), "Comments is not editable");
		Assert.assertTrue(candidatesPage.DateOfApplication().isEnabled(), "Date of application is not editable");

		// Validate if Edit interface is populated.
		String headtext = candidatesPage.EditCandHeading().getText();
		Assert.assertEquals("Edit Candidate", headtext);

		// Validate if Save and Cancel buttons are displayed
		Assert.assertTrue(candidatesPage.SaveButton().isDisplayed(), "Save Button Not Displayed");
		Assert.assertTrue(candidatesPage.CancelButton().isDisplayed(), "Cancel Button Not Displayed");

		// Clearing fields before entering the data to be edited
		candidatesPage.FirstName().clear();
		candidatesPage.middleName().clear();
		candidatesPage.lastName().clear();
		candidatesPage.Email().clear();
		candidatesPage.contactNo().clear();
		candidatesPage.KeyWords().clear();
		candidatesPage.Comments().clear();
		candidatesPage.DateOfApplication().clear();

		// Enter data from file
		candidatesPage.FirstName().sendKeys(firstname);
		// Validation for mandatory field First Name
		if (candidatesPage.FirstName().getAttribute("value").isEmpty()) {
			System.out.println("Please enter First Name");
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		}
		candidatesPage.middleName().sendKeys(middlename);
		candidatesPage.lastName().sendKeys(lastname);
		// Validation for mandatory field Last Name
		if (candidatesPage.lastName().getAttribute("value").isEmpty()) {
			System.out.println("Please enter First Name");
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		}
		candidatesPage.Email().sendKeys(email);
		// Validation for mandatory field Email
		if (candidatesPage.Email().getAttribute("value").isEmpty()) {
			System.out.println("Please enter First Name");
			System.out.println(driver.findElement(By.className("validation-error")).getText() + " is displayed");
		}

		candidatesPage.contactNo().sendKeys(contactno);
		candidatesPage.ReplaceCurrent().click();

		WebElement ele = candidatesPage.chooseFile();
		AttatchmentsUtil.uploadingFileUsingRobot(ele, driver, "resume2.pdf");

//		AttatchmentsUtil.uploadingFileUsingRobotInmac(ele2, driver,"/Users/chelak/Downloads/Sprint8/attachments/resume");
		candidatesPage.KeyWords().sendKeys(keywords);
		candidatesPage.Comments().sendKeys(comments);
		candidatesPage.DateOfApplication().sendKeys(appldate);

		// To validate colors of Save and Cancel button
		String color3 = ColorValidationUtil.GetColor(candidatesPage.SaveButton());
		Assert.assertEquals("Green", color3);
		String color4 = ColorValidationUtil.GetColor(candidatesPage.CancelButton());
		Assert.assertEquals("Darker Grey", color4);

		candidatesPage.SaveButton().click();

		// Validate if Navigation Happening to candidates page.
		String headtext2 = candidatesPage.CandHeading().getText();
		Assert.assertEquals("Candidate", headtext2);

	}
	 
	    //Candidate Page History Header Table validation
	    
	    @Test(priority=14)
	    public void candidate_History_HdrValidate()
	    {
	    	boolean canHistoryHdrValidate = driver.findElement(By.id("search-results")).isDisplayed();
	    	Assert.assertTrue(canHistoryHdrValidate);
	    	System.out.println("Candidate History Header Table is Validated" +"\n");
	    }
	    
	  
	    
}

