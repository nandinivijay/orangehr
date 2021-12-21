package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserManagementPage extends AdminPage{

	WebDriver driver;

	public UserManagementPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By Users_ID = By.id("menu_admin_viewSystemUsers");
	
	
	public WebElement getUsers_id()
	{
		
		return driver.findElement(Users_ID);
		
	}
	
	public UsersPage navigatingToUsers()
	{
		getUsers_id().click();
		return new UsersPage(driver);
	}

		
}
