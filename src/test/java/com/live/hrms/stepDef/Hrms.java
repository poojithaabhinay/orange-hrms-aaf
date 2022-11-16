package com.live.hrms.stepDef;

import com.live.hrms.pages.LoginPage;

import com.live.hrms.pages.PhonePage;
;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


import java.time.Duration;



public class Hrms {
 public WebDriver driver;
 public LoginPage lp;
 public PhonePage pp;


   @Given("Open browser")
    public void open_browser() {

       WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       driver.manage().window().maximize();
       lp = new LoginPage(driver);
       pp = new PhonePage(driver);

   }
   @When("Open cart application {string}")
    public void open_cart_application(String url) {
       driver.get(url);
   }




    @Then("Click on Login button")
    public void click_on_login_button() {
        lp.clickLogin();
    }

   @Then("Enter  email address {string} and password {string} and click login")
    public void enter_email_and_password(String email, String password) {
            lp.Login(email,password);
   }
    @Then("Click Phone&PDAs")
    public void click_phone_pd_as() {
       lp.clickPhone();
       if (driver.getTitle().equals("Phones & PDAs"))
       {
           Assert.assertTrue(true);

       }
       else {
           Assert.assertTrue(false);
       }

    }
    @Then("Click HTC Touch HD")
    public void click_htc_touch_hd() {

        pp.clickHTCTouchHD();

    }
    @Then("Add to cart")
    public void add_to_cart()  {
       pp.clickAddToCart();


    }
    @Then("verify in items")
    public void verify_in_items() throws InterruptedException {
      Thread.sleep(5000);
       String itemText=pp.getTextFromItemsCart();
        if (itemText.equals("1 item(s) - $122.00")) {
             System.out.println("Pass");
             Assert.assertTrue(true);
        } else {
            System.out.println("fail");
            Assert.assertTrue(false);
        }

    }


    }

