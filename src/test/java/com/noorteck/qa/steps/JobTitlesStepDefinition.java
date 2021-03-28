package com.noorteck.qa.steps;

import java.util.List;
import java.util.Map;
import com.noorteck.qa.utils.CommonUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobTitlesStepDefinition extends CommonUI {
	
	
//	@When("User navigates to random page")
//	public void user_navigates_to_random_page() {
//		System.out.println("Helllloooo Form job title page");
//	}


	@When("User navigates to Job Titles Page")
	public void navToJobTitles() {
		navToPageObj.navigateToJobTitles();
	}

	@When("User enters {string}, {string}")
	public void enterJobTitleData(String title, String description) {

		jobTitlesObj.enterJobTitleName(title);
		jobTitlesObj.enterJobDescription(description);
	}

	@When("User enters job title data successfully")
	public void enterJobTitleData(DataTable dataTable) {

		// Convert the dataTable to List of Map
		List<Map<String, String>> listMap = dataTable.asMaps(String.class, String.class);

		System.out.println(listMap);
		
		// Convert the list of Map to a MAP
		for (Map<String, String> map : listMap) {
			jobTitlesObj.enterJobTitleName(map.get("JobTitle"));
			jobTitlesObj.enterJobDescription(map.get("JobDescription"));
		}
	}

	@Then("User verifies the Edit Icon is enabled")
	public void isEditIconEnabled() {
		System.out.println(jobTitlesObj.isEditEnabled());
	}
	
}
