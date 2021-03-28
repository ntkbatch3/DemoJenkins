package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 
public class SalaryComponentsPage extends CommonElementPage {

	@FindBy(xpath = "//label[contains(text(),'Deduction')]")
	WebElement deductionRadio;

	@FindBy(xpath = "//label[contains(text(),'Total Payable')]")
	WebElement totalPayableRadio;

	@FindBy(xpath = "//label[contains(text(),'Company')]")
	WebElement costToCompanyCheckbox;

	@FindBy(xpath = "//label[contains(text(),'Amount')]")
	WebElement amountCheckbox;

	@FindBy(xpath = "//label[contains(text(),'Percentage')]")
	WebElement percentageCheckbox;

	public SalaryComponentsPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterComponentName(String value) {
		enter(nameField, value);
	}

	public void clickDeductionRadio() {
		click(deductionRadio);
	}

	public void clickTotalPayRadio() {
		click(totalPayableRadio);
	}

	public void clickCostToCompCheckbox() {
		click(costToCompanyCheckbox);
	}

	public void clickAmountCheckbox() {
		click(amountCheckbox);
	}

	public void clickPercentageCheckbox() {
		click(percentageCheckbox);
	}

}
