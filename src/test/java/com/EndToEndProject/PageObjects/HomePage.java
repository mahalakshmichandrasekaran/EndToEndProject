package com.EndToEndProject.PageObjects;

import com.EndToEndProject.Utilities.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.Utilities;

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
