package com.oppfi.loan.Base;

import org.testng.log4testng.Logger;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
    final static Logger logger = Logger.getLogger(BaseAPI.class);

    public static void displayResponse(String str, int len){
        if(logger.isDebugEnabled()) {
            if (str.length() > len)
                logger.debug(str.substring(0, len) + "...Truncated");
            else
                logger.debug(str);
        }
    }

    public static Response  processPostAPIWithHeader(String requestBody) {
        RestAssured.baseURI = System.getProperty("TARGET_URL");
        System.out.println("TARGET_URL: " + System.getProperty("TARGET_URL"));
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("x-api-key", System.getProperty("API_KEY"));
        System.out.println("API_KEY: " + System.getProperty("API_KEY"));
        httpRequest.body(requestBody);
        Response response = httpRequest.request(Method.POST);
        String responseBody = response.getBody().asString();
        logger.debug("   post URL =>  " + System.getProperty("TARGET_URL"));
        logger.debug("   Response Body is =>  " + responseBody);
        return response;
    }

    public static int  getAPIResponseCode(Response response){
        int respCode = response.getStatusCode();
        return respCode;
    }


}
