package com.dilip.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dilip.constants.Constants;
import com.dilip.page_Objects.LoginPage;
import com.dilip.page_Objects.NSWS_Dashboard_Page;
import com.dilip.step_definition.Common_Step_def;
import com.dilip.webdriver_manager.DriverManager;

public class CommonUtils {

	private static final Logger LOGGER = LogManager.getLogger(CommonUtils.getInstance());

	private static CommonUtils commonUtilsInstance=null;

	private CommonUtils() {

	}

	public static CommonUtils getInstance() {

		if(commonUtilsInstance==null) {

			commonUtilsInstance = new CommonUtils();
		}

		return commonUtilsInstance;

	}

	public void loadProperties() {

		Properties properties = new Properties();

		try {

			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}


		Constants.App_URL=	properties.getProperty("APP_URL");
		Constants.UserName=	properties.getProperty("UserName");
		Constants.Password=	properties.getProperty("Password");
		Constants.Browser=	properties.getProperty("Browser");
	}

	public void initWebelement() {

		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), NSWS_Dashboard_Page.getInstance());

	}

	public void implicitWait() {

		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void maximize() {

		DriverManager.getDriver().manage().window().maximize();
	}
	
	public void takeScreenShot() {

		TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
		File scourceFile = screenshot.getScreenshotAs(OutputType.FILE);

		File file = new File(Common_Step_def.getScenarioName()+".png");
		try {
			FileHandler.copy(scourceFile, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public void highlightElement(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();

		executor.executeScript("arguments[0].setAttribute('style',border: 3px solid blue)", element);
	}
	
	public void selectFromDropDown(WebElement dropDown, String howTo, String value) {

		Select select = new Select(dropDown);

		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;

		case "value":
			select.selectByValue(value);

			break;
		case "text":
			select.selectByVisibleText(value);
			break;

		default:
			LOGGER.info("Please provide the valid Selection in the feature file. Valid Selections are: text, value, index");
			break;
		}
	}

	public void actions(WebElement mouse) {

		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(mouse).build().perform();
	}

}
