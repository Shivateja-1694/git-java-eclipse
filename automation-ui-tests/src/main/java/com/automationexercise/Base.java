package com.automationexercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Base {
	
    // Declare WebDriver so that it can be used by child test classes
	public WebDriver driver;

	 /**
     * This method sets up the browser before running each test.
     * It reads the browser name from config.properties and launches the browser accordingly.
     * It also maximizes the window, applies implicit wait, and navigates to the base URL.
     */

	@BeforeMethod
	public void setUp() {
		
        // Fetching browser type from configuration file (chrome, firefox, edge)
		String browser = ConfigReader.getProperty("browser");
        
        // Launching browser based on the config value
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup(); // Setup ChromeDriver binary
            driver = new ChromeDriver();			 // Launch Chrome
        } else if (browser.equalsIgnoreCase("firefox")) { 
            WebDriverManager.firefoxdriver().setup(); // Setup FirefoxDriver binary
            driver = new FirefoxDriver();		      // Launch Firefox
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();    // Setup EdgeDriver binary
            driver = new EdgeDriver();				  // Launch Edge
        } else {
            throw new RuntimeException("❌ Invalid browser in config.properties");
        }
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Apply implicit wait (in seconds) from Utility class
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.implicitWait));
       
        // Launch the base URL from config.properties
        driver.get(ConfigReader.getProperty("baseUrl"));
		
	}
	
    /**
     * This method quits the browser after the test is complete.
     * Always called in teardown phase to ensure browser is closed.
     */
	
	@AfterMethod
	public void tearDown() {
		
        if (driver != null) {
            driver.quit();
        }
	}

}
