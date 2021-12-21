package com.orangeHRM.qa.util;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listener_ItestContext_Screenshot implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        WebDriver  driver1 = (WebDriver)context.getAttribute("driver1");
        TakeScreenshotdriverUtil.takescreenshot(methodName, driver1);
		
	}
}
