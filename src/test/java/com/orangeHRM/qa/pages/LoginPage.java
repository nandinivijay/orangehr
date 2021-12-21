package com.orangeHRM.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	//repeated in Resetpassword page too
	@FindBy(how=How.ID,using="divLogo")WebElement logo;//common
	
	@FindBy(how=How.ID,using="logInPanelHeading") WebElement loginpanel;//might be common in Home page
	@FindBy(how=How.XPATH,using="//span[normalize-space()='( Username : Admin | Password : admin123 )']")WebElement UserName_Password;//might be common in Home page
	
	
	@FindBy(how=How.ID,using="footer")WebElement footer;
	@FindBy(how=How.XPATH,using="//div[@id='footer']/div/a")WebElement footerLink;
	@FindBy(how=How.ID,using="social-icons")WebElement footerSocial;
	@FindBy(how=How.XPATH,using="//div[@id='social-icons']//a")List<WebElement> footerSocialLinks;
	
	@FindBy(how=How.ID,using="txtUsername") WebElement userName;
	@FindBy(how=How.ID,using="txtPassword") WebElement password;
	@FindBy(how=How.ID,using="btnLogin") WebElement login;
	@FindBy(how=How.ID,using="spanMessage") WebElement invalidMessage;
	
	
	
	//This method is to check logo is present
	public boolean isLogoPresent() {
		return (logo.isDisplayed());
	}
	
	
	//This method is to check login panel text is present
	public boolean isloginpanelPresent() {
		return (loginpanel.isDisplayed());
	}
	
	//This method is to check username and password is displayed
	public boolean isUserName_PasswordPresent() {
		return (UserName_Password.isDisplayed());
	}
	
	//This method is to check footer presence
	public boolean isFooterPresent() {
		return(footer.isDisplayed());
	}
	
	
	//this method is to get Text of footer
	public String getFooterText() {
		return(footer.getAttribute("innerText"));
			}
	
	//this method is to get Link of footer
		public String getFooterLink() {
			return(footerLink.getAttribute("href"));
				}
		
		//this method is to check footer social links are present
		public boolean isFooterSocialPresent() {
		return(footerSocial.isDisplayed());
		}
		
		//this method is to get number of links and what links are present
		public List<String> footerSocial_links(){
			List<String> socialLinkText=new ArrayList<String>();
			for(int i=0;i<footerSocialLinks.size();i++) {
				socialLinkText.add(footerSocialLinks.get(i).getAttribute("href"));
			}
		return(socialLinkText);
		}
		
		
		
	//This method is to sned username a value
	public void setuserName(String name) {
		userName.sendKeys(name);
	}
	
	//This method is to sned password a value
	public void setPassword(String pass) {
		password.sendKeys(pass);
		
	}
	
	//This method is to click on login
	public void clickOnLogin() {
		login.click();
	}
	
	
	//This method is to check invalid username or password message is displayed
	public String getInvalidMessageText() {
		return(invalidMessage.getText());
	}


	public WebElement getInvalidMessage() {
		return invalidMessage;
	}

	

	public void setInvalidMessage(WebElement invalidMessage) {
		this.invalidMessage = invalidMessage;
	}


	public WebElement getUserName() {
		
		return userName;
	}


	public WebElement getPassword() {
		
		return password;
	}
}
