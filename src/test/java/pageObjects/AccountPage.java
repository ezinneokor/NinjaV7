package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
	
	// Constructor
	
	public AccountPage(WebDriver driver){
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//h1[normalize-space()='My Account']")
	WebElement confirmationText_MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Affiliate']")  //Add Affiliate button
	WebElement affiliateBtn;
	private By affiliateBtnBy = By.xpath("//a[normalize-space()='Affiliate']");
	
	//For Log Out
	@FindBy(xpath = "//li[@class='list-inline-item']//i[@class='fa-solid fa-caret-down']")
	WebElement dropDown_MyAccount;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement link_Logout;
	
	
	
	//Action Methods
	public WebElement getMyAccountConfirmation() {
		return confirmationText_MyAccount;
	}
	
	public void clickMyAccountDropDown() {
		dropDown_MyAccount.click();
	}

	public void clickLogout() {
		link_Logout.click();
	}
	
	
	public void clickAffiliateBtn() {
		WebElement affiliateBtnWait;
		wait.until(ExpectedConditions.titleContains("My Account")); // Or any reliable logged-in check
		try {
			affiliateBtnWait = wait.until(ExpectedConditions.elementToBeClickable(affiliateBtnBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", affiliateBtnWait);
			 
			 
			 try {
				 affiliateBtnWait.click();
				
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", affiliateBtnWait);
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Button not found or clickable: " + e.getMessage());
		}
	}

}
