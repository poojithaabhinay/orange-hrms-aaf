package com.live.hrms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
    private WebDriver driver;

   public LoginPage (WebDriver driver) {
       super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how= How.XPATH,using =("//input[@name='email']"))
    WebElement email;

    @FindBy(how=How.XPATH,using =("//input[@name='password']"))
    WebElement password;

    @FindBy(how=How.XPATH,using =("//button[@type='submit']"))
            WebElement  button;



    public void Login(String userEmail,String userPassword) {
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        button.click();
    }
}