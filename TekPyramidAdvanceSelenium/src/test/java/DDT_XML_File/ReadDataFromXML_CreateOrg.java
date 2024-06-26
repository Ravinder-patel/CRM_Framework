package DDT_XML_File;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXML_CreateOrg { 
@Test
public void TestNG_CreateOrg_Test(XmlTest test) throws Throwable {
	String BROWSER = test.getParameter("browser");
	String URL = test.getParameter("url");
	String USERNAME =test.getParameter("username");
	String PASSWORD =test.getParameter("password");
	
	
	Random random = new Random(); // to generate the random numbers every time
	int randomInteger = random.nextInt(1000); // Setting the upper limit (1 to 1000)

	// Excel file
	FileInputStream fis2 = new FileInputStream("E:\\Softwares\\DDT Excel files\\ReadExcelBasedOnCondition.xlsx");
	Workbook wb = WorkbookFactory.create(fis2);
	Sheet sh = wb.getSheet("Sheet1");
	// create the object for values in Excel file
	String orgName = sh.getRow(1).getCell(2).toString() + randomInteger; // Adding the randomInteger to
																			// cellValue(orgName)
	wb.close();
	
	WebDriver driver=null;

	if (BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (BROWSER.equals("edge")) {
		driver = new EdgeDriver();
	} else if (BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	} else {
		driver = new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	// get the data from properties file object references
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//*[name()='img'][@title='Create Organization...']")).click();

	// get the data from excel file object references
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[contains(@class,'save')]")).click();

	Actions action = new Actions(driver);
	Thread.sleep(2000);
	action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	Thread.sleep(2000);
	// driver.findElement(By.linkText("//*a[text()='Sign Out']")).click();
	driver.findElement(By.xpath("//*[@id=\"ondemand_sub\"]/table/tbody/tr[2]/td/a")).click();

	Thread.sleep(2000);
	driver.quit();
	System.out.println("Test Executed");
}
}
