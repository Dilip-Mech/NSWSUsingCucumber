package com.dilip.step_definition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.dilip.utilities.CommonUtils;
import com.dilip.webdriver_manager.DriverManager;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_def {

	public static String scenarioName=null;

	public static String getScenarioName() {

		return scenarioName;

	}

	private static final Logger LOGGER = LogManager.getLogger(Common_Step_def.class);


	@Before
	public void beforeScenario(Scenario scenario) {



		LOGGER.info("Execution Started");
		try {

			scenarioName = scenario.getName();
			LOGGER.info("Instation the COmmon Utils");

			LOGGER.info("Loding the Prop File");
			CommonUtils.getInstance().loadProperties(); 
			LOGGER.info("Checking the driver is null or not");
			if(DriverManager.getDriver()==null) {
				LOGGER.info("DRIVER is Null. Instanting is it!");
				DriverManager.launchBrowser();
				CommonUtils.getInstance().maximize();
				CommonUtils.getInstance().implicitWait();
				CommonUtils.getInstance().initWebelement();

			}


		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@AfterStep
	public void attachScreenShot(Scenario scenario) {

		if(scenario.isFailed()) {

			byte [] screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		
			scenario.attach(screenshotTaken, "image/png", "errorscreen");
			
		}

	}


}
