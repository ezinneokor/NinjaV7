package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddedAffiliatePage extends BasePage {
	// Constructor
	
		public AddedAffiliatePage(WebDriver driver){
			super(driver);
		}
	
	//Locators
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")  //Affiliate account added
	WebElement affiliateAdded;
	private By affiliateAddedBy = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	
	//Action Methods
	
	public boolean affiliateAccountAdded() {
	    try {
	        WebElement affiliateAddedWait = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(affiliateAddedBy)
	        );
	        return affiliateAddedWait.isDisplayed();
	    } catch (TimeoutException e) {
	        System.out.println("Timeout waiting for affiliate confirmation message: " + e.getMessage());
	        return false;
	    } catch (Exception e) {
	        System.out.println("Unexpected error during affiliate confirmation check: " + e.getMessage());
	        return false;
	    }
	}

	
	

}
