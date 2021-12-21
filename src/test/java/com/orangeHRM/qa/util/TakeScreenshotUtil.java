package com.orangeHRM.qa.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.orangeHRM.qa.base.BaseClass;

public class TakeScreenshotUtil extends BaseClass{
	
	public static void captureScreenshot(String filename) throws IOException
	{
		
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		LocalDateTime now = LocalDateTime.now();
		String filenameDate = now.toString().replace(":","_").replace("T","_"); 
		try
		{
			FileHandler.copy(file,new File("./Screenshot/"+filename+"_"+filenameDate+".jpg"));
			System.out.println("Successfully captured a screenshot"); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	 
}
