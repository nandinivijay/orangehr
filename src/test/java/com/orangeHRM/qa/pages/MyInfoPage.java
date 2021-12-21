package com.orangeHRM.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.internal.collections.Pair;

import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class MyInfoPage {

	WebDriver driver;
	public MyInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("pim");
		
	}
	
	//sidebar
	private By PROFILEPIC=By.id("profile-pic");
	private By SIDENAV=By.id("sidenav");
	private By SIDENAVTITLES=By.xpath("//ul[@id='sidenav']/li/a");
	private By personalDetails_XPath =By.xpath("//*[@id=\"sidenav\"]/li[1]/a");
	private By contactDetails_XPath=By.xpath("//*[@id=\"sidenav\"]/li[2]/a");
	private By emergencyContacts_XPath =By.xpath("//*[@id=\"sidenav\"]/li[3]/a");
	private By dependents_XPath=By.xpath("//*[@id=\"sidenav\"]/li[4]/a");
	private By immigration_XPath=By.xpath("//*[@id=\"sidenav\"]/li[5]/a");
	private By job_XPath=By.xpath("//*[@id=\"sidenav\"]/li[6]/a");
	private By salary_XPath=By.xpath("//*[@id=\"sidenav\"]/li[7]/a");
	private By taxexemption_XPath=By.xpath("//*[@id=\"sidenav\"]/li[8]/a");
	private By reportTo_XPath=By.xpath("//*[@id=\"sidenav\"]/li[9]/a");
	private By qualification_MyInfo_XPath=By.xpath("//*[@id=\"sidenav\"]/li[10]/a");
	private By memberships_MyInfo_XPath=By.xpath("//*[@id=\"sidenav\"]/li[11]/a");
	public final String SIDENAV_CLICKEDCOLOR="#555657"; // dark grey
	public final String SIDENAV_HOVERCOLOR="#ce6d1d";
	
	//to get the webelement of all the sidenav options
	public WebElement getPersonalDetails_XPath() {
		return driver.findElement(personalDetails_XPath);
	}
	
	public WebElement getContactDetails_XPath() {
		return driver.findElement(contactDetails_XPath);
	}
	public WebElement getEmergencyContacts_XPath() {
		return driver.findElement(emergencyContacts_XPath);
	}
	public WebElement getDependents_XPath() {
		return driver.findElement(dependents_XPath);
	}
	public WebElement getImmigration_XPath() {
		return driver.findElement(immigration_XPath);
	}
	public WebElement getJob_XPath() {
		return driver.findElement(job_XPath);
	}
	public WebElement getSalary_XPath() {
		return driver.findElement(salary_XPath);
	}
	public WebElement getTaxexemption_XPath() {
		return driver.findElement(taxexemption_XPath);
	}
	public WebElement getReportTo_XPath() {
		return driver.findElement(reportTo_XPath);
	}
	public WebElement getQualification_MyInfo_XPath() {
		return driver.findElement(qualification_MyInfo_XPath);
	}
	public WebElement getMemberships_MyInfo_XPath() {
		return driver.findElement(memberships_MyInfo_XPath);
	}
	
	//methods t0 navigate to options on sidenav
	public PersonalDetailsPage navigatingToPersonalDetails()
	{
		ActionsUtil.MouseHoover(getPersonalDetails_XPath(), driver);
		getPersonalDetails_XPath().click();
		return new PersonalDetailsPage(driver);
	}
	
	public ContactDetailsPage navigatingToContactDetails()
	{
		ActionsUtil.MouseHoover(getContactDetails_XPath(), driver);
		getContactDetails_XPath().click();
		return new ContactDetailsPage(driver);
	}
	
	public EmergencyContactsPage navigatingToEmergencyContacts()
	{
		ActionsUtil.MouseHoover(getEmergencyContacts_XPath(), driver);
		getEmergencyContacts_XPath().click();
		return new EmergencyContactsPage(driver);
	}
	
	public DependentsPage navigatingToDependents()
	{
		ActionsUtil.MouseHoover(getDependents_XPath(), driver);
		getDependents_XPath().click();
		return new DependentsPage(driver);
	}
	
	public ImmigrationPage navigatingToImmigration()
	{
		ActionsUtil.MouseHoover(getImmigration_XPath(), driver);
		getImmigration_XPath().click();
		return new ImmigrationPage(driver);
	}
	
	public JobMyInfoPage navigatingToJobMyInfoPage()
	{
		ActionsUtil.MouseHoover(getJob_XPath(), driver);
		getJob_XPath().click();
		return new JobMyInfoPage(driver);
	}
	
	public SalaryPage navigatingToSalary()
	{
		ActionsUtil.MouseHoover(getSalary_XPath(), driver);
		getSalary_XPath().click();
		return new SalaryPage(driver);
	}
	
	public TaxExemptionPage navigatingToTaxExemption()
	{
		ActionsUtil.MouseHoover(getTaxexemption_XPath(), driver);
		getTaxexemption_XPath().click();
		return new TaxExemptionPage(driver);
	}
	
	public ReportToMyInfoPage navigatingToReportToMyInfo()
	{
		ActionsUtil.MouseHoover(getReportTo_XPath(), driver);
		getReportTo_XPath().click();
		return new ReportToMyInfoPage(driver);
	}
	
	public Qualification_MyInfoPage navigatingToQualification_MyInfo()
	{
		ActionsUtil.MouseHoover(getQualification_MyInfo_XPath(), driver);
		getQualification_MyInfo_XPath().click();
		return new Qualification_MyInfoPage(driver);
	}
	
	public Memberships_MyInfoPage navigatingToMemberships_MyInfo()
	{
		ActionsUtil.MouseHoover(getMemberships_MyInfo_XPath(), driver);
		getMemberships_MyInfo_XPath().click();
		return new Memberships_MyInfoPage(driver);
	}
	
	
	
	
	
	
	//to check profile pic section is present
	public boolean checkProfilePicPresence() {
		boolean flag=driver.findElement(PROFILEPIC).isDisplayed();
		return flag;
	}
	
	//to check profile pic section is present
	public boolean checkSideNavPresence() {
		return (driver.findElement(SIDENAV).isDisplayed());
	}
	
	//to get the Text of profilepic
	public String gettext_profilepic() {
		return driver.findElement(PROFILEPIC).getText();
	}

	//to get the list of webelements in the sidenav
	public List<WebElement> optionsAtSideNav(){
		return (driver.findElements(SIDENAVTITLES));
	}
	
	//toget SIDENAV Webelement
	public WebElement getsidenav() {
		return driver.findElement(SIDENAV);
	}
	//to get the bckground color of sidenav
	public String getColor_Sidenav(WebElement element) {
		String color=element.getCssValue("background-color");
	//	String color=driver.findElement(SIDENAV).getCssValue("background-color");
		String hexcolor = Color.fromString(color).asHex();
	//	System.out.println(hexcolor);
		return hexcolor;
		
	}
	
	
	//to get the background color of sidenav options without mousehover
	public Set<String> getColor_SideNav(int index,List<WebElement> options ){
		System.out.println("**************************");
		Set<String> hcolor=new HashSet<String>();
		
		for( int i=1;i<options.size() ;i++) {
		if(i==index) {
	
		}
			String  color=options.get(i).getCssValue("border-bottom-color");
			String hexcolor = Color.fromString(color).asHex();
		
			hcolor.add(hexcolor);
		}
		System.out.println("***************************");
		return hcolor;
		}
	
	
	
	
	
}
