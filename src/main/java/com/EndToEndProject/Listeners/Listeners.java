package com.EndToEndProject.Listeners;

import com.EndToEndProject.ExtentReports.ReportsUtil;
import com.EndToEndProject.PageBase.PageBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends PageBase implements ITestListener {
    ExtentTest test;
    ExtentReports extentReports=ReportsUtil.getExtentReports();
    ThreadLocal<ExtentTest> threadLocal=new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {
        test=extentReports.createTest(result.getMethod().getMethodName());
        threadLocal.set(test);
    }
    public void onTestSuccess(ITestResult result) {
        threadLocal.get().log(Status.PASS,"Test Passed");
    }
    public void onTestFailure(ITestResult result) {
        WebDriver driver=null;
        try {
            driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String testMethodName=result.getMethod().getMethodName();
        try {
            threadLocal.get().addScreenCaptureFromPath(getScreenShot(testMethodName,driver),result.getMethod().getMethodName());

        } catch (IOException e) {
            e.printStackTrace();
        }
        threadLocal.get().fail(result.getThrowable());

    }
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

}
