package com.EndToEndProject.Tests;

import com.EndToEndProject.PageBase.PageBase;
import com.EndToEndProject.PageObjects.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends PageBase {

    @Test
    public void base() throws IOException {
        driver=initializeDriver();
        HomePage hpo=new HomePage(driver);
        hpo.goToPractice().click();
    }

}
