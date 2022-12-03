package com.live.hrms.pages;

import com.live.hrms.utilities.UiUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
    private WebDriver driver;
    private UiUtilities utilities;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        utilities = new UiUtilities(driver);
    }
    @FindBy(how = How.XPATH, using = ("//input[@name='email']"))
    WebElement email;

    @FindBy(how = How.XPATH, using = ("//input[@name='password']"))
    WebElement password;

    @FindBy(how = How.XPATH, using = ("//button[@type='submit']"))
    WebElement button;
    public void Login(String userEmail, String userPassword) {
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        button.click();
    }
}