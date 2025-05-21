package pageObjects;

import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	//constructor
	//HomePage is a subclass of BasePage
	//When a HomePage object is created, it needs WebDriver instance to work with
	//super(driver) is a call to the constructor of the parent class(BasePage), passing along the webDriver.
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	
	
	//Step2: Locators
	@FindBy(xpath="//i[@class='fa-solid fa-user']")    //Account link locator
	WebElement link_Account;
	
	@FindBy(xpath="//a[normalize-space()='Login']")     //login link locator
	WebElement link_Login;
	
	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")  //laptop & Notebook link
	WebElement laptopNotebook_Link;
	
	@FindBy(xpath = "//a[normalize-space()='Show All Laptops & Notebooks']")  //show all laptops and notebooks
	WebElement showAllLaptopNotebook_Link;
			
	
	
	//Step3: Action Methods
	public void clickMyAccount() {
		link_Account.click();
	}
	
	public void goTologin() {
		link_Login.click();
	}
	
	public void clickLaptopNotebook() {
		laptopNotebook_Link.click();
	}
	
	public void clickshowAllLaptopNotebook() {
		showAllLaptopNotebook_Link.click();
	}

}
