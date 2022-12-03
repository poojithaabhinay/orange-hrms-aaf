package com.live.hrms.services;

import com.live.hrms.logger.LoggerClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.logging.Logger;


public class WebServices {
  org.apache.log4j.Logger log = LoggerClass.getThreadLogger(Thread.currentThread().getName().toString(), "Ws001");
   public Response getResponseFromGetMethodRestAssured(String endPoint,String baseUrl,String header) {
       Response response=null;
       try {

            RestAssured.baseURI= baseUrl;
            RequestSpecification specification = RestAssured.given();
                String[] headerValues = header.split(";");
                for(int i = 0; i < headerValues.length; ++i) {
                    String[] values = headerValues[i].split(":");
                    specification.header(values[0],values[1]);
                }
          response = specification.get(endPoint);
            int statusCode = response.getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed : HTTP error code :" +  statusCode);
            }
            String responseString = response.body().asString();
            log.info("Response  - " + responseString);

        }catch(Exception var1) {
            log.info("response failed " + var1 + System.lineSeparator());
        }
    return response;



    }
    public Response getResponseFromPostMethodRestAssured(String jsonRequest, String endPoint, String baseUrl, String header) {
        Response response =null;
        try {

            RestAssured.baseURI= baseUrl;
            RequestSpecification specification = RestAssured.given();

                          String[] headerValues = header.split(";");
                for(int i = 0; i < headerValues.length; ++i) {
                    String[] values = headerValues[i].split(":");
                    specification.header(values[0],values[1]);
                }

                specification.body(jsonRequest.toString());
             response = specification.post(endPoint);
            int statusCode = response.getStatusCode();
            if (statusCode != 201) {
                throw new RuntimeException("Failed : HTTP error code :" +  statusCode);
            }
            //String responseString = given().spec(specification).body(jsonRequest).when().post(url).asString();
            String responseString = response.body().asString();

            log.info("Response  - " + responseString);

        }catch(Exception var1) {
            log.info("response failed " + var1.getMessage() + System.lineSeparator());
        }
        return response;
   }
}
