package com.bankguru.RegisterLogin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class TC_01_Register extends BaseTest{
	WebDriver driver;
	RegisterPageObject registerPage;
	public static String userId;
	public static String password;
	
	@Parameters ({"browser", "url"}) 
	@BeforeTest
	public void beforeTest(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl); 
	}
	
	@Test
	public void RG_01_Register_By_Email() {
	registerPage = PageGeneratorManager.getRegisterPage(driver);
	registerPage.enterToEmailBox(driver);
	registerPage.clickToSubmitEmail(driver);
	userId = registerPage.getUserID(driver);
	password = registerPage.getPassword(driver);
	
	}
	
	@AfterTest
	public void afterTest() {
		
	}
}
