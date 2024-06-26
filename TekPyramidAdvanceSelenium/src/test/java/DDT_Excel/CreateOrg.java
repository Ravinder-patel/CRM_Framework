package DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrg {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("E:\\Softwares\\DDT Properties Files\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		WebDriver driver = null;
		// properties file
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		// excel file
		FileInputStream fis2 = new FileInputStream("E:\\Softwares\\DDT Excel files\\ReadExcelBasedOnCondition.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("Sheet1");
		String cellData = sh.getRow(1).getCell(2).toString();
		wb.close();

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// get the data from properties file
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//*[name()='img'][@title='Create Organization...']")).click();
		// get the data from excel
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(cellData);
		driver.findElement(By.xpath("//input[contains(@class,'save')]")).click();

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build()
				.perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		Thread.sleep(2000);
		driver.quit();
	}
}
