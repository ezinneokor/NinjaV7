package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC01_LaunchApplication extends BaseClass {

    Logger logger = LogManager.getLogger(TC01_LaunchApplication.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    void testLaunchApplication() {
        logger.info("==== Starting test: testLaunchApplication ====");
        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Initialized HomePage object");

            String title = getDriver().getTitle();
            logger.info("Retrieved page title: " + title);

            Assert.assertEquals(title, "Your store of fun", "Page title does not match");
            logger.info("Assertion passed: Page title is correct");
        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            Assert.fail("Test failed due to assertion error");
        } catch (Exception e) {
            logger.error("Unexpected error in testLaunchApplication", e);
            Assert.fail("Test failed due to unexpected error");
        }
    }
}
