package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.HpProductPage;
import pageObjects.LaptopsNotebooksProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC03_AddToCart extends BaseClass {

    Logger logger = LogManager.getLogger(TC03_AddToCart.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    void testAddToCart() throws InterruptedException {
        logger.info("==== Starting test: testAddToCart ====");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Initialized HomePage");
            hp.clickLaptopNotebook();
            logger.debug("Clicked Laptop & Notebook");
            hp.clickshowAllLaptopNotebook();
            logger.debug("Clicked Show All Laptops & Notebooks");

            LaptopsNotebooksProductPage lnp = new LaptopsNotebooksProductPage(getDriver());
            lnp.clickHpProduct();
            logger.debug("Clicked HP Product");

            HpProductPage hpp = new HpProductPage(getDriver());
            hpp.addDate();
            logger.debug("Added delivery date");
            hpp.addToCartClick();
            logger.info("Clicked Add to Cart");

            String successText = hpp.successMessage().getText();
            logger.info("Success message: " + successText);

            Assert.assertTrue(successText.contains("Success"),
                    "Test Failed: Success message not displayed as expected");

            logger.info("Assertion passed: Product added to cart successfully");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            Assert.fail("Test failed due to assertion error.");
        } catch (Exception e) {
            logger.error("Unexpected error during testAddToCart", e);
            Assert.fail("Test failed due to unexpected error.");
        }
    }
}
