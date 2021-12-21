package com.orangeHRM.qa.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DeleteUtil {
	
	public static void singleRowDelete(WebDriver driver, WebElement element)
	{
		//WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='delContactsBtn']"));
		if(element.isDisplayed())
		{
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='emgcontact_list']/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : "+numRows);
			driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr/td[1]/input")).click();
		    element.click();
		    List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id='emgcontact_list']/tbody/tr"));
		    int finalnumRows = finalRows.size();
		   	System.out.println("No. of Rows After Deleting : "+finalnumRows);
			Assert.assertEquals(finalnumRows, numRows-1); 
			 
		}
		System.out.println("No rows are displayed");
	}
	
	public static void allRowDelete(WebDriver driver, WebElement element)
	{
		//WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='delContactsBtn']"));
		if(element.isDisplayed());
		{
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='emgcontact_list']/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : "+numRows);
			driver.findElement(By.xpath("//*[@id='checkAll']")).click();
			element.click();
			
		}
		 System.out.println("No Rows Displayed");
	}
	
	public static void  singleAttDelete(WebDriver driver, WebElement element)
	{
		//WebElement deleteBtn= driver.findElement(By.xpath("//*[@id=\"btnDeleteAttachment\"]"));
		if(element.isDisplayed());
		{
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : "+numRows);
			driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[1]/input")).click();
		    element.click();
		    List<WebElement> finalRows = driver.findElements(By.xpath("//*[@id=\"tblAttachments\"]/tbody/tr"));
			int finalnumRows = finalRows.size();
			System.out.println("No. of Rows After Deleting : "+finalnumRows);
			Assert.assertEquals(finalnumRows, numRows-1);	
		}
		System.out.println("No rows are displayed");

	}
	
	public static void allAttDelete(WebDriver driver, WebElement element)
	{
		//WebElement deleteBtn= driver.findElement(By.xpath("//*[@id=\"btnDeleteAttachment\"]"));
		if(element.isDisplayed());
		{
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tblAttachments']/tbody/tr"));
			int numRows = rows.size();
			System.out.println("No. of Rows Before Deleting : "+numRows);
		    driver.findElement(By.xpath("//*[@id='attachmentsCheckAll']")).click();
		   element.click();
		}
		    System.out.println("No Rows Displayed");
	}

}
