package com.live.hrms.utilities;

import com.live.hrms.logger.LoggerClass;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UiUtilities {
    org.apache.log4j.Logger log = LoggerClass.getThreadLogger(Thread.currentThread().getName().toString(), "Ws001");
    Scenario scenario;
    WebDriver driver;
     public UiUtilities(){

     }
     public UiUtilities(WebDriver driver, Scenario scenario) {
        this.scenario = scenario;
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

    public void verify(String expectedWelcomeText, String actualWelcomeText){
        if(expectedWelcomeText.equals(actualWelcomeText)){
            String results = "PASS::: Expected and Actual Values are matching for Welcome Text. Expected Text :'" + expectedWelcomeText + "' and Actual Text '" + expectedWelcomeText + "'" ;
            log.info(results);
            scenario.write(results);
        }else{
            String results = "FAIL::: Expected and Actual Values are not matching for Welcome Text. Expected Text :'" + expectedWelcomeText + "' and Actual Text '" + expectedWelcomeText + "'" ;
            log.info(results);
            scenario.write(results);
        }
        Assert.assertEquals(actualWelcomeText,expectedWelcomeText);
    }
}

