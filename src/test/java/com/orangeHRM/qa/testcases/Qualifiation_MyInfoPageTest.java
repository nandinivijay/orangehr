package com.orangeHRM.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.base.BaseClass;
import com.orangeHRM.qa.base.BaseVerification;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.pages.Qualification_MyInfoPage;
import com.orangeHRM.qa.testdata.ExcelReaderWithIndex;
import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.AttatchmentsUtil;
import com.orangeHRM.qa.util.ColorValidationUtil;
import com.orangeHRM.qa.util.DropDownUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class Qualifiation_MyInfoPageTest extends BaseClass{
	BaseVerification baseVerification ;
	MyInfoPage myInfoPage;
	Qualification_MyInfoPage qualifiation_MyInfoPage;
	WebElement element;

	@BeforeClass
	public void verifyQualifiation_MyInfoPageNavigation() {
		login();
		baseVerification = new BaseVerification(driver);
		myInfoPage = baseVerification.navigatingToMyInfo();
		qualifiation_MyInfoPage = myInfoPage.navigatingToQualification_MyInfo();
		System.out.println("Clicked Qualifiation_MyInfoPage and url is validated");
	}

	@Test(priority=3) 
	public void validateQualifiation_MyInfoButton_bgcolor() {
		try {

			
			// details button bg-color- grey
			element = myInfoPage.getQualification_MyInfo_XPath();
			ActionsUtil.MouseHoover(element, driver);
			Assert.assertTrue(myInfoPage.getColor_Sidenav(element).contains(myInfoPage.SIDENAV_CLICKEDCOLOR),
					"*********Buttton clicked color mis match*************");
			System.out.println("qualifiation_MyInfoPage button bg-color is validated after clicking---grey");
			
			
		} catch (AssertionError ae) {
			System.out.println("In qualifiation_MyInfoPage Testing--validateQualifiation_MyInfoButton_bgcolor :" + ae.getMessage());
		} catch (WebDriverException we) {
			System.out.println("In qualifiation_MyInfoPage--validateQualifiation_MyInfoButton_bgcolor :" + we.getMessage());
		}

	}


	@Test(priority=4)
	public void colorValidationForAddandDeleteButtons()
	{
		 String addhex = ColorValidationUtil.GetColor(qualifiation_MyInfoPage.addButtonClk());
		 System.out.println("add button color"+addhex);
	String deletehex = ColorValidationUtil.GetColor(qualifiation_MyInfoPage.deleteButtonClk());
	 System.out.println("deletebutton colur"+deletehex);
	 Assert.assertEquals(addhex,"Green");
	 Assert.assertEquals(deletehex,"Red");
	 Assert.assertNotEquals(addhex,deletehex);
	 System.out.println("add and delete button colors are different");

	}
	
	// Work Experience Qualification MyInfo Testcases.
	
	@Test(priority = 5)
	public void mandatoryFieldValidationWrkExp() {
		qualifiation_MyInfoPage.addButtonClk().click();
		qualifiation_MyInfoPage.saveButtonClk().click();
		boolean flag;
		if (qualifiation_MyInfoPage.company().getAttribute("value").isEmpty()) {
			flag = true;
			System.out.println("Company Field Is Empty");
		} else {
			System.out.println("Company Field Is Not Empty");
			flag = false;
		}
		
		if (qualifiation_MyInfoPage.job_title().getAttribute("value").isEmpty()) {
			flag = true;
			System.out.println("Job_title Field Is Empty");
		} else {
			System.out.println("Job_title Field Is Not Empty");
			flag = false;
		}
		
		Assert.assertTrue(flag);
		System.out.println("All Mandatory Fields Are Tested Successfully");
		qualifiation_MyInfoPage.cancelButtonClk().click();
		// driver.quit();
	} 
	
	
	@Test(priority=6)
	public void setcontextWrkExp(ITestContext context) {
	int	sheetnumber=36;
	context.setAttribute("index", sheetnumber);
	}
	
		
	@Test(dataProvider = "paramName",dataProviderClass=ExcelReaderWithIndex.class,priority=7 )
	public void verifyAddWorkExperience(String company,String job_title,String fromyear,String frommonth,String fromdate,String toyear,String tomonth,String todate,String comment ) throws Exception
	{
		qualifiation_MyInfoPage.addButtonClk().click();
		Thread.sleep(1000);
		
		qualifiation_MyInfoPage.company().sendKeys(company);
		System.out.println("Company :"+company);
		Thread.sleep(1000);
		
		qualifiation_MyInfoPage.job_title().sendKeys(job_title);
		System.out.println("Job_title : "+job_title);
		Thread.sleep(1000);
		
		qualifiation_MyInfoPage.fromDate().click();  
				
		DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.month(), frommonth);
		DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.year(), fromyear);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+fromdate+")]")).click();
		Thread.sleep(1000);
		
		qualifiation_MyInfoPage.to_date().click();
  		DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.year(), toyear);
		DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.month(), tomonth);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+todate+")]")).click();
		Thread.sleep(1000);
		
		qualifiation_MyInfoPage.commentSection().sendKeys(comment);
		qualifiation_MyInfoPage.saveButtonClk().click();
		Thread.sleep(2000); 
		
	}
	
   @Test(priority=8)  
	public void tableValidatingWrkExp() 
	{
		List<WebElement> li = driver.findElements(By.xpath("//*[@id='frmDelWorkExperience']/table/thead/tr/th")); //  //*[@id="tblEducation"]/table/thead/tr
		int n = li.size();
		
		List<String> s = new ArrayList<String>();
		System.out.println("size of Columns : " + n);  
		
		for (int i = 0; i < n; i++) 
		{
			s.add(li.get(i).getText());
		}

		System.out.println("List String : " + s);
		System.out.println("No . of columns in a table are : " + n);
		Assert.assertEquals(6, n);

		for (int i = 1; i <= n - 1; i++) 
		{
			WebElement header = driver.findElement(By.xpath("//*[@id='frmDelWorkExperience']/table/thead/tr/th[" + (i + 1) + "]"));
			System.out.print(header.getText());
			if (header.getText().equalsIgnoreCase("Company")) 
			{
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Company"));
			} 
			else if (header.getText().equalsIgnoreCase("JobTitle")) 
			{
				System.out.println(": is  in the header ");
				Assert.assertTrue(header.getText().contains("jobTitle"));
			} 
			else if (header.getText().equalsIgnoreCase("From")) 
			{
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("From"));
			}
			else if (header.getText().equalsIgnoreCase("To")) 
			{
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("To"));
			} 
			else if (header.getText().equalsIgnoreCase("Comment")) 
			{
				System.out.println(": is in the header");
				Assert.assertTrue(header.getText().contains("Comment"));
			}
		}
	}


  	@Test(priority=9)
	public void setcontextWrkExpEdit(ITestContext context) {
	int	sheetnumber=34;
	context.setAttribute("index", sheetnumber);
	}
	
	@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class ,priority=10,dependsOnMethods = { "verifyAddWorkExperience" })
	public void editWorkExperience(String company1,String job_title1,String fromyear1,String frommonth1 ,String fromdate1,String toyear1,String tomonth1,String todate1,String comment1) throws Exception 
	{
		System.out.println("Qualifications clicked");
		
		SynchronisationWaitsUtil.implicitwait(12,TimeUnit.SECONDS, driver);
		System.out.println("i am here");
		System.out.println("Current Url of Work Experience : "+qualifiation_MyInfoPage.getcurrentUrl());
		driver.findElement(By.xpath("//*[@id='frmDelWorkExperience']/table/tbody/tr[1]/td[2]/a")).click(); 
						 
		SynchronisationWaitsUtil.threadsleep(2000);
		
		qualifiation_MyInfoPage.company().clear();
		qualifiation_MyInfoPage.job_title().clear();
		// Enter data from file
		qualifiation_MyInfoPage.company().sendKeys(company1);
			
		qualifiation_MyInfoPage.job_title().sendKeys(job_title1);
		
		qualifiation_MyInfoPage.fromDate().click();	
		
		DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.year(), fromyear1);
		DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.month(), frommonth1);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+fromdate1+")]")).click();

		qualifiation_MyInfoPage.to_date().click();
		
		DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.month(), tomonth1);
		DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.year(), toyear1);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+todate1+")]")).click();
		
		qualifiation_MyInfoPage.commentSection().clear();
		qualifiation_MyInfoPage.commentSection().sendKeys(comment1);
		
		qualifiation_MyInfoPage.saveButtonClk().click();
		
		SynchronisationWaitsUtil.threadsleep(2000);
		
        String cmpny = driver.findElement(By.xpath("//*[@id='frmDelWorkExperience']/table/tbody/tr[1]/td[2]")).getText(); 
		  
		  System.out.println("Company : "+cmpny +"Company1 "+company1);
		  Assert.assertEquals(cmpny, company1);
		  System.out.println("Company Edited Successfully");
				
		}  
	
	
	int finalWorkExpnumRows;
	@Test(priority = 11, dependsOnMethods = { "verifyAddWorkExperience" })
	public void deletingSingle_WorkExp() throws InterruptedException {
		
		if (qualifiation_MyInfoPage.deleteButtonClk().isDisplayed())
			
		{
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='frmDelWorkExperience']/table/tbody/tr")); 
			Thread.sleep(2000);
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : " + numRows);
			
			driver.findElement(By.xpath("//*[@id='frmDelWorkExperience']/table/tbody/tr[1]/td[1]")).click();
			qualifiation_MyInfoPage.deleteButtonClk().click();
			Thread.sleep(2000);
			
			List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id='frmDelWorkExperience']/table/tbody/tr"));
			// List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id='frmDelWorkExperience']/table/tbody"));
			 
			finalWorkExpnumRows = finalRows.size();  
			Thread.sleep(1000);
			System.out.println("No. of Rows After Deleting : " + finalWorkExpnumRows);
			Assert.assertEquals(finalWorkExpnumRows, numRows - 1);
		} else {
			Assert.assertFalse(qualifiation_MyInfoPage.deleteButtonClk().isDisplayed());
			System.out.println("No Rows Displayed");
		}
	} 
	
	
	@Test(priority = 12)
	public void deletingall_WorkExperience() throws InterruptedException {
		
		if (finalWorkExpnumRows > 0) {
			
			List<WebElement> rowsWEList = driver.findElements(By.xpath("//*[@id='frmDelWorkExperience']/tbody/tr"));
			int numWERows = rowsWEList.size();
			System.out.println("No. of Rows After Deleting All WrkExp : " + numWERows); 
			
			//driver.findElement(By.id("workCheckAll")).click();
			driver.findElement(By.xpath("//*[@id='frmDelWorkExperience']/table/thead/tr/th[1]")).click();
			
			//qualifiation_MyInfoPage.checkboxallAttatchment().click();
			qualifiation_MyInfoPage.deleteButtonClk().click();
			Thread.sleep(1000);

		} else {

			System.out.println("No rows Displayed");
		}
	} 
	
	// Education MyInfo Qualifications Test Cases
	
	@Test(priority = 13)
	public void mandatoryFieldValidation() {
		qualifiation_MyInfoPage.addEduButton().click();
		qualifiation_MyInfoPage.saveEduButton().click();
		boolean flag;
		if (qualifiation_MyInfoPage.sellevel().getAttribute("value").isEmpty()) {
			flag = true;
			System.out.println("Level Field Is Empty");
		} else {
			System.out.println("Level Field Is Not Empty");
			flag = false;
		}
		Assert.assertTrue(flag);
		System.out.println("All Mandatory Fields Are Tested Successfully");
		qualifiation_MyInfoPage.cancelEduButton().click();
		// driver.quit();
	}

