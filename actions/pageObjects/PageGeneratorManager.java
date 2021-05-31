package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;
	private static LoginPageObject loginPage;
	private static ManagerPageObject managerPage;
	private static NewCustomerPageObject newCustomerPage;
	private static EditCustomerPageObject editCustomerPage;
	private static DeleteCustomerPageObject deleteCustomerPage;

	public PageGeneratorManager(WebDriver driver) {
		
	}
	
	public LoginPageObject getLoginPage (WebDriver driver) {
		if(loginPage == null) {
			return new LoginPageObject(driver);
		}
		return loginPage;
	}

	public ManagerPageObject managerPage (WebDriver driver) {
		if(managerPage == null) {
			return new ManagerPageObject(driver);
		}
		return managerPage;
	}
	
	public NewCustomerPageObject getNewCustomerPage (WebDriver driver) {
		if(newCustomerPage == null) {
			return new NewCustomerPageObject(driver);
		}
		return newCustomerPage;
	}

	public EditCustomerPageObject geEditCustomerPage (WebDriver driver) {
		if(editCustomerPage == null) {
			return new EditCustomerPageObject(driver);
		}
		return editCustomerPage;
	}

	public DeleteCustomerPageObject getDeletePage (WebDriver driver) {
		if(deleteCustomerPage == null) {
		return new DeleteCustomerPageObject(driver);
	}
		return deleteCustomerPage;
	}
}
