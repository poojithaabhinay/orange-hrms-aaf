package com.live.hrms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Page {


   private WebDriver driver;
   Page(){

   }

    Page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);

    }
    @FindBy(how= How.XPATH,using =("//ul[@class ='nav navbar-nav']/li[1]/a"))
    WebElement deskTop;

    @FindBy(how=How.XPATH,using =("//ul[@class ='nav navbar-nav']/li[2]/a"))
    WebElement lapTop;

    @FindBy(how=How.XPATH,using =("//ul[@class ='nav navbar-nav']/li[3]/a"))
             WebElement component;

    @FindBy(how=How.XPATH,using=("//ul[@class ='nav navbar-nav']/li[4]/a"))
    WebElement tablet;

    @FindBy(how=How.XPATH,using =("//ul[@class ='nav navbar-nav']/li[5]/a"))
    WebElement software;

    @FindBy(how= How.XPATH,using =("//ul[@class ='nav navbar-nav']/li[6]/a"))
           WebElement  phone;
            @FindBy(how=How.XPATH,using =("//ul[@class ='nav navbar-nav']/li[5]/a"))
            WebElement camera;

            @FindBy(how= How.XPATH,using =("//ul[@class ='nav navbar-nav']/li[8]/a"))
            WebElement player;

            @FindBy(how=How.XPATH,using =("//a[@id='wishlist-total']"))
            WebElement wishList;

            @FindBy(how = How.XPATH, using="//span[text()='MY ACCOUNT']")
            WebElement myaccount;

            @FindBy(how = How.LINK_TEXT, using="REGISTER")
            WebElement register;

            @FindBy(how = How.LINK_TEXT, using="LOGIN")
            WebElement login;
            public void clickDesktop()
            {
            deskTop.click();
            }
            public void clickLaptop()
            {
            lapTop.click();
            }
            public void clickComponent()
            {
            component.click();
            }
            public void clickTablet()
            {
            tablet.click();
            }
            public void clickSoftware()
            {
            software.click();
            }
            public void clickPhone(){

            phone.click();
            }
            public void clickCamera()
            {
            camera.click();
            }
            public void clickPLayer()
            {
            player.click();
            }
            public void clickWishList()
            {
            wishList.click();
            }

            public void clickMyAccount(){

            myaccount.click();
            }
            public void clickRegister()
            {
            register.click();
            }
            public void clickLogin()
            {
            login.click();
            }

}
