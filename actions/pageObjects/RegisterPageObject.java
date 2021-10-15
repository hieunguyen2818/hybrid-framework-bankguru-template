package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUIs;

public class RegisterPageObject extends BasePage{
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailBox(WebDriver driver) {
		String email = getRandomEmail();
		waitForElementVisible(driver, RegisterPageUIs.EMAIL_BOX);
		sendKeyToElement(driver, RegisterPageUIs.EMAIL_BOX, email);
		
	}

	public void clickToSubmitEmail(WebDriver driver) {
		waitForElementClickable(driver, RegisterPageUIs.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUIs.SUBMIT_BUTTON);
	}

	public String getUserID(WebDriver driver) {
		waitForElementVisible(driver, RegisterPageUIs.USER_ID);
		return getElementText(driver, RegisterPageUIs.USER_ID);
	}

	public String getPassword(WebDriver driver) {
		waitForElementVisible(driver, RegisterPageUIs.PASSWORD);
		return getElementText(driver, RegisterPageUIs.PASSWORD);
	}
}
