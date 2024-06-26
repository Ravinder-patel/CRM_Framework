package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectRepository.createOrganizationPage;
import com.comcast.crm.ObjectRepository.homePage;
import com.comcast.crm.ObjectRepository.loginPage;
import com.comcast.crm.ObjectRepository.organizationsPage;
import com.comcast.generic.file.utility.ExcelFileUtility;
import com.comcast.generic.file.utility.PropertiesFileUtility;
import com.comcast.genric.java.utility.JavaUtility;
import com.comcast.genric.webdriver.utility.WebDriverUtility;

public class createOrgAndDelete {
	public static void main(String[] args) throws Throwable {
		// get test data from properties file utility
		PropertiesFileUtility pfileUtil = new PropertiesFileUtility();
		String BROWSER = pfileUtil.getDataFromProperties("browser");
		String URL = pfileUtil.getDataFromProperties("url");
		String USERNAME = pfileUtil.getDataFromProperties("username");
		String PASSWORD = pfileUtil.getDataFromProperties("password");

		// get random integer
		JavaUtility ju = new JavaUtility();
		int randomNumber = ju.getRandomInteger();

		// get test data from excel file utility
		ExcelFileUtility excelUtil = new ExcelFileUtility();
		String OrgName = excelUtil.getDataFromExcel("orgData", 1, 2) + randomNumber;

		WebDriver driver = null;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(URL);

		// loginto vtigers busing business funtion
		loginPage lp = new loginPage(driver);
		lp.logIntoVtigers(USERNAME, PASSWORD);

		// click on organization
		homePage hp = new homePage(driver);
		hp.getOrganizationsLink().click();

		// click on create new org img
		organizationsPage orgPage = new organizationsPage(driver);
		orgPage.getCrateOrgLink().click();

		// create org with mandetory fields
		createOrganizationPage createOrg = new createOrganizationPage(driver);

		createOrg.getOrganizationTextFeild().sendKeys(OrgName);
		createOrg.getSaveButton().click();

		Thread.sleep(2000);

		// click on organizations
		hp.getOrganizationsLink().click();

		// search for org
		orgPage.getSearchBox().sendKeys(OrgName);
		Thread.sleep(2000);

		// select type
		orgPage.selectDropDown("Organization Name");

		// click on SEARCH
		orgPage.getSearchButton().click();

		// identify the org by using dynamic xpath====its not possible to craete dynamic xpath in pom but we can create method for that
		driver.findElement(By.xpath("//a[.='" + OrgName + "']/../../descendant::a[.='del']")).click();

		//====>>> or else we can create method for dynamic xpath in pom and call it here but it will works for this only
		//orgPage.dynamicElementDelete(OrgName).click();
		
		// accept the alert to delete
		WebDriverUtility wu = new WebDriverUtility();
		wu.alertAccept(driver);	//organization will be deleted
		
		Thread.sleep(3000);

		// log out
		hp.logOut();

		// close
		driver.quit();
	}

}
