package com.dilip.webdriver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.dilip.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	
	public static WebDriver getDriver() {
		return driver;
	}
	private static WebDriver driver=null;
	
	private static Logger logger = LogManager.getLogger(DriverManager.class);

	public static void launchBrowser() {

		try {
			switch (Constants.Browser) {
			case "chrome": 
				WebDriverManager.chromedriver();
				logger.info("Launching"+Constants.Browser);
				driver = new ChromeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				logger.info("Launching"+Constants.Browser);
				driver = new FirefoxDriver();
				break;

			case "ie" :
				WebDriverManager.iedriver().setup();
				logger.info("Launching"+Constants.Browser);
				driver = new InternetExplorerDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver();
				logger.info("Launching"+Constants.Browser);
				driver = new EdgeDriver();
			default:

				WebDriverManager.chromedriver().setup();
				logger.info("Launching"+Constants.Browser);
				driver = new ChromeDriver();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
