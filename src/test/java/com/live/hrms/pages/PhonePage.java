package com.live.hrms.pages;

import com.live.hrms.utilities.UiUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.Scenario;
public class PhonePage extends Page {
    private WebDriver driver;
    Scenario scenario;
    public PhonePage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH, using = ("(//a[text()='HTC Touch HD'])[1]"))
    WebElement htcTouch;
    @FindBy(how = How.XPATH, using = ("//a[text()='iPhone']"))
    WebElement iphone;
    @FindBy(how = How.XPATH, using = ("//a[text()='Palm Treo Pro']"))
    WebElement palmTreo;
    @FindBy(how = How.XPATH, using = ("//button[@id='button-cart']"))
    WebElement btnAddToCart;

    public void clickHTCTouchHD() {
       waitForElement(htcTouch);
        clickElementWithJs(htcTouch);
    }
    public void clickIphone() {
        iphone.click();
    }
    public void clickPalmTreoPro() {
        palmTreo.click();
    }
    public void clickAddToCart(){
        clickElementWithJs(btnAddToCart);
    }
}