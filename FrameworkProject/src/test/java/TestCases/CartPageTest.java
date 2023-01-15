package TestCases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Utility.ReadData;

public class CartPageTest extends TestBase {
	CartPage cartPage; // global variable

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		// To call initialization method and login method from TestBase class
		initialization();
		cart();
		cartPage = new CartPage();
	}

	@Test(groups = {"sanity", "regression"})
	public void verifyCartUrlTest() throws Exception {
		// To verify URL of cart page
		String actual = cartPage.verifyCartUrl();
		String expected = ReadData.excelData(5, 1);
		Assert.assertEquals(actual, expected);
	}

	@Test(groups = {"sanity", "regression"})
	public void verifyYourCartTextTest() {
		// To verify Your cart Text spelling
		String actual = cartPage.verifyYourCartText();
		Assert.assertEquals("YOUR CART", actual);
	}

	@Test(groups = {"sanity", "regression"})
	public void verifyItemsAddedInCartTest() {
		// To verify Items added in cart
		cartPage.addItemsInCart();
		boolean actual = cartPage.backPack.isDisplayed();
		boolean expected = cartPage.jacket.isDisplayed();
		Assert.assertEquals(actual, expected);
	}

	@Test(groups = {"sanity", "regression"})
	public void verifyCountOfCartTest() {
		// verify count of cart items
		String actual = cartPage.verifyCountOfCart();
		Assert.assertEquals(actual, "2");
	}

	@Test(groups = {"sanity", "regression"})
	public void verifyItemsRemoverdFromCartTest() {
		// To verify Item removed from Cart
		cartPage.addItemsInCart();
		cartPage.backPackRemoveToCartBtn.click();
		/* As we removed element so we get NoSuchElementException */
		try {

			cartPage.backPack.isDisplayed();
			Assert.assertTrue(false);

		} catch (NoSuchElementException e) {
			/* if this exception occurs means element is removed from cart */
			Assert.assertTrue(true);
		}
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
