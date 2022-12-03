package com.live.hrms.pages;

import com.live.hrms.utilities.UiUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PhonePage extends Page {
    private WebDriver driver;
    private  UiUtilities utilities;
    public PhonePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        utilities =new UiUtilities(driver);
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
       utilities.waitForElement(htcTouch);
        utilities.clickElementWithJs(htcTouch);
    }
    public void clickIphone() {
        iphone.click();
    }
    public void clickPalmTreoPro() {
        palmTreo.click();
    }
    public void clickAddToCart(){
        utilities.clickElementWithJs(btnAddToCart);
    }
}