package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CheckoutStepTwoPage;
import Utility.ReadData;

public class CheckoutStepTwoPageTest extends TestBase {
	CheckoutStepTwoPage checkoutStepTwoPage;

	@BeforeMethod
	public void setup() throws Exception {
		// To call initialize method and login method from TestBase class
		initialization();
		checkoutPageTwo();
		checkoutStepTwoPage = new CheckoutStepTwoPage();

	}

	@Test
	public void verifyOverviewTitleTest() throws Exception {
		// To confirm Title
		String actual = checkoutStepTwoPage.verifyOverviewTitle();
		String expected = ReadData.excelData(16, 1);
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void verifyPaymentInformationTest() {
		// To conform Payment information
		boolean actual = checkoutStepTwoPage.verifyPaymentInformation();
		Assert.assertTrue(actual);
	}

	@Test
	public void verifyShipingInformationTest() {
		// To conform shipping information
		boolean actual = checkoutStepTwoPage.verifyShipingInformation();
		Assert.assertTrue(actual);
	}

	@Test
	public void verifyTotalPaymentTest() {
		// To confirm Total payment information
		boolean actual = checkoutStepTwoPage.verifyTotalPayment();
		Assert.assertTrue(actual);
	}

	@Test
	public void verifyTaxTest() {
		// To confirm Tax information
		boolean actual = checkoutStepTwoPage.verifyTax();
		Assert.assertTrue(actual);
	}

	@Test
	public void verifyFinishButtonNavigateToLastPage() throws Exception {
		// To verify after clicking on finish button navigate to last page using URL
		checkoutStepTwoPage.getFinishBtn();
		String actual = driver.getCurrentUrl();
		String expected = ReadData.excelData(19, 1);
		Assert.assertEquals(actual, expected);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
