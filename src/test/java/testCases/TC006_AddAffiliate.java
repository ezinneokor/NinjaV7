package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.AddedAffiliatePage;
import pageObjects.AffiliateCreationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC006_AddAffiliate extends BaseClass {

    Logger logger = LogManager.getLogger(TC006_AddAffiliate.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    void login() throws InterruptedException {
        logger.info("==== Starting test: TC006_AddAffiliate ====");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Navigated to HomePage");

            hp.clickMyAccount();
            logger.debug("Clicked on 'My Account'");

            hp.goTologin();
            logger.debug("Clicked on 'Login'");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("ezinneokorbassey5@gmail.com");
            lp.setPwd("user123");
            lp.click_Login();
            logger.info("Login successful with provided credentials");

            AccountPage ap = new AccountPage(getDriver());
            ap.clickAffiliateBtn();
            logger.debug("Navigated to 'Affiliate' section");

            AffiliateCreationPage acp = new AffiliateCreationPage(getDriver());
            acp.addCompanyName("CloudBerry");
            acp.addCompanyWebsite("cloudberrystore.services");
            acp.addCompanyTax("12345");
            acp.clickPaymentMethods();
            acp.addPaymentMethod("ezinneokorbassey5@gmail.com");
            acp.clickContinueBtn();
            logger.info("Filled affiliate details and submitted");

            AddedAffiliatePage aap = new AddedAffiliatePage(getDriver());
            boolean confirmation = aap.affiliateAccountAdded();
            logger.info("Affiliate account added confirmation: " + confirmation);

            Assert.assertTrue(confirmation, "Affiliate account creation failed.");
            logger.info("Assertion passed: Affiliate account created successfully");

        } catch (AssertionError ae) {
            logger.error("Assertion failed: " + ae.getMessage());
            Assert.fail("Test failed due to assertion error.");
        } catch (Exception e) {
            logger.error("Unexpected error occurred in TC006_AddAffiliate", e);
            Assert.fail("Test failed due to unexpected exception.");
        }
    }
}
