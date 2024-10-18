package com.dilip.step_definition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.dilip.page_Objects.NSWS_Dashboard_Page;
import com.dilip.utilities.CommonUtils;
import com.dilip.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Verify_NSWS_Dashboard_step_def {

	Logger logger = LogManager.getLogger(Verify_NSWS_Dashboard_step_def.class);



	@Given("Click the Organisation name")
	public void click_the_organisation_name() {
		try {
			logger.info("Succesful on second Feature");
			System.out.println("Problem Solved");

			NSWS_Dashboard_Page.getInstance().getOrganisationName().click();
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}
	} 

	@Given("Click My Dashboard feature")
	public void click_my_dashboard_feature() {

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader-wrapper")));
			
			wait.until(ExpectedConditions.elementToBeClickable(NSWS_Dashboard_Page.getInstance().getDashboardFeatureClick())).click();
			
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}



	}

	@Then("Click Profile Feature")
	public void click_profile_feature() {

		try {
			NSWS_Dashboard_Page.getInstance().getClickProfileFeature().click();
			
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();
			Assert.fail(e.getMessage());
			
		
		}


	}
	
	@Then("Mouseover into Central Approvals")
	public void mouseover_into_central_approvals() {
	    
		try {
			logger.info("Mouse Over action to be peroming");
			CommonUtils.getInstance().actions(NSWS_Dashboard_Page.getInstance().getMouseOverCentralApprovals());
			
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}
	}
}
