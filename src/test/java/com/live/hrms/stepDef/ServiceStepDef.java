package com.live.hrms.stepDef;

import com.live.hrms.config.Config;
import com.live.hrms.logger.LoggerClass;
import com.live.hrms.services.WebServices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class ServiceStepDef {
    org.apache.log4j.Logger log = LoggerClass.getThreadLogger(Thread.currentThread().getName().toString(), "Ws001");
    WebServices ws=new WebServices();
    Response response;
    String payLoad = null;
    @Given("I submit json get request to get employee {string}")
    public void i_submit_json_get_request_to_get_employee(String empId) {
    String Environment= Config.properties.getProperty("Environment");
        String GoRestBaseUrl= Config.properties.getProperty(Environment+"GoRestBaseUrl");
        String GoRestGetUserEndPoint= Config.properties.getProperty(Environment+"GoRestGetUserEndPoint");
        String GoRestGetUrlHeader= Config.properties.getProperty(Environment+"GoRestGetUrlHeader");
        GoRestGetUserEndPoint =GoRestGetUserEndPoint+"/"+empId;
     response=   ws.getResponseFromGetMethodRestAssured(GoRestGetUserEndPoint, GoRestBaseUrl, GoRestGetUrlHeader);
    }
    @When("Response code {int}")
    public void response_code(int expResponseCode) {
         int actResponseCode = response.getStatusCode();
         log.info("Expected Response Code '" + expResponseCode + "' And Actual Response code '" + actResponseCode +"'");
        Assert.assertEquals(actResponseCode,expResponseCode);
    }
    @Then("validate name {string}")
    public void validate_name(String expName) {
        String actName =response.jsonPath().getString("name");
        log.info("Expected Name '" + expName + "' And Actual Name '" + actName +"'");
        Assert.assertEquals(actName,expName);

    }
    @Then("validate email {string}")
    public void validate_email(String expEmail) {
        String actEmail =response.jsonPath().getString("email");
        log.info("Expected Email '" + expEmail + "' And Actual Email '" + actEmail +"'");

        Assert.assertEquals(actEmail,expEmail);


    }
    @Then("validate gender {string}")
    public void validate_gender(String expGender) {
        String actGender =response.jsonPath().getString("gender");
        log.info("Expected Gender '" + expGender + "' And Actual Gender '" + actGender +"'");
        Assert.assertEquals(actGender,expGender);


    }
    @Then("validate status {string}")
    public void validate_status(String expStatus) {
        String actStatus =response.jsonPath().getString("status");
        log.info("Expected Status '" + expStatus + "' And Actual Status '" + actStatus +"'");

        Assert.assertEquals(actStatus,expStatus);


    }
    @Given("Prepare json payload to create user- name={string} and email={string} and gender={string} and status={string}")
    public void createUser(String name, String email,String gender, String status) {
          payLoad ="{\n" +
                 "    \"name\": \"{name}\",\n" +
                 "    \"gender\": \"{gender}\",\n" +
                 "    \"email\": \"{email}\",\n" +
                 "    \"status\": \"{status}\"\n" +
                 "}";
        payLoad  =payLoad.replace("{name}",name);
        payLoad  =payLoad.replace("{gender}",gender);
        payLoad  =payLoad.replace("{email}",email);
        payLoad  =payLoad.replace("{status}",status);

    }
    @When("I submit json post request")
    public void i_submit_json_post_request() {
        String Environment= Config.properties.getProperty("Environment");
        String GoRestBaseUrl= Config.properties.getProperty(Environment+"GoRestBaseUrl");
        String GoRestPostUserEndPoint= Config.properties.getProperty(Environment+"GoRestPostUserEndPoint");
        String GoRestPostUrlHeader= Config.properties.getProperty(Environment+"GoRestPostUrlHeader");
        response = ws.getResponseFromPostMethodRestAssured(payLoad,GoRestPostUserEndPoint,GoRestBaseUrl,GoRestPostUrlHeader);


    }


}
