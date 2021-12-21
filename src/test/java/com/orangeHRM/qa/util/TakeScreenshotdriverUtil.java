package com.orangeHRM.qa.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotdriverUtil {
	public static void takescreenshot(String filename,WebDriver driver)  {
		System.out.println("*********In takesscreenshot method************");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Local date and time" + LocalDateTime.now());
		String filenameDate = now.toString().replace(":","_").replace("T","_"); 
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		try {
			System.out.println("In try block");
	File file=	takescreenshot.getScreenshotAs(OutputType.FILE);
	System.out.println("Succesfully captured an image" + filename);
	FileHandler.copy(file,new File(".\\Test_Screenshots/"+filename+"_"+filenameDate+".jpg"));
	}catch(IOException e) {
		
		e.printStackTrace();
	}
	}

}
