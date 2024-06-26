package AdvanceReporting;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdvReportingWithSS {

	public ExtentReports eReports;
	public ExtentTest test;

	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report3.html");
		spark.config().setDocumentTitle("CRM test suite");
		spark.config().setReportName("Organization module smoke test");
		spark.config().setTheme(Theme.DARK);

		eReports = new ExtentReports();
		eReports.attachReporter(spark);
		eReports.setSystemInfo("Operating System", "windows 11");
		eReports.setSystemInfo("Browser", "Chrome.123.43.67");

	}

	@AfterSuite
	public void configAS() {
		eReports.flush();
	}

	@Test
	public void appTitleTest() throws Throwable {
		System.out.println("Test Started========");
		String actualTitle = "CRM360";
		test = eReports.createTest("appTitleTest");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		Thread.sleep(3000);

		String title = driver.getTitle();

		if (title.equals(actualTitle)) {
			test.log(Status.PASS, actualTitle + " : is matched with -" + title);
		} else {
			test.log(Status.FAIL, actualTitle + " : is not matched with -" + title);
			TakesScreenshot file = (TakesScreenshot) driver;
			String filepath = file.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(filepath, "ERROR");
		}
		driver.close();
		System.out.println("========Test Ended");
	}

}
