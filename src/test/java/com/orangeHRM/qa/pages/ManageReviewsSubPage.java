package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ManageReviewsSubPage extends ManageReviewsPage{

	WebDriver driver;

	public ManageReviewsSubPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("searchPerformancReview");
		
	}
}
