package practice.testng;

import org.junit.Assert;
import org.testng.annotations.Test;

public class dependsOnTestNGtest {

	@Test
	public void createContactTest() {
		System.out.println("crate contact test====1");
		System.out.println("create contact-->> ICICI");

	}

	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		System.out.println("delete Contact test====3");
		System.out.println("delete Contact -->> SBI");
	}

	@Test
	public void modifyContactTest() {
		System.out.println("modify Contact test====2");
		System.out.println("modify contact-->> ICICI-->>SBI");
		Assert.fail();
	}

}
