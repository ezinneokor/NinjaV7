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
import org.openqa.selenium.support.ui.WebDriverWait;

public class AffiliateCreationPage extends BasePage{
	
	       // Constructor
			public AffiliateCreationPage(WebDriver driver){
				super(driver);
			}
			
	
	
	//Locators
	@FindBy(xpath="//input[@id='input-company']")  //Add Affiliate name
	WebElement companyName;
	private By companyNameBy = By.xpath("//input[@id='input-company']");
	
	@FindBy(xpath="//input[@id='input-website']")  //Add Affiliate website
	WebElement companyWebsite;
	private By companyWebsiteBy = By.xpath("//input[@id='input-website']");
	
	@FindBy(xpath="//input[@id='input-tax']")  //Add Affiliate tax number
	WebElement companyTaxNum;
	private By companyTaxNumBy = By.xpath("//input[@id='input-tax']");

	
	@FindBy(xpath="//input[@id='input-payment-paypal']")  //Add Affiliate payment methods
	WebElement companyPaymentMethods;
	private By companyPaymentMethodsBy = By.xpath("//input[@id='input-payment-paypal']");
	
	
	@FindBy(xpath="//input[@id='input-paypal']")  //Add Affiliate payment method
	WebElement companyPaymentMethod;
	private By companyPaymentMethodBy = By.xpath("//input[@id='input-paypal']");
	
	
	@FindBy(xpath="//button[normalize-space()='Continue']")  //Continue button
	WebElement continueBtn;
	private By continueBtnBy = By.xpath("//button[normalize-space()='Continue']");
	
	
	//Action Methods
	public void addCompanyName(String companyNameInfo) {
		WebElement companyNameWait;
		companyNameWait = wait.until(ExpectedConditions.visibilityOfElementLocated(companyNameBy));
		companyNameWait.clear();
		companyNameWait.sendKeys(companyNameInfo);
		
	}
	
	public void addCompanyWebsite(String companyWebsiteInfo) {
		WebElement companyWebsiteWait;
		companyWebsiteWait = wait.until(ExpectedConditions.visibilityOfElementLocated(companyWebsiteBy));
		companyWebsiteWait.clear();
		companyWebsiteWait.sendKeys(companyWebsiteInfo);
		
	}
	
	
	public void addCompanyTax(String companyTaxInfo) {
		WebElement companyTaxNumWait;
		companyTaxNumWait = wait.until(ExpectedConditions.visibilityOfElementLocated(companyTaxNumBy));
		companyTaxNumWait.clear();
		companyTaxNumWait.sendKeys(companyTaxInfo);
		
	}
	
	
	public void clickPaymentMethods() {
		WebElement companyPaymentMethodsWait;
		
		
		try {
			companyPaymentMethodsWait = wait.until(ExpectedConditions.visibilityOfElementLocated(companyPaymentMethodsBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", companyPaymentMethodsWait);
			 
			 
			 try {
				 companyPaymentMethodsWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", companyPaymentMethodsWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
		
	}
	
	public void addPaymentMethod(String companyPaymentInfo) {
		WebElement companyPaymentMethodWait;
		companyPaymentMethodWait = wait.until(ExpectedConditions.visibilityOfElementLocated(companyPaymentMethodBy));
		companyPaymentMethodWait.clear();
		companyPaymentMethodWait.sendKeys(companyPaymentInfo);
		
	}
	
	
	public void clickContinueBtn() {
		WebElement continueBtnWait;
		
		
		try {
			continueBtnWait = wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtnBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtnWait);
			 
			 
			 try {
				 continueBtnWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtnWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
		
	}



}
