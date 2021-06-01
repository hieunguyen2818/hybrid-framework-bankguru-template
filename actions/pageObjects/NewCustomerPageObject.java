package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import commons.BasePage;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage{
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToNameTextbox(String name) {
		waitForElementClickable(driver, NewCustomerPageUI.CUSTOMER_NAME_BOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_BOX, name);
		
	}
	
	public void clearNameBox(WebDriver driver) {
		driver.findElement(By.xpath(NewCustomerPageUI.CUSTOMER_NAME_BOX)).clear();
	}
	public void clearCityBox(WebDriver driver) {
		driver.findElement(By.xpath(NewCustomerPageUI.CITY_BOX)).clear();
	}
	
	public void clearStateBox(WebDriver driver) {
		driver.findElement(By.xpath(NewCustomerPageUI.STATE_BOX)).clear();
	}
	
	public void clearPINBox(WebDriver driver) {
		driver.findElement(By.xpath(NewCustomerPageUI.PIN_BOX)).clear();
	}
	
	public void clearMobileBox(WebDriver driver) {
		driver.findElement(By.xpath(NewCustomerPageUI.MOBILE_NO_BOX)).clear();
	}
	
	public void clearEmailBox(WebDriver driver) {
		driver.findElement(By.xpath(NewCustomerPageUI.EMAIL_BOX)).clear();
	}
	
	public void clearPasswordBox(WebDriver driver) {
		driver.findElement(By.xpath(NewCustomerPageUI.PASSWORD_BOX)).clear();
	}	
	
	public void inputToAdressTextArea(String adress) {
		waitForElementClickable(driver, NewCustomerPageUI.CUSTOMER_ADRESS_TEXT_AREA);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_ADRESS_TEXT_AREA, adress);
		
	}

	public void pressTabKey() {
		pressKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_BOX, Keys.TAB);
		
	}

	public String getNameErrorMessage() {
		waitForElementVisible(driver, NewCustomerPageUI.NAME_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerPageUI.NAME_ERROR_MESSAGE);
	}
	
	public String getAdressErrorMessage() {
		waitForElementVisible(driver, NewCustomerPageUI.ADRESS_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerPageUI.ADRESS_ERROR_MESSAGE);
	}

	public void inputToCityBox(String city) {
		waitForElementClickable(driver, NewCustomerPageUI.CITY_BOX);
		sendKeyToElement(driver, NewCustomerPageUI.CITY_BOX, city);
		
	}

	public String getCityErrorMessage() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
	}

	public void inputToStateField(String state) {
		waitForElementClickable(driver, NewCustomerPageUI.STATE_BOX);
		sendKeyToElement(driver, NewCustomerPageUI.STATE_BOX, state);		
	}
	
	public String getStateErrorMessage() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
	}
	
	public void inputToPINField(String pin) {
		waitForElementClickable(driver, NewCustomerPageUI.PIN_BOX);
		sendKeyToElement(driver, NewCustomerPageUI.PIN_BOX, pin);		
	}
	
	public String getPINErrorMessage() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
	}
	
	public void inputToMobileField(String mobile) {
		waitForElementClickable(driver, NewCustomerPageUI.MOBILE_NO_BOX);
		sendKeyToElement(driver, NewCustomerPageUI.MOBILE_NO_BOX, mobile);		
	}
	
	public String getMobileErrorMessage() {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerPageUI.MOBILE_ERROR_MESSAGE);
	}
	
	public void inputToEmailField(String email) {
		waitForElementClickable(driver, NewCustomerPageUI.EMAIL_BOX);
		sendKeyToElement(driver, NewCustomerPageUI.EMAIL_BOX, email);		
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void clearAdressTextArea(WebDriver driver) {
		driver.findElement(By.xpath(NewCustomerPageUI.CUSTOMER_ADRESS_TEXT_AREA)).clear();
		
	}
	
	
}
