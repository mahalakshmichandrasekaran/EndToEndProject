package com.EndToEndProject.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsUtil {
    static ExtentReports extentReports;
    public static ExtentReports getExtentReports(){
        String file=System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
        sparkReporter.config().setReportName("Web App Automation Results");
        sparkReporter.config().setDocumentTitle("Test Results");
        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Testser","abc");
        return extentReports;


    }
}
