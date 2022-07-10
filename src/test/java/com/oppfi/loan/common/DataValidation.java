package com.oppfi.loan.common;


import org.junit.Assert;

public class DataValidation {

    public static void validateResponseCode(String expRespCode){
        if("not".equals(expRespCode.substring(0,3)))
            validateResponseCodeNot(Integer.parseInt(expRespCode.split(" ")[1]));
        else
            validateResponseCode(Integer.parseInt(expRespCode));
    }
    public static void validateResponseCode(int expRespCode){
        Assert.assertEquals(expRespCode, TestVar.getResponseCode());
    }
    public static void validateResponseCodeNot(int expRespCode){
        Assert.assertNotEquals(expRespCode, TestVar.getResponseCode());

    }

}
