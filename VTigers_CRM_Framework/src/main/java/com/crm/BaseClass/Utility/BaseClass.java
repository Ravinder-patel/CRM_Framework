package com.crm.BaseClass.Utility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.comcast.crm.ObjectRepository.createContactPage;
import com.comcast.crm.ObjectRepository.createOrganizationPage;
import com.comcast.crm.ObjectRepository.homePage;
import com.comcast.crm.ObjectRepository.loginPage;
import com.comcast.crm.ObjectRepository.organizationsPage;
import com.comcast.crm.StaticPoolUlility.StaticObjectsUtility;
import com.comcast.generic.database.utility.DatabaseUtility;
import com.comcast.generic.file.utility.ExcelFileUtility;
import com.comcast.generic.file.utility.PropertiesFileUtility;
import com.comcast.genric.java.utility.JavaUtility;
import com.comcast.genric.webdriver.utility.WebDriverUtility;

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	public JavaUtility jUtil = new JavaUtility();
	public DatabaseUtility dbUtil = new DatabaseUtility();
	public PropertiesFileUtility pFileUtil = new PropertiesFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public homePage hp = new homePage(driver);
	public organizationsPage orgPage = new organizationsPage(driver);
	public createOrganizationPage createOrgPage = new createOrganizationPage(driver);
	public createContactPage createCont = new createContactPage(driver);

	@BeforeSuite(groups = { "Smoke Test", "Regression Test" })
	public void configBeforeSuite() throws Throwable {
		System.out.println(">>>>>>Connect to DB<<<<<<<<");
		dbUtil.getConnection();
	}

	@BeforeTest(groups = { "Smoke Test", "Regression Test" })
	public void configBeforeTest() throws Throwable {
		System.out.println(">-------Before Test---------<");

	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "Smoke Test", "Regression Test" })
	// execute only once in a class
	 //public void configBeforeClass(String browser) throws Throwable {
	public void configBeforeClass() throws Throwable {
		System.out.println("=====Launching the browser======");
		//String BROWSER = browser; //read data from properties then remove parameter
		// in testng suite
		String BROWSER = pFileUtil.getDataFromProperties("browser");
		String URL = pFileUtil.getDataFromProperties("url");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver(); // default browser
		}
		sdriver = driver;
		StaticObjectsUtility.setDriver(sdriver);

		wlib.maximizeWindow(driver);
		driver.get(URL);
		wlib.pageToLoad(driver);

	}

	@BeforeMethod(groups = { "Smoke Test", "Regression Test" })
	public void configBeforeMethod() throws Throwable {
		System.out.println("==Log in==");
		String USERNAME = pFileUtil.getDataFromProperties("username");
		String PASSWORD = pFileUtil.getDataFromProperties("password");

		loginPage lp = new loginPage(driver);
		lp.logIntoVtigers(USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "Smoke Test", "Regression Test" })
	public void configAfterMethod() {
		System.out.println("==Log out=");
		homePage hp = new homePage(driver);
		hp.logOut();
	}

	@AfterClass(groups = { "Smoke Test", "Regression Test" })
	public void configAfterClass() {
		System.out.println("=====close the browser=====");
		driver.quit();

	}

	@AfterTest(groups = { "Smoke Test", "Regression Test" })
	public void configAfterTest() throws Throwable {
		System.out.println(">-------After Test---------<");
	}

	@AfterSuite(groups = { "Smoke Test", "Regression Test" })
	public void configAfterSuite() throws Throwable {
		System.out.println(">>>>>>Close DB Connection<<<<<<<<");
		dbUtil.closeConnection();
	}
	// All these annotations are not dependents

}
