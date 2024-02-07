package com.mystore.testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	// use all the reusable methods for the test cases for example url and browser needed for every tests
	ReadConfig rc = new ReadConfig();
	String url = rc.getBaseURL();
	String browser = rc.getBrowser();

	public static WebDriver driver;
	public static Logger log;

	@BeforeClass
	public void setUp() {
		//		String browser = "chrome";
		switch(browser.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			driver = null;
			break;

		}

		//wait for 10 seconds - implicit wait applicable for all the web elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

		//for logging 
		log = LogManager.getLogger("MyStoreV1");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}


}
