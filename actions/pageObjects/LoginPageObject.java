package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String userID) {
		waitForElementClickable(driver, LoginPageUI.USER_ID_INPUT_BOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_INPUT_BOX, userID);
		
	}

	public void enterPassword(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_INPUT_BOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_INPUT_BOX, password);
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
//		return PageGeneratorManager.getManagerPage(driver);
	}

}
