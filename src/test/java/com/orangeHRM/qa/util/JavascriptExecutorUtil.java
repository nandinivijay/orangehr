package com.orangeHRM.qa.util;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JavascriptExecutorUtil {
		
	//This method is to refresh page
	public static void refresh(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("history.go(0);");
		
	}
	
	public static void clickingOnElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	//This method is to scroll to an element in the page.
	public static void scrollToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	
	//This method is to scroll to the down of a page
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,(document.body.scrollHeight));");
		
	}
	
	//This method is to scroll to the up of a page
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-(document.body.scrollHeight));");
		
	}

	//This method is to get title page
	public static String getPageTitle(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		return ( js.executeScript("return document.title;").toString());
		
	}
	
	//This method is to get Url of a page
	public static String getURL(WebDriver driver){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        return( (String) js.executeScript("return document.URL;"));
      
    }
	
	//This method is to create an alert
	public static void alertMessage(WebDriver driver,String message) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("alert(arguments[0]);",message);
		 driver.switchTo().alert().accept();
		
	}
	
	//This method is to send keysto an element
	public static void sendKeysElement( WebDriver driver,WebElement element,String sendvalue) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];",element, sendvalue);
		
	}
	
	//This method is to create a box around an element
	public static void highLightAnElement(WebDriver driver,WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px dotted blue'", element);
       
    }

	//This method is to blink an element
	public static void hideAndShowElement(WebDriver driver,WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Hide an element
        js.executeScript("arguments[0].style.display='none'",element);
        Thread.sleep(5000);
        //Show an element
        js.executeScript("arguments[0].style.display='block'",element);
        Thread.sleep(5000);
    }
 

	
}

