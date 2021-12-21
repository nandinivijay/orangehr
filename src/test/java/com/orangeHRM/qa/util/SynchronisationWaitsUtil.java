package com.orangeHRM.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SynchronisationWaitsUtil {
	 
	public static void implicitwait(int time, TimeUnit s,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(time, s);
	}
	public static void scripttimeout(int time,TimeUnit s,WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(time, s);
	}
	public static void pageloadtimeout(int time, TimeUnit s,WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(time, s);
	}
	public static void threadsleep(long ms) throws Exception
	{
		Thread.sleep(ms);
	}
	public static void elementtobeclickable(By locator,int n,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,n);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	public static void elementtobeSelected(By locator,int n,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,n);
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	public static void alertispresent(int n,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,n);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void  invisiblityofElementLocated(By locator,int n,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,n);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public static void invisibilityOfElementWithText(By locator, String t,int n,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,n);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, t));
	}
	public static void texttobePresentinelementLocated(By locator, String t,int n,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,n);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, t));
	}
	public static void titleis(String t,int n,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,n);
		wait.until(ExpectedConditions.titleIs(t));
	}
	
	/*
	 * public static void main(String[] args) throws Exception {
	 * //SynchronisationWaitsUtil.implicitwait(30, s);
	 * //SynchronisationWaitsUtil.alertispresent();
	 * 
	 * System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
	 * WebDriver driver = new ChromeDriver();
	 * driver.get("https://opensource-demo.orangehrmlive.com/");
	 * SynchronisationWaitsUtil.threadsleep(3000);
	 * //SynchronisationWaitsUtil.implicitwait(30,TimeUnit.SECONDS );
	 * driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 * System.out.println("Done"); SynchronisationWaitsUtil.elementtobeSelected(5,
	 * driver, By.id("txtUsername"));; }
	 */
	 
	
	
	public static void fwpresenceofelementlocated(int n,int p,TimeUnit t,By locator ,WebDriver driver)
	{
				
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(n, t)
				.pollingEvery(p, t)
				.ignoring(WebDriverException.class);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
	public static void fwalertIsPresent(int n,int p, TimeUnit t,WebDriver driver)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(n, t)
				.pollingEvery(p, t)
				.ignoring(WebDriverException.class);
				wait.until(ExpectedConditions.alertIsPresent());
	}
public static void fwelementselectionstatetobe(By locator,boolean b,int n,int p,TimeUnit t,WebDriver driver)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(n, t)
			.pollingEvery(p, t)
			.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.elementSelectionStateToBe(locator, b));
}
public static void fwelementtobeclickable(int n,int p,TimeUnit t,By locator,WebDriver driver)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(n, t)
			.pollingEvery(p, t)
			.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
}
public static void fwelementtobeselected(int n, int p ,TimeUnit t, By locator,WebDriver driver)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(n, t)
			.pollingEvery(p, t)
			.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
}
public static void fwpresenceofallelementslocatedby(int n, int p ,TimeUnit t, By locator,WebDriver driver)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(n, t)
			.pollingEvery(p, t)
			.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
}
public static void fwpresenceofelementlocated1(int n, int p ,TimeUnit t, By locator,WebDriver driver)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(n, t)
			.pollingEvery(p, t)
			.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

}
public static void fwtexttobepresentinelementlocated(int n, int p ,TimeUnit t, By locator,String s1,WebDriver driver)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(n, t)
			.pollingEvery(p, t)
			.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, s1)) ;

}
public static void fwtexttobepresentinelementvalue(int n,int p , TimeUnit t, By locator,String s1,WebDriver driver)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(n, t)
			.pollingEvery(p, t)
			.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.textToBePresentInElementValue(locator, s1)) ;
}
public static void fwtileis(int n,int p , TimeUnit t, String s1,WebDriver driver)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(n, t)
			.pollingEvery(p, t)
			.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.titleIs(s1));
}
public static void fwtitlecontains(int n, int p,TimeUnit t,String s1,WebDriver driver)
{
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(n, t)
			.pollingEvery(p, t)
			.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.titleContains(s1));

	
}
public static void fwvisiblityofallelementslocatedby(int n,int p,By locator,TimeUnit t,WebDriver driver)
{
	FluentWait<WebDriver>wait=new FluentWait<WebDriver>(driver)
			.withTimeout(n,t)
			.pollingEvery(p,t)
			.ignoring(WebDriverException.class);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}




}	

	
