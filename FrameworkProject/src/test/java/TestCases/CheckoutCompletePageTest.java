package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CheckoutCompletePage;
import Utility.ReadData;

public class CheckoutCompletePageTest extends TestBase {
	CheckoutCompletePage checkoutCompletePage;

	@BeforeMethod
	public void setup() throws Exception {
		// To call initialize method and to navigate to last page
		initialization();
		checkoutComplete();
		checkoutCompletePage = new CheckoutCompletePage();
	}

	@Test
	public void verifyPonyExpressLogoTest() {
		// To verify logo
		boolean actual = checkoutCompletePage.verifyPonyExpressLogo();
		Assert.assertTrue(actual);
	}

	@Test
	public void verifyCheckoutCompleteTitleTest() throws Exception {
		// To verify Title
		String actual = checkoutCompletePage.getCheckoutCompleteTitle();
		String expected = ReadData.excelData(17, 1);
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void verifyThankYouTextElementTest() throws Exception {
		// To verify Thank You text
		String actual = checkoutCompletePage.getThankYouTextElement();
		String expected = ReadData.excelData(18, 1);
		Assert.assertEquals(actual, expected);
		Reporter.log("Thank you text: " + actual);
	}

	@Test
	public void verifyBackToHomeButtonFunctionalityTest() throws Exception {
		// To verify Back to home button navigate to inventory page
		String actual = checkoutCompletePage.verifyBackToHomeButtonFunctionality();
		String expected = ReadData.excelData(4, 1);
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
