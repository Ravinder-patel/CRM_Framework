package com.comcast.crm.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.StaticPoolUlility.StaticObjectsUtility;

public class ListenerImplemetation implements ISuiteListener, ITestListener {
	public static ExtentReports eReport;
	public static ExtentTest test;
	
	// ISuiteListener methods
	@Override
	public void onStart(ISuite result) {
		String timeStamp=new Date().toString().replace(":", "_").replace(" ", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/Report_"+timeStamp+".html");
		spark.config().setDocumentTitle("VTigers CRM");
		spark.config().setReportName("Functional Testing");
		spark.config().setTheme(Theme.DARK);

		eReport = new ExtentReports();
		eReport.attachReporter(spark); // pass spark object into attachReporter() method
		eReport.setSystemInfo("OS", "Windows");
		eReport.setSystemInfo("Processor", "intel i5");
		eReport.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite result) {
		eReport.flush();
	}

	// ITestListener methods
	@Override
	public void onTestStart(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		System.out.println(testCase + "=====Started=====");

		test = eReport.createTest(testCase);
		StaticObjectsUtility.setTest(test);
		test.log(Status.INFO, testCase + "===== is Started=====");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		System.out.println(testCase + "=====PASSED=====");
		
		test.log(Status.INFO, testCase + "===== is PASSED=====");

	}

	public void onTestFailure(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		System.out.println(testCase + "=====FAILED=====");
		
		TakesScreenshot takeScreenshotObj = (TakesScreenshot)StaticObjectsUtility.getDriver();
		String filePath = takeScreenshotObj.getScreenshotAs(OutputType.BASE64);
		
		String timeStamp = new Date().toString().replace(":", "_").replace(" ", "_");
		
		test.addScreenCaptureFromBase64String(filePath,testCase+timeStamp);
		
		test.log(Status.INFO, testCase + "===== is FAILED=====");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);
	}

}