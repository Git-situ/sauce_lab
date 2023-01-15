package Utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	// To read data from config.proprties file
	public static String readPropertyFile(String value) throws Exception {
		String address = System.getProperty("user.dir") + "\\TestData\\config.properties";
		FileInputStream file = new FileInputStream(address);
		Properties p = new Properties();
		p.load(file);
		return p.getProperty(value);

	}

	public static String excelData(int row, int col) throws Exception {
		// To read data from excel file
		String address = System.getProperty("user.dir") + "\\TestData\\Swag Lab Test Data.xlsx";
		FileInputStream file = new FileInputStream(address);
		Sheet excel = WorkbookFactory.create(file).getSheet("Login Page");
		return excel.getRow(row).getCell(col).getStringCellValue();
	}
	public static String excelData(int row, int col, String sheetName) throws Exception {
		// To read data from excel file
		String address = System.getProperty("user.dir") + "\\TestData\\Swag Lab Test Data.xlsx";
		FileInputStream file = new FileInputStream(address);
		Sheet excel = WorkbookFactory.create(file).getSheet(sheetName); 
		return excel.getRow(row).getCell(col).getStringCellValue();
	}
}
