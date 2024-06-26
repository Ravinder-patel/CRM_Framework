package AdvanceReporting;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class advanceReportingTest {

	@Test
	public void sampleTest() {
		// step 1 : storage and config of report file
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");// create spark
		spark.config().setDocumentTitle("CRM test suite results"); // report Document title
		spark.config().setReportName("Vtigers Organization Module Test"); //
		spark.config().setTheme(Theme.DARK); // report theme

		// step 2 :
		ExtentReports eReports = new ExtentReports();// create instance for ExtentReports
		eReports.attachReporter(spark); // pass spark object into attachReporter() method
		eReports.setSystemInfo("Operating System", "Windows 10");
		eReports.setSystemInfo("Browser", "Chrome");

		// step 3 :
		ExtentTest test = eReports.createTest("sampleTest"); // create test and pass the test method name as string
															// argument

		// step 4 : test script
		test.log(Status.INFO, "Navigate to application");
		test.log(Status.INFO, "Log in ");
		test.log(Status.INFO, "Create organization");
		if ("Facebook".equals("Meta")) {
			test.log(Status.PASS, "Organization is present");
		} else {
			test.log(Status.FAIL, "Organization is not present");
		}
		test.log(Status.INFO, "log out");

		// Step 4: Backup the report
		eReports.flush();

	}

}
