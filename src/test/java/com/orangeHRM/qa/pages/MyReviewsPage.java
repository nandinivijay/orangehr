package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class MyReviewsPage extends ManageReviewsPage{

	WebDriver driver;

	public MyReviewsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("myPerformanceReview");
		
	}
}
