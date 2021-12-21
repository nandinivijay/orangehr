package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Memberships_MyInfoPage extends MyInfoPage{
	WebDriver driver;

	public Memberships_MyInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("viewMemberships");
	}
	
	By addMembershipbtnId = By.id("btnAddMembershipDetail");
	By delMembershipbtnId = By.id("delMemsBtn");
	By membership = By.id("membership_membership");
	By subscriptionPaidBy = By.id("membership_subscriptionPaidBy");
	By subscriptionAmt = By.id("membership_subscriptionAmount");
	By currency = By.id("membership_currency");
	By commenceDateId = By.id("membership_subscriptionCommenceDate");
	By ddXpath = By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[1]/a");
	By monXpath = By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]");
	By yearXpath = By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]");
	By renewalDateId = By.id("membership_subscriptionRenewalDate");
	By saveMembershipbtnId = By.id("btnSaveMembership");
	By cancelMembershipbtnId = By.id("btnCancel");
	By editMembershipLink = By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr/td[2]/a");
	By membershipfilecheckbox = By.xpath("//*[@id='frmEmpDelMemberships']/table/tbody/tr/td[1]/input");
	By membershipCheckall = By.id("checkAllMem");
	
	public WebElement editMembershipLinkClick() {

		return driver.findElement(editMembershipLink);
	}

	public WebElement delMembershipButton() {

		return driver.findElement(delMembershipbtnId);
	}

	public WebElement membershipfileCheckbox() {
		return driver.findElement(membershipfilecheckbox);
	}
	
	public WebElement membershipCheckallboxes() {
		return driver.findElement(membershipCheckall);
	}
	
	public WebElement saveMembershipButton() {

		return driver.findElement(saveMembershipbtnId);
	}

	public WebElement cancelMembershipButton() {
		return driver.findElement(cancelMembershipbtnId);
	}
	
	public WebElement addMembershipButton()

	{
		return driver.findElement(addMembershipbtnId);
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
	
	public WebElement commenceDate()
	{
	 return driver.findElement(commenceDateId);
	}
	public WebElement renewalDate()
	{
		return driver.findElement(renewalDateId);
	 
	}
	
	public WebElement selMembership()
	{
		return driver.findElement(membership);
	}
	public WebElement selSubscriptionPaidBy()
	{
		return driver.findElement(subscriptionPaidBy);
	}
	public WebElement selSubscriptionAmt()
	{
		return driver.findElement(subscriptionAmt);
	}
	
	public WebElement selCurrency()
	{
	 return driver.findElement(currency);
	}

	
}
