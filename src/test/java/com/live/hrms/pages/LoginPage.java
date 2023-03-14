package com.live.hrms.pages;

import com.live.hrms.security.Security;
import com.live.hrms.utilities.UiUtilities;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
    private WebDriver driver;
    Scenario scenario;
    public LoginPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
        this.scenario = scenario;
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(how = How.ID, using = ("username"))
    WebElement txt_user;

    @FindBy(how = How.ID, using = ("password"))
    WebElement txt_password;

    @FindBy(how = How.ID, using = ("login"))
    WebElement button;
    public void Login(String user, String Password) {
        Security security = new Security();
      String decryptpwd=  security.decryptPassword(Password);
        txt_user.sendKeys(user);
        txt_password.sendKeys(decryptpwd);
        button.click();
    }
}