@Test(priority=14)
public void setcontext(ITestContext context) {
int	sheetnumber=18;
context.setAttribute("index", sheetnumber);
}
@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class,priority=15 )

public void verifyAddEducationTesting(String level,String institute,String major,String year,String gpa,String startdd,String startmonth,String startyear,String enddd,String endmonth,String endyear) throws Exception
{
	Thread.sleep(5000);
	qualifiation_MyInfoPage.addEduButton().click();
	
	qualifiation_MyInfoPage.sellevel().sendKeys(level);
	qualifiation_MyInfoPage.selInstitute().sendKeys(institute);
	qualifiation_MyInfoPage.selmajor().sendKeys(major);
	qualifiation_MyInfoPage.selEduYear().sendKeys(year);
	qualifiation_MyInfoPage.selgpa().sendKeys(gpa);
	qualifiation_MyInfoPage.startDate().click();	
	DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.selmonth(), startmonth);
	DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.selYear(), startyear);
	driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+startdd+")]")).click();

	qualifiation_MyInfoPage.endDate().click();

	
	DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.selmonth(), endmonth);
	DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.selYear(), endyear);
	driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+enddd+")]")).click();
	
	qualifiation_MyInfoPage.saveEduButton().click();
	
}
@Test(priority = 16)
public void edutableValidating() 
{
	List<WebElement> li = driver.findElements(By.xpath("//*[@id='tblEducation']/table/thead/tr/th"));
	int n = li.size();
	List<String> s = new ArrayList<String>();
	System.out.println("size of Columns : " + n);
	for (int i = 0; i < n; i++) 
	{
		s.add(li.get(i).getText());
	}

	System.out.println("List String : " + s);
	System.out.println("No . of columns in a table are : " + n);
	Assert.assertEquals(4, n);

	for (int i = 1; i <= n - 1; i++) 
	{
		WebElement header = driver.findElement(By.xpath("//*[@id='tblEducation']/table/thead/tr/th[" + (i + 1) + "]"));
		System.out.print(header.getText());
		if (header.getText().equalsIgnoreCase("Level")) 
		{
			System.out.println(": is in the header");
			Assert.assertTrue(header.getText().contains("Level"));
		} 
		else if (header.getText().equalsIgnoreCase("Year")) 
		{
			System.out.println(": is  in the header ");
			Assert.assertTrue(header.getText().contains("Year"));
		} 
		else if (header.getText().equalsIgnoreCase("GPA/Score")) 
		{
			System.out.println(": is in the header");
			Assert.assertTrue(header.getText().contains("GPA/Score"));
		}
	}
}

 @Test(priority = 17)
