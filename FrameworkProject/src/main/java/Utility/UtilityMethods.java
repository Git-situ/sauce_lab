package Utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {

	/*
	 * public static void selectClass(WebElement dropDown, String visibleValue) { //
	 * To handle Dropdown with select tagname Select dropdown = new
	 * Select(dropDown); dropdown.selectByValue(visibleValue); }
	 */

	public static void selectClass(WebElement dropDown, String visibleTextOrValue) {

		// To handle Dropdown with select tagname
		Select dropdown = new Select(dropDown);

		try {
			dropdown.selectByValue(visibleTextOrValue);

		} catch (Exception e) {
			dropdown.selectByVisibleText(visibleTextOrValue);
		}
	}

	public static void selectClass(WebElement dropDown, int index) {
		Select dropdown = new Select(dropDown);
		dropdown.selectByIndex(index);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static List<Double> sortingInteger(List<WebElement> prices) {
		// To sorting all Products price into Ascending order

		List<WebElement> listOfAllPrices = prices;// To store all the price WebElements
		List<Double> listOfDoubleTypePrices = new ArrayList<Double>();
		for (WebElement ele : listOfAllPrices) {
			// convert WebElements into double type values and remove $ sign
			listOfDoubleTypePrices.add(Double.valueOf(ele.getText().replace("$", "")));
		}
		return listOfDoubleTypePrices;
	}

	public static List<String> sortingString(List<WebElement> allTexts) {
		// To sorting all Products Name into Alphabetical order

		List<WebElement> listOfAllStringTexts = allTexts;
		List<String> list = new ArrayList<String>();
		for (WebElement ele : listOfAllStringTexts) {
			list.add(ele.getText());
		}
		return list;
	}

	public static void expliciteWait(WebDriver driver, WebElement ele) {
		// To provide time upto 10 sec to element to visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
