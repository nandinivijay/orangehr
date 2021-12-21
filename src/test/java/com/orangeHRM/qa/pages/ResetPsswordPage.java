package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

public class ResetPsswordPage {
WebDriver driver;

public ResetPsswordPage(WebDriver driver) {
	this.driver=driver;
}


//using FindBy to locate elements

//non-action  elements
//@FindBy(how=How.ID,using="divLogo")WebElement logo; //common element
@FindBy(how=How.XPATH,using="//div[@class='head']")WebElement headingForgotPassWord;
@FindBy(how=How.XPATH,using="//div[@class='inner']/div")WebElement description;
@FindBy(how=How.XPATH,using="//label[contains(text(),'OrangeHRM Username')]")WebElement labelUserName;

//actionelements
@FindBy(how=How.XPATH,using="//a[text()='Forgot your password?']")WebElement forgotPassword;
@FindBy(how=How.ID,using ="securityAuthentication_userName")WebElement userName;
@FindBy(how=How.ID,using ="btnSearchValues")WebElement reset;
@FindBy(how=How.ID,using ="btnCancel")WebElement cancle;

//dynamically displayed elements
@FindBy(how=How.XPATH,using="//div[@class='message warning fadable']") WebElement invalidUserName_ResetRequest_validUserName_Existing_ResetRequest;
@FindBy(how=How.XPATH,using="//div[@id='divContent']") WebElement validUserName_ResetRequest;




//This method is to check logo is present
//common method
/*
public boolean isLogoPresent() {
	return (logo.isDisplayed());
}*/


//This Methos is to check "Forgot Password?" Heading is present
public boolean isHeadingPresent() {
	return (headingForgotPassWord.isDisplayed());
}

//This method is to check "Please enter your username to identify your account to reset your password." is present
public boolean isDescriptionPresent() {
	return (description.isDisplayed());
}

//This method is check label-"OrangeHRM Username" is present
public boolean islabelUserName() {
	return (labelUserName.isDisplayed());
}


//This method is to click on ForgotPassword
public void clickOnForgotPasssword() {
	forgotPassword.click();
	
}
//This method to send value to username text field
public void setUserName(String name) {
	userName.clear();
	userName.sendKeys(name);
	
}

//This method to click on reset button
public void clickOnRest() {
	reset.click();
	
}

//This method to click on cancle button
public void clickOnCancle() {
	cancle.click();
	
}


//This method is to get text of the message given after clicking on reset button with invalid username ,or valid username having already reset request submittedd.
public Pair<String,Boolean> getMessageText_InvalidUserName() {
	//Pair<String,boolean>
	if(invalidUserName_ResetRequest_validUserName_Existing_ResetRequest.isDisplayed()) {
	return (new Pair<String, Boolean>(invalidUserName_ResetRequest_validUserName_Existing_ResetRequest.getText(),invalidUserName_ResetRequest_validUserName_Existing_ResetRequest.isDisplayed()));
	}
	else
		return(new Pair<String,Boolean>("No such element found",false));
}

//This method is to get Text of the message given after clicking on restbutton with valid username not having request sent before
public String getMessageText_ValidUserName() {
	return (validUserName_ResetRequest.getText());
}
public boolean MessageText_ValidUserNamePresent() {
	return (validUserName_ResetRequest.isDisplayed());
}

}
	





