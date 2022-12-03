package com.live.hrms.stepDef;

import com.live.hrms.pages.LoginPage;

import com.live.hrms.pages.PhonePage;
;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import com.live.hrms.config.Config;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;


public class Hrms {
 public WebDriver driver;
 public LoginPage lp;
 public PhonePage pp;


   @Given("Open browser")
    public void open_browser() throws MalformedURLException {
        String ExecutionType = Config.properties.getProperty("ExecutionType");
       String RemoteExecutionGrid = Config.properties.getProperty("RemoteExecutionGrid");
       String Browser = Config.properties.getProperty("Browser");
       if (ExecutionType.equals("Local")) {
            if(Browser.equals("CH")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (Browser.equals("FF")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else if (Browser.equals("ED")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
       } else if(ExecutionType.equals("Remote")) {
           DesiredCapabilities cap;
           if(Browser.equals("CH")) {
               ChromeOptions options = new ChromeOptions();
               options.addArguments("no-sandbox");
               options.addArguments("start-maximized");
               options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
               options.setExperimentalOption("useAutomationExtension", false);
               options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
               cap = new DesiredCapabilities();
               cap.setCapability(ChromeOptions.CAPABILITY, options);
               cap.setBrowserName("chrome");

                   cap.setPlatform(Platform.WINDOWS);

               try {
                   driver = new RemoteWebDriver(new URL(RemoteExecutionGrid), cap);

               } catch (MalformedURLException e) {
                   e.printStackTrace();
               }

           } else if (Browser.equals("FF")) {
               cap = new DesiredCapabilities();
               driver = new RemoteWebDriver(new URL(RemoteExecutionGrid),cap);
           } else if (Browser.equals("ED")) {
               cap = new DesiredCapabilities();
               driver = new RemoteWebDriver(new URL(RemoteExecutionGrid),cap);
           }
       }

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       driver.manage().window().maximize();
       lp = new LoginPage(driver);
       pp = new PhonePage(driver);

   }
   @When("Open cart application")
    public void open_cart_application() {
       String Environment= Config.properties.getProperty("Environment");
       String CartUrl= Config.properties.getProperty(Environment+"CartUrl");
       driver.get(CartUrl);
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

