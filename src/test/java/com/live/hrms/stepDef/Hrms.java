package com.live.hrms.stepDef;

import com.live.hrms.pages.LoginPage;
import com.live.hrms.pages.Page;
import com.live.hrms.pages.PhonePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hrms {
 public WebDriver driver;
 public LoginPage lp;
 public PhonePage pp;
 @Before
 public void setup(){
     lp = new LoginPage(driver);
     pp = new PhonePage(driver);
 }
   @Given("Open browser")
    public void open_browser() {

       WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
   }
   @When("Open cart application {string}")
    public void open_cart_application(String url) {
       driver.get(url);
   }


    @Then("Click on MyAccount drop menu")
    public void click_on_my_account_drop_menu() {
           lp.clickMyAccount();
    }

    @Then("Click on Login button")
    public void click_on_login_button() {
        lp.clickLogin();
    }

    @Then("Enter  email address {string} and password {string}")
    public void enter_email_and_password(String email, String password) {


            lp.setEmail(email);
            lp.setPassword(password);
        }
    @Then("Click login")
    public void click_login() {

        lp.clickLoginButton();

    }
    @Then("Click Phone&PDAs")
    public void click_phone_pd_as() {
       lp.clickPhone();
    }

    @Then("Click HTC Touch HD")
    public void click_htc_touch_hd() {

        pp.clickHTCTouchHD();
    }
    @Then("Add to cart and verify in items")
    public void add_to_cart_and_verify_in_items () {
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();
        WebElement item = driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block dropdown-toggle']"));
        if (item.equals("HTC Touch HD")) {
            System.out.println("Pass");
        } else {
            System.out.println("fail");
        }
    }
}
