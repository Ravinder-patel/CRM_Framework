package GenericUtility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createContactWithOrg2 {

	public static void main(String[] args) throws Throwable {
		System.out.println("Org Started");
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
		// enter password
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		// click on log in button
		driver.findElement(By.id("submitButton")).click();
		// click on Organizations button to create new organization
		driver.findElement(By.linkText("Organizations")).click();
		// click on + (create org) button
		driver.findElement(By.xpath("//*[name()='img'][@title='Create Organization...']")).click();

		// get testscript data from excel file
		FileInputStream fis2 = new FileInputStream("E:\\Softwares\\DDT Excel files\\VTigers.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("orgData");

		Random random = new Random();
		int randomInt = random.nextInt(1000);

		String OrgName = sh.getRow(1).getCell(2).toString() + randomInt;
		wb.close();

		// get the data from excel file object references
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
		// save
		driver.findElement(By.xpath("//input[contains(@class,'save')]")).click();

		// verify the expected results
		// find created org name in header message
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find created org name in org table
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		// verify header message contains org name
		if (headerInfo.contains(OrgName)) {
			System.out.println(OrgName + ": is available in Header=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in Header=====Fail");
		}
		// verify org table contains org name
		if (actualOrgName.equals(OrgName)) {
			System.out.println(OrgName + ": is available in org table=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in org table=====Fail");
		}
		System.out.println("Org ended");
		System.out.println("=============");
		System.out.println("contact with Started");

		// click on contacts
		driver.findElement(By.linkText("Contacts")).click();
		// click on + (create contact) button
		driver.findElement(By.xpath("//*[name()='img'][@title='Create Contact...']")).click();

		// get testscript data from excel file
		FileInputStream fis3 = new FileInputStream("E:\\Softwares\\DDT Excel files\\VTigers.xlsx");
		Workbook wb3 = WorkbookFactory.create(fis3);
		Sheet sh3 = wb3.getSheet("contact");

		Random random3 = new Random();
		int randomInt3 = random3.nextInt(1000);

		String lastName3 = sh3.getRow(4).getCell(6).toString() + randomInt3;

		wb3.close();

		// get the data from excel file object references
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName3);
		// click on + (create contact with org) button
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();

		// create parentv window handle
		String parentWindow = driver.getWindowHandle();
		// switch to child window
		Set<String> childwindows = driver.getWindowHandles();
		Iterator<String> iter = childwindows.iterator();
		while (iter.hasNext()) {
			String windowID = iter.next();
			driver.switchTo().window(windowID);

			String actualUrl = driver.getCurrentUrl();

			if (actualUrl.contains("Accounts&action")) {
				break;
			}
		}

//	        for (String window : childWindows) {
//	            if (!window.equals(parentWindow)) {
//	                driver.switchTo().window(window);
//	                break;
//	            }
//	        }

		// perform child window actions
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgName);

		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='" + OrgName + "']")).click();

		// switch to parent window
		driver.switchTo().window(parentWindow);

		Thread.sleep(2000);

		// save contacts info
		driver.findElement(By.xpath("//input[contains(@class,'save')]")).click();

		// find created last name in header message
		String headerInfo3 = driver.findElement(By.className("dvHeaderText")).getText();
		// find created last name in org table
		String actualLastName3 = driver.findElement(By.id("dtlview_Last Name")).getText();
		// selected org name
		String actualOrgName3 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		// verify header message contains last name

		if (headerInfo3.contains(lastName3)) {
			System.out.println(lastName3 + ": is available in Header=====Pass");
		} else {
			System.out.println(lastName3 + ": is not available in Header=====Fail");
		}
		// verify org table contains last name
		if (actualLastName3.contains(lastName3)) {
			System.out.println(lastName3 + ": is available in org table=====Pass");
		} else {
			System.out.println(lastName3 + ": is not available in org table=====Fail");
		}
		// verify org table name in contact with org
		if (actualOrgName3.contains(OrgName)) {
			System.out.println(OrgName + ": is available in org table=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in org table=====Fail");
		}
		System.out.println("contact with org ends");
		Thread.sleep(3000);
		driver.quit();
	}

}
