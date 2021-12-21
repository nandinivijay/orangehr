package com.orangeHRM.qa.testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 
public class RetryFailedTestCases implements IRetryAnalyzer {
    int retryCnt = 0;
    int retryMaxLimit = 2;
    
    public boolean retry(ITestResult result) {
        if (retryCnt < retryMaxLimit) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
            retryCnt++;
            return true;
        }
        return false;
    }
   
}