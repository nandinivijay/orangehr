package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Qualification_MyInfoPage extends MyInfoPage{
	WebDriver driver;

	public Qualification_MyInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("viewQualifications");
	}
	
	//Work Experience Qualification_MyInfo
	
	By addbtn=By.id("addWorkExperience");
	By company=By.xpath("//input[@id='experience_employer']");
	By job_title=By.xpath("//input[@id='experience_jobtitle']");
	By fromdate=By.id("experience_from_date");                               
	By month=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");    
	By year=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");    
	//By date=By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a");
	By to_date=By.xpath("//input[@id='experience_to_date']");
	By comment=By.id("experience_comments");
	By savebutton=By.xpath("//input[@id='btnWorkExpSave']");
	By cancelbutton=By.xpath("//input[@id='btnWorkExpCancel']");
	By checkboxdel=By.xpath("//input[@id='workCheckAll']");
	By delbutton=By.xpath("//input[@id='delWorkExperience']");
	
	//License Qualification_MyInfo
	
	By addbtnlicense=By.id("addLicense");
	By license_type=By.xpath("//select[@id='license_code']");
	By license_number=By.xpath("//input[@id='license_license_no']");
	By issued_date_license=By.xpath("//input[@id='license_date']");
	By monthlicense=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"); //   
	By yearlicense=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");    
	By expiry_date_license=By.xpath("//input[@id='license_renewal_date']");
	By savebuttonlicense=By.xpath("//input[@id='btnLicenseSave']");
	By cancelbuttonlicense=By.xpath("//input[@id='btnLicenseCancel']");
	By delbuttonlicense=By.xpath("//input[@id='delLicense']");
	By checkboxdelAlllicense=By.xpath("//*[@id=\"licenseCheckAll\"]");
	
	//Qualification_MyInfo_Work Experince
	
	public WebElement addButtonClk()

	{
		return driver.findElement(addbtn);
	}
	
	public WebElement company()
	{
		return driver.findElement(company);
	}
	
	public WebElement job_title()
	{
		return driver.findElement(job_title);
	}
	
	public WebElement fromDate()
	{
		return driver.findElement(fromdate);
	}
	
	public WebElement year()
	{
		return driver.findElement(year);
	}
	
	public WebElement month()
	{
		return driver.findElement(month);
	}
	
	/*public Object date()
	{
		return driver.findElement(date);
	}*/
	
	public WebElement to_date()
	{
		return driver.findElement(to_date);
	}
	
	public WebElement commentSection()
	{
		return driver.findElement(comment);
	}
	
	public WebElement saveButtonClk()
	{
		return driver.findElement(savebutton);
	}
	
	public WebElement cancelButtonClk()
	{
		return driver.findElement(cancelbutton);
	}
	
	public WebElement checkBoxDelClk()
	{
		return driver.findElement(checkboxdel);
	}
	
	public WebElement deleteButtonClk()
	{
		return driver.findElement(delbutton);
	}
	
	
	//License Qualification_MyInfo
	
	public WebElement addButtonLicenseClk()

	{
		return driver.findElement(addbtnlicense);
	}
	
	public WebElement licenseType()

	{
		return driver.findElement(license_type);
	}
	
	
	public WebElement licenseNumber()

	{
		return driver.findElement(license_number);
	}
	
	public WebElement issued_datelicense()

	{
		return driver.findElement(issued_date_license);
	}
	
	public WebElement month_license()

	{
		return driver.findElement(monthlicense);
	}
	
	public WebElement year_license()

	{
		return driver.findElement(yearlicense);
	}
	
	public WebElement expiry_datelicense()

	{
		return driver.findElement(expiry_date_license);
	}
	
	public WebElement saveBtnClklicense()

	{
		return driver.findElement(savebuttonlicense);
	}
	
	public WebElement cancelBtnClklicense()

	{
		return driver.findElement(cancelbuttonlicense);
	}
	
	public WebElement delBtnClklicense()

	{
		return driver.findElement(delbuttonlicense);
	}
	

	public WebElement chkboxdelBtnClklicense()

	{
		return driver.findElement(checkboxdelAlllicense);
	}
	
    // Education MyInfo Qualification
	
	By addEdubtnId = By.id("addEducation");
	By delEdubtnId = By.id("delEducation");
	By levelId = By.id("education_code");
	By instituteId = By.id("education_institute");
	By majorId = By.id("education_major");
	By yearId = By.id("education_year");
	By gpaScoreId = By.id("education_gpa");
	By startDateId = By.id("education_start_date");
	By ddXpath = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[1]/a");
	By monXpath = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
	By yearXpath = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
	By endDateId = By.id("education_end_date");
	By saveEdubtnId = By.id("btnEducationSave");
	By cancelEdubtnId = By.id("btnEducationCancel");
	By editeduLink = By.xpath("//*[@id=\"tblEducation\"]/table/tbody/tr/td[2]/a");
	By edufilecheckbox = By.xpath("//*[@id=\"tblEducation\"]/table/tbody/tr/td[1]/input[10]");
	By eduCheckall = By.id("educationCheckAll");
	
	// Skills MyInfo Qualification
	
	By addSkillbtnId = By.id("addSkill");
	By delSkillbtnId = By.id("delSkill");
	By skillId = By.id("skill_code");
	By skillYOE = By.id("skill_years_of_exp");
	By skillsComments = By.id("skill_comments");
	By saveSkillbtnId = By.id("btnSkillSave");
	By cancelSkillbtnId = By.id("btnSkillCancel");
	By skillfilecheckbox = By.xpath("//*[@id='frmDelSkill']/table/tbody/tr/td[1]/input[5]");
	By skillCheckall = By.id("skillCheckAll");
	By editskillLink = By.xpath("//*[@id='frmDelSkill']/table/tbody/tr/td[2]/a");
	
	// Languages MyInfo qualifications
	
