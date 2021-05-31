package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPageObject;
import pageObjects.ManagerPageObject;
import pageObjects.PageGeneratorManager;


public class BaseTest {
	
	private WebDriver driver;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	
	private enum BROWSER {
		CHROME, FIREFOX, EDGE_CHOROMIUM, SAFARI;
	}
	
	public WebDriver getBrowserDriver(String browserName, String appUrl) {
		
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		
		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BROWSER.EDGE_CHOROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		driver.get(appUrl);
		
		return driver;
	}

	public void Login(String userID, String password) {
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterUserName(userID);
		loginPage.enterPassword(password);
		managerPage = loginPage.clickToLoginButton();
		Assert.assertEquals(managerPage.getWelcomeMessageText(),"Welcome To Manager's Page of Guru99 Bank");
	}

}
