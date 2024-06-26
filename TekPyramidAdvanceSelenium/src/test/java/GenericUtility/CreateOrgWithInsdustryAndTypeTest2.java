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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithInsdustryAndTypeTest2 {
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
		// Click on Organizations button to create new organization
		driver.findElement(By.linkText("Organizations")).click();
		// Click on + (create org) button
		driver.findElement(By.xpath("//*[name()='img'][@title='Create Organization...']")).click();

		// get testscript data from excel file
		FileInputStream fis2 = new FileInputStream("E:\\Softwares\\DDT Excel files\\VTigers.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("orgData");

		Random random = new Random();
		int randomInt = random.nextInt(1000);

		String OrgName = sh.getRow(2).getCell(2).toString() + randomInt;
		String OrgIndustry = sh.getRow(2).getCell(3).toString();
		String OrgType = sh.getRow(2).getCell(4).toString();
		wb.close();

		// get the data from excel file object references
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
		// select industry of the org
		WebElement industryDrop = driver.findElement(By.name("industry"));
		Select selectIndustry=new Select(industryDrop);
		selectIndustry.selectByVisibleText(OrgIndustry);
		
		// select industry of the org
		WebElement typeDrop = driver.findElement(By.name("accounttype"));
		Select selectType = new Select(typeDrop);
		selectType.selectByVisibleText(OrgType);

		//save changes
		driver.findElement(By.xpath("//input[contains(@class,'save')]")).click();

		// Verify the Expected results

		// find created org name in header messsage
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find created org name in org table
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		// find created org industry in org table
		String actualIndustry= driver.findElement(By.id("dtlview_Industry")).getText();
		// find created org industry in org table
		String actualType= driver.findElement(By.id("dtlview_Type")).getText();
		
		

		// verify header msg contains org name

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
		// verify header msg contains org name

				if (actualIndustry.equals(OrgIndustry)) {
					System.out.println(OrgIndustry + ": is available in Header=====Pass");
				} else {
					System.out.println(OrgIndustry + ": is not available in Header=====Fail");

				}
				// verify org table contains org name
				if (actualType.equals(OrgType)) {
					System.out.println(OrgType + ": is available in org table=====Pass");
				} else {
					System.out.println(OrgType + ": is not available in org table=====Fail");

				}

		Thread.sleep(3000);
		driver.quit();

	}

}
