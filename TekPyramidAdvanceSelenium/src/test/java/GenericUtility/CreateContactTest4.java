package GenericUtility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactTest4 {
	public static void main(String[] args) throws Throwable {
		// get common data from properties file
		FileInputStream fis = new FileInputStream("E:\\Softwares\\DDT Properties Files\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver(); // default browser
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// navigate to application
		driver.get(URL);
		// enter username
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		// Enter password
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		// Click on log in Button
		driver.findElement(By.id("submitButton")).click();
		// Click on contact button to create new organization
		driver.findElement(By.linkText("Contacts")).click();
		// Click on + (create contact) button
		driver.findElement(By.xpath("//*[name()='img'][@title='Create Contact...']")).click();

		// get testscript data from excel file
		FileInputStream fis2 = new FileInputStream("E:\\Softwares\\DDT Excel files\\VTigers.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("contact");

		Random random = new Random();
		int randomInt = random.nextInt(1000);

		String lastName = sh.getRow(4).getCell(6).toString() + randomInt;

		wb.close();

		// get the data from excel file object references
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);

		// save changes
		driver.findElement(By.xpath("//input[contains(@class,'save')]")).click();

		// Verify the Expected results

		// find created lastname name in header messsage
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find create lastrname in org table
		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		// verify header msg contains last name

		if (headerInfo.contains(lastName)) {
			System.out.println(lastName + ": is available in Header=====Pass");
		} else {
			System.out.println(lastName + ": is not available in Header=====Fail");

		}
		// verify org table contains last name
		if (actualLastName.equals(lastName)) {
			System.out.println(lastName + ": is available in org table=====Pass");
		} else {
			System.out.println(lastName + ": is not available in org table=====Fail");

		}

		Thread.sleep(3000);
		driver.quit();

	}

}
