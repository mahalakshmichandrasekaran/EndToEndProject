package com.EndToEndProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TabPage {

    public WebDriver driver;

    public TabPage(WebDriver driver){
        this.driver=driver;
    }

    By course=By.xpath("//div[@class='nav-outer clearfix']//a[contains(text(),'Courses')]");
    public WebElement coursePage(){
        return driver.findElement(course);
    }
}
