package com.EndToEndProject.Tests;

import com.EndToEndProject.PageBase.PageBase;
import com.EndToEndProject.PageObjects.HomePage;
import com.EndToEndProject.PageObjects.PracticeHomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends PageBase {

    @Test
    public void base() throws IOException {
        driver=initializeDriver();
        HomePage hpo=new HomePage(driver);
        hpo.goToPractice().click();

    }
    @Test(dataProvider = "sendCountry")
    public void practiceHomePage(String Country){
        PracticeHomePage php=new PracticeHomePage(driver);
        if(php.verifyTitlePresent().isDisplayed()){
            System.out.println("title is present");
        }
        php.countryTypeOne().sendKeys(Country);
        php.suggestionSelection().click();
        php.countryTypeTwo().sendKeys(Country);
       // php.suggestionSelectionTwo().click();
        php.openTabExample().click();



    }
    @DataProvider
    public Object[][] sendCountry(){
        Object[][] ob=new Object[1][1];
        ob[0][0]="usa";//1
       // ob[1][0]="india";//2
        return ob;
    }


}
