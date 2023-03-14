package com.live.hrms.pages;

import com.live.hrms.utilities.UiUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.Scenario;
import java.util.HashMap;

public class SearchHotel extends Page {
    Scenario scenario;
    WebDriver driver;
    public SearchHotel(WebDriver driver, Scenario scenario){
        super(driver, scenario);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(how = How.NAME, using = ("location"))
    WebElement location;
    @FindBy(how = How.NAME, using = ("hotels"))
    WebElement hotel;
    @FindBy(how = How.NAME, using = ("room_type"))
    WebElement room_type;
    @FindBy(how = How.NAME, using = ("room_nos"))
    WebElement room_nos;
    @FindBy(how = How.XPATH, using = ("//input[@name='datepick_in']"))
    WebElement datepick_in;
    @FindBy(how = How.XPATH, using = ("//input[@name='datepick_out']"))
    WebElement datepick_out;
    @FindBy(how = How.NAME, using = ("adult_room"))
    WebElement adult_room;
    @FindBy(how = How.NAME, using = ("child_room"))
    WebElement child_room;
    @FindBy(how = How.NAME, using = ("Submit"))
    WebElement Submit;
    @FindBy(how = How.XPATH, using = "(//td[@class='welcome_menu'])[1]")
    WebElement welcomeText;
    @FindBy(how = How.XPATH, using = "//span[@id='checkin_span']")
    WebElement checkin;



    public void searchHotel(HashMap<String, String> data){

        Select selectLocation = new Select(location);

        selectLocation.selectByVisibleText(data.get("Location"));
        Select selectHotel = new Select(hotel);
        selectHotel.selectByVisibleText(data.get("Hotels"));
        Select selectStandard = new Select(room_type);
        selectStandard.selectByVisibleText(data.get("Room Type"));
        Select selectRoom= new Select(room_nos);
        selectRoom.selectByVisibleText(data.get("Number Of Rooms"));
        datepick_in.sendKeys(data.get("Check In Date"));
        datepick_out.sendKeys(data.get("Check Out Date"));
        Select selectAdult = new Select(adult_room);
        selectAdult.selectByVisibleText(data.get("Adults per Room"));
        Select selectChild = new Select(child_room);
        selectChild.selectByVisibleText(data.get("Children per Room"));
        Submit.click();

    }
    public String getTextFromWelcomepage() {
        String val = welcomeText.getText();

        return val;
    }
    public String getTextFromSearchPage(){
        String val1= checkin.getText();
        return val1;
    }
}
