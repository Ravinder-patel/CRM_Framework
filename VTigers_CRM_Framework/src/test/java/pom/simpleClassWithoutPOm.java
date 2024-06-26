package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class simpleClassWithoutPOm {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http:/localhost:8888");
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement login = driver.findElement(By.id("submitButton"));
		
		username.sendKeys("admin");
		password.sendKeys("root");
		Thread.sleep(3000);
		
		driver.navigate().refresh();	//page get refresh and address of the webelements will change

		username.sendKeys("admin");	//StaleElementReferenceException
		password.sendKeys("root");
		login.click();
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}

}
