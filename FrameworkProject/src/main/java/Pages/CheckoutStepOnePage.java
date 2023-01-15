package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class CheckoutStepOnePage extends TestBase {
	CartPage cartPage;
	InventoryPage inventoryPage;
	@FindBy(className = "title")
	private WebElement checkoutTitle;
	@FindBy(id = "cancel")
	private WebElement cancelBtn;
	@FindBy(id = "continue")
	private WebElement continueBtn;
	@FindBy(id = "first-name")
	private WebElement firstNameTextbox;
	@FindBy(id = "last-name")
	private WebElement lastNameTextbox;
	@FindBy(id = "postal-code")
	private WebElement postalCodeTextbox;
	@FindBy(css = ".error-message-container.error")
	private WebElement errorMessage;

	public CheckoutStepOnePage() {
		// constructor to initialize driver with instance variables
		PageFactory.initElements(driver, this);
		inventoryPage = new InventoryPage();
		cartPage = new CartPage();
	}

	public String verifyceckoutTitleText() {
		// To verify Title of checkOut page one
		return checkoutTitle.getText();
	}

	public String verifyErrorMessage() {
		// To verify Error Message
		continueBtn.click();
		return errorMessage.getText();
	}

	public String verifyEnteredFirstName() throws Exception {
		// To enter fist name in first name textBox
		firstNameTextbox.sendKeys(ReadData.excelData(6, 1));
		return firstNameTextbox.getAttribute("value");
	}

	public String verifyEnteredLastName() throws Exception {
		// To enter last name in last name textBox
		lastNameTextbox.sendKeys(ReadData.excelData(7, 1));
		return lastNameTextbox.getAttribute("value");
	}

	public String verifyEnteredPostalCode() throws Exception {
		// To enter postal code in postal code textBox
		postalCodeTextbox.sendKeys(ReadData.excelData(8, 1));
		return postalCodeTextbox.getAttribute("value");
	}

	public String verifyCheckoutFunctionality() throws Exception {
		// To add items to cart and navigate to checkout
		cancelBtn.click();
		cartPage.continueShopingBtn.click();
		inventoryPage.getAddtocartBag().click();
		inventoryPage.getCartLink().click();
		cartPage.getCheckoutBtn().click();
		verifyEnteredFirstName(); // to enter first name
		verifyEnteredLastName(); // to enter last name
		verifyEnteredPostalCode(); // to enter postal code
		continueBtn.click();
		return driver.getCurrentUrl(); // verify this URL with check out page two URL
	}

	public WebElement getContinueBtn() {
		// getMethod to return WebElement
		return continueBtn;
	}

	public WebElement getFirstNameTextbox() {
		// getMethod to return WebElement
		return firstNameTextbox;
	}

	public WebElement getLastNameTextbox() {
		// getMethod to return WebElement
		return lastNameTextbox;
	}

	public WebElement getPostalCodeTextbox() {
		// getMethod to return WebElement
		return postalCodeTextbox;
	}
}
