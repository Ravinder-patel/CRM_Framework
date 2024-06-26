package com.comcast.crm.createorg.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.generic.file.utility.ExcelFileUtility;
import com.comcast.generic.file.utility.PropertiesFileUtility;
import com.comcast.genric.java.utility.JavaUtility;
import com.comcast.genric.webdriver.utility.WebDriverUtility;

public class CreateContactTest4 {
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
		// Click on contact button to create new organization
		driver.findElement(By.linkText("Contacts")).click();
		// Click on + (create contact) button
		driver.findElement(By.xpath("//*[name()='img'][@title='Create Contact...']")).click();

		// get testscript data from excel file
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility javaUtil = new JavaUtility();
		int randomInt = javaUtil.getRandomInteger();
		String lastName = eUtil.getDataFromExcel("contact", 4, 6) + randomInt;

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
