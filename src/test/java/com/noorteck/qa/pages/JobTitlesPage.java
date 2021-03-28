package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 
public class JobTitlesPage extends CommonElementPage {

	@FindBy(id = "jobTitleName")
	WebElement jobTitleNameField;

	@FindBy(id = "jobDescription")
	WebElement jobDescriptionField;

	@FindBy(id = "note")
	WebElement noteField;

	public JobTitlesPage() {
		PageFactory.initElements(driver, this);

	}

	public void enterJobTitleName(String jobTitle) {
		enter(jobTitleNameField, jobTitle);
	}

	public void enterJobDescription(String jobDescription) {
		enter(jobDescriptionField, jobDescription);
	}

	public void enterNote(String note) {
		enter(noteField, note);
	}
}
