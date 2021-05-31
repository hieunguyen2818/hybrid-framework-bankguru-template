package pageObjects;

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
	
	
}
