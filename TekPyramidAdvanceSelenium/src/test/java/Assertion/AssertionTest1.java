package Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest1 {

	@Test(priority = 0)
	public void homePageTitleTest() throws Throwable {

		String expectedTitle = "Home1";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();

		String actualTitle = driver.findElement(By.className("hdrLink")).getText();
		boolean title=actualTitle.contains(expectedTitle);
		//hard Assertion
		Assert.assertTrue(title);

		Thread.sleep(3000);
		driver.quit();
	}

	@Test(priority = 1)
	public void homePageLogoTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status = driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).isEnabled();
		//hard Assertion
		Assert.assertTrue(status);
		
		driver.quit();
		Thread.sleep(3000);
	}

}
