package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigateToPage extends CommonElementPage {

	@FindBy(xpath = "//span[contains(text(),'Admin')]")
	WebElement adminMenu;

	@FindBy(xpath = "//span[contains(text(),'Job')]")
	WebElement jobMenu;

	@FindBy(xpath = "//span[contains(text(),'Job Titles')]")
	WebElement jobTitles;

	@FindBy(xpath = "//span[contains(text(),'Components')]")
	WebElement salaryCompMenu;

	@FindBy(xpath = "//span[contains(text(),'Pay Grades')]")
	WebElement payGradesMenu;

	@FindBy(xpath = "//span[contains(text(),'Employment Status')]")
	WebElement employmentStatusMenu;

	@FindBy(xpath = "//span[contains(text(),'Job Categories')]")
	WebElement jobCategoriesMenu;

	public NavigateToPage() {
		PageFactory.initElements(driver, this);

	}

	public void navigateToJobTitles() {
		click(adminMenu);
		click(jobMenu);
		click(jobTitles);
	}

	public void navigateToSalaryComponents() {
		click(adminMenu);
		click(jobMenu);
		click(salaryCompMenu);
	}

	public void navigateToPayGrades() {
		click(adminMenu);
		click(jobMenu);
		click(payGradesMenu);
	}

	public void navigateToEmpStatus() {
		click(adminMenu);
		click(jobMenu);
		click(employmentStatusMenu);
	}

	public void navigateToJobCategories() {
		click(adminMenu);
		click(jobMenu);
		click(jobCategoriesMenu);
	}
}
