package com.orangeHRM.qa.util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {

	public static void MouseHoover(WebElement element,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public static void moveToElement(WebElement element,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	public static void ContextClick(WebElement element,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).build().perform();
		
	}
	public static void DoubleClick(WebElement element,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	public static void dragAndDROP(WebElement sourceelemnt,WebElement targetelement,WebDriver driver )
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(sourceelemnt, targetelement).build().perform();
		//or  act.clickAndHold(sourceelemnt).moveToElement(targetelement).release().build().perform();
	}
	public static void sendkeys(WebElement element,CharSequence[] c,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).sendKeys(c).build().perform();
	}
	public static void keydown(WebElement element,  Keys k,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).keyDown(k).build().perform();
	}
	public static void keyup(WebElement element,Keys k,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).keyUp(k).build().perform();
	}
	
	public static void moveoffset(int xOffset,int yOffset,WebDriver driver ) {
		Actions act=new Actions(driver);
		act.moveByOffset(xOffset, yOffset).build().perform();
	}
	
	public static void movetoelementoffset(WebElement element,int xOffset,int yOffset,WebDriver driver ) {
		Actions act=new Actions(driver);
		act.moveToElement(element,xOffset, yOffset).build().perform();
	}
	

}


