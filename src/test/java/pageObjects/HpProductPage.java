package pageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

public class HpProductPage extends BasePage{
	
	
	//Constructor
	public HpProductPage(WebDriver driver){
		super(driver);
	}
	
	
	//Locators
	@FindBy(xpath="//input[@id='input-option-225']")  //Date input field locator
	WebElement inputDate;
	private By inputDataBy = By.xpath("//input[@id='input-option-225']");
			
	@FindBy(xpath="//button[@id='button-cart']")    // Add To cart Button
	WebElement addToCartBtn;
	private By addToCartBtnBy = By.xpath("//button[@id='button-cart']");
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement actualMessage;
	private By actualMessageBy = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	@FindBy(xpath="//div[@class=\"btn-group\"]/button[1]")  //Add To WishList Icon
	WebElement wishListProduct;
	private By wihListProductBy = By.xpath("//div[@class=\"btn-group\"]/button[1]");
	
	@FindBy(xpath="//i[@class='fa-solid fa-share']")  //Checkout Icon
	WebElement checkOutIcon;
	private By checkOutIconBy = By.xpath("//i[@class='fa-solid fa-share']");
	
	

	//Action Methods
	
	public void addDate()  {
		WebElement inputDataWait;
		inputDataWait = wait.until(ExpectedConditions.elementToBeClickable(inputDataBy));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",inputDataWait);
		 inputDataWait.clear();
		 LocalDate today = LocalDate.now();
		 LocalDate deliveryDate = today.plusDays(5);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 String formattedDeliveryDate = deliveryDate.format(formatter);
		 inputDataWait.sendKeys(formattedDeliveryDate);	 	 

	}
	
	
	
	
	
	public void addToCartClick() {
		 WebElement addToCartWait;
			try {
				addToCartWait = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtnBy));
				 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addToCartWait);
				 
				 
				 try {
					addToCartWait.click();
					
				} catch (ElementClickInterceptedException e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartWait);
				}
			} catch (TimeoutException | NoSuchElementException e) {
				System.out.println("Button not found or clickable: " + e.getMessage());
			}
			
	}
	
	
	public WebElement successMessage() {
		wait.until(ExpectedConditions.visibilityOf(actualMessage));
		
		return  actualMessage;
		
	
	}
	
	
	
	public void addToWishListClick() {
		WebElement wishListProductWait;
		try {
			wishListProductWait = wait.until(ExpectedConditions.elementToBeClickable(wihListProductBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishListProductWait);
			 
			 
			 try {
				 wishListProductWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", wishListProductWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
		
		//wait.until(ExpectedConditions.elementToBeClickable(wishListProductWait));
		
	}
	
	
	
	public void goToCheckout() throws InterruptedException {
		WebElement checkOutIconWait;
		
		
		try {
			checkOutIconWait = wait.until(ExpectedConditions.elementToBeClickable(checkOutIconBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkOutIconWait);
			 Thread.sleep(500);
			 
			 
			 try {
				 checkOutIconWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkOutIconWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
		
	}
				 
				 
	}
	
	
	


