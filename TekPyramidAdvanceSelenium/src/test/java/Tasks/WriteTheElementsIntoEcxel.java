package Tasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WriteTheElementsIntoEcxel {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "E:\\Softwares\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		//navigate to noon
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//find recomonded for you section
		//WebElement forYou = driver.findElement(By.xpath("//h2[text()='Recommended for you']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,950)");
		
		List<WebElement> products = null;
		// Extract product names
		
		for(int i=0;i<=5;i++) {
			Thread.sleep(2000);
			products = driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section/div/div/div[5]/div/div/div/div/div/div/div/div[2]/div[2]")).click();
			Thread.sleep(1000);
			for (WebElement element : products) {
				
				System.out.println(element.getText());
			}

		}
	
		Thread.sleep(2000);

	
		driver.quit();
	}

}
