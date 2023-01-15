package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase {
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public WebElement cart;
	@FindBy(xpath = "//span[@class='title']")
	private WebElement yourCartText;
	@FindBy(id = "continue-shopping")
	public WebElement continueShopingBtn;
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement backPackAddToCartBtn;
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement jacketAddTOCArtBtn;
	@FindBy(xpath = "//div[contains(text(),'Backpack')]")
	public WebElement backPack;
	@FindBy(xpath = "//div[contains(text(),'Jacket')]")
	public WebElement jacket;
	@FindBy(id = "remove-sauce-labs-backpack")
	public WebElement backPackRemoveToCartBtn;
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	public CartPage() {
		// To call initialization method
		PageFactory.initElements(driver, this);
	}

	public String verifyCartUrl() {
		// To get current URL
		return driver.getCurrentUrl();
	}

	public String verifyYourCartText() {
		// To verify Your Cart Text spelling
		return yourCartText.getText();
	}

	public void addItemsInCart()  {
		// To add Items in the cart
		continueShopingBtn.click();
		backPackAddToCartBtn.click();
		jacketAddTOCArtBtn.click();
		cart.click();
	}

	public String verifyCountOfCart()  {
		continueShopingBtn.click();
		backPackAddToCartBtn.click();
		jacketAddTOCArtBtn.click();
		return cart.getText();
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public WebElement getCart() {
		return cart;
	}

}