By addbtn_language=By.xpath("//input[@id='addLanguage']");
	By language=By.xpath("//select[@id='language_code']");
	By fluency_language=By.xpath("//select[@id= 'language_lang_type']");
	By competency_language=By.xpath("//select[@id= 'language_competency']");
	By comments_language=By.xpath("//textarea[@id='language_comments']");
	By savebtn_language=By.xpath("//input[@id='btnLanguageSave']");
	By cancelbtn_language=By.xpath("//input[@id='btnLanguageCancel']");
	By allcheckbox_language=By.xpath("//table[@id='lang_data_table']//tr[1]/th[1]");
	By deletebtn_language=By.xpath("//input[@id='delLanguage']");
	By edit_language=By.xpath("//table[@id='lang_data_table']//tbody/tr[1]//a[1]");
	By addbutton_attachments=By.xpath("//input[@id='btnAddAttachment']");
	By choosefile_attachments=By.xpath("//input[@id='ufile']");
	By comments_attachments=By.xpath("//textarea[@id='txtAttDesc']");
	By upload_attachments=By.xpath("//input[@id='btnSaveAttachment']");
	By cancel_attachments=By.xpath("//input[@id='cancelButton']");
	By edit_attachments=By.xpath("//table[@id='tblAttachments']//tr[1]/td[8]");
	By checkbox_attachments=By.xpath("//table[@id='tblAttachments']//tr[1]//td[1]");
	By allcheckbox_attachments=By.xpath("//table[@id='tblAttachments']//tr[1]/th[1]");
	By deletebutton_attachments=By.xpath("//input[@id='btnDeleteAttachment']");
	
	
	public WebElement clickOnEditAttachments()
	{
		return driver.findElement(edit_attachments);
		
	}

	
	public WebElement clickonCheckBox()
	{
		return driver.findElement(checkbox_attachments);
	}
	public WebElement clickonDeleteButtonInAttachments()
	{
		return driver.findElement(deletebutton_attachments);
	}
	
	
	public WebElement clickonallCheckBox()
	{
		return driver.findElement(allcheckbox_attachments);
	}
	
	public WebElement ClickOnDeleteButton()
	{
		return driver.findElement(deletebtn_language);
		
	}

	public WebElement ClickOnAddButton()
	{
		return driver.findElement(addbtn_language);
		
	}
	public WebElement clickonlanguageDropDown()
	
	{
		return driver.findElement(language);
		
	}
