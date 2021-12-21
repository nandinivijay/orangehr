package com.orangeHRM.qa.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.orangeHRM.qa.base.BaseClass;

public class ListenerClassForScreenShot extends BaseClass implements ITestListener {
	
	
	  
	  
	  @Override 
	  public void onTestFailure(ITestResult result) {
	  System.out.println("***** Error "+result.getName()+" test has failed *****");
	   try
	  { 
		  
		  TakeScreenshotUtil.captureScreenshot(result.getName());
		  System.out.println("Screenshot captured successfully"); 
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
}
	 
}
