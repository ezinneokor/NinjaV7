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

public class OrderPlacedPage extends BasePage{
	
	//Constructor
			public OrderPlacedPage(WebDriver driver){
				super(driver);
			}
	
	
	//Locators
	
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")  //order has been placed locator
	WebElement orderPlaced;
	private By orderPlacedBy = By.xpath("//h1[normalize-space()='Your order has been placed!']");
	
	//Action Methods
	
	public boolean orderHasBeenPlaced() {
		
        wait.until(ExpectedConditions.visibilityOf(orderPlaced));
       // WebElement orderPlacedWait;
        
        return  orderPlaced.isDisplayed();

		
		
//				try {
//			        // Wait for the alert to be visible using the By locator
//					orderPlacedWait= wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlacedBy));
//			        boolean confirmOrder = orderPlacedWait.isDisplayed();
//			        
//
//			        Assert.assertTrue(confirmOrder, "Test Failed: confirmOrder was false");
//			        
//
//			    } catch (TimeoutException e) {
//			        Assert.fail("Test Failed: Success message did not appear in time.");
//			    }
	}

}
