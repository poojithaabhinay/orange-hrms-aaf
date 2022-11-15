package com.live.hrms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PhonePage extends Page {


    private WebDriver driver;

    PhonePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(how = How.XPATH, using = ("(//a[text()='HTC Touch HD'])[1]"))
    WebElement htcTouch;
    @FindBy(how = How.XPATH, using = ("//a[text()='iPhone']"))
    WebElement iphone;
    @FindBy(how = How.XPATH, using = ("//a[text()='Palm Treo Pro']"))
    WebElement palmTreo;

    public void clickHTCTouchHD() {
        htcTouch.click();
    }

    public void clickIphone() {
        iphone.click();
    }

    public void clickPalmTreoPro() {
        palmTreo.click();
    }
}