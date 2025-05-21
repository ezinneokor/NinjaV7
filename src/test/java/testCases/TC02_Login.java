package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC02_Login extends BaseClass {

    Logger logger = LogManager.getLogger(TC02_Login.class);

    @Test(groups = {"sanity", "regression", "datadriven"},
          dataProvider = "LoginData",
          dataProviderClass = DataProviders.class,
          retryAnalyzer = utilities.RetryAnalyzer.class)
    void testLogin(String email, String pwd) {
        logger.info("==== Starting test: testLogin ====");
        logger.debug("Input Data -> Email: " + email + ", Password: " + pwd);

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Initialized HomePage");
            hp.clickMyAccount();
            logger.debug("Clicked My Account");
            hp.goTologin();
            logger.debug("Navigated to Login Page");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail(email);
            lp.setPwd(pwd);
            lp.click_Login();
            logger.info("Login submitted");

            AccountPage ap = new AccountPage(getDriver());
            boolean status = ap.getMyAccountConfirmation().isDisplayed();

            if (status) {
                logger.info("Login successful. Proceeding with logout.");
                ap.clickMyAccountDropDown();
                ap.clickLogout();
                logger.info("Logout completed successfully.");
                Assert.assertTrue(true);
            } else {
                logger.error("Login failed: MyAccount confirmation not found.");
                Assert.fail("Login failed: MyAccount confirmation not found.");
            }

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            Assert.fail("Test failed due to assertion error.");
        } catch (Exception e) {
            logger.error("Unexpected error during testLogin", e);
            Assert.fail("Test failed due to unexpected error.");
        }
    }
}
