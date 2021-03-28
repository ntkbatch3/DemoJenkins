package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.utils.CommonUI;

public class LoginPage extends CommonElementPage {

	@FindBy(id = "txtUsername")
	WebElement userNameField;

	@FindBy(id = "txtPassword")
	WebElement passwordField;

	@FindBy(name = "Submit")
	WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(CommonUI.driver, this);
	}

	public void login() {		
		enter(userNameField, prop.getProperty("username"));	
		enter(passwordField, prop.getProperty("password"));	
		click(loginButton); 
	}

}