public void leveldropdownSortedOrNot() {
	
	WebElement element1 = qualifiation_MyInfoPage.sellevel();
	Select sel = new Select(element1);
	ArrayList<String> originalList = new ArrayList<String>();
	
	for (WebElement e : sel.getOptions()) {
		//System.out.println("New "+driver.findElement(By.xpath("//*[@id=\"education_code\"]/option[2]")).getText());
		originalList.add(e.getText());
	}
	System.out.println("OriginalList:" + originalList);
	ArrayList<String> tempList = originalList;
	Collections.sort(tempList);

	System.out.println("OriginalList:" + originalList);
	System.out.println("TempList:" + tempList);
	Assert.assertEquals(originalList, tempList);
	System.out.println("OriginalList and TempList Dropdowns are in sorted order ");
	

}

@Test(priority = 18)
public void validatingLevelDropdownOptionsDuplicates()
{
	WebElement element1 =driver.findElement(By.xpath("//*[@id='education_code']"));//qualifiation_MyInfoPage.sellevel();
	  Select se = new Select(element1);
	
	    List<WebElement> list = se.getOptions();
	    
	    Set<String> s = new LinkedHashSet<String>();
	    for (WebElement w : list) {
	        s.add(w.getText());
	        System.out.println(s);
	    }
	    System.out.println("List size = "+list.size()+"\n Set Size = "+s.size());
	    Assert.assertEquals(list.size(),s.size());
	    System.out.println("No duplicates present in dropdown.");
}

