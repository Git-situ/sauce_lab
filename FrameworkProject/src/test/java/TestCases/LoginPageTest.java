package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.ReadData;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		// To call initialization method and assign instance variable
		initialization(); 
		loginPage = new LoginPage();
	}

	@Test(groups = "sanity")
	public void verifyTitleTest() throws Exception {
		// To verify Title of Login page
		String actual = loginPage.verifyTitle();
		String expected = ReadData.excelData(0, 1);
		Assert.assertEquals(expected, actual);
		Reporter.log("Title of Login Page : " + actual);
	}

	@Test(groups = "sanity")
	public void verifyUrlTest() throws Exception {
		// To verify URL of Login page
		String actual = loginPage.verifyUrl();
		String expected = ReadData.excelData(1, 1);
		Assert.assertEquals(expected, actual);
		Reporter.log("Url of Login Page : " + actual);
	}

	@Test
	public void verifyloginLogoTest() {
		// To verify logo
		boolean actual = loginPage.verifyLoginLogo();
		Assert.assertTrue(actual);
	}

	@Test
	public void verifyBotLogoTest() {
		// To verify logo
		boolean actual = loginPage.verifyBotLogo();
		Assert.assertTrue(actual);
	}

	@Test(groups = {"sanity","regression"})
	public void verifyLoginTest() throws Exception {
		// To verify Login to application
		login();
		boolean actual = loginPage.getLogoutBtn().isEnabled();
		Assert.assertTrue(actual, "Login is not Successful");
	}

	@Test(groups = "sanity")
	public void verifyEnteredUsername() throws Exception {
		// To verify UserName should be Entered in userName textbox
		loginPage.getUserNameTextbox().sendKeys(ReadData.readPropertyFile("username"));
		String actual = loginPage.getUserNameTextbox().getAttribute("value");
		String expected = ReadData.readPropertyFile("username");
		Assert.assertEquals(actual, expected);
		Reporter.log("Entered Usename : " + actual);
	}

	@Test(groups = "sanity")
	public void verifyEnteredPassword() throws Exception {
		// To verify password should be entered in password textbox
		loginPage.getPasswordTextbox().sendKeys(ReadData.readPropertyFile("password"));
		String actual = loginPage.getPasswordTextbox().getAttribute("value");
		String expected = ReadData.readPropertyFile("password");
		Assert.assertEquals(actual, expected);
		Reporter.log("Entered Password : " + actual);
	}

	@AfterMethod(alwaysRun = true)
	public void browserClose() {
		driver.close();
	}

}
