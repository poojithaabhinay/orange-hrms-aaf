package com.live.hrms.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UiUtilities {
    WebDriver driver;
     public UiUtilities(){

     }



    public UiUtilities(WebDriver driver) {

        this.driver = driver;
    }

    public void waitForElement( WebElement element) {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickElementWithJs(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)this. driver;
        js.executeScript("arguments[0].click();",element);
    }
    public String getElementText(WebElement element){
         return element.getText();

    }

    }

