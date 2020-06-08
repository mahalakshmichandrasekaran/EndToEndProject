package com.EndToEndProject.Tests;

import com.EndToEndProject.PageBase.PageBase;
import com.EndToEndProject.PageObjects.HomePage;
import com.EndToEndProject.PageObjects.PracticeHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlGroups;

import java.io.IOException;


public class HomePageTest extends PageBase {
    private WebDriver driver;
    private static Logger logger= LogManager.getLogger(HomePageTest.class.getName());

    @Test
    public void base() throws IOException {
        driver=initializeDriver();
        HomePage hpo=new HomePage(driver);
        hpo.goToPractice().click();
        logger.info("Click on Practice link");

    }
    @Test(dataProvider = "sendCountry",enabled = true,groups = {"Smoke"},timeOut = 40000)
    public void practiceHomePage(String Country) throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("practiceurl"));
        PracticeHomePage php=new PracticeHomePage(driver);
        TabPageTest tpt=new TabPageTest();
        Assert.assertTrue(php.verifyTitlePresent().isDisplayed(),"title is present");
        logger.info("verifying title is present");
        php.countryTypeOne().sendKeys(Country);
        logger.info("verifying the suggestion text box");
        php.suggestionSelection().click();
        logger.info("country is selected");
        //php.countryTypeTwo().sendKeys(Country);
       // php.suggestionSelectionTwo().click();
        php.openTabExample().click();
        logger.info("Click on Tab");




    }
    @DataProvider
    public Object[][] sendCountry(){
        Object[][] ob=new Object[1][1];
        ob[0][0]="usa";//1
       // ob[1][0]="india";//2
        return ob;
    }


}
