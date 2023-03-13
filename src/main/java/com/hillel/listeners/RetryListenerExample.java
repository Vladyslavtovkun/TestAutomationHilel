package com.hillel.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerExample implements IRetryAnalyzer {

    private int retryCount = 1;
    private int maxCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