@Test(priority = 19)
public void verifystartDateFormat() throws Exception 
{
	
	String startDate = qualifiation_MyInfoPage.startDate().getAttribute("value");
	System.out.println("Here is Start Date Value: " + startDate);
	StringBuffer sBuffer = new StringBuffer(startDate);
	System.out.println("String buffer : "+sBuffer);
	String date, month, year;
	boolean flag;
	year = sBuffer.substring(0, 4);
	month = sBuffer.substring(5, 7);
	date = sBuffer.substring(8, 10);
	System.out.println("Year:" + year + " Mon:" + month + " Date:" + date);

	if (year.matches("^[12][0-9]{3}$") && month.matches("^(0?[1-9]|1[012])$")
			&& date.matches("^(0[1-9]|[12]\\d|3[01])$")) {
		System.out.println("Start Date Format Matched.");
		flag = true;
	} else {
		System.out.println("Start Date Format Didn't Matched.");
		flag = false;
	}
	Assert.assertTrue(flag);
	Thread.sleep(2000);
}

@Test(priority=20)
public void setcontext3(ITestContext context) {
int	sheetnumber=19;
context.setAttribute("index", sheetnumber);
}

@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class ,priority=21,dependsOnMethods = { "verifyAddEducationTesting" })
public void editEducationTesting(String institute1,String major1,String year1,String gpa1,String startdd1,String startmonth1,String startyear1,String enddd1,String endmonth1,String endyear1) throws Exception 
{
	System.out.println("Education Page clicked");
	
	SynchronisationWaitsUtil.implicitwait(12,TimeUnit.SECONDS, driver);
	System.out.println("i am here");
	System.out.println("Current Url of Education : "+qualifiation_MyInfoPage.getcurrentUrl());
	
	driver.findElement(By.xpath("//*[@id='tblEducation']/table/tbody/tr[1]/td[2]/a")).click();
		
	qualifiation_MyInfoPage.selInstitute().clear();
	qualifiation_MyInfoPage.selInstitute().sendKeys(institute1);
	qualifiation_MyInfoPage.selmajor().clear();
	qualifiation_MyInfoPage.selmajor().sendKeys(major1);
	qualifiation_MyInfoPage.selEduYear().clear();
	qualifiation_MyInfoPage.selEduYear().sendKeys(year1);
	qualifiation_MyInfoPage.selgpa().clear();
	qualifiation_MyInfoPage.selgpa().sendKeys(gpa1);
	qualifiation_MyInfoPage.startDate().click();	
	DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.selmonth(), startmonth1);
	DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.selYear(), startyear1);
	driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+startdd1+")]")).click();

	qualifiation_MyInfoPage.endDate().click();

	
	DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.selmonth(), endmonth1);
	DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.selYear(), endyear1);
	driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+enddd1+")]")).click();
	
	qualifiation_MyInfoPage.saveEduButton().click();
		
	
	
	SynchronisationWaitsUtil.threadsleep(2000);
	List<WebElement> table = driver.findElements(By.xpath("//*[@id='tblEducation']/table/tbody/tr"));
	int size = table.size();
	for (int i=1;i<size;i++)
	{
	   //String level = driver.findElement(By.xpath("//*[@id='tblEducation']/table/tbody/tr["+i+"]/td[2]/a")).getText(); 
	  
	   //System.out.println("Level :"+level);
	   String year = driver.findElement(By.xpath("//*[@id='tblEducation']/table/tbody/tr["+i+"]/td[3]")).getText();
	   String gpa = driver.findElement(By.xpath("//*[@id='tblEducation']/table/tbody/tr["+i+"]/td[4]")).getText();
	   if(year.equals(year1) && gpa.equals(gpa1))
	   {
	   Assert.assertEquals(year,year1 );
	   System.out.println("Year Edited Successfully");
	   
	   Assert.assertEquals( gpa, gpa1);
	   System.out.println("GPA/Score Edited Successfully");
	   }
	}
}

int finalEdunumRows;
@Test(priority = 22, dependsOnMethods = { "verifyAddEducationTesting" })
public void deletingSingle_Education() {
	// driver.findElement(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr/td[1]/input")).click();
	if (qualifiation_MyInfoPage.delEduButton().isDisplayed())
//			if (Assert.assertTrue(emergencyContactsPage.deleteButton().isDisplayed())
	{
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tblEducation']/table/tbody/tr"));
		int numRows = rows.size();
		System.out.println("No. of Rows Before Deleting : " + numRows);
		driver.findElement(By.xpath("//*[@id='tblEducation']/table/tbody/tr[1]/td[1]")).click();
		//*[@id="tblEducation"]/table/tbody/tr[1]/td[1]/input[10]
		// emergencyContactsPage.getCheckboxAttatchment().click();
		qualifiation_MyInfoPage.delEduButton().click();
		List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id='tblEducation']/table/tbody/tr"));
		finalEdunumRows = finalRows.size();
		System.out.println("No. of Rows After Deleting : " + finalEdunumRows);
		Assert.assertEquals(finalEdunumRows, numRows - 1);
	} else {
		Assert.assertFalse(qualifiation_MyInfoPage.delEduButton().isDisplayed());
		System.out.println("No Rows Displayed");
	}
}

