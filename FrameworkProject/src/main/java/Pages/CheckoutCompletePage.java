package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.UtilityMethods;

public class CheckoutCompletePage extends TestBase {

	@FindBy(className = "title")
	private WebElement checkoutCompleteTitle;
	@FindBy(className = "complete-header")
	private WebElement thankYouTextElement;
	@FindBy(className = "pony_express")
	private WebElement ponyExoressLogo;
	@FindBy(id = "back-to-products")
	private WebElement backToHomeBtn;

	public CheckoutCompletePage() {
		// Constructor to initialize driver with instance variable
		PageFactory.initElements(driver, this);
	}

	public String getCheckoutCompleteTitle() {
		// getMethod to return Title
		return checkoutCompleteTitle.getText();
	}

	public String getThankYouTextElement() {
		// getMthod to return Thank you text
		return thankYouTextElement.getText();
	}

	public String verifyBackToHomeButtonFunctionality() {
		// to click Back to button and get URL
		backToHomeBtn.click();
		return driver.getCurrentUrl();
	}

	public boolean verifyPonyExpressLogo() {
		// To verify logo is present
		UtilityMethods.expliciteWait(driver, ponyExoressLogo);
		return ponyExoressLogo.isDisplayed();
	}

}
