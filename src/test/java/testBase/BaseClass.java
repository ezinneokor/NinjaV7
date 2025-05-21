package testBase;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public Properties p;
    public static Logger logger = LogManager.getLogger(BaseClass.class);

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeClass(groups = {"sanity", "regression", "datadriven"})
    @Parameters({"os", "browser"})
    public void openApp(String os, String br) {
        logger.info("==== Starting openApp ====");
        logger.info("Operating System: " + os + ", Browser: " + br);

        WebDriver localDriver = null;

        try {
            FileReader file = new FileReader(".//src//test//resources//config.properties");
            p = new Properties();
            p.load(file);
            logger.debug("Loaded config.properties successfully.");
        } catch (IOException e) {
            logger.error("Error loading config.properties file", e);
            return;
        }

        try {
        	
        	
        	if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();

				// os
				if (os.equalsIgnoreCase("windows")) {
					capabilities.setPlatform(Platform.WIN11);
				} else if (os.equalsIgnoreCase("mac")) {
					capabilities.setPlatform(Platform.MAC);
				} else {
					System.out.println("No matching os");
					return;
				}

				String gridURL = "http://localhost:4444/wd/hub"; // Update if needed
				//String gridURL = "http://192.168.86.36:4444/wd/hub"; // this will also work
				

				switch (br.toLowerCase()) {
				case "chrome":
					ChromeOptions chromeOptions = new ChromeOptions();
					localDriver = new RemoteWebDriver(URI.create(gridURL).toURL(), chromeOptions.merge(capabilities));
					break;

				case "firefox":
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					localDriver = new RemoteWebDriver(URI.create(gridURL).toURL(), firefoxOptions.merge(capabilities));
					break;

				case "edge":
					EdgeOptions edgeOptions = new EdgeOptions();
					localDriver = new RemoteWebDriver(URI.create(gridURL).toURL(), edgeOptions.merge(capabilities));
					break;

				default:
					logger.error("No matching browser found: {}", br);
					return;
				}

			}
			
			
			
			
			
			if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
        	
        	
            switch (br.toLowerCase()) {
                case "chrome":
                    logger.info("Launching Chrome browser.");
                    localDriver = new ChromeDriver();
                    break;
                case "edge":
                    logger.info("Launching Edge browser.");
                    localDriver = new EdgeDriver();
                    break;
                case "firefox":
                    logger.info("Launching Firefox browser.");
                    localDriver = new FirefoxDriver();
                    break;
                default:
                    logger.error("Invalid browser specified: " + br);
                    return;
            }
			}

            driver.set(localDriver);
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            getDriver().manage().window().maximize();
            getDriver().get(p.getProperty("appURL"));
            logger.info("Navigated to application URL: " + p.getProperty("appURL"));

        } catch (Exception e) {
            logger.error("Error occurred while setting up the browser and navigating to the URL", e);
        }
    }

    @AfterClass(groups = {"sanity", "regression", "datadriven"})
    public void closeApp() {
        logger.info("==== Starting closeApp ====");
        try {
            getDriver().quit();
            logger.info("Browser closed successfully.");
        } catch (Exception e) {
            logger.error("Error while closing the browser", e);
        }
    }

    public String captureScreen(String tname) {
        logger.info("Capturing screenshot for: " + tname);
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String targetFilePath = null;

        try {
            File sourceFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
            File targetFile = new File(targetFilePath);
            sourceFile.renameTo(targetFile);
            logger.info("Screenshot saved to: " + targetFilePath);
        } catch (Exception e) {
            logger.error("Failed to capture screenshot for: " + tname, e);
        }

        return targetFilePath;
    }
}
