package Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAndHardAssertionExample {
	@Test
	public void hardAssertiionTest1() {
		System.out.println("Test1 Started");

		System.out.println(" Step - 1");
		System.out.println(" Step - 2");
		//hard Assertion
		Assert.assertTrue(false);
		System.out.println(" Step - 3");
		System.out.println(" Step - 4");
		System.out.println(" Step - 5");
		
		System.out.println("Test1 Ended");
	}

	@Test
	public void softAssertiionTest2() {
		System.out.println("Test2 Started");
		
		System.out.println(" Step - 1");
		// soft Assert
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertTrue(false);
		System.out.println(" Step - 2");
		System.out.println(" Step - 3");
		assertObj.assertEquals("Ravi", "ravi");
		System.out.println(" Step - 4");
		System.out.println(" Step - 5");

		assertObj.assertAll();	// if you use SoftAssert you should use assertAll() to find exceptions
		
		System.out.println("Test2 Ended");
	}
}