@Test(priority = 23)
public void deletingall_Education() {

	
	if (finalEdunumRows > 0) {
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tblEducation']/table/tbody/tr"));
		int numRows = rows.size();
		System.out.println("No. of Rows Before Deleting : " + numRows);
		//driver.findElement(By.id("educationCheckAll")).click();
		qualifiation_MyInfoPage.eduCheckallboxes().click();
		qualifiation_MyInfoPage.delEduButton().click();

	} else {

		System.out.println("No rows Displayed");
	}
}

    
// Skills Qualifications MyInfo TestCases

@Test(priority=24) 
public void setcontext5(ITestContext context) 
{
	  int sheetnumber=24; 
	  context.setAttribute("index", sheetnumber);
}

@Test(dataProvider = "paramName",dataProviderClass=ExcelReaderWithIndex.class,priority=25 )

public void verifyAddSkillTesting(String skill,String yoe,String comments) throws Exception 
{
	  qualifiation_MyInfoPage.addSkillButton().click();
	  DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.selSkill(), skill);
	  //qualifiation_MyInfoPage.selSkill().sendKeys(skill);

	  qualifiation_MyInfoPage.selSkillYear().sendKeys(yoe);
	  qualifiation_MyInfoPage.selSkillComments().sendKeys(comments);
	  qualifiation_MyInfoPage.saveSkillButton().click();

}

@Test(priority = 26) 
public void skilltableValidating()
{
	  List<WebElement> li =  driver.findElements(By.xpath("//*[@id='frmDelSkill']/table/thead/tr/th"));
	  int n = li.size(); 
	  List<String> s = new ArrayList<String>();
	  System.out.println("size of Columns : " + n); 
	  for (int i = 0; i < n; i++) 
	  {
		  s.add(li.get(i).getText()); 
	  }

	  System.out.println("List String : " + s);
	  System.out.println("No . of columns in a table are : " + n);
	  Assert.assertEquals(3, n);

	  for (int i = 1; i <= n - 1; i++) 
	  {
		  WebElement header = driver.findElement(By.xpath("//*[@id='frmDelSkill']/table/thead/tr/th[" + (i + 1) + "]"));
		  System.out.print(header.getText());
		  if(header.getText().equalsIgnoreCase("Skill"))
		  {
			  System.out.println(": is in the header");
			  Assert.assertTrue(header.getText().contains("Skill"));
		  }
		  else if(header.getText().equalsIgnoreCase("Years of Experience"))
		  {
			  System.out.println(": is  in the header ");
			  Assert.assertTrue(header.getText().contains("Years of Experience"));
		  }
		  
	  }
}


@Test(priority = 27)
public void skilldropdownSortedOrNot() 
{

	  //WebElement element1 = qualifiation_MyInfoPage.selSkill(); 
	  WebElement element1 = driver.findElement(By.xpath("//*[@id='skill_code']"));
	  Select sel = new Select(element1);
	  ArrayList<String> originalList = new ArrayList<String>();

	  for (WebElement e : sel.getOptions()) {
//	System.out.println("New "+driver.findElement(By.xpath("//*[@id=\"education_code\"]/option[2]")).getText());
		  originalList.add(e.getText());
	  }
	  System.out.println("OriginalList:" +originalList);
	  ArrayList<String> tempList = originalList;
	  Collections.sort(tempList);

	  System.out.println("OriginalList:" + originalList);
	  System.out.println("TempList:" + tempList);
	  Assert.assertEquals(originalList,tempList);
	  System.out.println("OriginalList and TempList Dropdowns are in sorted order ");

	}

@Test(priority = 28) 
public void validatingskillDropdownOptionsDuplicates()
{ 
	  WebElement element1 = qualifiation_MyInfoPage.selSkill();
	  Select se = new Select(element1);

	  List<WebElement> list = se.getOptions();

	  Set<String> s = new LinkedHashSet<String>();
	  for (WebElement w : list)
	  {
		  s.add(w.getText()); 
		  System.out.println(s); 
	  }
	  System.out.println("List size = "+list.size()+"\n Set Size = "+s.size());
	  Assert.assertEquals(list.size(),s.size());
	  System.out.println("No duplicates present in dropdown."); 
	  }


@Test(priority=29) 
public void setcontext6(ITestContext context)
{
	  int sheetnumber=25; 
	  context.setAttribute("index", sheetnumber); }

