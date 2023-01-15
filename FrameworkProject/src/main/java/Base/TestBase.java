package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CartPage;
import Pages.CheckoutStepOnePage;
import Pages.CheckoutStepTwoPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	static public WebDriver driver;

	public void initialization() throws Exception {
		// TO open browser and enter URL
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		String url = ReadData.readPropertyFile("url");
		driver.get(url);
	}

	public void login() throws Exception {
		// To Login to application
		LoginPage loginPage = new LoginPage();
		loginPage.getUserNameTextbox().sendKeys(ReadData.readPropertyFile("username"));
		loginPage.getPasswordTextbox().sendKeys(ReadData.readPropertyFile("password"));
		loginPage.getLoginBtn().click();
	}

	public void inventory() throws Exception {
		// To navigate upto inventory page
		login();
	}

	public void cart() throws Exception {
		// To navigate upto cart page
		login();
		InventoryPage inventoryPage = new InventoryPage();
		inventoryPage.getCartLink().click();
	}

	public void checkoutPageOne() throws Exception {
		// To navigate upto checkOut page one
		cart();
		CartPage cartPage = new CartPage();
		cartPage.getCheckoutBtn().click();
	}

	public void checkoutPageTwo() throws Exception {
		// To navigate upto checkout page two
		checkoutPageOne();
		CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage();
		checkoutStepOnePage.getFirstNameTextbox().sendKeys(ReadData.excelData(6, 1));
		checkoutStepOnePage.getLastNameTextbox().sendKeys(ReadData.excelData(7, 1));
		checkoutStepOnePage.getPostalCodeTextbox().sendKeys(ReadData.excelData(8, 1));
		checkoutStepOnePage.getContinueBtn().click();
	}

	public void checkoutComplete() throws Exception {
		// To navigate upto checkout page complete
		checkoutPageTwo();
		CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage();
		checkoutStepTwoPage.getFinishBtn();
	}

}
