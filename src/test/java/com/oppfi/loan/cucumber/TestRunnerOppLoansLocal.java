package com.oppfi.loan.cucumber;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "json:target/cucumber-report.json",
                "html:target/cucumber-report.html" },
        features = "src/test/resources/features/loan_application.feature",
        tags={"@loan"},
        glue = "com.oppfi.loan.cucumber"
)
public class TestRunnerOppLoansLocal extends AbstractTestNGCucumberTests {
    final static Logger logger = Logger.getLogger(TestRunnerOppLoansLocal.class);

    @BeforeSuite
    public static void beforeSuite() {
        String propFeatureName = "loan_application.feature";
        logger.info("Runner Before Suite-TestRunnerBackRoom");
    }

    @AfterSuite
    public static void afterSuite() {
        logger.info("Runner After Suite-TestRunnerBackRoom");
    }
}
