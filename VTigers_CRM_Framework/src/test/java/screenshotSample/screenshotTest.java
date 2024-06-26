package screenshotSample;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class screenshotTest {
@Test
public void amazonHomeScreenshot() throws IOException, Throwable {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/ref=nav_logo");
	File ssFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
//	EventFiringWebDriver ewDriver=new EventFiringWebDriver(driver);
//	File ssFile = ewDriver.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(ssFile, new File("./Screenshots1/amazonHome.png"));
	Thread.sleep(3000);
	
	driver.quit();
	
	
}
}
