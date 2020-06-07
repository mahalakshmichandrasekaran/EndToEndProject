package com.EndToEndProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeHomePage {
    public WebDriver driver;
    public PracticeHomePage(WebDriver driver){
        this.driver=driver;
    }
    By practiceHomePageText=By.xpath("//h1[contains(text(),'Practice Page')]");
    By suggestion=By.cssSelector("input#autocomplete.inputs.ui-autocomplete-input");
    By suggestionWrapOver=By.cssSelector(".ui-menu-item-wrapper");
    By suggestionWrapOverTwo=By.xpath("(//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front'])[1]");
    By openTab=By.cssSelector("a#opentab.btn-style.class1.class2");
    public WebElement verifyTitlePresent(){
        return driver.findElement(practiceHomePageText);
    }
    public WebElement openTabExample(){
        return driver.findElement(openTab);
    }
    public WebElement countryTypeOne(){
        return driver.findElement(suggestion);
    }
    public WebElement suggestionSelection(){
        return driver.findElement(suggestionWrapOver);
    }
    public WebElement countryTypeTwo(){
        return driver.findElement(suggestion);
    }
    public WebElement suggestionSelectionTwo(){
        return driver.findElement(suggestionWrapOverTwo);
    }

}
