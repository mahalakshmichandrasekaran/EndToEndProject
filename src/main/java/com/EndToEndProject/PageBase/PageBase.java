package com.EndToEndProject.PageBase;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PageBase {
    public WebDriver driver;
    public  Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop=new Properties();
        FileInputStream fileInputStream=new FileInputStream("src/main/java/com/EndToEndProject/PageBase/Data.properties");
        prop.load(fileInputStream);
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
            driver=new ChromeDriver();

        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public String getScreenShot(String testMethodName,WebDriver driver) throws IOException {
      TakesScreenshot ts=(TakesScreenshot)driver;
      File sourceForScreenshot=ts.getScreenshotAs(OutputType.FILE);
      String destinationScreenshot=System.getProperty("user.dir")+"//reports//"+testMethodName+".png";
      FileUtils.copyFile(sourceForScreenshot,new File(destinationScreenshot));
      return destinationScreenshot;
  }
    @AfterTest
    public void afterTests(){
        driver.quit();
    }
}
