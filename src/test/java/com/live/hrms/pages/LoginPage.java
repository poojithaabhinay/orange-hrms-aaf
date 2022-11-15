package com.live.hrms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
    private WebDriver driver;

    LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how= How.XPATH,using =("//input[@name='email']"))
    WebElement email;

    @FindBy(how=How.XPATH,using =("//input[@name='password']"))
    WebElement password;

    @FindBy(how=How.XPATH,using =("//button[@type='submit']"))
            WebElement  button;


    public void setEmail(String userEmail)
    {
        email.sendKeys(userEmail);
    }
    public void setPassword(String password1)
    {
       password.sendKeys(password1);
    }
    public void clickLoginButton() {
        button.click();
    }
}