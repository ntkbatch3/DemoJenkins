package com.noorteck.qa.utils;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUI extends Constants {

	/**
	 * This method takes 1 string parameter and opens the browser
	 * 
	 * @param browser
	 */
	public static void openBrowser(String browser) {
		try {
			switch (browser.toLowerCase()) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
			System.out.println("Browser has [" + browser + "] value. Make sure to pass [chrome/ie/firefox]");
			e.printStackTrace();
		}
	}

	/**
	 * This method takes 1 string parameter, it sets the implicit wait, maximizes
	 * page and navigates to the url
	 * 
	 * @param url
	 */
	public static void navigate(String url) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
		} catch (Exception e) {
			System.out.println("Check the url [" + url + "], make sure it contains correct format");
			e.printStackTrace();
		}

	}

	/**
	 * This method takes web element as argument and return boolean value (checks if
	 * element is displayed/not)
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isDisplayed(WebElement element) {

		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed: " + element);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method takes web element as argument and return boolean value (checks if
	 * element is enabled/not)
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isEnabled(WebElement element) {

		try {
			return element.isEnabled();
		} catch (NoSuchElementException e) {
			System.out.println("Element is does not exist, and it is not enabled: " + element);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method takes web element as argument and return boolean value (checks if
	 * element is selected/not)
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isSelected(WebElement element) {

		try {
			return element.isSelected();
		} catch (NoSuchElementException e) {
			System.out.println("Element is does not exist " + element);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method takes 1 webElement and performs click operation if element is
	 * displayed
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {

		if (isDisplayed(element)) {
			element.click();
		}
	}

	/**
	 * This method returns the web page title as String
	 * 
	 * @return
	 */

	public static String getTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("Driver instance is NULL");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method takes 1 web element param and return the element text as String
	 * 
	 * @param element
	 * @return
	 */
	public static String getText(WebElement element) {
		String text = null;

		if (isDisplayed(element)) {
			text = element.getText();
		}

		return text;
	}

	/**
	 * This method quits the browser
	 */
	public static void quitBrowser() {

		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Driver object is NULL");
			e.printStackTrace();
		}
	}

	public static void selectFromDropdown(WebElement element, String methodName, String indexTextValue) {
		try {

			Select obj = new Select(element);
			String methodStr = methodName.toLowerCase();

			if (methodStr.contains("index")) {

				int index = Integer.parseInt(indexTextValue);
				obj.selectByIndex(index);

			} else if (methodStr.contains("value")) {
				obj.selectByValue(indexTextValue);

			} else if (methodStr.contains("text")) {

				obj.selectByVisibleText(indexTextValue);
			} else {
				System.out.println(
						"Drop down can be selected only with [index, value, or text] check parameter passed matches");
			}

		} catch (Exception e) {
			System.out.println("Unable to find dropdown webelement:" + element);
			e.printStackTrace();
		}

	}

	/**
	 * This method takes two parameters and enter value to the text field
	 * 
	 * @param element
	 * @param value
	 */
	public static void enter(WebElement element, String value) {

		if (isDisplayed(element)) {
			element.clear();
			element.sendKeys(value);
		}

	}

	/**
	 * This method checks if alert is present or not. Returns boolean value
	 * 
	 * @return
	 */

	public static boolean isAlertPresent() {

		boolean isAlert = false;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				isAlert = true;
			}
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
			e.printStackTrace();
		}

		return isAlert;
	}

	/**
	 * This methods switchs to alert and accepts
	 */
	public static void acceptAlert() {

		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();

			alert.accept();
		}
	}

	/**
	 * This methods switchs to alert and declines
	 */
	public static void dismissAlert() {

		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}
	}

	/**
	 * This method takes two params, drags source and drops to target
	 * 
	 * @param source
	 * @param target
	 */

	public static void dragAndDrop(WebElement source, WebElement target) {
		try {

			Actions actions = new Actions(driver);
			actions.dragAndDrop(source, target).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method hovers over the element
	 * 
	 * @param element
	 */
	public static void moveToElement(WebElement element) {
		try {

			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method hovers over the element then clicks
	 * 
	 * @param element
	 */
	public static void moveToElementAndClick(WebElement element) {
		try {

			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will open a browser --> USE this as reference to compare
	 */

	public static void openBrowserOld(String browser) {
		String key = null;
		String path = null;
		try {
			switch (browser.toLowerCase()) {

			case "firefox":
				key = "webdriver.gecko.driver";
				path = "C:\\Users\\noort\\OneDrive - NoorTeck\\Desktop\\Selenium\\geckodriver.exe";
				System.setProperty(key, path);
				driver = new FirefoxDriver();
				break;
			case "ie":
				key = "webdriver.ie.driver";
				path = "C:\\Users\\noort\\OneDrive - NoorTeck\\Desktop\\Selenium\\iedriver.exe";
				System.setProperty(key, path);
				driver = new InternetExplorerDriver();
				break;

			default:
				key = "webdriver.chrome.driver";
				path = "C:\\Users\\noort\\OneDrive - NoorTeck\\Desktop\\Selenium\\chromedriver.exe";
				System.setProperty(key, path);
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
			System.out.println("Browser has [" + browser + "] value. Make sure to pass [chrome/ie/firefox]");
			e.printStackTrace();

		}

	}

	// Handle Iframe

	// Switch window

	// pop ups

}
