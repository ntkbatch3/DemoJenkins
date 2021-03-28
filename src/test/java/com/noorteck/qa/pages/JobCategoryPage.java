package com.noorteck.qa.pages;

 
import org.openqa.selenium.support.PageFactory;

public class JobCategoryPage extends CommonElementPage {

	public JobCategoryPage() {
		PageFactory.initElements(driver, this);
	}

}