@Test(dataProvider = "paramName",dataProviderClass=ExcelReaderWithIndex.class ,priority=30,dependsOnMethods ={ "verifyAddSkillTesting" })
public void editSkillTesting(String skill1,String yoe1,String comments1)throws Exception 
{
	  System.out.println("Skill Page clicked");

	  SynchronisationWaitsUtil.implicitwait(12,TimeUnit.SECONDS, driver);
	  System.out.println("i am here");
	  System.out.println("Current Url of Skill : "+qualifiation_MyInfoPage.getcurrentUrl());

	  qualifiation_MyInfoPage.editSkillClick().click();

	  SynchronisationWaitsUtil.threadsleep(2000);

	  qualifiation_MyInfoPage.selSkillYear().clear();
	  qualifiation_MyInfoPage.selSkillYear().sendKeys(yoe1);
	  qualifiation_MyInfoPage.selSkillComments().clear();
	  qualifiation_MyInfoPage.selSkillComments().sendKeys(comments1);

	  qualifiation_MyInfoPage.saveSkillButton().click();



	  SynchronisationWaitsUtil.threadsleep(2000); 
	  List<WebElement> table = driver.findElements(By.xpath("//*[@id='frmDelSkill']/table/tbody/tr")); 
	  int size = table.size(); 
	  for (int i=1;i<size;i++)
	  {
		  String skill = driver.findElement(By.xpath("//*[@id='frmDelSkill']/table/tbody/tr["+i+"]/td[2]/a")).getText();
		  System.out.println("Skill : "+skill);
		  String yoe = driver.findElement(By.xpath("//*[@id='frmDelSkill']/table/tbody/tr["+i+"]/td[3]")).getText(); 
		  if(yoe.equals(yoe1)) 
		  {
			  Assert.assertEquals(yoe,yoe1 );
			  System.out.println("Year Edited Successfully");

		  }
	  }
}

int finalskillnumRows;

@Test(priority = 31, dependsOnMethods = { "verifyAddSkillTesting" })
public void deletingSingle_skill() 
{
	 
	  if(qualifiation_MyInfoPage.delSkillButton().isDisplayed()) 
		  // if(Assert.assertTrue(emergencyContactsPage.deleteButton().isDisplayed()) 
	  {
		  List<WebElement> rows =  driver.findElements(By.xpath("//*[@id='frmDelSkill']/table/tbody/tr"));
		  int numRows = rows.size(); 
		  System.out.println("No. of Rows Before Deleting : " + numRows);
		  driver.findElement(By.xpath("//*[@id='frmDelSkill']/table/tbody/tr[1]/td[1]")).click();
		  qualifiation_MyInfoPage.delSkillButton().click(); 
		  List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id='frmDelSkill']/tbody/tr"));
		  finalskillnumRows = finalRows.size();
		  System.out.println("No. of Rows After Deleting : " + finalskillnumRows);
		  Assert.assertEquals(finalskillnumRows, numRows - 1);
	  }
	  else 
	  {
		  Assert.assertFalse(qualifiation_MyInfoPage.delSkillButton().isDisplayed());
		  System.out.println("No Rows Displayed"); 
	  }
}

@Test(priority = 32)
public void deletingall_Skills() 
{
	  
	  if (finalskillnumRows > 0)
	  {
		  List<WebElement> rows = driver.findElements(By.xpath("//*[@id='frmDelSkill']/tbody/tr")); 
		  int numRows = rows.size();
		  System.out.println("No. of Rows Before Deleting : " + numRows);
		  qualifiation_MyInfoPage.skillCheckallboxes().click();
		  qualifiation_MyInfoPage.delSkillButton().click();

	  }
	  else
	  {
		  System.out.println("No rows Displayed"); 
	  }
}

   // Languages Qualificaton MyInfo TestCases

