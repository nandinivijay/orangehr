package com.orangeHRM.qa.testcases;

import java.util.Iterator;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class suiteListener implements ISuiteListener {


    @Override
    public void onStart(ISuite suite) {

    }

     @Override
        public void onFinish(ISuite suite) {

              System.out.println("suite finished");
            final Map<java.lang.String,ISuiteResult>  res = suite.getResults();      
                    for (ISuiteResult r : res.values()) {
                             ITestContext context = r.getTestContext()  ;           
                    Iterator<ITestResult> failedTestCases =context.getFailedTests().getAllResults().iterator();
                    while (failedTestCases.hasNext()) {
                     System.out.println("failedTestCases...");
                     ITestResult failedTestCase = failedTestCases.next();
                     ITestNGMethod method = failedTestCase.getMethod();
                    java.lang.String testName =    failedTestCase.getName();

                       System.out.println("failed method.."+ method);   
                       System.out.println("failed testName.."+ testName);   
                    }
                    
                }
     }
}