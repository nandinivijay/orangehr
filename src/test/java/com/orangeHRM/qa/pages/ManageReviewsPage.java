package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageReviewsPage extends PerformancePage{

	WebDriver driver;

	public ManageReviewsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By ManageReviewsSub_ID = By.id("menu_performance_searchPerformancReview");
	By MyReviews_ID = By.id("menu_performance_myPerformanceReview");
	By ReviewList_ID = By.id("menu_performance_searchEvaluatePerformancReview");
	
	
	public WebElement getManageReviewsSub_id()
	{
		
		return driver.findElement(ManageReviewsSub_ID);
		
	}
	
	public ManageReviewsSubPage navigatingToManageReviewsSubModule()
	{
		getManageReviewsSub_id().click();
		return new ManageReviewsSubPage(driver);
	}
	
	public WebElement getMyReviews_id()
	{
		
		return driver.findElement(MyReviews_ID);
		
	}
	
	public MyReviewsPage navigatingToMyReviews()
	{
		getMyReviews_id().click();
		return new MyReviewsPage(driver);
	}
	
	public WebElement getReviewList_id()
	{
		
		return driver.findElement(ReviewList_ID);
		
	}
	
	public ReviewListPage navigatingToReviewList()
	{
		getReviewList_id().click();
		return new ReviewListPage(driver);
	}
	

}
