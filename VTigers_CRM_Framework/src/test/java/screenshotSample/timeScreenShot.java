package screenshotSample;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImplemetation.class)
public class timeScreenShot {
	public WebDriver driver = null;

	@BeforeMethod
	public void configBeforeMethod() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void timeScreenShotTest() throws InterruptedException {

		driver.get("https://time.is/");

		String title = driver.getTitle();

		System.out.println("Step-1");
		System.out.println("Step-2");

		Assert.assertEquals(title, "ravi");

		System.out.println("Step-3");
		System.out.println("Step-4");

		
	}

	
	@AfterMethod
	public void configAfterMethod() {
		driver.close();
	}
}
