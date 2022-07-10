package com.oppfi.loan.common;

import java.util.List;

import com.oppfi.loan.Base.TestVarBase;


public class TestVar extends TestVarBase {
    private static String status;
    private static String socialSecurityNumber;
    private static String leadOfferId;
    private static String email;
    private static String stateCode;
    private static Integer requestedLoanAmount;
    private static Integer grossMonthlyIncome;
    private static Boolean accepted;
    private  static List<Object> offers;
    private static Integer code;

    public static Integer getGrossMonthlyIncome() {
        return grossMonthlyIncome;
    }

    public static void setGrossMonthlyIncome(Integer grossMonthlyIncome) {
        TestVar.grossMonthlyIncome = grossMonthlyIncome;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        TestVar.status = status;
    }

    public static String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public static void setSocialSecurityNumber(String socialSecurityNumber) {
        TestVar.socialSecurityNumber = socialSecurityNumber;
    }

    public static String getLeadOfferId() {
        return leadOfferId;
    }

    public static void setLeadOfferId(String leadOfferId) {
        TestVar.leadOfferId = leadOfferId;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        TestVar.email = email;
    }

    public static String getStateCode() {
        return stateCode;
    }

    public static void setStateCode(String stateCode) {
        TestVar.stateCode = stateCode;
    }

    public static Integer getRequestedLoanAmount() {
        return requestedLoanAmount;
    }

    public static void setRequestedLoanAmount(Integer requestedLoanAmount) {
        TestVar.requestedLoanAmount = requestedLoanAmount;
    }

    public static Boolean getAccepted() {
        return accepted;
    }

    public static void setAccepted(Boolean accepted) {
        TestVar.accepted = accepted;
    }

    public static List<Object> getOffers() {
        return offers;
    }

    public static void setOffers(List<Object> offers) {
        TestVar.offers = offers;
    }

	public static Integer getCode() {
		return code;
	}

	public static void setCode(Integer code) {
		TestVar.code = code;
	}
}
