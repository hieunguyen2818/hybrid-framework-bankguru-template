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

public class TC_01_New_Customer extends BaseTest{
	
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
		managerPage = loginPage.clickToLoginButton();
		Assert.assertEquals(managerPage.getWelcomeMessageText(),"Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void NC_01_Name_Can_Not_Be_Empty() {
		newCustomerPage = managerPage.clickOnNewCustomerPage();
		newCustomerPage.inputToNameTextbox("");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getNameErrorMessage(),"Customer name must not be blank");
		
	}
	@Test
	public void NC_02_Name_Can_Not_Be_Numeric() {
		newCustomerPage.clearNameBox(driver);
		newCustomerPage.inputToNameTextbox("12345");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getNameErrorMessage(),"Numbers are not allowed");
		
	}
	@Test
	public void NC_03_Name_Cannot_have_special_characters() {
		newCustomerPage.clearNameBox(driver);
		newCustomerPage.inputToNameTextbox("@#$^&*****");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getNameErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_04_Name_Cannot_havefirstCharacter_asBlankSpace () {
		newCustomerPage.clearNameBox(driver);
		newCustomerPage.inputToNameTextbox(" hieunguyen");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getNameErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_05_Adress_Cannot_Be_Empty() {
		newCustomerPage.inputToAdressTextArea("");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getAdressErrorMessage(),"Address Field must not be blank");
	}
	@Test
	public void NC_06_Adress__havefirst_BlankSpace() {
		newCustomerPage.clearAdressTextArea(driver);
		newCustomerPage.inputToAdressTextArea(" Hanoi");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getAdressErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_07_City_Field_Cannot_Be_Empty() {
		newCustomerPage.clearCityBox(driver);
		newCustomerPage.inputToCityBox("");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getCityErrorMessage(),"City Field must not be blank");
	}
	@Test
	public void NC_08_City_Cannot_Be_Numeric() {
		newCustomerPage.clearCityBox(driver);
		newCustomerPage.inputToCityBox("12345678");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getCityErrorMessage(),"Numbers are not allowed");
	}
	@Test
	public void NC_09_City_Cannot_have_special_characters() {
		newCustomerPage.clearCityBox(driver);
		newCustomerPage.inputToCityBox("@#$%^&@@()");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getCityErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_10_City_Cannot_have_first_blankSpace () {
		newCustomerPage.clearCityBox(driver);
		newCustomerPage.inputToCityBox(" Hanoi");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getCityErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_11_State_Cannot_be_empty () {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToStateField("");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getStateErrorMessage(),"State must not be blank");
	}
	@Test
	public void NC_12_State_Cannot_be_numeric () {
		newCustomerPage.clearStateBox(driver);
		newCustomerPage.inputToStateField("12345678");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getStateErrorMessage(),"Numbers are not allowed");
	}
	@Test
	public void NC_13_State_Cannot_have_specialCharacters () {
		newCustomerPage.clearStateBox(driver);
		newCustomerPage.inputToStateField("@#$^@&@");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getStateErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_14_StateCannot_have_first_blankSpace() {
		newCustomerPage.clearStateBox(driver);
		newCustomerPage.inputToStateField(" California");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getStateErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_15_PIN_mustbe_numeric () {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToPINField("xdsdaasdwq");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getPINErrorMessage(),"Characters are not allowed");
	}
	@Test
	public void NC_16_PIN_cannot_be_empty () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField("");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getPINErrorMessage(),"PIN Code must not be blank");
	}
	@Test
	public void NC_17_PIN_must_have_6_digits () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField("1234");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getPINErrorMessage(),"PIN Code must have 6 Digits");
	}
	@Test
	public void NC_18_PIN_cannot_have_specialCharacters () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField("@#$%###@@@@");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getPINErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_19_PIN_cannot_have_first_blankSpace () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField(" 12345678");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getPINErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_20_PIN_cannot_have_blankSpace () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField("123 4567");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getPINErrorMessage(),"Characters are not allowed");
	}
	@Test
	public void NC_21_Telephone_Cannot_be_empty () {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToMobileField("");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getMobileErrorMessage(),"Mobile no must not be blank");
	}
	@Test
	public void NC_22_Telephone_Cannot_have_first_blankSpace () {
		newCustomerPage.clearMobileBox(driver);
		newCustomerPage.inputToMobileField(" 123567867");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getMobileErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_23_Telephone_Cannot_have_space () {
		newCustomerPage.clearMobileBox(driver);
		newCustomerPage.inputToMobileField("235 67867");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getMobileErrorMessage(),"Characters are not allowed");
	}
	@Test
	public void NC_24_Telephone_Cannot_have_special_Characters () {
		newCustomerPage.clearMobileBox(driver);
		newCustomerPage.inputToMobileField("@#@#@#@@@@@@@");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getMobileErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_25_Email_Cannot_be_empty () {
		newCustomerPage.clearEmailBox(driver);
		newCustomerPage.inputToEmailField("");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getEmailErrorMessage(),"Email-ID must not be blank");
	}
	@Test
	public void NC_26_Email_must_be_correct_format () {
		newCustomerPage.clearEmailBox(driver);
		newCustomerPage.inputToEmailField("123gmail.com");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getEmailErrorMessage(),"Email-ID is not valid");		
	}
	@Test
	public void NC_27_Email_Cannot_have_space () {
		newCustomerPage.clearEmailBox(driver);
		newCustomerPage.inputToEmailField("hh hh");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getEmailErrorMessage(),"Email-ID is not valid");	
	}
	@Test
	public void NC_28_Check_all_fields_label_as_requirement () {
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
