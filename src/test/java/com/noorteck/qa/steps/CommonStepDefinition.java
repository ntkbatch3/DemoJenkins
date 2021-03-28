package com.noorteck.qa.steps;

import com.noorteck.qa.utils.CommonUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepDefinition extends CommonUI {

	@Given("User is logged in to NTK application")
	public void loginToApp() {
		loginObj.login();
	}

	@When("User clicks Add Icon")
	public void clickAddIcon() {
		commonElObj.clickAddIcon();
	}

	@When("User clicks Edit Icon")
	public void clickEditIcon() {
		commonElObj.clickEditIcon();
	}

	@When("User clicks Cancel Button")
	public void clickCancelButton() {
		commonElObj.clickCancelButton();
	}

	@When("User clicks Save Button")
	public void clickSaveButton() {
		commonElObj.clickSaveButton();
	}

	@When("Application displays success message {string}")
	public void verifyDisplayMessage(String message) {

		System.out.println(commonElObj.getSuccessMessage());
	}

	@Given("Application displays Page Header {string}")
	public void verifyPageHeader(String header) {

		System.out.println(commonElObj.getPageTitle());

	}

}
