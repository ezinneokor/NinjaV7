package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	    // Step 1: Constructor
	
	    public LoginPage(WebDriver driver) {
	        super(driver);
	    }

	    // Step 2: Locators
	    @FindBy(xpath = "//input[@id='input-email']")     //Email input field locator
	    private WebElement txt_Email;

	    @FindBy(xpath = "//input[@id='input-password']")    //Password input field locator
	    private WebElement txt_Password;

	    @FindBy(xpath = "//button[normalize-space()='Login']")   //Login button locator
	    private WebElement btn_Login;

	    private By btn_LoginBy = By.xpath("//button[normalize-space()='Login']");

	    // Step 3: Action Methods

	    public void setEmail(String email) {
	        wait.until(ExpectedConditions.visibilityOf(txt_Email)).sendKeys(email);
	    }

	    public void setPwd(String pwd) {
	        wait.until(ExpectedConditions.visibilityOf(txt_Password)).sendKeys(pwd);
	    }

	    public void click_Login() {
	        try {
	            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(btn_LoginBy));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", loginBtn);
	            try {
	                loginBtn.click();
	            } catch (ElementClickInterceptedException e) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
	            }
	        } catch (TimeoutException | NoSuchElementException e) {
	            System.out.println("Login button not found or clickable: " + e.getMessage());
	        }
	    }


}
