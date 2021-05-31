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
		Login("mngr330605", "pEtUtUg");		
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
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToNameTextbox("12345");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getNameErrorMessage(),"Numbers are not allowed");
		
	}
	@Test
	public void NC_03_Name_Cannot_have_special_characters() {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToNameTextbox("@#$^&*****");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getNameErrorMessage(),"Special characters are not allowed");
	}
	@Test
	public void NC_04_Name_Cannot_havefirstCharacter_asBlankSpace () {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToNameTextbox(" hieunguyen");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getNameErrorMessage(),"First character can not have space");
	}
	@Test
	public void NC_05_Adress_Cannot_Be_Empty() {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToAdressTextArea("");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getAdressErrorMessage(),"Address Field must not be blank");
	}
	@Test
	public void NC_06_Adress__havefirst_BlankSpace() {
		newCustomerPage.refreshCurrenPage(driver);
		newCustomerPage.inputToAdressTextArea(" Hanoi");
		newCustomerPage.pressTabKey();
		Assert.assertEquals(newCustomerPage.getAdressErrorMessage(),"Address Field must not be blank");
	}
	@Test
	public void NC_07_City_Field_Cannot_Be_Empty() {
		
	}
	@Test
	public void NC_08_City_Cannot_Be_Numeric() {
		
	}
	@Test
	public void NC_09_City_Cannot_have_special_characters() {
		
	}
	@Test
	public void NC_10_City_Cannot_have_first_blankSpace () {
		
	}
	@Test
	public void NC_11_State_Cannot_be_empty () {
		
	}
	@Test
	public void NC_12_State_Cannot_be_numeric () {
		
	}
	@Test
	public void NC_13_State_Cannot_have_specialCharacters () {
		
	}
	@Test
	public void NC_14_City_Cannot_have_first_blankSpace() {
		
	}
	@Test
	public void NC_15_PIN_mustbe_numeric () {
		
	}
	@Test
	public void NC_16_PIN_cannot_be_empty () {
		
	}
	@Test
	public void NC_17_PIN_must_have_6_digits () {
		
	}
	@Test
	public void NC_18_PIN_cannot_have_specialCharacters () {
		
	}
	@Test
	public void NC_19_PIN_cannot_have_first_blankSpace () {
		
	}
	@Test
	public void NC_20_PIN_cannot_have_blankSpace () {
		
	}
	@Test
	public void NC_21_Telephone_Cannot_be_empty () {
		
	}
	@Test
	public void NC_22_Telephone_Cannot_have_first_blankSpace () {
		
	}
	@Test
	public void NC_23_Telephone_Cannot_have_space () {
		
	}
	@Test
	public void NC_24_Telephone_Cannot_have_special_Characters () {
		
	}
	@Test
	public void NC_25_Email_Cannot_be_empty () {
		
	}
	@Test
	public void NC_26_Email_must_be_correct_format () {
		
	}
	@Test
	public void NC_27_Email_Cannot_have_space () {
		
	}
	@Test
	public void NC_28_Check_all_fields_label_as_requirement () {
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
