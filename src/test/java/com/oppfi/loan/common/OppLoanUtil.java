package com.oppfi.loan.common;

import org.testng.log4testng.Logger;

public class OppLoanUtil  {
    final static Logger logger = Logger.getLogger(OppLoanUtil.class);
    

    public static void initialSetup() {
        initialSetup("");
    }
    
    public static void initialSetup(String featureName) {
        logger.info("### InitialSetup DC###");
            TestVar.resetResponseVariables();
            logger.info("### InitialSetup Done ###");
    }

    public static void tearDown(){
        logger.info("TestNG-AfterSuite-tearDown");
    }


}
