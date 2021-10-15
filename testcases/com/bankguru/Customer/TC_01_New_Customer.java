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
		log.info("Precondition: Step 1 init browser "+ browserName);
		driver = getBrowserDriver(browserName, appUrl); 
		
		log.info("Precondition: Step 2 - Login to app");
		Login(driver);
		managerPage = PageGeneratorManager.getManagerPage(driver);
	}

	@Test
	public void NC_01_Name_Can_Not_Be_Empty() {
		log.info("TC_01: Step 1 - Click on New Customer Page");
		newCustomerPage = managerPage.clickOnNewCustomerPage();
		
		log.info("TC_01: Step 2 - Input empty to Name Textbox");
		newCustomerPage.inputToNameTextbox("");
		
		log.info("TC_01: Step 3 - Press Tab key");
		newCustomerPage.pressTabKey();
		
		log.info("TC_01: Step 4 - Verify message display correctly");
		verifyEquals(newCustomerPage.getNameErrorMessage(),"Customer name must not be blank");
		
	}
	@Test
	public void NC_02_Name_Can_Not_Be_Numeric() {
		log.info("TC_02: Step 1 - Clear Name Textbox");
		newCustomerPage.clearNameBox(driver);
		
		log.info("TC_02: Step 2 - Input to Name Textbox with number");
		newCustomerPage.inputToNameTextbox("12345");
		
		log.info("TC_02: Step 3 - Press Tab key");
		newCustomerPage.pressTabKey();
		
		log.info("TC_02: Step 4 - Verify message display correctly");
		verifyEquals(newCustomerPage.getNameErrorMessage(),"Numbers are not allowed");
		
	}
	@Test
	public void NC_03_Name_Cannot_have_special_characters() {
		log.info("TC_03: Step 1 - Clear Name Textbox");
		newCustomerPage.clearNameBox(driver);
		
		log.info("TC_03: Step 2 - Input to Name Textbox with special characters");
		newCustomerPage.inputToNameTextbox("@#$^&*****");
		
		log.info("TC_03: Step 3 - Press Tab key");
		newCustomerPage.pressTabKey();
		
		log.info("TC_03: Step 4 - Verify message display correctly");
		verifyEquals(newCustomerPage.getNameErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_04_Name_Cannot_havefirstCharacter_asBlankSpace () {
		log.info("TC_04: Step 1 - Clear Name Textbox");
		newCustomerPage.clearNameBox(driver);
		
		log.info("TC_04: Step 2 - Input to Name Textbox with first characters is space");
		newCustomerPage.inputToNameTextbox(" hieunguyen");
		
		log.info("TC_04: Step 3 - Press Tab key");
		newCustomerPage.pressTabKey();
		
		log.info("TC_04: Step 4 - Verify message display correctly");
		verifyEquals(newCustomerPage.getNameErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_05_Adress_Cannot_Be_Empty() {
		log.info("TC_05: Step 1 - Input to TextArea with space");
		newCustomerPage.inputToAdressTextArea("");
		
		log.info("TC_04: Step 2 - Press Tab key");
		newCustomerPage.pressTabKey();
		
		log.info("TC_05: Step 3 - Verify message display correctly");
		verifyEquals(newCustomerPage.getAdressErrorMessage(),"Address Field must not be blank");
	}
	@Test
	public void NC_06_Adress__havefirst_BlankSpace() {
		log.info("TC_06: Step 1 - Clear Adress Text area");
		newCustomerPage.clearAdressTextArea(driver);
		
		log.info("TC_06: Step 2 - Input to Adress Text area with first characters is space");
		newCustomerPage.inputToAdressTextArea(" Hanoi");
		
		log.info("TC_06: Step 3 - Press Tab key");
		newCustomerPage.pressTabKey();
		
		log.info("TC_06: Step 4 - Verify message display correctly");
		verifyEquals(newCustomerPage.getAdressErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_07_City_Field_Cannot_Be_Empty() {
		log.info("TC_07: Step 1 - Clear City Textbox");
		newCustomerPage.clearCityBox(driver);
		
		log.info("TC_07: Step 2 - Input to City Textbox with space");
		newCustomerPage.inputToCityBox("");
		
		log.info("TC_07: Step 3 - Press Tab key");
		newCustomerPage.pressTabKey();
		
		log.info("TC_07: Step 4 - Verify message display correctly");
		verifyEquals(newCustomerPage.getCityErrorMessage(),"City Field must not be blank");
	}
	@Test
	public void NC_08_City_Cannot_Be_Numeric() {
		newCustomerPage.clearCityBox(driver);
		newCustomerPage.inputToCityBox("12345678");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getCityErrorMessage(),"Numbers are not allowed");
	}
	@Test
	public void NC_09_City_Cannot_have_special_characters() {
		newCustomerPage.clearCityBox(driver);
		newCustomerPage.inputToCityBox("@#$%^&@@()");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getCityErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_10_City_Cannot_have_first_blankSpace () {
		newCustomerPage.clearCityBox(driver);
		newCustomerPage.inputToCityBox(" Hanoi");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getCityErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_11_State_Cannot_be_empty () {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToStateField("");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getStateErrorMessage(),"State must not be blank");
	}
	@Test
	public void NC_12_State_Cannot_be_numeric () {
		newCustomerPage.clearStateBox(driver);
		newCustomerPage.inputToStateField("12345678");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getStateErrorMessage(),"Numbers are not allowed");
	}
	@Test
	public void NC_13_State_Cannot_have_specialCharacters () {
		newCustomerPage.clearStateBox(driver);
		newCustomerPage.inputToStateField("@#$^@&@");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getStateErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_14_StateCannot_have_first_blankSpace() {
		newCustomerPage.clearStateBox(driver);
		newCustomerPage.inputToStateField(" California");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getStateErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_15_PIN_mustbe_numeric () {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToPINField("xdsdaasdwq");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getPINErrorMessage(),"Characters are not allowed");
	}
	@Test
	public void NC_16_PIN_cannot_be_empty () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField("");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getPINErrorMessage(),"PIN Code must not be blank");
	}
	@Test
	public void NC_17_PIN_must_have_6_digits () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField("1234");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getPINErrorMessage(),"PIN Code must have 6 Digits");
	}
	@Test
	public void NC_18_PIN_cannot_have_specialCharacters () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField("@#$%###@@@@");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getPINErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_19_PIN_cannot_have_first_blankSpace () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField(" 12345678");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getPINErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_20_PIN_cannot_have_blankSpace () {
		newCustomerPage.clearPINBox(driver);
		newCustomerPage.inputToPINField("123 4567");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getPINErrorMessage(),"Characters are not allowed");
	}
	@Test
	public void NC_21_Telephone_Cannot_be_empty () {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToMobileField("");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getMobileErrorMessage(),"Mobile no must not be blank");
	}
	@Test
	public void NC_22_Telephone_Cannot_have_first_blankSpace () {
		newCustomerPage.clearMobileBox(driver);
		newCustomerPage.inputToMobileField(" 123567867");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getMobileErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_23_Telephone_Cannot_have_space () {
		newCustomerPage.clearMobileBox(driver);
		newCustomerPage.inputToMobileField("235 67867");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getMobileErrorMessage(),"Characters are not allowed");
	}
	@Test
	public void NC_24_Telephone_Cannot_have_special_Characters () {
		newCustomerPage.clearMobileBox(driver);
		newCustomerPage.inputToMobileField("@#@#@#@@@@@@@");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getMobileErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_25_Email_Cannot_be_empty () {
		newCustomerPage.clearEmailBox(driver);
		newCustomerPage.inputToEmailField("");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getEmailErrorMessage(),"Email-ID must not be blank");
	}
	@Test
	public void NC_26_Email_must_be_correct_format () {
		newCustomerPage.clearEmailBox(driver);
		newCustomerPage.inputToEmailField("123gmail.com");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getEmailErrorMessage(),"Email-ID is not valid");		
	}
	@Test
	public void NC_27_Email_Cannot_have_space () {
		newCustomerPage.clearEmailBox(driver);
		newCustomerPage.inputToEmailField("hh hh");
		newCustomerPage.pressTabKey();
		verifyEquals(newCustomerPage.getEmailErrorMessage(),"Email-ID is not valid");	
	}
	@Test
	public void NC_28_Check_all_fields_label_as_requirement () {		
		verifyEquals(newCustomerPage.getLabelText("name"), "Customer Name");
		verifyEquals(newCustomerPage.getLabelText("rad1"), "Gender");
		verifyEquals(newCustomerPage.getLabelText("dob"), "Date of Birth");
		verifyEquals(newCustomerPage.getAdressLabelText("addr"), "Address");
		verifyEquals(newCustomerPage.getLabelText("city"), "City");
		verifyEquals(newCustomerPage.getLabelText("state"), "State");
		verifyEquals(newCustomerPage.getLabelText("pinno"), "PIN");
		verifyEquals(newCustomerPage.getLabelText("telephoneno"), "Mobile Number");
		verifyEquals(newCustomerPage.getLabelText("emailid"), "E-mail");
		verifyEquals(newCustomerPage.getLabelText("password"), "Password");
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
