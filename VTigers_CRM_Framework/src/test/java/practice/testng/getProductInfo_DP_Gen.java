package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.generic.file.utility.ExcelFileUtility;

public class getProductInfo_DP_Gen {
	//System.out.println("");
	
	@Test(dataProvider = "getData") //or (dataProvider = "phones") dataprovidername
	public void dataproviderTest(String searchProduct, String phone) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// navigate to application
		driver.get("https://www.amazon.in/ref=nav_logo");
		// search for product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchProduct, Keys.ENTER);
		// write dynamic xpath
		WebElement productPrice = driver.findElement(By.xpath("//a[@target='_blank' and contains(.,'" + phone
				+ "')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small' and not(contains(.,'Sponsored')) ]/descendant::span[@class='a-price-whole']"));
		System.out.println(productPrice.getText());
		Thread.sleep(2000);
		driver.quit();

	}
	@DataProvider	//(name="phones")
	public Object[][] getData() throws Throwable {
		ExcelFileUtility excelUtil = new ExcelFileUtility();
		int rowCount = excelUtil.getRowCount("MobilePhones");
		short columnCount = excelUtil.getColumnCount("MobilePhones", 1);

		Object[][] objArr = new Object[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			for(int j = 0; j < columnCount; j++) {
			objArr[i][0] = excelUtil.getDataFromExcel("MobilePhones", i + 1, j);
			objArr[i][1] = excelUtil.getDataFromExcel("MobilePhones", i + 1, j);
		}
		}
		return objArr;
		
	}

	

}

/*
 * @DataProvider	//(name="phones")
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
	*/
