package DDT_PropertiesFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws InterruptedException {
		
	// Hardcoded testing 
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		Thread.sleep(3000);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		Thread.sleep(3000);
		driver.quit();

	}

}
