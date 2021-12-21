package com.orangeHRM.qa.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil {
	
	public static void selectbytext(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public static void selectbyvalue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public static void selectbyindex(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public static void deselectall(WebElement element)
	{
		Select sel=new Select(element);
		sel.deselectAll();
	}
	public static void deselectbyvalue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.deselectByValue(value);
	}
	public static void deselectbyindex(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	public static void deselectbytext(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.deselectByVisibleText(text);
	}
	public static void ismultiple(WebElement element )
	{
		Select sel=new Select(element);
		sel.isMultiple();
	}
}
