package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ReportsPIMPage extends PIMPage{
	
WebDriver driver;
	
	public  ReportsPIMPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public boolean getcurrentUrl() {
		
		return driver.getCurrentUrl().contains("reportType");
		
	}

}
