package com.comcast.crm.createorg.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.generic.file.utility.ExcelFileUtility;
import com.comcast.generic.file.utility.PropertiesFileUtility;
import com.comcast.genric.java.utility.JavaUtility;
import com.comcast.genric.webdriver.utility.WebDriverUtility;

public class CreateOrgWithInsdustryAndTypeTest2 {
	public static void main(String[] args) throws Throwable {

		// get common data from properties file
		PropertiesFileUtility pFileUtil = new PropertiesFileUtility();

		String BROWSER = pFileUtil.getDataFromProperties("browser");
		String URL = pFileUtil.getDataFromProperties("url");
		String USERNAME = pFileUtil.getDataFromProperties("username");
		String PASSWORD = pFileUtil.getDataFromProperties("password");

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

		// crrate obj for web utility
		WebDriverUtility webUtil = new WebDriverUtility();
		webUtil.maximizeWindow(driver);
		webUtil.pageToLoad(driver);

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
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility javaUtil = new JavaUtility();
		int randomInt = javaUtil.getRandomInteger();
		String OrgName = eUtil.getDataFromExcel("orgData", 1, 2) + randomInt;
		String OrgIndustry = eUtil.getDataFromExcel("orgData", 2, 3);
		String OrgType = eUtil.getDataFromExcel("orgData", 2, 4);

		// get the data from excel file object references
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
		// select industry of the org
		WebElement industryDrop = driver.findElement(By.name("industry"));
		Select selectIndustry = new Select(industryDrop);
		selectIndustry.selectByVisibleText(OrgIndustry);

		// select industry of the org
		WebElement typeDrop = driver.findElement(By.name("accounttype"));
		Select selectType = new Select(typeDrop);
		selectType.selectByVisibleText(OrgType);

		// save changes
		driver.findElement(By.xpath("//input[contains(@class,'save')]")).click();

		// Verify the Expected results

		// find created org name in header messsage
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find created org name in org table
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		// find created org industry in org table
		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		// find created org industry in org table
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();

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
