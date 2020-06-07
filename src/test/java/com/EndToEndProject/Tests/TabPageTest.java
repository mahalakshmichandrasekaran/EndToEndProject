package com.EndToEndProject.Tests;

import com.EndToEndProject.PageBase.PageBase;
import com.EndToEndProject.PageObjects.TabPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class TabPageTest extends PageBase {
    @Test
    public void tabHome() throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("taburl"));
        TabPage tp=new TabPage(driver);
        tp.coursePage().click();
    }

}
