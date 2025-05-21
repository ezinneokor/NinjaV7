package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WishListPage extends BasePage{
	
	
	
	//Constructor
	
	public WishListPage(WebDriver driver){
		super(driver);
	}
	
	
	
	//Locators
	@FindBy(xpath="//i[@class='fa-solid fa-heart']")
	WebElement wishListIcon;
	private By wishListIconBy = By.xpath("//i[@class='fa-solid fa-heart']");
	
	@FindBy(xpath="//h1[normalize-space()='My Wishlist']")
	WebElement wishListTable;
	private By wishListTableBy = By.xpath("//h1[normalize-space()='My Wishlist']");
	
	@FindBy(xpath="//table//td[2]/a")
	List<WebElement> tableData;
	private By tableDataBy = By.xpath("//table//td[2]/a");
	
	
	
	//Action Methods
	
	public void wishIconClick() throws InterruptedException {
		WebElement wishListIconWait;
//		wishListIconWait = wait.until(ExpectedConditions.elementToBeClickable(wishListIconBy));
//		wishListIconWait.click();
		Thread.sleep(1000);
		
		try {
			wishListIconWait = wait.until(ExpectedConditions.elementToBeClickable(wishListIconBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishListIconWait);
			 
			 
			 try {
				 wishListIconWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", wishListIconWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
		
	}
	
	
	
	public boolean confirmWishList() {
	    try {
	        List<WebElement> productNames = tableData;
	        for (WebElement product : productNames) {
	            if (product.getText().equalsIgnoreCase("HP LP3065")) {
	                return true;
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Exception while confirming wishlist: " + e.getMessage());
	    }
	    return false;
	}

	
	
	

}
