package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ProjectsPage extends ProjectInfoPage{

	WebDriver driver;

	public ProjectsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("Projects");
	}

}
