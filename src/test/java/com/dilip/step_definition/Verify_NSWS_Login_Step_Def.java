package com.dilip.step_definition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import com.dilip.constants.Constants;
import com.dilip.page_Objects.LoginPage;
import com.dilip.utilities.CommonUtils;
import com.dilip.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Verify_NSWS_Login_Step_Def {

	Logger logger = LogManager.getLogger(Verify_NSWS_Login_Step_Def.class);



	@Given("User should landed into NSWS Home Page")
	public void user_should_landed_into_nsws_home_page() {
		try {

			DriverManager.getDriver().get(Constants.App_URL);

		}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();

		}

		logger.info("The User Landed NSWS Home Page");

	}

	@Given("Close the popup")
	public void close_the_popup() {
		try {

			LoginPage.getInstance().getPopUp1().click();
			LoginPage.getInstance().getPopUp2().click();
			logger.info("Pop are Closed");
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();

		}


	}

	@Given("Mouse over into the Login feature")
	public void mouse_over_into_the_login_feature() {

		try {
			Actions actions = new Actions(DriverManager.getDriver());

			actions.click(LoginPage.getInstance().getLoginMouseOver()).build().perform();

			logger.info("Mouse Over into Login Feature");

		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();

		}


	}

	@Given("click Bussiness user Login feature")
	public void click_bussiness_user_login_feature() {
		try {
			LoginPage.getInstance().getBussinessLogin().click();

			logger.info("Bussiness Login is Clicked");
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();

		}



	}

	@Given("Enter username and password")
	public void enter_username_and_password() {

		try {
			LoginPage.getInstance().getUsername().sendKeys(Constants.UserName);
			logger.info("UserName entered correctly");
			LoginPage.getInstance().getPassword().sendKeys(Constants.Password);
			logger.info("Password Entered Correctly");
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();
			Assert.fail();

		}



	}

	@Then("Click Sign in button")
	public void click_sign_in_button() {

		try {
			LoginPage.getInstance().getLoginButton().click();

			logger.info("The User Logged in Succesfully");
		} catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takeScreenShot();

		}


	}

}
