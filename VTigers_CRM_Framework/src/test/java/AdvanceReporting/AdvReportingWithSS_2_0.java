package AdvanceReporting;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.ListenerUtility.ListenerImplemetation;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImplemetation.class)
public class AdvReportingWithSS_2_0 {

	@Test
	public void appTitleTest() throws Throwable {

		ExtentTest test = ListenerImplemetation.eReport.createTest("appTitleTest");

		String actualTitle = "Time";

		WebDriver driver = new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://time.is/");

		String title = driver.getTitle();

		if (title.equals(actualTitle)) {
			test.log(Status.PASS, actualTitle + " : is matched with -" + title);
		} 
		else 
		{
			test.log(Status.FAIL, actualTitle + " : is not matched with -" + title);
			TakesScreenshot file = (TakesScreenshot) driver;
			String filepath = file.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(filepath);
		}
		driver.close();
	}

}
