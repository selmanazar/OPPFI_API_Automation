package com.oppfi.loan.cucumber;

import com.oppfi.loan.APIs.APIpostOfferCheck;
import com.oppfi.loan.common.DataValidation;
import com.oppfi.loan.common.TestVar;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class TestStepDefOppLoan {
    final static Logger logger = Logger.getLogger(TestStepDefOppLoan.class);

    @After
    public void testDataAndResponseInLogsForReference(Scenario scen){
        logger.debug("### Reset ###");
    }

    @When("Application or endUser calls loanoffer with ssn {string}")
    public void applicationOrEndUserCallsCreateLocationTagAs(String socialSecurityNumber) {
        APIpostOfferCheck.processPostOfferCheckAPI(socialSecurityNumber);
    }
    
    @When("Application or endUser calls loanoffer with invalid ssn")
    public void applicationOrEndUserCallsCreateLocationTagAs() {
        APIpostOfferCheck.processPostOfferCheckAPI(null);
    }

    @Then("API responds with status code of {string}")
    public void api_responds_with_status_code_of(String expRespCode) {
        DataValidation.validateResponseCode(expRespCode);
    }

    @Then("check if offer is accepted")
    public void check_if_offer_is_accepted() {
        Assert.assertEquals(TestVar.getAccepted(),Boolean.TRUE);
    }

    @Then("check if offer is declined")
    public void check_if_offer_is_declined() {
        Assert.assertEquals(TestVar.getAccepted(),Boolean.FALSE);
    }
    

    @Then("check if offer have loan details")
    public void check_if_offer_have_loan_details() {
        Assert.assertNotNull(TestVar.getOffers());
    }

    @Then("check if offer does have any loan details")
    public void check_if_offer_does_have_any_loan_details() {
        Assert.assertNull(TestVar.getOffers());
    }

    @Then("check if status is approved")
    public void check_if_status_is_approved() {
        Assert.assertEquals(TestVar.getStatus(),"APPROVED");
    }
    @Then("check if status is declined")
    public void check_if_status_is_declined() {
    	Assert.assertEquals(TestVar.getStatus(),"DECLINED");
    }


    @Then("check if ssn is populated as {string} in the loan response")
    public void check_if_ssn_is_populated_as_in_the_loan_response(String socialSecurityNumber) {
        Assert.assertEquals(TestVar.getSocialSecurityNumber(),socialSecurityNumber);
    }

    @Then("check if leadOfferId is populated as {string} in the loan response")
    public void check_if_leadOfferId_is_populated_as_in_the_loan_response(String leadOfferId) {
        Assert.assertEquals(TestVar.getLeadOfferId(),leadOfferId);
    }
    @Then("check if emailId is populated as {string} in the loan response")
    public void check_if_emailId_is_populated_as_in_the_loan_response(String email) {
        Assert.assertEquals(TestVar.getEmail(),email);
    }
    @Then("check if stateCode is populated as {string} in the loan response")
    public void check_if_stateCode_is_populated_as_in_the_loan_response(String stateCode) {
        Assert.assertEquals(TestVar.getStateCode(),stateCode);
    }
    @Then("check if requestedLoanAmount is populated as {int} in the loan response")
    public void check_if_requestedLoanAmount_is_populated_as_in_the_loan_response(Integer requestedLoanAmount) {
        Assert.assertEquals(TestVar.getRequestedLoanAmount(),requestedLoanAmount);
    }
    @Then("check if grossMonthlyIncome is populated as {int} in the loan response")
    public void check_if_grossMonthlyIncome_is_populated_as_in_the_loan_response(Integer grossMonthlyIncome) {
        Assert.assertEquals(TestVar.getGrossMonthlyIncome(),grossMonthlyIncome);
    }
    
    @Then("check if code is populated as {int} in the loan response")
    public void check_if_code_is_populated_as_in_the_loan_response(Integer code) {
        Assert.assertEquals(TestVar.getCode(),code);
    }


}
