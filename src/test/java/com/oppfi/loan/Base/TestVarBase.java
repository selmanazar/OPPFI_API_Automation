package com.oppfi.loan.Base;

import io.restassured.response.Response;


public class TestVarBase {

    /* response variables */
    private static Response response;
    private static int responseCode = 0;



    public static Response getResponse() {
        return response;
    }
    public static void setResponse(Response response) {
        TestVarBase.response = response;
    }

    public static int getResponseCode() {
        return responseCode;
    }
    public static void setResponseCode(int argResponseCode) {
        TestVarBase.responseCode = argResponseCode;
    }


    public static void resetResponseVariables(){
        response = null ;
        responseCode = 0;
    }
}
