package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.HpProductPage;
import pageObjects.LaptopsNotebooksProductPage;
import pageObjects.LoginPage;
import pageObjects.OrderPlacedPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC_04_CompletePurchase extends BaseClass {

    Logger logger = LogManager.getLogger(TC_04_CompletePurchase.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = RetryAnalyzer.class)
    void checkOut() throws InterruptedException {
        logger.info("==== Starting test: checkOut ====");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Initialized HomePage");
            hp.clickLaptopNotebook();
            logger.debug("Clicked Laptop & Notebook");
            hp.clickshowAllLaptopNotebook();
            logger.debug("Clicked Show All Laptop & Notebook");

            LaptopsNotebooksProductPage ln = new LaptopsNotebooksProductPage(getDriver());
            ln.clickHpProduct();
            logger.debug("Selected HP product");

            HpProductPage hpp = new HpProductPage(getDriver());
            hpp.addDate();
            logger.debug("Delivery date added");
            hpp.addToCartClick();
            logger.info("Clicked Add to Cart");
            hpp.goToCheckout();
            logger.info("Proceeded to Checkout");

            CheckOutPage cop = new CheckOutPage(getDriver());
            cop.clickLoginPage();
            logger.debug("Navigated to Login Page");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("ezinneokorbassey5@gmail.com");
            lp.setPwd("user123");
            lp.click_Login();
            logger.info("Logged in with test credentials");

            cop.checkOutClick();
            logger.debug("Clicked Continue after login");
            cop.clickShippingAddress();
            logger.debug("Selected shipping address");
            cop.clickShippingMethod();
            logger.debug("Selected shipping method");
            cop.clickPaymentMethod();
            logger.debug("Selected payment method");
            cop.clickConfirmOrder();
            logger.info("Clicked Confirm Order");

            OrderPlacedPage op = new OrderPlacedPage(getDriver());
            boolean orderSuccess = op.orderHasBeenPlaced();
            logger.info("Order placement message displayed: " + orderSuccess);

            Assert.assertTrue(orderSuccess, "Order placement confirmation not displayed.");
            logger.info("Assertion passed: Order placed successfully.");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            Assert.fail("Test failed due to assertion error.");
        } catch (Exception e) {
            logger.error("Unexpected error during complete purchase flow", e);
            Assert.fail("Test failed due to unexpected error.");
        }
    }
}
