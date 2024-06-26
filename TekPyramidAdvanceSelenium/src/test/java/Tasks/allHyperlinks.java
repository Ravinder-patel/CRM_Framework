package Tasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class allHyperlinks {
	@Test
	private void read_allHyperlinksTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		List<WebElement> tags = driver.findElements(By.xpath("//a"));
		
		for(WebElement ele:tags) {
			System.out.println(ele.getText());
		}
		Thread.sleep(2000);
		driver.quit();

	}
	
	
}
