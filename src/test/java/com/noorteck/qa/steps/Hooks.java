package com.noorteck.qa.steps;

import com.noorteck.qa.pages.CommonElementPage;
import com.noorteck.qa.pages.DashboardPage;
import com.noorteck.qa.pages.EmployementStatusPage;
import com.noorteck.qa.pages.JobCategoryPage;
import com.noorteck.qa.pages.JobTitlesPage;
import com.noorteck.qa.pages.LoginPage;
import com.noorteck.qa.pages.NavigateToPage;
import com.noorteck.qa.pages.PayGradesPage;
import com.noorteck.qa.pages.SalaryComponentsPage;
import com.noorteck.qa.utils.CommonUI;
import com.noorteck.qa.utils.ReadPropertyData;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonUI {

	@Before
	public void setUp(Scenario scenario) {
		System.out.println("Test Environment set up");
		System.out.println("Executing Test Scenario: [" + scenario.getName() + "]");

		prop = ReadPropertyData.getProperties(configFilePath);
		openBrowser(prop.getProperty("browser"));
		navigate(prop.getProperty("url"));
		initializeClassObj();

	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Finished Exeucting Test Scenario: [" + scenario.getName() + "]");

		quitBrowser();

	}

	public void initializeClassObj() {
		loginObj = new LoginPage();
		dashboardObj = new DashboardPage();
		jobTitlesObj = new JobTitlesPage();
		payGradesObj = new PayGradesPage();
		salaryCompObj = new SalaryComponentsPage();
		empStatusObj = new EmployementStatusPage();
		navToPageObj = new NavigateToPage();
		jobCategoryObj = new JobCategoryPage();
		commonElObj = new CommonElementPage();
	}
}
