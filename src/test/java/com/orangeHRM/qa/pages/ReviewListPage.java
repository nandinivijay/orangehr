package com.orangeHRM.qa.pages;

import org.openqa.selenium.WebDriver;

public class ReviewListPage extends ManageReviewsPage{

	WebDriver driver;

	public ReviewListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getcurrentUrl()
	{
		return driver.getCurrentUrl().contains("EvaluatePerformancReview");
		
	}
}
