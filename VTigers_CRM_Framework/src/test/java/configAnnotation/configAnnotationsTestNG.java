package configAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class configAnnotationsTestNG {
	@BeforeSuite	//execute only once in tast suite
	public void configBeforeSuite() {
		System.out.println("execute config Before Suite");
	}

	@BeforeClass	//execute only once in a class
	public void configBeforeClass() {
		System.out.println("execute config Before Class");
	}

	@BeforeMethod	//execute for each and every test case===@BeforeMethod and @AfterMethod are not dependents
	public void configBeforeMethod() {
		System.out.println("execute config Before Method");
	}

	@Test
	public void testCase1() {
		System.out.println(">>>>>Test Case 1");
	}

	@Test
	public void testCase2() {
		System.out.println(">>>>>Test Case 2");
	}

	@AfterMethod
	public void configAfterMethod() {
		System.out.println("execute config After Method");
	}

	@AfterClass
	public void configAfterClass() {
		System.out.println("execute config After Class");
	}

	@AfterClass
	public void configAfterSuite() {
		System.out.println("execute config After Suite");
	}
	// All these annotations are not dependents

}
