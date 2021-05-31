package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.ManagerPageUI;

public class ManagerPageObject extends BasePage{
	WebDriver driver;

	public ManagerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getWelcomeMessageText() {
		waitForElementVisible(driver, ManagerPageUI.WELCOME_MESSAGE);
		return getElementText(driver, ManagerPageUI.WELCOME_MESSAGE);		
	}

	public NewCustomerPageObject clickOnNewCustomerPage() {
		waitForElementClickable(driver, ManagerPageUI.NEW_CUSTOMER);
		clickToElement(driver, ManagerPageUI.NEW_CUSTOMER);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}
	
}
