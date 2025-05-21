package pageObjects;

import java.time.Duration;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends BasePage{
	//Constructor
		public CheckOutPage(WebDriver driver){
			super(driver);
		}
		
	
	//Locators
	@FindBy(xpath="//strong[normalize-space()='login page']")  //Login page locator in the checkout page
	WebElement loginPageElement;
	private By loginPageElementBy = By.xpath("//strong[normalize-space()='login page']");
	
	
	@FindBy(xpath="//a[@title='Checkout']//i[@class='fa-solid fa-share']")  //checkout button locator in the checkout page
	WebElement checkOutBtn;
	private By checkOutBtnBy = By.xpath("//a[@title='Checkout']//i[@class='fa-solid fa-share']");
	
	
	@FindBy(xpath="//select[@id='input-shipping-address']")  //shipping address locator
	WebElement shippingAddress;
	private By shippingAddressBy = By.xpath("//select[@id='input-shipping-address']");
	
	
	@FindBy(xpath="//button[@id='button-shipping-methods']")  //shipping methods locator  
	WebElement shippingMethods;
	private By shippingMethodsBy = By.xpath("//button[@id='button-shipping-methods']");
	
	@FindBy(xpath="//button[@id='button-shipping-method']")  //shipping method locator
	WebElement shippingMethod;
	private By shippingMethodBy = By.xpath("//button[@id='button-shipping-method']");
	
	
	
	@FindBy(xpath="//button[@id='button-payment-methods']")  //payment methods locator
	WebElement paymentMethods;
	private By paymentMethodsBy = By.xpath("//button[@id='button-payment-methods']");
	
	@FindBy(xpath="//button[@id='button-payment-method']")  //payment method locator
	WebElement paymentMethod;
	private By paymentMethodBy = By.xpath("//button[@id='button-payment-method']");
	
	
	
	@FindBy(xpath="//button[@id='button-confirm']")  //confirmOrder btn locator
	WebElement confirmOderBtn;
	private By confirmOderBtnBy = By.xpath("//button[@id='button-confirm']");
	
	
	
	//Action Methods
	
	public void clickLoginPage() {
		WebElement loginPageElementWait;
		
		try {
			loginPageElementWait = wait.until(ExpectedConditions.elementToBeClickable(loginPageElementBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",loginPageElementWait);
			 
			 
			 try {
				 loginPageElementWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginPageElementWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
				
		
	}
	
	
	public void checkOutClick() {
		WebElement checkOutBtnWait;
		
		try {
			checkOutBtnWait = wait.until(ExpectedConditions.elementToBeClickable(checkOutBtnBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",checkOutBtnWait);
			 
			 
			 try {
				 checkOutBtnWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkOutBtnWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
	}
	
	
	public void clickShippingAddress() throws InterruptedException {
		WebElement addressDropDown;
		Thread.sleep(500);
		addressDropDown = wait.until(ExpectedConditions.elementToBeClickable(shippingAddressBy));
		Select select = new Select(addressDropDown);
		select.selectByIndex(1);
	}
	
	
	public void clickShippingMethod() {
		WebElement shippingMethodsWait;
		WebElement shippingMethodWait;
//		shippingMethodsWait = wait.until(ExpectedConditions.elementToBeClickable(shippingMethodsBy));
//		shippingMethodsWait.click();
//		shippingMethodWait = wait.until(ExpectedConditions.elementToBeClickable(shippingMethodBy));
//		shippingMethodWait.click();
		
		
		try {
			shippingMethodsWait = wait.until(ExpectedConditions.elementToBeClickable(shippingMethodsBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",shippingMethodsWait);
			 
			 
			 try {
				 shippingMethodsWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", shippingMethodsWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
		
		
		
		try {
			shippingMethodWait = wait.until(ExpectedConditions.elementToBeClickable(shippingMethodBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",shippingMethodWait);
			 
			 
			 try {
				 shippingMethodWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", shippingMethodWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
	}
	
	
	public void clickPaymentMethod() {
		WebElement paymentMethodsWait;
		WebElement paymentMethodWait;
//		paymentMethodsWait = wait.until(ExpectedConditions.elementToBeClickable(paymentMethodsBy));
//		paymentMethodsWait.click();
//		paymentMethodWait = wait.until(ExpectedConditions.elementToBeClickable(paymentMethodBy));
//		paymentMethodWait.click();
		
		
		try {
			paymentMethodsWait = wait.until(ExpectedConditions.elementToBeClickable(paymentMethodsBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",paymentMethodsWait);
			 
			 
			 try {
				 paymentMethodsWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",paymentMethodsWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
		
		
		
		
		try {
			paymentMethodWait = wait.until(ExpectedConditions.elementToBeClickable(paymentMethodBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",paymentMethodWait);
			 
			 
			 try {
				 paymentMethodWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", paymentMethodWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
	}
	
	
	public void clickConfirmOrder() {
		WebElement confirmOderBtnWait;
		try {
			confirmOderBtnWait = wait.until(ExpectedConditions.elementToBeClickable(confirmOderBtnBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",confirmOderBtnWait);
			 
			 
			 try {
				 confirmOderBtnWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmOderBtnWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
	}
	
	

}
