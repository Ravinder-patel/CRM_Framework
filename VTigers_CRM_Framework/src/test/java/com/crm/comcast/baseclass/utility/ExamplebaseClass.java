package com.crm.comcast.baseclass.utility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ExamplebaseClass {
	@BeforeSuite // execute only once in tast suite
	public void configBeforeSuite() {
		System.out.println(">>>>>>Connect to DB<<<<<<<<");
	}
	@BeforeTest
	public void configBeforeTest() {
		System.out.println("-----Report start-------");
	}

	@BeforeClass // execute only once in a class
	public void configBeforeClass() {
		System.out.println("=====Launching the browser======");
	}

	@BeforeMethod // execute for each and every test case===@BeforeMethod and @AfterMethod are not
					// dependents
	public void configBeforeMethod() {
		System.out.println("==Log in==");
	}

	@AfterMethod
	public void configAfterMethod() {
		System.out.println("==Log out=");
	}

	@AfterClass
	public void configAfterClass() {
		System.out.println("=====close the browser=====");
	}
	@AfterTest
	public void configAfterTest() {
		System.out.println("-----Report Backup-------");
	}

	@AfterSuite
	public void configAfterSuite() {
		System.out.println(">>>>>>Close DB Connection<<<<<<<<");
	}
	// All these annotations are not dependents

}
