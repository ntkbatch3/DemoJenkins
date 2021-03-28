package com.noorteck.qa.utils;




import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.noorteck.qa.pages.CommonElementPage;
import com.noorteck.qa.pages.DashboardPage;
import com.noorteck.qa.pages.EmployementStatusPage;
import com.noorteck.qa.pages.JobCategoryPage;
import com.noorteck.qa.pages.JobTitlesPage;
import com.noorteck.qa.pages.LoginPage;
import com.noorteck.qa.pages.NavigateToPage;
import com.noorteck.qa.pages.PayGradesPage;
import com.noorteck.qa.pages.SalaryComponentsPage;




/**
 * This class will store all the OBJECTS declarations shared among all the
 * classes
 * 
 * @author noort
 *
 */
public class Constants {

	public static WebDriver driver;
	public static Properties prop;

	public static String configFilePath = "./src/test/resources/configs/configs.properties";

 
	// Create object for each Webpage class
	public static LoginPage loginObj;
	public static DashboardPage dashboardObj;
	public static JobTitlesPage jobTitlesObj;
	public static PayGradesPage payGradesObj;
	public static SalaryComponentsPage salaryCompObj;
	public static EmployementStatusPage empStatusObj;
	public static NavigateToPage navToPageObj;

	public static JobCategoryPage jobCategoryObj;
	public static CommonElementPage commonElObj;

		
	//Create Web API objects	
	public static Map<String, String> headerMap = new HashMap<String, String>();
	public static Map<String, String> queryParamMap = new HashMap<String, String>();
	public static Map<String, String> apiDataMap = new HashMap<String, String>();


	


}
