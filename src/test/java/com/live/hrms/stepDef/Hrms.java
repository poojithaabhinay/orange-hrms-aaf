package com.live.hrms.stepDef;

import com.live.hrms.logger.LoggerClass;
import com.live.hrms.pages.LoginPage;

import com.live.hrms.pages.PhonePage;
;
import com.live.hrms.pages.SearchHotel;
import com.live.hrms.pages.SelectHotel;
import com.live.hrms.services.WebServices;
import com.live.hrms.utilities.UiUtilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
import java.util.HashMap;


public class Hrms {
    WebServices ws=new WebServices();
    org.apache.log4j.Logger log = LoggerClass.getThreadLogger(Thread.currentThread().getName().toString(), "Ws001");
    SelectHotel selectHotel;
    public WebDriver driver;
    public LoginPage lp;
    public PhonePage pp;
    SearchHotel searchHotel;
    Scenario scenario;
    @Before
    public void setup(Scenario scenario){
        this.scenario = scenario;
    }


    @Given("Open browser")
    public void open_browser() throws MalformedURLException {

        String ExecutionType = System.getProperty("ExecutionType");
        if (ExecutionType == null) {
            ExecutionType = Config.properties.getProperty("ExecutionType");
        }

        String RemoteExecutionGrid = System.getProperty("RemoteExecutionGrid");
        if (RemoteExecutionGrid == null) {
            RemoteExecutionGrid = Config.properties.getProperty("RemoteExecutionGrid");
        }

        String Browser = System.getProperty("Browser");
        if (Browser == null) {
            Browser = Config.properties.getProperty("Browser");
        }

        if (ExecutionType.equals("Local")) {
            if (Browser.equals("CH")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (Browser.equals("FF")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else if (Browser.equals("ED")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        } else if (ExecutionType.equals("Remote")) {
            DesiredCapabilities cap;
            if (Browser.equals("CH")) {
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
                driver = new RemoteWebDriver(new URL(RemoteExecutionGrid), cap);
            } else if (Browser.equals("ED")) {
                cap = new DesiredCapabilities();
                driver = new RemoteWebDriver(new URL(RemoteExecutionGrid), cap);
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        lp = new LoginPage(driver, this.scenario);
        pp = new PhonePage(driver, this.scenario);
        searchHotel = new SearchHotel(driver, this.scenario);
        selectHotel = new SelectHotel(driver, scenario);
    }

    @When("Hotel app application")
    public void Hotel_app_application() {

        String Environment = System.getProperty("Environment");
        if (Environment == null) {
            Environment = Config.properties.getProperty("Environment");
        }
        String CartUrl = Config.properties.getProperty(Environment + "CartUrl");
        driver.get(CartUrl);
    }


    @Then("Enter the username {string} and password {string} and Click on Login button")
    public void enter_the_username_and_password_and_Click_on_Login_button(String user, String pwd) {
        lp.Login(user, pwd);
    }
    @Then("Verify the  welcome text {string} in hotel home page")
    public void verify_the_hotel_home_page_displayed(String expectedWelcomeText) {

        String actualWelcomeText= searchHotel.getTextFromWelcomepage();
        searchHotel.verify(expectedWelcomeText, actualWelcomeText);
    }

    @Then("Enter the data in all fields and click search button")
    public void enter_the_data_in_all_fields_and_click_search_button(DataTable dataTable) {
        HashMap<String, String> data = ws.convertDataTableValuesToList(dataTable);
        searchHotel.searchHotel(data);
    }
    @Then("Verify the page should display {string}")
    public void verify_the_page_should_display(String exp) {
        String actual = searchHotel.getTextFromSearchPage();
        searchHotel.verify(exp,actual);
    }
    @Then("Verify the location is displayed in select hotel page")
    public void verify_the_location_is_displayed_in_select_hotel_page() {

        selectHotel.getText();

    }

}