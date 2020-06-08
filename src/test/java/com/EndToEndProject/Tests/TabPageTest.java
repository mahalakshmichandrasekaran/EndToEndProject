package com.EndToEndProject.Tests;

import com.EndToEndProject.PageBase.PageBase;
import com.EndToEndProject.PageObjects.TabPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class TabPageTest extends PageBase {
    private static Logger logger= LogManager.getLogger(TabPageTest.class.getName());
    @Test
    public void tabHome() throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("taburl"));
        logger.info("A seperate tab is displayed");
        TabPage tp=new TabPage(driver);
        tp.coursePage().click();
        logger.info("click on courses tab");
    }

}
