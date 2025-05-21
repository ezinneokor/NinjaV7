package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.HpProductPage;
import pageObjects.LaptopsNotebooksProductPage;
import pageObjects.LoginPage;
import pageObjects.WishListPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC05__AddToWishList extends BaseClass {

    Logger logger = LogManager.getLogger(TC05__AddToWishList.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    void addToWishList() throws InterruptedException {
        logger.info("==== Starting test: addToWishList ====");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Navigated to HomePage");

            hp.clickLaptopNotebook();
            logger.debug("Clicked on 'Laptop & Notebook'");

            hp.clickshowAllLaptopNotebook();
            logger.debug("Clicked 'Show All Laptop & Notebook'");

            LaptopsNotebooksProductPage ln = new LaptopsNotebooksProductPage(getDriver());
            ln.clickHpProduct();
            logger.debug("Selected HP product");

            HpProductPage hpp = new HpProductPage(getDriver());
            hpp.addToWishListClick();
            logger.info("Clicked 'Add to Wishlist'");

            hp.clickMyAccount();
            hp.goTologin();
            logger.info("Navigated to Login Page");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("ezinneokorbassey5@gmail.com");
            lp.setPwd("user123");
            lp.click_Login();
            logger.info("Logged in with test credentials");

            WishListPage wp = new WishListPage(getDriver());
            wp.wishIconClick();
            boolean confirmation = wp.confirmWishList();
            logger.info("Wish list confirmation displayed: " + confirmation);

            Assert.assertTrue(confirmation, "Wish list confirmation not displayed.");
            logger.info("Assertion passed: Item successfully added to wishlist.");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            Assert.fail("Test failed due to assertion error.");
        } catch (Exception e) {
            logger.error("Unexpected error during addToWishList test", e);
            Assert.fail("Test failed due to unexpected exception.");
        }
    }
}
