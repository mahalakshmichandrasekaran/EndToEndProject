package com.EndToEndProject.PageBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PageBase {
    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        Properties prop=new Properties();
        FileInputStream fileInputStream=new FileInputStream("src/main/java/com/EndToEndProject/PageBase/Data.properties");
        prop.load(fileInputStream);
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
            driver=new ChromeDriver();

        }
        driver.get("http://www.qaclickacademy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

//    @AfterTest
//    public void afterTests(){
//        driver.quit();
//    }
}
