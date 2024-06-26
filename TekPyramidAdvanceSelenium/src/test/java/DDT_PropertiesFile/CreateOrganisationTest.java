package DDT_PropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganisationTest {
	// Data Driven from properties file =====>Data is not hardcoded here
	public static void main(String[] args) throws IOException, InterruptedException {
		// Step 1: Get the resource
		FileInputStream fis = new FileInputStream("E:\\Softwares\\DDT Properties Files\\CommonData.properties");
		// step 2: create properties class and load all the keys
		Properties property = new Properties();
		property.load(fis);

		// Step 3: Get the value by using keys and store in a variable
		String BROWSER = property.getProperty("browser");
		String URL = property.getProperty("url");
		String USERNAME = property.getProperty("username");
		String PASSWORD = property.getProperty("password");
		String OrgName = property.getProperty("faceBook");

		WebDriver driver = null;

		if (BROWSER.equals("chrome ")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge ")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox ")) {
			driver = new FirefoxDriver();
		} else {
			driver = new FirefoxDriver(); // default
		}

		driver.manage().window().maximize();
		// navigate to vitigers
		driver.get(URL);
		// Enter username
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		// Enter password
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		// Click on log in Button
		driver.findElement(By.id("submitButton")).click();
		// Click on Organizations button to create new organization
		driver.findElement(By.linkText("Organizations")).click();
		// Click on + (create org) button
		driver.findElement(By.xpath("//*[name()='img'][@title='Create Organization...']")).click();
		// Enter organization details
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
		// Click on save button
		driver.findElement(By.xpath("//input[contains(@class,'save')]")).click();

		Thread.sleep(3000);
		driver.quit();
	}

}
