package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//div[@class='login_logo']")
	private WebElement loginLogo;
	@FindBy(xpath = "//div[@class='bot_column']")
	private WebElement botLogo;
	@FindBy(id = "user-name")
	private WebElement userNameTextbox;
	@FindBy(id = "password")
	private WebElement passwordTextbox;
	@FindBy(name = "login-button")
	private WebElement loginBtn;
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutBtn;

	public LoginPage() {
		// Constructor to initialize driver with instance variable
		PageFactory.initElements(driver, this);
	}

	public String verifyTitle() {
		// To get Title of WebPage
		return driver.getTitle();
	}

	public WebElement getUserNameTextbox() {
		// get method to return userName TextBox
		return userNameTextbox;
	}

	public WebElement getPasswordTextbox() {
		// get method to return password TextBox
		return passwordTextbox;
	}

	public WebElement getLoginBtn() {
		// get method to return login Button
		return loginBtn;
	}

	public String verifyUrl() {
		// To get current URL
		return driver.getCurrentUrl();
	}

	public boolean verifyLoginLogo() {
		// To verify logo is present
		return loginLogo.isDisplayed();
	}

	public boolean verifyBotLogo() {
		// To verify logo is present
		return botLogo.isDisplayed();
	}

	public WebElement getLogoutBtn() {
		// get method to return logout Button
		return logoutBtn;
	}
}
