package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.generic.file.utility.ExcelFileUtility;

public class readFromDataProvide {
	@Test(dataProvider = "getData")
	public void dataproviderTest(String ProductName, String model) throws InterruptedException {

		System.out.println(ProductName + "=====" + model);

	}

	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelFileUtility excelUtil = new ExcelFileUtility();
		int rowCount = excelUtil.getRowCount("MobilePhones");

		Object[][] objArr = new Object[rowCount][2];

		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = excelUtil.getDataFromExcel("MobilePhones", i + 1, 0);
			objArr[i][1] = excelUtil.getDataFromExcel("MobilePhones", i + 1, 1);
		}
		return objArr;

	}

}
