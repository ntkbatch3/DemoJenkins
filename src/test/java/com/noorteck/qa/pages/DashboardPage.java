package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.utils.CommonUI;

public class DashboardPage extends CommonElementPage {

	@FindBy(xpath = "//li[@class='page-title']")
	WebElement dashboardTitle;

	@FindBy(id = "account-name")
	WebElement accountName;

	@FindBy(xpath = "//i[@class='material-icons']")
	WebElement userMenuDropdown;

	@FindBy(id = "logoutLink")
	WebElement logoutOption;


	public DashboardPage() {
		PageFactory.initElements(CommonUI.driver, this);
	}

	public String getDashboardTitle() {
		return getText(dashboardTitle);
	}

	public String getAccountName() {
		return getText(accountName);
	}

	public void clickUserMenuDropdown() {
		click(userMenuDropdown);
	}

	public void clickLogOutOption() {
		click(logoutOption);
	}
}
