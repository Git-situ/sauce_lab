package TestCases;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;

public class InventoryPageTest extends TestBase {
	InventoryPage inventoryPage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		// To call initialization method and assign instance variable
		initialization();
		inventory();
		inventoryPage = new InventoryPage();
	}

	@Test
	public void verifyPeekLogoTest() {
		// To verify logo is present
		boolean actual = inventoryPage.verifyPeekLogo();
		Assert.assertTrue(actual);
	}

	@Test
	public void verifyproductTextTest() {
		// To verify Product text spelling
		String actual = inventoryPage.verifyProductText();
		String expected = "PRODUCTS";
		Assert.assertEquals(expected, actual);
		Reporter.log("Spelling of products text : " + actual);
	}

	@Test(groups = "regression")
	public void verifycartItems() {
		// To verify Item is added in cart
		inventoryPage.getAddtocartBag().click();
		inventoryPage.getCartLink().click();
		boolean actual = inventoryPage.getBagpack().isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(groups = "regression")
	public void verifyAtoZSortOption() {
		// To verify A to Z sorting option
		List<String> actual = inventoryPage.actualNamesAcordingToDropdownOptionSelected("az");
		List<String> expected = inventoryPage.alphabeticalOrderProductsNames();
		Assert.assertEquals(actual, expected);
		Reporter.log("Order of Items : " + actual);
	}

	@Test(groups = "regression")
	public void verifyZtoASortOption() {
		// To verify Z to A sorting option
		List<String> actual = inventoryPage.actualNamesAcordingToDropdownOptionSelected("za");
		List<String> expected = inventoryPage.alphabeticalOrderProductsNames();
		Collections.reverse(expected);// To change array list in reverse alphabetical order
		Assert.assertEquals(actual, expected);
		Reporter.log("Order of Items : " + actual);
	}

	@Test(groups = "regression")
	public void verifyLowToHighPriceSortOptionTest() {
		// To verify Low to High price option
		List<Double> actual = inventoryPage.actulPriceListAcordingToDropdownOptionSelected("lohi");
		List<Double> expected = inventoryPage.ascendingOrderPriceList();
		Assert.assertEquals(actual, expected);
		Reporter.log("Order of Items : " + actual);
	}

	@Test(groups = "regression")
	public void verifyHighToLowPriceSortOptionTest() {
		// To verify high to low price option
		List<Double> actual = inventoryPage.actulPriceListAcordingToDropdownOptionSelected("hilo");
		List<Double> expected = inventoryPage.ascendingOrderPriceList();
		Collections.reverse(expected);// to change array list in Descending order
		Assert.assertEquals(actual, expected);
		Reporter.log("Order of Items : " + actual);
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}

}
