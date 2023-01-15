package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CheckoutStepOnePage;
import Utility.ReadData;

public class CheckoutStepOnePageTest extends TestBase {
	CheckoutStepOnePage checkOutPageOne;

	@BeforeMethod
	public void setup() throws Exception {
		// To open browser enter URL and navigate to checkout page one
		initialization();
		checkoutPageOne();
		checkOutPageOne = new CheckoutStepOnePage();
	}

	@Test
	public void verifyErroeMessageTest() throws Exception {
		// To verify error message when click on continue without entering details
		String actual = checkOutPageOne.verifyErrorMessage();
		String expected = ReadData.excelData(12, 1);
		Assert.assertEquals(actual, expected);
		Reporter.log("Error message : " + actual);
	}

	@Test
	public void verifyCheckoutTitleTest() throws Exception {
//To verify Title of check out page one
		String actual = checkOutPageOne.verifyceckoutTitleText();
		String expected = ReadData.excelData(10, 1);
		Assert.assertEquals(actual, expected);
		Reporter.log("Title : " + actual);
	}

	@Test
	public void verifyEnteredFirstNameTest() throws Exception {
		// To verify firstName should be entered in firstName textBox
		String actual = checkOutPageOne.verifyEnteredFirstName();
		String expected = ReadData.excelData(6, 1);
		Assert.assertEquals(actual, expected);
		Reporter.log("Entered First Name : " + actual);
	}

	@Test
	public void verifyEnteredLastNameTest() throws Exception {
		// To verify lastName should be entered in lastName textBox
		String actual = checkOutPageOne.verifyEnteredLastName();
		String expected = ReadData.excelData(7, 1);
		Assert.assertEquals(actual, expected);
		Reporter.log("Entered Last Name : " + actual);
	}

	@Test
	public void verifyEnteredPostalCodeTest() throws Exception {
		// To verify postalCode should be entered in postalCode textBox
		String actual = checkOutPageOne.verifyEnteredPostalCode();
		String expected = ReadData.excelData(8, 1);
		Assert.assertEquals(actual, expected);
		Reporter.log("Entered Postal Code : " + actual);
	}

	@Test
	public void verifyCheckoutFunctionalityTest() throws Exception {
		// To verify user should navigate to checkout page when click on continue button
		// verify using URL
		String actual = checkOutPageOne.verifyCheckoutFunctionality();
		String expected = ReadData.excelData(14, 1);
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
