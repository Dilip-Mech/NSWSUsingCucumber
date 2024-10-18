package com.dilip.page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	//Webelement find 

	private static LoginPage loginInstance;

	private LoginPage () {

	}

	public static LoginPage  getInstance() {

		if(loginInstance==null) {
			loginInstance = new LoginPage();
		}
		return loginInstance;

	}


	@FindBy(xpath = "//div[@id='dsc-popup']/div/span")
	private WebElement popUp1;

	public WebElement getPopUp1() {


		return popUp1;
	}

	public WebElement getPopUp2() {

		return popUp2;
	}

	public WebElement getLoginMouseOver() {


		return loginMouseOver;
	}

	public WebElement getBussinessLogin() {

		return BussinessLogin;
	}

	public WebElement getUsername() {

		return Username;
	}

	public WebElement getPassword() {

		return Password;
	}

	public WebElement getLoginButton() {


		return LoginButton;
	}

	@FindBy(id = "close1-popup")
	private WebElement popUp2;

	@FindBy(id = "login-block")
	private WebElement loginMouseOver;

	@FindBy(linkText = "Business User Login")
	private WebElement BussinessLogin;

	@FindBy(id = "username")
	private WebElement Username;

	@FindBy(id = "userPassword")
	private WebElement Password;

	@FindBy(id = "kc-login")
	private WebElement LoginButton;

}