@Test(priority=33)
public void setcontext10(ITestContext context) 
{
int	sheetnumber=20;
context.setAttribute("index", sheetnumber);
//qualifiation_MyInfoPage.ClickOnAddButton().click();

}
@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class,priority=34)
public void validateLangaugesSection_Qualification(String language,String fluency1,String competency1,String comments1,String competency2,String comments2) throws Exception
{
	System.out.println("here i am ");
	Thread.sleep(1000);
qualifiation_MyInfoPage.ClickOnAddButton().click();
System.out.println("i am here");
Thread.sleep(1000);

 //qualifiation_MyInfoPage.clickonlanguageDropDown().click();
 DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.clickonlanguageDropDown(),language);

 DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.clickonfluencyDropDown(),fluency1);
 DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.clickOnCompetencyDropDown(),competency1);
 qualifiation_MyInfoPage.enterComments().sendKeys(comments1);
 qualifiation_MyInfoPage.clickOnSaveButton().click();
 qualifiation_MyInfoPage.clickOnEdit().click();
 DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.clickOnCompetencyDropDown(),competency2);
 qualifiation_MyInfoPage.enterComments().clear();
 qualifiation_MyInfoPage.enterComments().sendKeys(comments2);

 qualifiation_MyInfoPage.clickOnSaveButton().click();

 qualifiation_MyInfoPage.clickOnAllCheckBox().click();

 qualifiation_MyInfoPage.ClickOnDeleteButton().click();

} 

	// License Qualifications MyInfo TestCases
	
	@Test(priority=35)
	public void mandatoryLicenseFieldValidationLicen() {
		
		qualifiation_MyInfoPage.addButtonLicenseClk().click();
		qualifiation_MyInfoPage.saveBtnClklicense().click();
		boolean flag;
		if (qualifiation_MyInfoPage.licenseType().getAttribute("value").isEmpty()) {
			flag = true;
			System.out.println("License Type Field Is Empty");
		} else {
			System.out.println("License Type Field Is Not Empty");
			flag = false;
		}
		
		Assert.assertTrue(flag);
		System.out.println(" Mandatory Field is Tested Successfully");
		qualifiation_MyInfoPage.cancelBtnClklicense().click();
	}	
	
	@Test(priority=36)
	public void setcontextLicense(ITestContext context) {
		int	sheetnumber=35;
		context.setAttribute("index", sheetnumber);
		}
		
			
		@Test(dataProvider = "paramName",dataProviderClass=ExcelReaderWithIndex.class,priority=37 )
		public void verifyAddLicense(String licenseType,String licenseNumber,String issuedLisYear,String issuedLisMonth,String issuedLisDate,String expiryLisYear,String expiryLisMonth,String expiryLisDate) throws Exception
		{
			
			Thread.sleep(1000);
			qualifiation_MyInfoPage.addButtonLicenseClk().click();
			Thread.sleep(1000);
			
			qualifiation_MyInfoPage.licenseType().sendKeys(licenseType);
			Thread.sleep(1000);
			System.out.println("License Type Is :"+licenseType);
			Thread.sleep(1000);
			
			qualifiation_MyInfoPage.licenseNumber().sendKeys(licenseNumber);
			System.out.println("License Number Is : "+licenseNumber);
			Thread.sleep(1000);
			
			qualifiation_MyInfoPage.issued_datelicense().click();  
					
			DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.year_license(),issuedLisYear);
			DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.month_license(), issuedLisMonth);
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+issuedLisDate+")]")).click();
			
			Thread.sleep(1000);
			
			qualifiation_MyInfoPage.expiry_datelicense().click();
	  		DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.year_license(),expiryLisYear);
			DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.month_license(),expiryLisMonth);
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+expiryLisDate+")]")).click();
			Thread.sleep(1000);
			
			qualifiation_MyInfoPage.saveBtnClklicense().click();
			
		}
		
		 @Test(priority=38)  
			public void tableValidatingLicense() 
			{
				List<WebElement> listWebEle = driver.findElements(By.xpath("//*[@id='frmDelLicense']/table/thead/tr/th")); //  //*[@id="tblEducation"]/table/thead/tr
				int nmbr = listWebEle.size();
				
				List<String> strg = new ArrayList<String>();
				System.out.println("size of Columns : " + nmbr);  
				
				for (int i = 0; i <nmbr; i++) 
				{
					strg.add(listWebEle.get(i).getText());
				}

				System.out.println("List String : " + strg);
				System.out.println("No . of columns in a table are : " + nmbr);
				Assert.assertEquals(4, nmbr);

				for (int i = 1; i <= nmbr - 1; i++) 
				{
					WebElement header5 = driver.findElement(By.xpath("//*[@id='frmDelLicense']/table/thead/tr/th[" + (i + 1) + "]"));
					System.out.print(header5.getText());
					if (header5.getText().equalsIgnoreCase("License Type")) 
					{
						System.out.println(": is in the header");
						Assert.assertTrue(header5.getText().contains("License Type"));
					} 
					else if (header5.getText().equalsIgnoreCase("License Number")) 
					{
						System.out.println(": is  in the header ");
						Assert.assertTrue(header5.getText().contains("License Number"));
					} 
					else if (header5.getText().equalsIgnoreCase("Issued Date")) 
					{
						System.out.println(": is in the header");
						Assert.assertTrue(header5.getText().contains("Issued Date"));
					}
					else if (header5.getText().equalsIgnoreCase("Expiry Date")) 
					{
						System.out.println(": is in the header");
						Assert.assertTrue(header5.getText().contains("Expiry Date"));
					} 
				}
			}

		
		 @Test(priority=39)
			public void setcontextLicenseEdit(ITestContext context) {
			int	sheetnumber=37;
			context.setAttribute("index", sheetnumber);
			}
			
			@Test(dataProvider = "paramName" ,dataProviderClass=ExcelReaderWithIndex.class ,priority=40,dependsOnMethods = { "verifyAddLicense" })
			public void editMyInfoLicense(String licenseType1,String licenseNumber1,String issuedLicYear1,String issuedLicMonth1 ,String issuedLicDate1,String expiryLicYear1,String expiryLicMonth1,String expiryLicDate1) throws Exception 
			{
				System.out.println("Qualifications clicked");
				
				SynchronisationWaitsUtil.implicitwait(12,TimeUnit.SECONDS, driver);
				System.out.println("i am here");
				System.out.println("Current Url of License : "+qualifiation_MyInfoPage.getcurrentUrl());
				driver.findElement(By.xpath("//*[@id='frmDelLicense']/table/tbody/tr[1]/td[2]/a")).click(); 
				SynchronisationWaitsUtil.threadsleep(2000);
				
				//qualifiation_MyInfoPage.licenseType().clear();
				//Thread.sleep(1000);
				//qualifiation_MyInfoPage.licenseType().sendKeys(licenseType1);
				
				qualifiation_MyInfoPage.licenseNumber().clear();
				// Enter data from file
				
				qualifiation_MyInfoPage.licenseNumber().sendKeys(licenseNumber1);
				
				qualifiation_MyInfoPage.issued_datelicense().click();	
				
				DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.year_license(), issuedLicYear1);
				DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.month_license(), issuedLicMonth1);
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+issuedLicDate1+")]")).click();

				qualifiation_MyInfoPage.expiry_datelicense().click();
				
				DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.year_license(), expiryLicYear1);
				DropDownUtil.selectbyvalue(qualifiation_MyInfoPage.month_license(), expiryLicMonth1);
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),"+expiryLicDate1+")]")).click();
				
				qualifiation_MyInfoPage.saveBtnClklicense().click();
				
				SynchronisationWaitsUtil.threadsleep(2000);
				
		       // String licNum = driver.findElement(By.xpath("//*[@id='frmDelLicense']/table/tbody/tr[1]/td[2]")).getText(); 
				//  System.out.println("License Number : "+licNum +"License Number1 "+licenseNumber1);
				 // Assert.assertEquals(licNum, licenseNumber1);
				  System.out.println("License Number Edited Successfully");
						
				}  
			
			int finalLicensnumRows;
			@Test(priority = 41, dependsOnMethods = { "verifyAddLicense" })
			public void deletingSingle_LicenseRow() throws InterruptedException {
				
				if (qualifiation_MyInfoPage.delBtnClklicense().isDisplayed())
					
				{
					List<WebElement> licenList = driver.findElements(By.xpath("//*[@id='frmDelLicense']/table/tbody/tr")); 
					Thread.sleep(2000);
					int numLicenRows = licenList.size();
					System.out.println("No. of Rows Before Deleting : " + numLicenRows);
					
					driver.findElement(By.xpath("//*[@id='frmDelLicense']/table/tbody/tr[1]/td[1]")).click();
					qualifiation_MyInfoPage.delBtnClklicense().click();
					Thread.sleep(2000);
					
					List<WebElement> finalLicenList = driver.findElements(By.xpath("//*[@id='frmDelLicense']/table/tbody/tr"));
					// List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id='frmDelWorkExperience']/table/tbody"));
					 
					int finalLicensnumRows = finalLicenList.size();  
					Thread.sleep(1000);
					System.out.println("No. of Rows After Deleting : " + finalLicensnumRows);
					Assert.assertEquals(finalLicensnumRows, numLicenRows - 1);
				} else {
					Assert.assertFalse(qualifiation_MyInfoPage.delBtnClklicense().isDisplayed());
					System.out.println("No Rows Displayed");
				}
			} 
			
			
			@Test(priority = 42)
			public void deletingall_License() throws InterruptedException {
								
				if (finalLicensnumRows > 0) {
					
					List<WebElement> licenList = driver.findElements(By.xpath("//*[@id=\"frmDelLicense\"]/table/tbody"));
					int numLicenRows = licenList.size();
					System.out.println("No. of Rows Before Deleting : " + numLicenRows);
					qualifiation_MyInfoPage.chkboxdelBtnClklicense().click();
					//driver.findElement(By.xpath("//*[@id='frmDelLicense']/table/thead/tr/th[1]")).click();
					qualifiation_MyInfoPage.delBtnClklicense().click();
				} 
				else
				{
					System.out.println("No rows Displayed");
				}
			}
			
			// Attachments Qualification MyInfo Testcase
			
			@Test(priority=43)
			public void validateAttachmentsInQualifications() throws Exception
			{
				qualifiation_MyInfoPage.clickOnAddButton().click();
				WebElement ele = qualifiation_MyInfoPage.clickOnChooseFile();
				
				AttatchmentsUtil.uploadingFileUsingRobotInmac(ele,driver,"/Users/chelak/Downloads/Sprint8/attachments/images/smallbird.jpg");
				

				
			   
				System.out.println("file choosen");
				qualifiation_MyInfoPage.clickOnComments().sendKeys("hello");
				qualifiation_MyInfoPage.clickOnUploadFile().click();
				
				qualifiation_MyInfoPage.clickOnEditAttachments().click();
				
				WebElement ele2 = qualifiation_MyInfoPage.clickOnChooseFile();
				

				AttatchmentsUtil.uploadingFileUsingRobotInmac(ele2, driver, "/Users/chelak/Downloads/Sprint8/attachments/images/SampleJPGImage_50kbmb.jpg");
				
				System.out.println("I am here closing the file dialog box");
				
				qualifiation_MyInfoPage.clickOnUploadFile().click();
				qualifiation_MyInfoPage.clickonCheckBox().click();
				
				
				
				qualifiation_MyInfoPage.clickonDeleteButtonInAttachments().click();
				
				qualifiation_MyInfoPage.clickonallCheckBox().click();
				qualifiation_MyInfoPage.clickonDeleteButtonInAttachments().click();

				
			}  
		} 
			


