package com.EndToEndProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;


    By practice=By.xpath("//a[contains(text(),'Practice')]");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement goToPractice(){
        return driver.findElement(practice);
    }



}
