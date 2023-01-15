package Pages;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.UtilityMethods;

public class InventoryPage extends TestBase {
	@FindBy(xpath = "//div[@class='peek']")
	private WebElement peekLogo;
	@FindBy(xpath = "//span[@class='title']")
	private WebElement productText;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartLink;
	@FindBy(xpath = "//div[contains(text(),'Backpack')]")
	private WebElement bagpack;
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addtocartBag;
	@FindBy(className = "inventory_item_price")
	private List<WebElement> prices;
	@FindBy(className = "inventory_item_name")
	private List<WebElement> names;
	@FindBy(className = "product_sort_container")
	private WebElement dropDown;

	public InventoryPage() {
		// Constructor to initialize driver with instance variable
		PageFactory.initElements(driver, this);
	}

	public boolean verifyPeekLogo() {
		// To verify logo is present
		return peekLogo.isDisplayed();
	}

	public String verifyProductText() {
		// To get Text of Product element
		return productText.getText();
	}

	public WebElement getBagpack() {
		// get method to return bagPack WebElement
		return bagpack;
	}

	public WebElement getAddtocartBag() {
		// get method to return addToCartButton WebElement
		return addtocartBag;
	}

	public WebElement getCartLink() {
		// get method to return cartLink WebElement
		return cartLink;
	}

	public List<Double> ascendingOrderPriceList() {
		// To sort all products price into ascending order
		List<Double> list = UtilityMethods.sortingInteger(prices);
		Collections.sort(list);
		return list;
	}

	public List<Double> actulPriceListAcordingToDropdownOptionSelected(String visibleValue) {
		// To get all products prices from WebPage
		UtilityMethods.selectClass(dropDown, visibleValue);
		List<Double> list = UtilityMethods.sortingInteger(prices);
		return list;
	}

	public List<String> alphabeticalOrderProductsNames() {
		// To sort all products names into alphabetical order
		List<String> list = UtilityMethods.sortingString(names);
		Collections.sort(list);
		return list;
	}

	public List<String> actualNamesAcordingToDropdownOptionSelected(String visibleValue) {
		// To get all products names from WebPage
		UtilityMethods.selectClass(dropDown, visibleValue);
		List<String> list = UtilityMethods.sortingString(names);
		return list;
	}

}
