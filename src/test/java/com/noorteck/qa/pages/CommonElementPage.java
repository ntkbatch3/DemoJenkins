package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.utils.CommonUI;

public class CommonElementPage extends CommonUI {

	@FindBy(xpath = "//*[@class='page-title']")
	WebElement pageHeader;

	@FindBy(xpath = "//*[contains(text(),'add')]")
	WebElement addIcon;

	@FindBy(xpath = "//*[contains(text(),'edit')]")
	WebElement editIcon;

	@FindBy(xpath = "//*[contains(text(),'Save')]")
	WebElement saveButton;

	@FindBy(xpath = "//*[contains(text(),'Cancel')]")
	WebElement cancelButton;

	@FindBy(xpath = "//*[contains(text(),'Successfully Saved')]")
	WebElement successMessage;

	@FindBy(id = "name")
	WebElement nameField;

	public CommonElementPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickAddIcon() {
		click(addIcon);
	}

	public void clickEditIcon() {
		click(editIcon);
	}
	
	public boolean isEditEnabled() {
		return isEnabled(editIcon);
	}

	public String getSuccessMessage() {
		return getText(successMessage);
	}

	public void clickSaveButton() {
		click(saveButton);
	}

	public void clickCancelButton() {
		click(cancelButton);
	}

	public String getPageTitle() {
		return getText(pageHeader);
	}

	public void enterName(String value) {
		enter(nameField, value);
	}
}
