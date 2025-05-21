package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//Step1: Constructors
		WebDriver driver;
		//This is the constructor of the BasePage class. It takes a web driver object as an argument
		//which is used to interact with the browser
		WebDriverWait wait;
		
		public BasePage(WebDriver driver){
			this.driver = driver; //The passed driver is assigned to the instance variable driver. This allows
			//the class and its sub classes to use it for interactions.
			PageFactory.initElements(driver, this);   //This initializes the web elements defined in the class using
			//selenium's PageFactory.
			//The PageFactory.initElements() tells Selenium to scan the current class(this) for any @FindBy annotations
			//and connect them to actual elements on the page using the provided driver.
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}

}