public WebElement clickonfluencyDropDown()
	
	{
		return driver.findElement(fluency_language);
		
	}
public WebElement clickOnCompetencyDropDown()

{
	return driver.findElement(competency_language);
	
}
public WebElement enterComments()

{
	return driver.findElement(comments_language);

}
public WebElement clickOnSaveButton()

{
	return driver.findElement(savebtn_language);

}

public WebElement clickOnEdit()

{
	return driver.findElement(edit_language);

}
public WebElement clickOnAllCheckBox()

{
		return driver.findElement(allcheckbox_language);

	}
public WebElement clickOnAddButton()

{
		return driver.findElement(addbutton_attachments);

	}

public WebElement clickOnChooseFile()

{
		return driver.findElement(choosefile_attachments);

	}
public WebElement clickOnComments()

{
		return driver.findElement(comments_attachments);

	}
public WebElement clickOnUploadFile()

{
		return driver.findElement(upload_attachments);

	}

public WebElement clickOnCancelButton()

{
		return driver.findElement(cancel_attachments);

	}





	

	
	
	public WebElement editEduClick() {

		return driver.findElement(editeduLink);
	}

	public WebElement delEduButton() {

		return driver.findElement(delEdubtnId);
	}

	public WebElement edufileCheckbox() {
		return driver.findElement(edufilecheckbox);
	}
	
	public WebElement eduCheckallboxes() {
		return driver.findElement(eduCheckall);
	}
	
	public WebElement saveEduButton() {

		return driver.findElement(saveEdubtnId);
	}

	public WebElement cancelEduButton() {
		return driver.findElement(cancelEdubtnId);
	}
	
	public WebElement addEduButton()

	{
		return driver.findElement(addEdubtnId);
	}

	public WebElement seldate()
	{
		return driver.findElement(ddXpath);
	}
	public WebElement selmonth()
	{
		return driver.findElement(monXpath);
	}
	public WebElement selYear()
	{
		return driver.findElement(yearXpath);
	}
	
	public WebElement startDate()
	{
	 return driver.findElement(startDateId);
	}
	public WebElement endDate()
	{
		return driver.findElement(endDateId);
	 
	}
	
	public WebElement sellevel()
	{
		return driver.findElement(levelId);
	}
	public WebElement selmajor()
	{
		return driver.findElement(majorId);
	}
	public WebElement selgpa()
	{
		return driver.findElement(gpaScoreId);
	}
	
	public WebElement selInstitute()
	{
	 return driver.findElement(instituteId);
	}
	public WebElement selEduYear()
	{
		return driver.findElement(yearId);
	 
	}
 
	
	
	public WebElement editSkillClick() {

		return driver.findElement(editskillLink);
	}

	public WebElement delSkillButton() {

		return driver.findElement(delSkillbtnId);
	}

	public WebElement skillfileCheckbox() {
		return driver.findElement(skillfilecheckbox);
	}
	
	public WebElement skillCheckallboxes() {
		return driver.findElement(skillCheckall);
	}
	
	public WebElement saveSkillButton() {

		return driver.findElement(saveSkillbtnId);
	}

	public WebElement cancelSkillButton() {
		return driver.findElement(cancelSkillbtnId);
	}
	
	public WebElement addSkillButton()

	{
		return driver.findElement(addSkillbtnId);
	}


	public WebElement selSkill()
	{
		return driver.findElement(skillId);
	}
	
	public WebElement selSkillYear()
	{
		return driver.findElement(skillYOE);
	 
	}
	
	public WebElement selSkillComments()
	{
		return driver.findElement(skillsComments);
	}
 
}
	
	
	
	
		