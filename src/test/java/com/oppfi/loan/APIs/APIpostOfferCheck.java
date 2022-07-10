package com.oppfi.loan.APIs;

import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.log4testng.Logger;

import com.oppfi.loan.Base.BaseAPI;
import com.oppfi.loan.common.TestVar;

import io.restassured.response.Response;

public class APIpostOfferCheck extends BaseAPI {
    final static Logger logger = Logger.getLogger(APIpostOfferCheck.class);

    public static String buildRequestBody(String socialSecurityNumber) {
        JSONObject payLoad = new JSONObject();

        payLoad.put("isProduction", false);
        payLoad.put("language", "en");
        payLoad.put("currency", "USD");
        payLoad.put("campaignId", "11-50-newhope");
        payLoad.put("socialSecurityNumber",socialSecurityNumber);
        payLoad.put("leadOfferId", "20160912-21EC2020-3AEA-4069-A2DD-08002B30309D");
        payLoad.put("email", "test_customer@gmail.com");
        payLoad.put("grossMonthlyIncome", 2800);
        payLoad.put("requestedLoanAmount", 1500);
        payLoad.put("stateCode", "FL");
        

        JSONObject personalInfo = new JSONObject();
        personalInfo.put("firstName", "Jennifer");
        personalInfo.put("lastName", "Smith");
        personalInfo.put("dateOfBirth", "19451009");
        
        JSONObject address = new JSONObject();
        address.put("streetAddress", "123 Main Street");
        address.put("city", "Miami");
        address.put("zip", "33125");
        address.put("countryCode", "US");
        personalInfo.put("address",address);

        personalInfo.put("mobilePhone", "3224340098");
        personalInfo.put("homePhone", "4523452232");
        payLoad.put("personalInfo",personalInfo);


        JSONObject bankInfo = new JSONObject();
        bankInfo.put("bankName", "Chase");
        bankInfo.put("abaRoutingNumber", "123456789");
        bankInfo.put("accountNumber", "012345789");
        bankInfo.put("accountType", 1);
        bankInfo.put("accountLength", 6);
        payLoad.put("bankInfo",bankInfo);

        JSONObject incomeInfo = new JSONObject();
        incomeInfo.put("incomeType", "Employment");
        incomeInfo.put("payrollType", "DirectDeposit");
        incomeInfo.put("payrollFrequency", 1);
        incomeInfo.put("lastPayrollDate", "20160915");
        payLoad.put("incomeInfo",incomeInfo);

        JSONObject employmentInfo = new JSONObject();
        employmentInfo.put("employerName", "ToysRUs");
        employmentInfo.put("hireDate", "20110516");
        payLoad.put("employmentInfo",employmentInfo);


        String strBody = payLoad.toJSONString();
        System.out.println(strBody);
       logger.info("Request Body Create Case Tags =>" + strBody);
        return strBody;
    }

    public static void processPostOfferCheckAPI(String socialSecurityNumber)  {
        logger.info("API >> post check offer");
        TestVar.resetResponseVariables();
        Response response = processPostAPIWithHeader(buildRequestBody(socialSecurityNumber));
        TestVar.setResponse(response);
        TestVar.setResponseCode(getAPIResponseCode(response));
        parseResponse(response);
        System.out.println(response);
    }

    public static  int getAPIResponseCode(){
        return getAPIResponseCode(TestVar.getResponse());
    }

    public static void parseResponse(Response resp){
    	System.out.println("Response Body #Loan Offer Check# API =>" + resp.getBody().prettyPrint());
        logger.info("Response Body #Loan Offer Check# API =>" + resp.getBody().prettyPrint());
        if(getAPIResponseCode(resp)==200 ) {
            String socialSecurityNumber = resp.jsonPath().getString("request.socialSecurityNumber");
            TestVar.setSocialSecurityNumber(socialSecurityNumber);
            String leadOfferId = resp.jsonPath().getString("request.leadOfferId");
            TestVar.setLeadOfferId(leadOfferId);
            String email = resp.jsonPath().getString("request.email");
            TestVar.setEmail(email);
            String stateCode = resp.jsonPath().getString("request.stateCode");
            TestVar.setStateCode(stateCode);
            Integer requestedLoanAmount = resp.jsonPath().getInt("request.requestedLoanAmount");
            TestVar.setRequestedLoanAmount(requestedLoanAmount);
            Integer grossMonthlyIncome = resp.jsonPath().getInt("request.grossMonthlyIncome");
            TestVar.setGrossMonthlyIncome(grossMonthlyIncome);
            Boolean accepted = resp.jsonPath().getBoolean("accepted");
            TestVar.setAccepted(accepted);
            String status = resp.jsonPath().getString("status");
            TestVar.setStatus(status);
            List<Object> offers = resp.jsonPath().getList("offers");
            TestVar.setOffers(offers);
            Integer code = resp.jsonPath().getInt("code");
            TestVar.setCode(code);

        }
        else {
            Assert.fail("Response Code =>"+resp.getStatusCode()+ " Response Body =>"+resp.getBody().prettyPrint());
        }
    }
}
