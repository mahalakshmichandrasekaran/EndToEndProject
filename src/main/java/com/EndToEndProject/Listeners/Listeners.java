package com.EndToEndProject.Listeners;

import com.EndToEndProject.PageBase.PageBase;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends PageBase implements ITestListener {
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
            getScreenShot(testMethodName,driver);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
