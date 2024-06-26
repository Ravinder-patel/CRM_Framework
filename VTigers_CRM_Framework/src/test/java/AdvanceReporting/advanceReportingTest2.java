package AdvanceReporting;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImplemetation.class)
public class advanceReportingTest2 {
	public ExtentReports eReports;
	public ExtentTest test;

	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report2.0.html");
		spark.config().setDocumentTitle("CRM test suite");
		spark.config().setReportName("Organization module smoke test");
		spark.config().setTheme(Theme.DARK);

		eReports = new ExtentReports();
		eReports.attachReporter(spark);
		eReports.setSystemInfo("Operating System", "windows 11");
		eReports.setSystemInfo("Browser", "Chrome");

	}

	@AfterSuite
	public void configAS() {
		eReports.flush();
	}

	@Test
	public void OrganizationTest() {

		 test = eReports.createTest("OrganizationTest"); // create test and pass the test method name as
																	// string argument

		test.log(Status.INFO, "Navigate to application");
		test.log(Status.INFO, "Log in ");
		test.log(Status.INFO, "organization created");

		if ("Facebook".equals("Meta")) {
			test.log(Status.PASS, "Organization is matched");

		} else {
			test.log(Status.FAIL, "Organization is not matched");
		}

		test.log(Status.INFO, "log out");

	}

	@Test
	public void OrganizationWithNumberTest() {

		ExtentTest test = eReports.createTest("OrganizationWithNumberTest"); // create test and pass the test method
																				// name as string argument

		test.log(Status.INFO, "Navigate to application");
		test.log(Status.INFO, "Log in ");
		test.log(Status.INFO, "Create organization with phone number");

		if ("Facebook7032195593".equals("Facebook7032195593")) {
			test.log(Status.PASS, "Organization is created with phone number");
		} else {
			test.log(Status.FAIL, "Organization is not created with phone number");
		}

		test.log(Status.INFO, "log out");

	}

}
