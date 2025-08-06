package orangeHrm.listeners;


import orangeHrm.testCase.LoginTest;
import orangeHrm.utils.BrowserUtility;
import orangeHrm.utils.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;




public class TestListener implements ITestListener {

    protected Logger logger = LoggerUtility.getLogger(this.getClass());

    public void onStart(ITestContext context){
        logger.info("Execution started for Test Suite: {}", context.getSuite().getName());
    }

    public void onTestStart(ITestResult result) {
        logger.info("Test Case Method: {}", result.getMethod().getMethodName());
        logger.info("Test Case Description: {}", result.getMethod().getDescription());
        logger.info("Execution of {} depends on {}",result.getMethod().getMethodName(), Arrays.toString(result.getMethod().getGroups()));
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("{} - PASS",result.getMethod().getDescription());
    }

    public void onTestFailure(ITestResult result) {

        Object testClassInstance = result.getInstance();
        BrowserUtility browserUtility = ((LoginTest)testClassInstance).getInstance();
        String screenShotPath =browserUtility.takeScreenshot(result.getMethod().getDescription());
        logger.debug("Screenshot captured and placed in {}", screenShotPath);
        logger.error("Failure Details: {}", result.getThrowable().getMessage());
        logger.error("{} - FAIL",result.getMethod().getDescription());
        
    }

    public void onFinish(ITestContext context) {
        logger.info("Execution finished for Test Suite: {}", context.getSuite().getName());
    }
}
