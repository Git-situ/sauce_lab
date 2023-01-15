package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutStepTwoPage extends TestBase {
	@FindBy(className = "title")
	private WebElement checkoutOverviewTitle;
	@FindBy(xpath = "//div[contains(text(),'Payment')]")
	private WebElement paymentInformation;
	@FindBy(xpath = "//div[text()='Shipping Information:']")
	private WebElement shipingInformation;
	@FindBy(xpath = "//div[contains(text(),'Total')]")
	private WebElement toatlPayment;
	@FindBy(xpath = "//div[contains(text(),'Tax')]")
	private WebElement tax;
	@FindBy(id = "finish")
	private WebElement finishBtn;

	public CheckoutStepTwoPage() {
		// Constructor to initialize driver with instance variable
		PageFactory.initElements(driver, this);
	}

	public String verifyOverviewTitle() {
		// To return Title
		return checkoutOverviewTitle.getText();
	}

	public boolean verifyPaymentInformation() {
		// To confirm payment Information is available
		return paymentInformation.isDisplayed();
	}

	public boolean verifyShipingInformation() {
		// To confirm shipping Information is available
		return shipingInformation.isDisplayed();
	}

	public boolean verifyTotalPayment() {
		// To confirm Total payment Information is available
		return toatlPayment.isDisplayed();
	}

	public boolean verifyTax() {
		// To confirm Tax Information is available
		return tax.isDisplayed();
	}

	public WebElement getFinishBtn() {
		// To click on finish button
		finishBtn.click();
		return finishBtn;
	}
}
