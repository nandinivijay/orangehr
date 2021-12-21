package com.orangeHRM.qa.util;

import org.openqa.selenium.WebDriver;
public class AlertsUtil {
		
	public static void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public static void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static void gettextAlert(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	public static void sendkeysAlert(String str,WebDriver driver)
	{
		driver.switchTo().alert().sendKeys(str);
	}


}
