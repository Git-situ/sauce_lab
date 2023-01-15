package TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ReadData;

public class DataproviderMethod {

	@DataProvider
	public String[][] data() throws Exception {
		String arr[][] = new String[4][2];
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 1; j++) {
				String str = ReadData.excelData(i, j, "Sheet1");
				arr[i][j] = str;
			}
		}
		return arr;
	}

	@Test(dataProvider = "data")
	public void testName(String s1, String s2) throws Exception { 
		System.out.println(s1 +"\t\t"+ s2);
	}
}
