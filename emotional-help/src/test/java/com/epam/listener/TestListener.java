package com.epam.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestSuccess(ITestResult result){
        LOGGER.info(result.getName() +" From "+ result.getTestClass().getName() +"is Run Successfully");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        LOGGER.info(result.getName() + " From "+result.getTestClass().getName()+"is Skipped");
    }

    @Override
    public void onTestFailure(ITestResult result){
       LOGGER.info(result.getName() + "Test Case is Failed");
    }

}
