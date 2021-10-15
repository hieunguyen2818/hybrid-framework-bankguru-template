package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;
	private static LoginPageObject loginPage;
	private static ManagerPageObject managerPage;
	private static NewCustomerPageObject newCustomerPage;
	private static EditCustomerPageObject editCustomerPage;
	private static DeleteCustomerPageObject deleteCustomerPage;
	private static RegisterPageObject registerPage;

	public PageGeneratorManager(WebDriver driver) {
		
	}
	
	public static LoginPageObject getLoginPage (WebDriver driver) {
		if(loginPage == null) {
			return new LoginPageObject(driver);
		}
		return loginPage;
	}

	public static ManagerPageObject getManagerPage (WebDriver driver) {
		if(managerPage == null) {
			return new ManagerPageObject(driver);
		}
		return managerPage;
	}
	
	public static NewCustomerPageObject getNewCustomerPage (WebDriver driver) {
		if(newCustomerPage == null) {
			return new NewCustomerPageObject(driver);
		}
		return newCustomerPage;
	}

	public static EditCustomerPageObject geEditCustomerPage (WebDriver driver) {
		if(editCustomerPage == null) {
			return new EditCustomerPageObject(driver);
		}
		return editCustomerPage;
	}

	public static DeleteCustomerPageObject getDeletePage (WebDriver driver) {
		if(deleteCustomerPage == null) {
		return new DeleteCustomerPageObject(driver);
	}
		return deleteCustomerPage;
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage == null) {
		return new RegisterPageObject(driver);
	}
		return registerPage;
	}
}
