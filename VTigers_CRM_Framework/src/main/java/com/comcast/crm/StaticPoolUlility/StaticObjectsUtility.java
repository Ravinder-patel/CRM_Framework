package com.comcast.crm.StaticPoolUlility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class StaticObjectsUtility {

	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	// provide getters and setters
	public static ExtentTest getTest() {
		return test.get();
	}

	public static void setTest(ExtentTest actualTest) {
		test.set(actualTest);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver actualDriver) {
		driver.set(actualDriver);
	}

}
