package com.bankguru.Customer;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.LoginPageObject;
import pageObjects.ManagerPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC_02_Edit_Customer extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	DeleteCustomerPageObject deleteCustomerPage;
	
	@Parameters ({"browser", "url"}) 
	@BeforeTest
	public void beforeTest(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl); 
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterUserName("mngr330605");
		loginPage.enterPassword("pEtUtUg");
		Assert.assertEquals(managerPage.getWelcomeMessageText(),"Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void f() {
		
	}

	@AfterTest
	public void afterTest() {
		
	}

}
