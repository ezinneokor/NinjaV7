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

public class LaptopsNotebooksProductPage extends BasePage{
	
	
	//Constructor
	public LaptopsNotebooksProductPage(WebDriver driver){
		super(driver);
	}
	
	
	//Locators
	@FindBy(xpath="//a[normalize-space()='HP LP3065']")
	WebElement hpElement;
	
	private By hpElementBy = By.xpath("//a[normalize-space()='HP LP3065']");   //This is used for reload
		
	
	//Action Methods
	 public void clickHpProduct() {
		 WebElement hpElementWait;
		try {
			hpElementWait = wait.until(ExpectedConditions.elementToBeClickable(hpElementBy));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", hpElementWait);
			 
			 try {
				 hpElementWait.click();
	            } catch (ElementClickInterceptedException e) {
	            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", hpElementWait);
	            }
			 
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Product not found or clickable: " + e.getMessage());
			
		}
	     
	     
	     
	     
	     
	     
	     
	 }

}
